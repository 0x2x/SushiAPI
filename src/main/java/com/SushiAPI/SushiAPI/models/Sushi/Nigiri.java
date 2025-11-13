package com.SushiAPI.SushiAPI.models.Sushi;

import java.util.List;

public class Nigiri extends Sushi{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;

    public Nigiri(String name, double price, int spiceLevel, List<String> ingredients, List<String> extras) {
        super(name + " Nigiri", price, spiceLevel, "Nigiri", ingredients, extras);
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
        return "roll";
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
