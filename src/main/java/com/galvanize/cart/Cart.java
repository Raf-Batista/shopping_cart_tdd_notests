package com.galvanize.cart;
import java.util.*;

public class Cart {
    public HashMap<Item, Integer> userCart = new HashMap<Item, Integer>();
    public Integer itemQuantity = 0;
    public Double totalPrice = 0.0;
    public Set<Item> onSale = new HashSet<Item>();

    public void addItem(Item item, Integer quantity) {
        this.itemQuantity += quantity;
        if (this.userCart.containsKey(item)) {
            this.userCart.put(item, this.userCart.get(item) + quantity);
        } else {
            this.userCart.put(item, quantity);
        }

        if (!this.onSale.contains(item)) {
            this.onSale.add(item);
        }

        this.totalPrice = roundToTwoPlaces((item.price * quantity) + this.totalPrice);
    }

    private static double roundToTwoPlaces(double d) {
        return Math.round(d * 100) / 100.0;
    }

    public HashMap<Item, Integer> itemizedList() {
        return this.userCart;
    }
}
