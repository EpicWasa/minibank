package ua.epicwasa.minibank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.epicwasa.minibank.data.entity.User;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model m, @AuthenticationPrincipal User user){
        HashMap<Object, Object> data = new HashMap<>();
        data.put("accounts", null);
        data.put("cards", null);
        data.put("profile", user);

        m.addAttribute("frontendData", data);
        m.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }

}
