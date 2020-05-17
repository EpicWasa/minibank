package ua.epicwasa.minibank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.epicwasa.minibank.Utils.CardNumberGenerator;
import ua.epicwasa.minibank.data.entity.*;
import ua.epicwasa.minibank.data.repo.*;

import java.time.LocalDate;
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
        account.setCreationDate(LocalDate.now());
        if(account.getName().equals("")){
            account.setName("New account("+account.getCurrency().getName()+")");
        }
        return accountRepo.save(account);
    }

    @PostMapping("/deposits")
    public DepositContract addDeposit(@RequestBody DepositContract deposit ){
        LocalDate currDate = LocalDate.now();
        deposit.setDateOfSigning(currDate);
        deposit.setDateOfExpiration(currDate.plusMonths(deposit.getRate().getDuration()));
        Account account = deposit.getAccount();
        account.setAmount(account.getAmount()-deposit.getInitialSum());
        accountRepo.save(account);
        return depositRepo.save(deposit);
    }

    @PostMapping("/loans")
    public LoanContract addLoan(@RequestBody LoanContract loan ){
        LocalDate currDate = LocalDate.now();
        loan.setDateOfSigning(currDate);
        loan.setDateOfExpiration(currDate.plusMonths(loan.getRate().getDuration()));
        Account account = loan.getAccount();
        account.setAmount(account.getAmount()+loan.getInitialSum());
        accountRepo.save(account);
        return loanRepo.save(loan);
    }

    @PostMapping("/cards")
    public Card addCard(@RequestBody Card card ){
        card.setCreationDate(LocalDate.now());
        card.setExpirationDate(card.getCreationDate().plusYears(4));
        card.setNumber(CardNumberGenerator.generate());
        return cardRepo.save(card);
    }

    @GetMapping("/cards/{id}")
    public Iterable<Card> getCards(@PathVariable("id") long id){
        Iterable<Card> cards = cardRepo.getCardsById(id);
         return cards;
    }


}
