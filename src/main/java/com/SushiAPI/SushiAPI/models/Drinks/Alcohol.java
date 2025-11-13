package com.SushiAPI.SushiAPI.models.Drinks;

import java.util.List;

public class Alcohol extends Drinks{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;

    public Alcohol(String name, double price, boolean isCold, boolean isAlcohol, List<String> ingredients, List<String> extras) {
        super(name + " Alcohol", price, isCold, true, "Alcohol", ingredients, extras);
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
        return "Alcohol";
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

    @Override
    public String toString() {
        return "Alcohol{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", extras=" + extras +
                '}';
    }
}
