package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {
    AtomicLong atomicLong = new AtomicLong(1);

    @GetMapping("/web/greeting")
    public String greeting(Model model, @RequestParam(value="name") String name) {
        model.addAttribute("name", name);
        model.addAttribute("greetingCounter", atomicLong.getAndIncrement());
        return "greeting2";
    }
}
