package com.SushiAPI.SushiAPI.utils.Services;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.utils.menu;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuService {
    public static HashMap<String, ArrayList<MenuItem>> getMenuItems() {
        HashMap<String, ArrayList<MenuItem>> menuItems = new HashMap<>();
        int index = 0;
        for(MenuItem item : main.items) {
            String category = item.getCategory();
            System.out.println(category);
            if(!menuItems.containsKey(category)) {
                menuItems.put(category, new ArrayList<>());
            }
            item.setId(index);
            index++;
            menuItems.get(category).add(item);
        }
        return menuItems;
    }
}
