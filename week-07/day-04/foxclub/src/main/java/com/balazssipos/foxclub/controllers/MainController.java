package com.balazssipos.foxclub.controllers;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.services.SignUpService;
import com.balazssipos.foxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private SignUpService signUpService;

  @Autowired
  public MainController(SignUpService signUpService) {
    this.signUpService = signUpService;
  }

  @GetMapping("/")
  public String index(Model model, @RequestParam(value = "name", required = false) String foxName) {
    if(foxName == null) {
      return "redirect:/login";
    }
    model.addAttribute("foxObject", this.signUpService.getCurrentFox());
    return "index";
  }

  @GetMapping("/login")
  public String renderLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String login(Model model, @RequestParam("name") String foxName) {
//    System.out.println(foxName);
    Fox currentFox = this.signUpService.checkIfFoxExist(foxName);
//    System.out.println("név" + currentFox.getName());
    this.signUpService.addFoxToFoxHashMap(currentFox);
    this.signUpService.setCurrentFox(foxName);
//    System.out.println("név" + this.signUpService.getCurrentFoxName());
    return "redirect:/?name=" + foxName;
  }
}
