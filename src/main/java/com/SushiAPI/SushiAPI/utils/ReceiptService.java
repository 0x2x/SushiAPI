package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class ReceiptService {
    public static ArrayList<HashMap<String, Item>> generateReceipt() {
        ArrayList<HashMap<String, Item>> items = new ArrayList<>();
        main.ReceiptItems.forEach(item -> {
            HashMap<String, Item> itemHashMap = new HashMap<>();
            itemHashMap.put("testing", item);
            items.add(itemHashMap);
        });
        return items;
    }

    public static void saveItems() {
        main.ReceiptItems.forEach(item -> {
            HashMap<String, Item> itemHashMap = new HashMap<>();
            itemHashMap.put("testing", item);
            items.add(itemHashMap);
        });
    }
}
