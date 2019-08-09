package balazssipos.webshop.models;

public class ShopItem{
    private String name;
    private String description;
    private double price;
    private int quantityInStock;
    private String type;

    public ShopItem(String name, String description, double price, int quantityInStock, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.type = type;
    }

    public ShopItem(String name, String description) {
        this(name, description, 0, 0, "other type");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: "  + this.getName() + ", description: " + this.getDescription() + ", type: " + this.getType() + ", price: " + this.getPrice() + ", quantity: " + this.getQuantityInStock();
    }
}
