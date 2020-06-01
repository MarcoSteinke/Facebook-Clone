package net.bestofcode.Facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FacebookController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/search/{param}")
    public String search(@PathVariable String param, Model model) {
        model.addAttribute("searchparam", param);
        return "search";
    }
}
