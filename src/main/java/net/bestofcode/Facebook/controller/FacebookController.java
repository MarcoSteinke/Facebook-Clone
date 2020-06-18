package net.bestofcode.Facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
public class FacebookController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/registration/success")
    public String registrationSuccessful(Model model) {
        model.addAttribute("success", "1");
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String param, Model model) {
        model.addAttribute("searchparam", param);
        return "search";
    }
}
