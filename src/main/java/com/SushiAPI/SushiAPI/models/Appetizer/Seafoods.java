package com.SushiAPI.SushiAPI.models.Appetizer;

import java.util.List;

public class Seafoods extends Appetizer{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;

    public Seafoods(String name, double price, int spiceLevel, List<String> ingredients, List<String> extras) {
        super(name + " Seafood Appetizer", price, spiceLevel, "Appetizer", ingredients, extras);
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
        return "Seafood Appetizer";
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
        return "Seafoods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", extras=" + extras +
                '}';
    }
}
