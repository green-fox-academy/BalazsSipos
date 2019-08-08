package balazssipos.webshop.models;

public class ShopItem{
    private String name;
    private String description;
    private int price;
    private int quantityInStock;

    public ShopItem(String name, String description, int price, int quantityInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
}
