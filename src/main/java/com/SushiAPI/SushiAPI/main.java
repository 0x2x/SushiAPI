package com.SushiAPI.SushiAPI;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.utils.menu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static boolean init = false;
    public static final ArrayList<Item> items = new ArrayList<>();
    public static final ArrayList<Item> Cart = new ArrayList<>();
    public static final ArrayList<Item> ReceiptItems = new ArrayList<>();

    public static void initialize() {
        if(!init) {
            menu.loadMenu();
        }
        init = true;
    }
    static void main() {
        initialize();
        SushiApiApplication.start();
    }
}
