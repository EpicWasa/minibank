package ua.epicwasa.minibank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.Card;
import ua.epicwasa.minibank.data.entity.User;
import ua.epicwasa.minibank.data.repo.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://")
@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private DepositRepo depositRepo;

    @Autowired
    private LoanRepo loanRepo;

    @GetMapping("/customer/{id}")
    public User getCustomer(@PathVariable("id") User user){

         return user;
    }

    @GetMapping("/accounts/{id}")
    public Iterable<Account> getAccounts(@PathVariable("id") String id){
        User user = userRepo.findById(id);
        if(user == null){
            return new ArrayList<Account>();
        }
        else return accountRepo.getAllByUser(user);
    }

    @PostMapping("/accounts")
    public Account addAcсount(@RequestBody Account account ){

        return accountRepo.save(account);
    }

    @GetMapping("/cards/{id}")
    public Iterable<Card> getCards(@PathVariable("id") long id){
        Iterable<Card> cards = cardRepo.getCardsById(id);
         return cards;
    }


}
