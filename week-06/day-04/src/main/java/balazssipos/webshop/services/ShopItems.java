package balazssipos.webshop.services;

import balazssipos.webshop.models.ShopItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ShopItems {
  private ArrayList<ShopItem> shopItemsList = new ArrayList<ShopItem>();

//  public ShopItems() {}
//
//  public ShopItems(ArrayList<ShopItem> shopItems) {
//    this.shopItems = shopItems;
//  }

  public void addItem(ShopItem item) {
    this.shopItemsList.add(item);
  }

  public ArrayList<ShopItem> getShopItemsList() {
    return shopItemsList;
  }

  public ArrayList<ShopItem> getAvailableWebshopItems() {
    //ArrayList<ShopItem> itemList = new ArrayList<>();
    ArrayList<ShopItem> itemList = this.getShopItemsList().stream()
            .filter(shopItem -> shopItem.getQuantityInStock() > 0)
            .collect(Collectors.toCollection(ArrayList::new));
    return itemList;
  }

  public ArrayList<ShopItem> cheapestFirst() {
    ArrayList<ShopItem> sortedList = this.getShopItemsList().stream()
            .sorted(Comparator.comparingInt(ShopItem::getPrice))
            .collect(Collectors.toCollection(ArrayList::new));
    return sortedList;
  }

  public ArrayList<ShopItem> getWebshopItemsContainNike() {
    ArrayList<ShopItem> itemList = this.getShopItemsList().stream()
            .filter(shopItem -> shopItem.getName().toLowerCase().contains("nike") || shopItem.getDescription().toLowerCase().contains("nike"))
            .collect(Collectors.toCollection(ArrayList::new));
    return itemList;
  }

  public double calculateAverageStock() {
    double sumStock = this.getShopItemsList().stream()
            .mapToDouble(shopItem -> shopItem.getQuantityInStock())
            .sum();
    return sumStock / this.getShopItemsList().size();
  }

  public ShopItem getMostExpensiveItem() {
    ShopItem mostExpensive= this.getShopItemsList().stream()
            .max(Comparator.comparing(ShopItem::getPrice))
            .get();
    return mostExpensive;
  }
}
