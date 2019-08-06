package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {
    AtomicLong atomicLong = new AtomicLong(1);

    @GetMapping("/web/greeting")
    public String greeting(Model model, @RequestParam("name") String userName, @RequestParam("lang") String lang, @RequestParam("color") String color) {
        model.addAttribute("name", userName);
        model.addAttribute("greetingCounter", this.FizzBuzzWoof(atomicLong.getAndIncrement()));
        String[] hellos = {"Hello", "Guten Tag", "Szia"};
        model.addAttribute("names", hellos);
        model.addAttribute("greetingLang", this.greetingSelector(lang));
        model.addAttribute("fontColor", "color:" + color);
        return "greeting";
    }

    private String greetingSelector(String lang) {
        HashMap<String, String> langGreetingsMap = new HashMap<>();
        langGreetingsMap.put("english", "Hello");
        langGreetingsMap.put("german", "Guten Tag");
        langGreetingsMap.put("hungarian", "Szia");

        return langGreetingsMap.get(lang);
    }

    private String FizzBuzzWoof(Long number) {
        if(number%3 == 0 && number%5 == 0 && number%7 == 0) {
            return "FizzBuzzWoof";
        } else if(number%3 == 0 && number%5 == 0) {
            return "FizzBuzz";
        } else if(number%3 == 0 && number%7 == 0) {
            return "FizzWoof";
        } else if(number%5 == 0 && number%7 == 0) {
            return "BuzzWoof";
        } else if(number%3 == 0) {
            return "Fizz";
        } else if(number%5 == 0) {
            return "Buzz";
        } else if(number%7 == 0) {
            return "Woof";
        } else {
            return number.toString();
        }
    }
}
