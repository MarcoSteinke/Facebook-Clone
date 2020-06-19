package net.bestofcode.Facebook.controller;

import net.bestofcode.Facebook.service.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
public class FacebookLoginController {

    DatabaseService databaseService;

    public FacebookLoginController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @PostMapping("/login")
    public String login(Model model,  @RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return "index";
    }
}
