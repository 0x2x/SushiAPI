package com.SushiAPI.SushiAPI.models.Appetizer;

import com.SushiAPI.SushiAPI.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Appetizer implements MenuItem {
    private String name;
    private double price;
    private int spiceLevel;
    private List<String> ingredients = new ArrayList<>();
    private List<String> extras = new ArrayList<>();
    private String category;

    public Appetizer(String name, double price, int spiceLevel, String category, List<String> ingredients,  List<String> extras) {
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

}
