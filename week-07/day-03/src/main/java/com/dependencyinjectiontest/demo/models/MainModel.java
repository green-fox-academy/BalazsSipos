package com.dependencyinjectiontest.demo.models;

public class MainModel {
  private int count = 0;

  public void incrementCount(){
    count++;
  }

  public int getCount(){
    return count;
  }
}