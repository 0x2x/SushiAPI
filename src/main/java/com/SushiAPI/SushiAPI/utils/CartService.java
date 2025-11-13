package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.models.extra.Extra;
import com.SushiAPI.SushiAPI.models.rolls.Roll;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CartService {

    public static void addItem(Item item) {
        main.Cart.add(item);
    }

    public static void removeItem(Item item) {
        main.Cart.remove(item);
    }

    public static JSONArray allItemsAsJson() {
        JSONArray array = new JSONArray();

        for (Item item : main.Cart) {
            JSONObject obj = new JSONObject();
            obj.put("name", item.getName());
            obj.put("price", item.getPrice());

            // Convert List<String> extras to JSONArray
            JSONArray extrasArray = new JSONArray();
            if (item.getExtras() != null) {
                for (Object extra : item.getExtras()) {
                    extrasArray.put(extra);
                }
            }
            obj.put("extras", extrasArray);

            array.put(obj);
        }

        return array;
    }

    public static double totalAmount() { // get Total Amount
        double totalAmount = 0;
        for (int i = 0; i < main.Cart.size(); i++) {
            totalAmount += main.Cart.get(i).getPrice();
        }
        return totalAmount;
    }

    public static double totalAmount(double tip) { // get total Amount Plus TIP
        double totalAmount = 0;
        for (int i = 0; i < main.Cart.size(); i++) {
            totalAmount += main.Cart.get(i).getPrice();
        }
        return totalAmount + tip;
    }

    public static boolean pay() {
        boolean anyFoodItems = false;
        for (int i = 0; i < main.Cart.size(); i++) {
            if(main.Cart.get(i).getCategory().toLowerCase() != "drink" || main.Cart.get(i).getCategory().toLowerCase() != "appetizer") { // if not a drink or appetizer
                anyFoodItems = true;
            }
        }

        if(!anyFoodItems) return false; // no food items

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

    public static void deleteAllItems() {
        main.Cart.clear();
    }
}
