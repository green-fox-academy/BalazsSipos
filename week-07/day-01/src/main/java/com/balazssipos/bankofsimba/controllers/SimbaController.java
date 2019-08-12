package com.balazssipos.bankofsimba.controllers;

import com.balazssipos.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimbaController {
  private List<BankAccount> bankAccountList = new ArrayList<>();

  @GetMapping("/show")
  public String showAccount(Model model) {
    BankAccount bankAccount = new BankAccount("Simba", 2000, "lion", false);
    model.addAttribute("bankAccount", bankAccount);
    return "showAccount";
  }



  @GetMapping("/checkutext")
  public String checkUtext(Model model) {
    String htmlText = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("testString", htmlText);
    return "checkutext";
  }

  @GetMapping("show/multi")
  public String showMultipleAccounts(Model model) {
    this.addAccount("Scar", 10000, "lion", false);
    this.addAccount("Rafiki", 0, "monkey", false);
    this.addAccount("Pumbaa", 0, "wildpig", false);
    this.addAccount("Shenzi", 240, "hyena", false);
    this.addAccount("Mufasa", 35000, "lion", true);
    model.addAttribute("bankAccountList", this.getBankAccountList());
    return "multi";
  }

  private void addAccount(String name, double balance, String animalType, boolean isKing) {
    this.bankAccountList.add(new BankAccount(name, balance, animalType, isKing));
  }

  public List<BankAccount> getBankAccountList() {
    return bankAccountList;
  }

}
