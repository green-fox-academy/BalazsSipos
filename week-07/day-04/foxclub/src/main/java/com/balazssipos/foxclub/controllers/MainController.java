package com.balazssipos.foxclub.controllers;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.models.entities.Nutrition;
import com.balazssipos.foxclub.models.entities.Trick;
import com.balazssipos.foxclub.services.NutritionService;
import com.balazssipos.foxclub.services.SignUpService;
import com.balazssipos.foxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class MainController {
  private SignUpService signUpService;
  private TrickService trickService;
  private NutritionService nutritionService;

  @Autowired
  public MainController(SignUpService signUpService, TrickService trickService, NutritionService nutritionService) {
    this.signUpService = signUpService;
    this.trickService = trickService;
    this.nutritionService = nutritionService;
  }

  @GetMapping("/")
  public String index(Model model, @RequestParam(value = "name", required = false) String foxName) {
    if(foxName == null) {
      return "redirect:/login";
    }
    System.out.println("querried fox: " + this.signUpService.getCurrentFox().toString());
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
    this.signUpService.initFox(foxName);

//    System.out.println(this.signUpService.getCurrentFox().toString());

    HashMap<String, Trick> tricksMap = this.trickService.getAllTricks();
    for (String trickName : tricksMap.keySet()) {
      System.out.println(tricksMap.get(trickName));
    }

    HashMap<String, Nutrition> drinksMap = this.nutritionService.getAllDrinks();
    for (String drinkName : drinksMap.keySet()) {
      System.out.println(drinksMap.get(drinkName));
    }

    HashMap<String, Nutrition> foodMap = this.nutritionService.getAllFoods();
    for (String foodName : foodMap.keySet()) {
      System.out.println(foodMap.get(foodName));
    }

//    Fox currentFox = this.signUpService.checkIfFoxExist(foxName);
//    System.out.println("név" + currentFox.getName());
//    this.signUpService.addFoxToFoxHashMap(currentFox);
//    this.signUpService.setCurrentFox(foxName);
//    System.out.println("név" + this.signUpService.getCurrentFoxName());
    return "redirect:/?name=" + foxName;
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore() {
    return ""
  }
}
