package balazssipos.webshop.controllers;

import balazssipos.webshop.models.FormData;
import balazssipos.webshop.models.ShopItem;
import balazssipos.webshop.services.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebshopController {
  private ShopItems shopItems = new ShopItems();
  private String[][] initializerArray = {
          {"Running shoes", "Nike running shoes for every day sport", "1000", "5"},
          {"Printer", "Some HP printer, that will print pages", "3000", "2"},
          {"Coca cola", "0.5l standard coke", "25", "0"},
          {"Wokin", "Chicken with fried rice and wokin sauce", "119", "100"},
          {"T-shirt", "Blue with a corgi on a bike", "300", "1"}
  };

  public WebshopController() {
    // Build the shopItems filed
    for (String[] item : this.initializerArray) {
      this.shopItems.addItem(new ShopItem(item[0], item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
    }
  }

  @GetMapping("/webshop2")
  @ResponseBody
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/webshop")
  public String showWebshopItems(Model model) {
    model.addAttribute("shopItems", this.shopItems.getShopItemsList());
    return "index";
  }

  @GetMapping("/only-available")
  public String showAvailableWebshopItems(Model model) {
    model.addAttribute("shopItems", this.shopItems.getAvailableWebshopItems());
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String showWebshopItemsByPrice(Model model) {
    model.addAttribute("shopItems", this.shopItems.cheapestFirst());
    return "index";
  }

  @GetMapping("/contains-nike")
  public String showWebshopItemsContainsNike(Model model) {
    model.addAttribute("shopItems", this.shopItems.getWebshopItemsContainNike());
    return "index";
  }

  @GetMapping("/average-stock")
  public String calculateAverageStock(Model model) {
    model.addAttribute("simpleContent", "Average stock: " + this.shopItems.calculateAverageStock());
    return "one-line-content";
  }

  @GetMapping("/most-expensive")
  public String getMostExpensiveProduct(Model model) {
    ShopItem mostExpensiveItem = this.shopItems.getMostExpensiveItem();
    model.addAttribute("simpleContent", "Most expensive product: " + mostExpensiveItem.getName() + ", with a price of " + mostExpensiveItem.getPrice() + ".");
    return "one-line-content";
  }

//  @PostMapping("/webshop")
//  public String filterToSearchedItems(@ModelAttribute ShopItem shopItem) {
//    //model.addAttribute("simpleContent", shopItem.getName());
//    System.out.println(shopItem.getName());
//    return "index";
//  }

  @PostMapping("/webshop")
  public String sendForm(@ModelAttribute("formData") FormData formData) {
    System.out.println(formData.getSearchField());
    return "index";
  }
}
