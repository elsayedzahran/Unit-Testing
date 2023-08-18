package org.example.store;

public class Product {
    private String name;
    private int price;
    private int quantity;


    public int getQuantity() {
        return  quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
