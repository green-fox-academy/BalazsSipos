package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Nutrition;

import java.util.HashMap;

public interface NutritionService {
  HashMap<String, Nutrition> getAllDrinks();
  HashMap<String, Nutrition> getAllFoods();
  void addNewNDrink(Nutrition newDrinkItem);
  void addNewNFood(Nutrition newFoodItem);
  Nutrition getFirstFood();
  Nutrition getFirstDrink();
}
