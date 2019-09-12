package com.balazssipos.oxe2.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
  @Id
  @GeneratedValue
  @JsonIgnore
  private Long id;
  private String plate;
  private String carBrand;
  private String carModel;
  private String color;
  private short year;

  public Car() {
  }

  public Car(String plate, String carBrand, String carModel, String color, short year) {
    this.plate = plate;
    this.carBrand = carBrand;
    this.carModel = carModel;
    this.color = color;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
  }

  public String getCarModel() {
    return carModel;
  }

  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public short getYear() {
    return year;
  }

  public void setYear(short year) {
    this.year = year;
  }
}
