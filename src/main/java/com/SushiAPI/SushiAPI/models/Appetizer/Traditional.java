package com.SushiAPI.SushiAPI.models.Appetizer;

import java.util.List;

public class Traditional extends Appetizer{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;

    public Traditional(String name, double price, int spiceLevel, List<String> ingredients, List<String> extras) {
        super(name + " Traditional Appetizer", price, spiceLevel, "Appetizer", ingredients, extras);
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.extras = extras;
    }

    public List<String> getExtras() {
        return extras;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Traditional Appetizer";
    }

    @Override
    public boolean getCold() {
        return false;
    }

    @Override
    public boolean isAlcohol() {
        return false;
    }
}
