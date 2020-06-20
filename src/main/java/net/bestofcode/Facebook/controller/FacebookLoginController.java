package net.bestofcode.Facebook.controller;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.VerificationPassword;
import net.bestofcode.Facebook.persistence.forms.LoginFormData;
import net.bestofcode.Facebook.service.DatabaseService;
import net.bestofcode.Facebook.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
public class FacebookLoginController {

    DatabaseService databaseService;
    LoginService loginService;

    public FacebookLoginController(DatabaseService databaseService, LoginService loginService) {
        this.databaseService = databaseService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String password, @RequestParam String email) {
        Email email1 = new Email(email);
        VerificationPassword verificationPassword = new VerificationPassword(password);
        LoginFormData loginFormData = new LoginFormData(email1, verificationPassword);
        loginFormData.setVerificationPassword(new VerificationPassword(password));
        User user = this.loginService.loginUser(loginFormData);

        if(user != null) {

            model.addAttribute("account", user);
            return "index";

        } else {

            return "error";
        }
    }
}
