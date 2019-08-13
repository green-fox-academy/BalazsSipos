package com.balazssipos.bankofsimba.controllers;

import com.balazssipos.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimbaController {
  private List<BankAccount> bankAccountList = new ArrayList<>();

  public SimbaController() {
    this.addAccount("Scar", 10000, "lion", false);
    this.addAccount("Rafiki", 0, "monkey", false);
    this.addAccount("Pumbaa", 0, "wildpig", false);
    this.addAccount("Shenzi", 240, "hyena", false);
    this.addAccount("Mufasa", 35000, "lion", true);
  }

  @GetMapping("/show")
  public String showAccount(Model model, @RequestParam(name = "index", required = false) Integer index) {
    BankAccount bankAccount = new BankAccount("Simba", 2000, "lion", false);
    if (index != null) {
      model.addAttribute("bankAccount", this.bankAccountList.get(index));
    } else {
      model.addAttribute("bankAccount", bankAccount);
    }
    return "showAccount";
  }

  @GetMapping("/show/{int}")
  public String showAccountPath(Model model, @PathVariable(name = "int") int index) {
    model.addAttribute("bankAccount", this.bankAccountList.get(index));
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

    model.addAttribute("bankAccountList", this.getBankAccountList());
    return "multi";
  }

//  @GetMapping("show/multi/add")
//  public String addAccount(Model model, @ModelAttribute(name="bankAccount") BankAccount bankAccount) {
//    model.addAttribute("bankAccount", bankAccount);
//    return "create";
//  }

  @GetMapping("show/multi/add")
  public String addAccount(Model model) {
//    model.addAttribute("bankAccount", bankAccount);
    return "create";
  }

  @PostMapping("show/multi/add")
  public String addBook(@ModelAttribute() BankAccount bankAccount, @RequestParam("animalName") String animalName,
                        @RequestParam("balance") int balance, @RequestParam("animalType") String animalType,
                        @RequestParam("isKing") boolean isKing) {
    this.bankAccountList.add(new BankAccount(animalName, balance, animalType, isKing));
    return "redirect:/show/multi";
  }

  @PostMapping("show/multi/increaseBalance")
  public String addBalance(@RequestParam(name="selector") int selectedIndex) {
//    for (BankAccount bankAccount : this.bankAccountList) {
      if (this.bankAccountList.get(selectedIndex).isKing()) {
        this.bankAccountList.get(selectedIndex).setBalance(this.bankAccountList.get(selectedIndex).getBalance() + 100);
      } else {
        this.bankAccountList.get(selectedIndex).setBalance(this.bankAccountList.get(selectedIndex).getBalance() + 10);
      }
//    }
    return "redirect:/show/multi";
  }

  private void addAccount(String name, int balance, String animalType, boolean isKing) {
    this.bankAccountList.add(new BankAccount(name, balance, animalType, isKing));
  }

  public List<BankAccount> getBankAccountList() {
    return bankAccountList;
  }

}
