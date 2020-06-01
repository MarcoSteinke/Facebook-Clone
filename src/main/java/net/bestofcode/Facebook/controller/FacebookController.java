package net.bestofcode.Facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
