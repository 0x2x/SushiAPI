package com.SushiAPI.SushiAPI.models.Sushi;

import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.item;

import java.util.ArrayList;
import java.util.List;

public abstract class Sushi extends item implements MenuItem {
    private String name;
    private double price;
    private int spiceLevel;
    private List<String> ingredients = new ArrayList<>();
    private List<String> extras = new ArrayList<>();
    private String category;

    public Sushi(String name, double price, int spiceLevel, String category, List<String> ingredients,  List<String> extras) {
        this.name = name;
        this.price = price;
        this.spiceLevel = spiceLevel;
        this.category = category;
        this.ingredients = ingredients;
        this.extras = extras;
    }

    @Override public String getName() { return this.name; }
    @Override public List<String> getIngredients() { return this.ingredients;}
    @Override public double getPrice() { return this.price; }
    @Override public int getSpiceLevel() { return this.spiceLevel; }
    @Override public List<String> getExtras() { return this.extras; }
    @Override public boolean isDrink() {return false;}

    @Override
    public String toString() {
        return "Sushi{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", spiceLevel=" + spiceLevel +
                ", ingredients=" + ingredients +
                ", extras=" + extras +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public String toCsv() {
//        name|price|SpiceLevel|ingredients|raw|extra
        // name|price|SpiceLevel|ingredients|raw|extra
        return name + "|" + price + "|" + spiceLevel + "|" + ingredients + "|" + true + "|" + extras;
    }


}
