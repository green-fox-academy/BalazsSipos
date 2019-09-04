package com.balazssipos.rest.models;

import java.util.ArrayList;

public class Receive {
  private String what;
  private ArrayList<Integer> numbers;

  public Receive() {
  }

  public Receive(String what, ArrayList<Integer> numbers) {
    this.what = what;
    this.numbers = numbers;
  }

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public ArrayList<Integer> getNumbers() {
    return numbers;
  }

  public void setNumbers(ArrayList<Integer> numbers) {
    this.numbers = numbers;
  }

  public int sum() {
    int sum = 0;
    for (int i = 0;i<this.numbers.size();i++) {
      sum += numbers.get(i);
    }
    return sum;
  }

  public int multiply() {
    int multiply = 1;
    for (int i = 0;i<this.numbers.size();i++) {
      multiply *= numbers.get(i);
    }
    return multiply;
  }

  public ArrayList<Integer> doubleNumbers() {
    ArrayList<Integer> doubledNumbers = new ArrayList<>();
    ArrayList<Integer> originalNumbers = this.numbers;
    for (int i = 0;i<this.numbers.size();i++) {
      doubledNumbers.add(originalNumbers.get(i) * 2);
    }
    return doubledNumbers;
  }

  @Override
  public String toString() {
    return "Receive{" + "what='" + what + '\'' + ", numbers=" + numbers + '}';
  }
}
