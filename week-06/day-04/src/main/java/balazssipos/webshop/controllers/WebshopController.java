package balazssipos.webshop.controllers;

import balazssipos.webshop.models.FormData;
import balazssipos.webshop.models.ShopItem;
import balazssipos.webshop.services.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
  private List<String> categoriesList = Arrays.asList("Clothes and Shoes", "Electronics", "Beverages and Snacks");
  //{"Clothes and Shoes", "Electronics", "Beverages and Snacks"};
  private double eurCurrencyRate = 250;
  private boolean isInEuro = false;

  public WebshopController() {
    // Build the shopItems filed
    for (String[] item : this.initializerArray) {
      this.shopItems.addItem(new ShopItem(item[0], item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3]),
              item[4]));
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
    model.addAttribute("categoriesList", this.categoriesList);
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
    model.addAttribute("simpleContent", "Most expensive product: " + mostExpensiveItem.getName() + ", with a price of" +
            " " + mostExpensiveItem.getPrice() + ".");
    return "one-line-content";
  }

  @GetMapping("/filter-by-type/{type}")
  public String getFilteredByCategoryList(@PathVariable("type") String categoryType, Model model) {
//    System.out.println(type);
    System.out.println(categoryType);
    model.addAttribute("shopItems", this.shopItems.getShopitemsBasedOnCategory(categoryType));
    model.addAttribute("categoriesList", this.categoriesList);
    return "more-filters";
  }

//  @PostMapping("/webshop")
//  public String filterToSearchedItems(@ModelAttribute("shopItem") ShopItem shopItem) {
//    //model.addAttribute("simpleContent", shopItem.getName());
//    System.out.println(shopItem.getDescription());
//    return "index";
//  }



  @GetMapping("/price-in-eur")
  public String getShopItemsListInForeignCurrency(Model model) {
    System.out.println(this.isInEuro);
    if (this.isInEuro) {
      System.out.println("eur if ag futott");
      model.addAttribute("shopItems", this.shopItems.getShopItemsList());
    } else {
      System.out.println("eur else ag futott");
      model.addAttribute("shopItems", this.shopItems.getShopItemsListInOtherCurrency(this.eurCurrencyRate));
      this.isInEuro = true;
    }

    model.addAttribute("categoriesList", this.categoriesList);

    return "more-filters";
  }

  @GetMapping("/price-in-original")
  public String getShopItemsListInOriginalCurrency(Model model) {
    System.out.println(this.isInEuro);
    if (!this.isInEuro) {
      model.addAttribute("shopItems", this.shopItems.getShopItemsList());
//      System.out.println("huf if ag futott");
    } else {
      model.addAttribute("shopItems", this.shopItems.getShopItemsListInOtherCurrency(1 / this.eurCurrencyRate));
      this.isInEuro = false;
//      System.out.println("huf else ag futott");
    }

    model.addAttribute("categoriesList", this.categoriesList);

    return "more-filters";
  }

  @PostMapping("/webshop")
  public String filterToSearchedItems(@RequestParam("searchWord") String searchWord, Model model) {
    model.addAttribute("shopItems", this.shopItems.getWebshopItemsContainSearch(searchWord));
    return "index";
  }

  @PostMapping("/filter-by-price")
  public String filterToSearchedPrice(Model model, @RequestParam("operand") String operand, @RequestParam("searchedPrice") int searchedPrice) {
    System.out.println(operand);
//    System.out.println(below);
    System.out.println(searchedPrice);
    if(operand.equals("Above") || operand.equals("Below") || operand.equals("Exactly")) {
      model.addAttribute("shopItems", this.shopItems.getShopitemsBasedOnPrice(operand, searchedPrice));
    }
    model.addAttribute("categoriesList", this.categoriesList);
    return "more-filters";
  }

//  @PostMapping("/webshop")
//  public String sendForm(@ModelAttribute("formData") FormData formData) {
//    System.out.println(formData.getSearchField());
//    return "index";
//  }
}
