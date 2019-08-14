package com.balazssipos.hellobeanworld.services;

import com.balazssipos.hellobeanworld.colors.MyColor;


public class GreenColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is green in color...");
  }
}
