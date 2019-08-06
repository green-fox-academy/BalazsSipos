package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWebController {
    @GetMapping("/web/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", " World! (It is a web page.)");
        return "greeting2";
    }
}
