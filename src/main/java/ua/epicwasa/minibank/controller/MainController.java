package ua.epicwasa.minibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.epicwasa.minibank.data.entity.*;
import ua.epicwasa.minibank.data.repo.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active:prod}")
    private String profile;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private DepositRepo depositRepo;

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private RateRepo rateRepo;

    @GetMapping
    public String main(Model m, @AuthenticationPrincipal User user){
        HashMap<Object, Object> data = new HashMap<>();
        Iterable<Account> accounts = null;
        Iterable<Card> cards = null;
        Iterable<DepositContract> deposits = null;
        Iterable<LoanContract> loans = null;
        data.put("profile", user);
        if(user!=null){
             accounts = accountRepo.getAllByUser(user);
             cards = cardRepo.getAllByAccountUser(user);
             deposits = depositRepo.getAllByAccountUser(user);
             loans = loanRepo.getAllByAccountUser(user);
        }
        data.put("accounts", accounts);
        data.put("cards", cards);
        data.put("deposits", deposits);
        data.put("loans", loans);
        data.put("currencies", currencyRepo.findAll());
        data.put("rates", rateRepo.findAll());

        m.addAttribute("frontendData", data);
        m.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }

}
