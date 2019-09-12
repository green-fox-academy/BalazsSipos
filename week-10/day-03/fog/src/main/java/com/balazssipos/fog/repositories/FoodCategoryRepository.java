package com.balazssipos.fog.repositories;

import com.balazssipos.fog.models.entities.FoodCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
  FoodCategory findByName(String name);
  List<FoodCategory> findAll();
  List<FoodCategory> findAllByFogUserId(Long id);
}
