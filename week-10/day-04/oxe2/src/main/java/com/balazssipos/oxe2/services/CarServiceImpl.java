package com.balazssipos.oxe2.services;

import com.balazssipos.oxe2.models.DTOs.CarDTO;
import com.balazssipos.oxe2.models.entities.Car;
import com.balazssipos.oxe2.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
  private CarRepository carRepository;

  @Autowired
  public CarServiceImpl(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public List<Car> findAllCars() {
    return this.carRepository.findAll();
  }

  @Override
  public List<Car> findAllCarsBasedOnSearch(String searchText) {
    System.out.println(searchText.matches("[-A-Za-z0-9]+"));
    if(searchText.matches("[-A-Za-z0-9]+") && searchText.length() <= 7) {
      System.out.println("ok");
      return this.carRepository.findByPlateContaining(searchText);
    } else {
      return null;
    }

  }

  @Override
  public List<Car> findAllCarsBasedOnSearchFull(String searchText) {
    return this.carRepository.findByCarBrandLike(searchText);
  }

  @Override
  public List<Car> findAllCarsBasedOnBeginning(String searchText) {
    return this.carRepository.findByPlateStartingWith(searchText);
  }

  @Override
  public void createCars() {
    Car car1 = new Car("ABC-123", "IFA", "T", "Blue", (short) 1976);
    Car car2 = new Car("ABC-456", "Wartburg", "W", "Red", (short) 1986);
    Car car3 = new Car("DEF-456", "Trabant", "601", "White", (short) 1983);
    Car car4 = new Car("RBC-789", "Trabant", "601", "Yellow", (short) 1979);
    Car car5 = new Car("DTC-789", "Lada", "1200", "Green", (short) 1978);

    this.carRepository.save(car1);
    this.carRepository.save(car2);
    this.carRepository.save(car3);
    this.carRepository.save(car4);
    this.carRepository.save(car5);
  }

  @Override
  public List<CarDTO> convertToCarDTO(List<Car> carList) {
    List<CarDTO> carDTOList = new ArrayList<>();
    for (Car car : carList) {
      carDTOList.add(new CarDTO(car.getPlate(), car.getCarBrand(), car.getCarModel(), car.getColor(), car.getYear()));
    }
    return carDTOList;
  }
}
