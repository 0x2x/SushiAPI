package com.SushiAPI.SushiAPI.models.Drinks;

import java.util.List;

public class Soda extends Drinks{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;

    public Soda(String name, double price, boolean isCold, boolean isAlcohol, List<String> ingredients, List<String> extras) {
        super(name + " Soda", price, isCold, false, "Soda", ingredients, extras);
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.extras = extras;
    }

    @Override
    public int getSpiceLevel() {
        return 0;
    }

    @Override
    public String getCategory() {
        return "Soda";
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
    public boolean getCold() {
        return false;
    }

    @Override
    public boolean isAlcohol() {
        return false;
    }
}
