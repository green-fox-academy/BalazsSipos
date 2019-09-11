package com.balazssipos.fog.controllers;

import com.balazssipos.fog.models.entities.Food;
import com.balazssipos.fog.models.entities.FoodCategory;
import com.balazssipos.fog.services.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodCategoryController {
  private FoodCategoryService foodCategoryService;

  @Autowired
  public FoodCategoryController(FoodCategoryService foodCategoryService) {
    this.foodCategoryService = foodCategoryService;
  }

  @GetMapping("/u/{userId}")
  public String renderIndex(Model model, @PathVariable("userId") Long userId) {
    model.addAttribute("foodCategories", this.foodCategoryService.findAllFoodCategoriesByUserId(userId));
    model.addAttribute("newFoodCategory", new FoodCategory());
    model.addAttribute("userId", userId);
    return "index";
  }

  @PostMapping("/u/{userId}/addFoodCategory")
  public String addFoodCategory(@ModelAttribute("newFoodCategory") FoodCategory foodCategory,
                                @PathVariable("userId") Long userId, Model model) {
    if(foodCategory.getName().equals("")) {
      model.addAttribute("errorMessage", "Please provide food category name!");
      model.addAttribute("foodCategories", this.foodCategoryService.findAllFoodCategoriesByUserId(userId));
      model.addAttribute("newFoodCategory", new FoodCategory());
      model.addAttribute("userId", userId);
//      return "index";
      return "redirect:/u/" + userId;
    }
    this.foodCategoryService.addFoodCategory(userId, foodCategory);
    return "redirect:/u/" + userId;
  }
}
