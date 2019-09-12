package com.balazssipos.oxe2.repositories;

import com.balazssipos.oxe2.models.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
  List<Car> findAll();
  List<Car> findByPlateContaining(String searchText);
  List<Car> findByPlateStartingWith(String searchText);
  List<Car> findByCarBrandLike(String searchText);
}
