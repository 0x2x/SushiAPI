package com.SushiAPI.SushiAPI.models.Drinks;

import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.item;

import java.util.ArrayList;
import java.util.List;

public abstract class Drinks extends item implements MenuItem {
    private String name;
    private double price;
    private boolean isCold;
    private List<String> ingredients = new ArrayList<>();
    private List<String> extras = new ArrayList<>();
    private String category;
    private boolean isAlcohol;

    public Drinks(String name, double price, boolean isCold, boolean isAlcohol, String category, List<String> ingredients,  List<String> extras) {
        this.name = name;
        this.price = price;
        this.isCold = isCold;
        this.category = category;
        this.ingredients = ingredients;
        this.extras = extras;
        this.isAlcohol = isAlcohol;
    }

    @Override public String getName() { return this.name; }
    @Override public List<String> getIngredients() { return this.ingredients;}
    @Override public double getPrice() { return this.price; }
    @Override public boolean getCold() { return this.isCold; }
    @Override public List<String> getExtras() { return this.extras; }
    @Override public boolean isDrink() {return true;}
    @Override
    public boolean isAlcohol() {
        return isAlcohol;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isCold=" + isCold +
                ", ingredients=" + ingredients +
                ", extras=" + extras +
                ", category='" + category + '\'' +
                ", isAlcohol=" + isAlcohol +
                '}';
    }
}
