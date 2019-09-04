package com.bs.fog.controllers;

import com.bs.fog.models.entities.User;
import com.bs.fog.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
  private UserServiceImpl userServiceImpl;

  @Autowired
  public MainController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @GetMapping("/")
  public String renderIndex() {
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }

  @GetMapping("/register")
  public String renderRegister(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute User user) {
    System.out.println(user.toString());
    this.userServiceImpl.saveNewUser(user);
    return "redirect:/";
  }
}
