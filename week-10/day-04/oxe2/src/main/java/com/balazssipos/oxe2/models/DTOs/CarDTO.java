package com.balazssipos.oxe2.models.DTOs;

public class CarDTO {
  private String plate;
  private String car_brand;
  private String car_model;
  private String color;
  private short year;

  public CarDTO(String plate, String car_brand, String car_model, String color, short year) {
    this.plate = plate;
    this.car_brand = car_brand;
    this.car_model = car_model;
    this.color = color;
    this.year = year;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getCar_brand() {
    return car_brand;
  }

  public void setCar_brand(String car_brand) {
    this.car_brand = car_brand;
  }

  public String getCar_model() {
    return car_model;
  }

  public void setCar_model(String car_model) {
    this.car_model = car_model;
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
