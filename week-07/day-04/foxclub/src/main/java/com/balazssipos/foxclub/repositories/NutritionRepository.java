package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Nutrition;

import java.util.HashMap;

public interface NutritionRepository {
  HashMap<String, Nutrition> findAllDrinks();
  HashMap<String, Nutrition> findAllFoods();
  void addDrinkItem(Nutrition nutritionItem);
  void addFoodItem(Nutrition nutritionItem);
  boolean checkIfDrinkItemAlreadyExist(Nutrition nutritionItem);
  boolean checkIfFoodItemAlreadyExist(Nutrition nutritionItem);
  Nutrition getFirstDrink();
  Nutrition getFirstFood();
}
