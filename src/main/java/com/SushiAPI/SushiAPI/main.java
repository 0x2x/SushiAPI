package com.SushiAPI.SushiAPI;

import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.utils.menu;

import java.util.ArrayList;

public class main {
    public static boolean init = false; // Safety check; Make sures no duplicates.
    public static final ArrayList<MenuItem> items = new ArrayList<>(); // Load in active cache for Menu
    public static final ArrayList<MenuItem> Cart = new ArrayList<>(); // Load items from users cart using REST API
    public static final ArrayList<MenuItem> ReceiptItems = new ArrayList<>(); // Generate Receipt from CART

    public static void initialize() { // Loads CSV FILES
        if(!init) {
            menu.loadMenu();
        }
        init = true;
    }
    static void main() { // Main Application
        initialize(); // run Function
        SushiApiApplication.start(); // Start Server
    }
}
