package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuServices implements com.SushiAPI.SushiAPI.models.menu {

    public static HashMap<String, ArrayList<Item>> getMenuItems() {
        HashMap<String, ArrayList<Item>> menuItems = new HashMap<>();
        int index = 0;
        for(Item item : main.items) {
            String category = item.getCategory();
            if(!menuItems.containsKey(category)) {
                menuItems.put(category, new ArrayList<>());
            }
            item.setId(index);
            index++;
            menuItems.get(category).add(item);
        }
        return menuItems;
    }

    public ArrayList<Item> getMenuItems(String filter) {
        ArrayList<Item> filterItems = filter(filter);
        return filterItems;
    }


    public ArrayList<Item> filter(String filter) { // drink, hot, raw, item name
//        main.items.stream().filter(item -> {
//            boolean drink = item.isDrink() == filter.equalsIgnoreCase("drink");
//            boolean raw = item.isRaw() == filter.equalsIgnoreCase("raw");
//
//            return drink;
//        }).map(item -> {
//            if(item.getName().equalsIgnoreCase(filter)) {
//                return item;
//            }
//            return null;
//        });

        return new ArrayList<>();
    }


}
