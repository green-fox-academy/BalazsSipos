package com.balazssipos.oxe2.models.DTOs;

import com.balazssipos.oxe2.models.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsDTO {
  private String result;
  List<CarDTO> data;

  public CarsDTO() {
    this.data = new ArrayList<>();
  }

  public CarsDTO(String result, List<CarDTO> data) {
    this.result = result;
    this.data = data;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<CarDTO> getData() {
    return data;
  }

  public void setData(List<CarDTO> data) {
    this.data = data;
  }

  public void addCar(CarDTO carDTO) {
    this.data.add(carDTO);
  }
}
