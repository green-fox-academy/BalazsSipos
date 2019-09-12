package com.balazssipos.oxe2.controllers;

import com.balazssipos.oxe2.models.DTOs.CarsDTO;
import com.balazssipos.oxe2.models.entities.Car;
import com.balazssipos.oxe2.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarRestController {
  private CarService carService;

  @Autowired
  public CarRestController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/api/search/{brand}")
  public ResponseEntity filterToBrand(@PathVariable("brand") String brand) {
    List<Car> carList = this.carService.findAllCarsBasedOnSearchFull(brand);
    CarsDTO carsDTO = new CarsDTO("ok", this.carService.convertToCarDTO(carList));
    return ResponseEntity.status(200).body(carsDTO);
  }
}
