package com.balazssipos.fog.services;

import com.balazssipos.fog.models.entities.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
  FoodCategory findFoodCategoryByName(String name);
  List<FoodCategory> findAllFoodCategoriesByUserId(Long id);
  Long addFoodCategory(Long id, FoodCategory foodCategory);
}
