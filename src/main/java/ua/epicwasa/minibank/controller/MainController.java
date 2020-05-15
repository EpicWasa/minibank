package ua.epicwasa.minibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.Card;
import ua.epicwasa.minibank.data.entity.User;
import ua.epicwasa.minibank.data.repo.AccountRepo;
import ua.epicwasa.minibank.data.repo.CardRepo;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping
    public String main(Model m, @AuthenticationPrincipal User user){
        HashMap<Object, Object> data = new HashMap<>();
        Iterable<Account> accounts = null;
        Iterable<Card> cards = null;
        data.put("profile", user);
        if(user!=null){
             accounts = accountRepo.getAllByUser(user);
             cards = cardRepo.getAllByAccountUser(user);
        }
        data.put("accounts", accounts);
        data.put("cards", cards);
        m.addAttribute("frontendData", data);
        m.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }

}
