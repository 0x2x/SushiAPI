package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import java.util.ArrayList;

public class CartService {

    public static void addItem(Item item) {
        main.Cart.add(item);
    }

    public static void removeItem(Item item) {
        main.Cart.remove(item);
    }

    public static ArrayList<Item> allItems() {
        return main.Cart;
    }

    public static double totalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < main.Cart.size(); i++) {
            totalAmount += main.Cart.get(i).getPrice();
        }
        return totalAmount;
    }

    public double totalAmount(double tip) {
        double totalAmount = 0;
        for (int i = 0; i < main.Cart.size(); i++) {
            totalAmount += main.Cart.get(i).getPrice();
        }
        return totalAmount + tip;
    }

    public static boolean pay() {
        main.ReceiptItems.addAll(main.Cart); // add to paid items
        ReceiptService.saveItems();
        main.Cart.clear(); // remove everything from cart
        return true;
    }

    public static ArrayList<Item> searchItems(String searchQuery) {
        ArrayList<Item> resultList = new ArrayList<>();
        for (int i = 0; i < main.Cart.size(); i++) {
            if(main.Cart.get(i).getName().contains(searchQuery)) {
                resultList.add(main.Cart.get(i));
            }
        }
        return resultList;
    }
}
