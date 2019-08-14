package com.balazssipos.hellobeanworld.colors;

import com.balazssipos.hellobeanworld.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor {
  private Printer printer;

  @Autowired
  private RedColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("It is red in color...");
//    System.out.println(LocalDateTime.now() + " It is red in color...");
  }
}
