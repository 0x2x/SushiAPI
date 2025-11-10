package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuServices implements com.SushiAPI.SushiAPI.models.menu {

    public static ArrayList<Map<String, Item>> getMenuItems() {
        ArrayList<Map<String, Item>> menuItems = new ArrayList<>();
        main.items.forEach(item -> {
            Map<String, Item> Data = new HashMap<>();
            Data.put(item.getCategory(), item);
            menuItems.add(Data);
        });
        System.out.println(menuItems);
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
