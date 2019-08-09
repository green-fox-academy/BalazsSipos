package balazssipos.webshop.controllers;

import balazssipos.webshop.models.FormData;
import balazssipos.webshop.models.ShopItem;
import balazssipos.webshop.services.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebshopController {
  private ShopItems shopItems = new ShopItems();
  private String[][] initializerArray = {
          {"Running shoes", "Nike running shoes for every day sport", "1000", "5", "Clothes and Shoes"},
          {"Printer", "Some HP printer, that will print pages", "3000", "2", "Electronics"},
          {"Coca cola", "0.5l standard coke", "25", "0", "Beverages and Snacks"},
          {"Wokin", "Chicken with fried rice and wokin sauce", "119", "100", "Beverages and Snacks"},
          {"T-shirt", "Blue with a corgi on a bike", "300", "1", "Clothes and Shoes"}
  };

  public WebshopController() {
    // Build the shopItems filed
    for (String[] item : this.initializerArray) {
      this.shopItems.addItem(new ShopItem(item[0], item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3]), item[4]));
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

  @GetMapping("/more-filters")
  public String showMoreFilters(Model model) {
    model.addAttribute("shopItems", this.shopItems.getShopItemsList());
    return "more-filters";
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
//  public String filterToSearchedItems(@ModelAttribute("shopItem") ShopItem shopItem) {
//    //model.addAttribute("simpleContent", shopItem.getName());
//    System.out.println(shopItem.getDescription());
//    return "index";
//  }

  @PostMapping("/webshop")
  public String filterToSearchedItems(@RequestParam("searchWord") String searchWord, Model model) {
    //model.addAttribute("simpleContent", shopItem.getName());
    System.out.println(searchWord);
//    System.out.println(name);
//    ShopItem shopItem = new ShopItem(name, description);
//    System.out.println(shopItem.toString());
//    System.out.println(shopItem.getName());
//    System.out.println(shopItem.getPrice());
//    System.out.println(shopItem.getQuantityInStock());
    model.addAttribute("shopItems", this.shopItems.getWebshopItemsContainSearch(searchWord));
    return "index";
  }

//  @PostMapping("/webshop")
//  public String sendForm(@ModelAttribute("formData") FormData formData) {
//    System.out.println(formData.getSearchField());
//    return "index";
//  }
}
