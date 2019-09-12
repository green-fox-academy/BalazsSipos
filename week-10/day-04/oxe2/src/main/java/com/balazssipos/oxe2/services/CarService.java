package com.balazssipos.oxe2.services;

import com.balazssipos.oxe2.models.DTOs.CarDTO;
import com.balazssipos.oxe2.models.entities.Car;

import java.util.List;

public interface CarService {
  List<Car> findAllCars();
  List<Car> findAllCarsBasedOnSearch(String searchText);
  List<Car> findAllCarsBasedOnSearchFull(String searchText);
  List<Car> findAllCarsBasedOnBeginning(String searchText);
  void createCars();
  List<CarDTO> convertToCarDTO(List<Car> carList);
}
