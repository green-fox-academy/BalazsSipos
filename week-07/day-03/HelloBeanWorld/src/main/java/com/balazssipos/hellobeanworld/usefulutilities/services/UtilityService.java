package com.balazssipos.hellobeanworld.usefulutilities.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UtilityService {
  ArrayList<String> colors;
  Random random;

  public UtilityService() {
    this.colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("orange");
    colors.add("magenta");
    this.random = new Random();
  }

  public String randomColor() {
    return this.colors.get(random.nextInt(colors.size()));
  }

  public boolean validateEmail(String emailToValidate) {
    if(emailToValidate.contains("@") && emailToValidate.contains(".")) {
      return true;
    }
    return false;
  }

  public String caesar(String text, int number) {
    if (number < 0) {
      number = 26 + number;
    }

    String result = "";
    for(int i = 0; i < text.length(); i++) {
      int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
      result += (char)(((int)text.charAt(i) + number - offset) % 26 + offset);
    }
    return result;
  }
}
