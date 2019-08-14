package com.balazssipos.hellobeanworld;

import com.balazssipos.hellobeanworld.colors.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanworldApplication implements CommandLineRunner {
  private MyColor myColor;
//  private Printer printer;

  @Autowired
  HellobeanworldApplication(MyColor myColor){
//    this.printer = printer;
    this.myColor = myColor;
  }
  public static void main(String[] args) {
    SpringApplication.run(HellobeanworldApplication.class, args);
  }

  public void run(String[] args) {
//    this.printer.log("Ciao!");
    this.myColor.printColor();
  }

}
