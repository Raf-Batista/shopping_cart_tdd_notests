package com.galvanize.cart;

public class Item {
    public String name;
    public Double price;
    public boolean onSale;

    public Item(String name, Double price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }


}
