package com.balazssipos.fog.services;

import com.balazssipos.fog.models.entities.FogUser;
import com.balazssipos.fog.models.entities.Food;
import com.balazssipos.fog.models.entities.FoodCategory;
import com.balazssipos.fog.repositories.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
  private FoodCategoryRepository foodCategoryRepository;
  private FogUserService fogUserService;

  @Autowired
  public FoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository, FogUserService fogUserService) {
    this.foodCategoryRepository = foodCategoryRepository;
    this.fogUserService = fogUserService;
  }

  @Override
  public FoodCategory findFoodCategoryByName(String name) {
    return this.foodCategoryRepository.findByName(name);
  }

  @Override
  public List<FoodCategory> findAllFoodCategoriesByUserId(Long id) {
    return this.foodCategoryRepository.findAllById(id);
  }

  @Override
  public Long addFoodCategory(Long id, FoodCategory foodCategory) {
    FoodCategory foundFoodCategory = this.findFoodCategoryByName(foodCategory.getName());
    if(foundFoodCategory == null) {
      FogUser fogUser = this.fogUserService.findUserById(id);
      if(fogUser != null) {
        fogUser.addFoodCategory(foodCategory);
        this.fogUserService.updateUser(fogUser);
      }
//      FoodCategory newFoodCategory = this.foodCategoryRepository.save(foodCategory);
      return foodCategory.getId();
    }
    return foundFoodCategory.getId();
  }
}
