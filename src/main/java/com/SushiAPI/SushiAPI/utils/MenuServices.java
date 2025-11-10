package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MenuServices implements com.SushiAPI.SushiAPI.models.menu {

    public static List<Item> getMenuItems() {
        return  main.items;
    }

    public ArrayList<Item> getMenuItems(String filter) {
        ArrayList<Item> filterItems = filter(filter);
        return filterItems;
    }


    public ArrayList<Item> filter(String filter) { // drink, hot, raw, item name
        main.items.stream().filter(item -> {
            boolean drink = item.isDrink() == filter.equalsIgnoreCase("drink");
            boolean raw = item.isRaw() == filter.equalsIgnoreCase("raw");

            return drink;
        }).map(item -> {
            if(item.getName().equalsIgnoreCase(filter)) {
                return item;
            }
            return null;
        });

        return new ArrayList<>();
    }


}
