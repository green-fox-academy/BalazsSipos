package com.balazssipos.rest.models.models.doUntil;

public class DoUntil {
  private int until;

  public DoUntil() {
  }

  public DoUntil(int until) {
    this.until = until;
  }

  public int getUntil() {
    return until;
  }

//  public void setUntil(int until) {
//    this.until = until;
//  }

  public int sumNumbers() {
    int sumOfNumbers = 0;
    for (int i=1;i<=this.getUntil();i++) {
      sumOfNumbers += i;
    }
    return sumOfNumbers;
  }

  public int factorNumbers() {
    int factorOfNumbers = 1;
    for (int i=1;i<=this.getUntil();i++) {
      factorOfNumbers *= i;
    }
    return factorOfNumbers;
  }
}
