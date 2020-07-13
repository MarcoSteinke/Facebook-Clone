package net.bestofcode.Facebook.controller;

import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.persistence.forms.RegistrationFormData;
import net.bestofcode.Facebook.service.DatabaseService;
import net.bestofcode.Facebook.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
public class FacebookRegistrationController {

    RegistrationService registrationService;
    DatabaseService databaseService;

    public FacebookRegistrationController(RegistrationService registrationService, DatabaseService databaseService) {
        this.registrationService = registrationService;
        this.databaseService = databaseService;
    }

    @PostMapping("/registration")
    public String register(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
        RegistrationFormData registrationFormData = new RegistrationFormData(new Username(username), new Email(email), new Password(password));
        boolean registrationSuccess = this.registrationService.registerUser(registrationFormData);


        if(!registrationSuccess)
            return "redirect:/error";

        System.out.println(username + ", " + new Password(password).getEncryptedPassword() + ", " + email);
        return "redirect:/registration/success";
    }

    /*@ModelAttribute("account")
    public User userAccount(Model model) {

    }*/
}
