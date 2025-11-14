package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Appetizer.Seafoods;
import com.SushiAPI.SushiAPI.models.Appetizer.Traditional;
import com.SushiAPI.SushiAPI.models.Drinks.Alcohol;
import com.SushiAPI.SushiAPI.models.Drinks.Soda;
import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;

import java.util.Arrays;

import static com.SushiAPI.SushiAPI.utils.Files.readFile;

public class menu {
    // Load items from CSV to ArrayList
    public static void loadMenu() {
        StringBuilder resultDrinks = readFile("files/menus/Drinks.csv");
        StringBuilder resultRolls = readFile("files/menus/Rolls.csv");
        StringBuilder resultAppetizers = readFile("files/menus/Appetizers.csv");
        StringBuilder resultNigiri = readFile("files/menus/Nigiri.csv");

        // load drinks
        // name|price|size|hot|alcohol
        String resultDrinksString = resultDrinks.toString();
        String[] drinkLines = resultDrinksString.split("\n");
        for(String line : drinkLines) {
            String[] lineSplit = line.split("\\|"); // split data
            // grab needed parameters
            String drinkName = lineSplit[0];
            double drinkPrice = Double.parseDouble(lineSplit[1]);
            int drinkSize = Integer.parseInt(lineSplit[2]);
            boolean drinkIsHot = Boolean.parseBoolean(lineSplit[3]);
            boolean drinkIsAlcohol = Boolean.parseBoolean(lineSplit[4]);

            if(drinkIsAlcohol) { // if alcohol
                main.items.add(new Alcohol(drinkName, drinkPrice, drinkIsHot, drinkIsAlcohol, null, null));
            } else {
                main.items.add(new Soda(drinkName, drinkPrice, drinkIsHot, drinkIsAlcohol, null, null));
            }
        }
        // load rolls
        // name|price|SpiceLevel|ingredients|raw|extra
        String resultRollsString = resultRolls.toString();
        String[] RollsLines = resultRollsString.split("\n");
        for(String line : RollsLines) {
            String[] lineSplit = line.split("\\|"); // split data
            // grab needed parameters
            String rollName = lineSplit[0];
            double rollPrice = Double.parseDouble(lineSplit[1]);
            int rollSpice = Integer.parseInt(lineSplit[2]);
            String[] rollIngredients = lineSplit[3].split(", ");
            boolean rollRaw = Boolean.parseBoolean(lineSplit[4]);
            String[] rollExtra = lineSplit[5].split(",");

            main.items.add(
                    new Roll(rollName, rollPrice, rollSpice, Arrays.asList(rollIngredients), Arrays.asList(rollExtra))
            );


        }
        // load Nigiri
        // name|price|SpiceLevel|ingredients|raw|extra
        String resultNigiriString = resultNigiri.toString();
        String[] nigiriLines = resultNigiriString.split("\n");
        for(String line : nigiriLines) {
            String[] lineSplit = line.split("\\|"); // split data
            // grab needed parameters
            String nigiriName = lineSplit[0];
            double nigiriPrice = Double.parseDouble(lineSplit[1]);
            int nigiriSpice = Integer.parseInt(lineSplit[2]);
            String[] nigiriIngredients = lineSplit[3].split(", ");
            boolean nigiriRaw = Boolean.parseBoolean(lineSplit[4]);
            String[] nigiriExtra = lineSplit[5].split(",");

            main.items.add(
                    new Nigiri(nigiriName, nigiriPrice, nigiriSpice, Arrays.asList(nigiriIngredients), Arrays.asList(nigiriExtra))
            );


        }
        // load appetizers
        // name|price|ingredients|hot|type
        String resultAppetizersString = resultAppetizers.toString();
        String[] AppetizersLines = resultAppetizersString.split("\n");
        for(String line : AppetizersLines) {
            String[] lineSplit = line.split("\\|"); // split data

            // grab needed parameters
            String appetizersName = lineSplit[0];
            double appetizersPrice = Double.parseDouble(lineSplit[1]);
            String[] appetizersIngredients = lineSplit[2].split(", ");
            boolean appetizersisHot = Boolean.parseBoolean(lineSplit[3]);
            String appetizersType = lineSplit[4];

            /*
                types:
                0 = Traditional
                1 = Seafood
             */
            if(appetizersType.equalsIgnoreCase("0")) {
                main.items.add(
                        new Traditional(appetizersName, appetizersPrice, 0, Arrays.asList(appetizersIngredients), null)
                );
            } else if(appetizersType.equalsIgnoreCase("1")) {
                main.items.add(
                        new Seafoods(appetizersName, appetizersPrice, 0, Arrays.asList(appetizersIngredients), null)
                );
            }



        }
    }
}
