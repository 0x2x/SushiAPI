package com.SushiAPI.SushiAPI.utils.Services;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import org.json.JSONArray;
import org.json.JSONObject;

public class CartService {
    public static MenuItem findItemByName(String name) {
        return main.items.stream().filter(product -> product.getName().toLowerCase().startsWith(name.toLowerCase().strip())).findFirst().orElse(null); // filter though
    }
    public static void addItemByItem(MenuItem item) {
        main.Cart.add(item);
    }

    public static boolean removeItem(MenuItem item) {
        if(main.Cart.contains(item)) {
            main.Cart.remove(item);
            return true;
        }
        return false;
    }

    public static double totalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < main.Cart.size(); i++) {
            totalAmount += main.Cart.get(i).getPrice();
        }
        return totalAmount;
    }

    public static boolean pay() {
        boolean anyFoodItems = false;
        for (int i = 0; i < main.Cart.size(); i++) {
            if(!main.Cart.get(i).getCategory().equalsIgnoreCase("drink") || !main.Cart.get(i).getCategory().equalsIgnoreCase("appetizer")) { // if not a drink or appetizer
                anyFoodItems = true;
            }
        }

        if(!anyFoodItems) return false;

        main.ReceiptItems.addAll(main.Cart); // move to receipts;
        // generate receipt here
        ReceiptService.saveItems();
        main.Cart.clear();
        return true;
    }

    public static JSONArray AllItems() {
        JSONArray array = new JSONArray();
        for(MenuItem item : main.Cart) {
            JSONObject obj = new JSONObject(); // create new Map style
            obj.put("name", item.getName());
            obj.put("price", item.getPrice());
            obj.put("category", item.getCategory());
            obj.put("isCold", item.getCold());
            obj.put("SpiceLevel", item.getSpiceLevel());
            obj.put("Ingredients", item.getIngredients());

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
}
