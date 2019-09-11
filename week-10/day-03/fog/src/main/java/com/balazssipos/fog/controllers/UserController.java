package com.balazssipos.fog.controllers;

import com.balazssipos.fog.models.DTOs.StatusMessageError;
import com.balazssipos.fog.models.entities.FogUser;
import com.balazssipos.fog.repositories.FogUserRepository;
import com.balazssipos.fog.services.FogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  private FogUserService fogUserService;

  @Autowired
  public UserController(FogUserService fogUserService) {
    this.fogUserService = fogUserService;
  }

  @GetMapping("/login")
  public String renderLogin(Model model) {
    model.addAttribute("user", new FogUser());
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute("user") FogUser fogUser, Model model) {
    if(fogUser.getName().equals("")) {
      model.addAttribute("errorMessage", "Please provide username!");
      return "login";
    }
    return "redirect:/u/" + this.fogUserService.createUser(fogUser);
  }
}
