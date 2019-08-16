package com.balazssipos.foxclub.controllers;

import com.balazssipos.foxclub.models.entities.Trick;
import com.balazssipos.foxclub.services.NutritionService;
import com.balazssipos.foxclub.services.FoxService;
import com.balazssipos.foxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private FoxService foxService;
  private TrickService trickService;
  private NutritionService nutritionService;

  @Autowired
  public MainController(FoxService foxService, TrickService trickService, NutritionService nutritionService) {
    this.foxService = foxService;
    this.trickService = trickService;
    this.nutritionService = nutritionService;
  }

  @GetMapping("/")
  public String index(Model model, @RequestParam(value = "name", required = false) String foxName) {
    if(foxName != null) {
      if (!foxName.equals(this.foxService.getCurrentFoxName())) {
        return "redirect:/login";
      }
    } else {
      return "redirect:/login";
    }
//    System.out.println("querried fox: " + this.signUpService.getCurrentFox().toString());
    model.addAttribute("foxObject", this.foxService.getCurrentFox());
    return "index";
  }

  @GetMapping("/login")
  public String renderLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String login(Model model, @RequestParam("name") String foxName) {
//    System.out.println(foxName);
    this.foxService.initFox(foxName);

//    System.out.println(this.signUpService.getCurrentFox().toString());

//    HashMap<String, Trick> tricksMap = this.trickService.getAllTricks();
//    for (String trickName : tricksMap.keySet()) {
//      System.out.println(tricksMap.get(trickName));
//    }
//
//    HashMap<String, Nutrition> drinksMap = this.nutritionService.getAllDrinks();
//    for (String drinkName : drinksMap.keySet()) {
//      System.out.println(drinksMap.get(drinkName));
//    }
//
//    HashMap<String, Nutrition> foodMap = this.nutritionService.getAllFoods();
//    for (String foodName : foodMap.keySet()) {
//      System.out.println(foodMap.get(foodName));
//    }

//    Fox currentFox = this.signUpService.checkIfFoxExist(foxName);
//    System.out.println("név" + currentFox.getName());
//    this.signUpService.addFoxToFoxHashMap(currentFox);
//    this.signUpService.setCurrentFox(foxName);
//    System.out.println("név" + this.signUpService.getCurrentFoxName());
    return "redirect:/?name=" + foxName;
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore(Model model, @RequestParam(value = "name", required = false) String foxName) {
    if(!foxName.equals(this.foxService.getCurrentFoxName()) || foxName == null) {
      return "redirect:/login";
    }
    model.addAttribute("foxObject", this.foxService.getCurrentFox());
    model.addAttribute("foods", this.nutritionService.getAllFoods().values());
    model.addAttribute("drinks", this.nutritionService.getAllDrinks().values());
    return "nutrition_store";
  }

  @PostMapping("/nutritionStore")
  public String changeNutrition(Model model, @RequestParam(value = "name", required = false) String foxName, @RequestParam("food") String selectedFood, @RequestParam("drink") String selectedDrink) {
    if(!foxName.equals(this.foxService.getCurrentFoxName()) || foxName == null) {
      return "redirect:/login";
    }
    this.foxService.changeDrinkOnFox(selectedDrink);
    this.foxService.changeFoodOnFox(selectedFood);
    return "redirect:/?name=" + foxName;
  }

  @GetMapping("/trickCentre")
  public String renderTrickStore(Model model, @RequestParam(value = "name", required = false) String foxName) {
    if(!foxName.equals(this.foxService.getCurrentFoxName()) || foxName == null) {
      return "redirect:/login";
    }
    model.addAttribute("foxObject", this.foxService.getCurrentFox());
    model.addAttribute("tricks", this.trickService.getAllTricks().values());
    return "trick-centre";
  }

  @PostMapping("/trickCentre")
  public String changeTrick(Model model, @RequestParam(value = "name", required = false) String foxName, @RequestParam("trick") String selectedTrick) {
    if(!foxName.equals(this.foxService.getCurrentFoxName()) || foxName == null) {
      return "redirect:/login";
    }
    this.foxService.learnTrickItem(new Trick(selectedTrick));
    return "redirect:/?name=" + foxName;
  }

  @GetMapping("/logout")
  public String logout() {
    return "login";
  }
}
