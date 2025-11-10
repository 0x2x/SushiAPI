package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import static com.SushiAPI.SushiAPI.utils.Files.readFile;

public class menu {
    public static void loadMenu() {
        StringBuilder resultDrinks = readFile("files/menus/Drinks.csv");
        StringBuilder resultRolls = readFile("files/menus/Rolls.csv");
        StringBuilder resultAppetizers = readFile("files/menus/Appetizers.csv");

        // load drinks
        String resultDrinksString = resultDrinks.toString();
        String[] drinkLines = resultDrinksString.split("\n");
        for(String line : drinkLines) {
            if(line.trim().isEmpty()) continue;
            String[] fields = line.split("\\|");
            String name = fields[0].trim();
            double price = Double.parseDouble(fields[1].trim());
            int quantity = Integer.parseInt(fields[2].trim());
            boolean hot = Boolean.parseBoolean(fields[3].trim());
            main.items.add(new Item(name, price, true, hot, false, false));
        }
        // load rolls
        // name|price|available|ingredients|raw
        String resultRollsString = resultRolls.toString();
        String[] RollsLines = resultRollsString.split("\n");
        for(String line : RollsLines) {
            if(line.trim().isEmpty()) continue;
            String[] fields = line.split("\\|");
            String name = fields[0].trim();
            double price = Double.parseDouble(fields[1].trim());
            boolean raw = Boolean.parseBoolean(fields[4].trim());
            main.items.add(new Item(name, price, false, false, false, raw));
        }
        // load appetizers
        // name|price|description|hot
        String resultAppetizersString = resultAppetizers.toString();
        String[] AppetizersLines = resultAppetizersString.split("\n");
        for(String line : AppetizersLines) {
            if(line.trim().isEmpty()) continue;
            String[] fields = line.split("\\|");
            String name = fields[0].trim();
            double price = Double.parseDouble(fields[1].trim());
            boolean hot = Boolean.parseBoolean(fields[3].trim());
            main.items.add(new Item(name, price, false, hot, false, false));
        }
    }
}
