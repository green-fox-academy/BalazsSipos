package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Nutrition;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NutritionRepositoryImpl implements NutritionRepository {
  private HashMap<String, Nutrition> drinkHashMap;
  private HashMap<String, Nutrition> foodHashMap;

  public NutritionRepositoryImpl() {
    this.drinkHashMap = new HashMap<>();
    this.foodHashMap = new HashMap<>();

    this.drinkHashMap.put("milk", new Nutrition("milk"));
    this.drinkHashMap.put("water", new Nutrition("water"));
    this.drinkHashMap.put("cola", new Nutrition("cola"));

    this.foodHashMap.put("cheese", new Nutrition("cheese"));
    this.foodHashMap.put("grass", new Nutrition("grass"));
    this.foodHashMap.put("insect", new Nutrition("insect"));
  }

  @Override
  public HashMap<String, Nutrition> findAllDrinks() {
    return this.drinkHashMap;
  }

  @Override
  public HashMap<String, Nutrition> findAllFoods() {
    return this.foodHashMap;
  }

  @Override
  public void addDrinkItem(Nutrition nutritionItem) {
    if(!checkIfDrinkItemAlreadyExist(nutritionItem)) {
      this.drinkHashMap.put(nutritionItem.getName(), nutritionItem);
    }
  }

  @Override
  public void addFoodItem(Nutrition nutritionItem) {
    if(!checkIfFoodItemAlreadyExist(nutritionItem)) {
      this.foodHashMap.put(nutritionItem.getName(), nutritionItem);
    }
  }

  @Override
  public boolean checkIfDrinkItemAlreadyExist(Nutrition nutritionItem) {
    if(this.drinkHashMap.containsKey(nutritionItem.getName())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean checkIfFoodItemAlreadyExist(Nutrition nutritionItem) {
    if(this.foodHashMap.containsKey(nutritionItem.getName())) {
      return true;
    }
    return false;
  }

  @Override
  public Nutrition getFirstFood() {
    return this.foodHashMap.get(this.foodHashMap.keySet().iterator().next());
  }

  @Override
  public Nutrition getFirstDrink() {
    return this.drinkHashMap.get(this.drinkHashMap.keySet().iterator().next());
  }
}
