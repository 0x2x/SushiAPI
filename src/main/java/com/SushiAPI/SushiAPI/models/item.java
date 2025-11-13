package com.SushiAPI.SushiAPI.models;

import java.util.List;

public class item implements MenuItem{
    private String name;
    private double price;
    private int spiceLevel;
    private List<String> ingredients;
    private List<String> extras;
    private String category;
    private boolean alcohol;
    private int id;
    private boolean cold;
    private boolean drink;

    public item() {}

    public item(String name, double price, String category, int id) {
        this.name = name;
        this.price = price;
        this.category =category;
        this.id = id;
    }
    // getters


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getSpiceLevel() {
        return spiceLevel;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public List<String> getExtras() {
        return extras;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public boolean isAlcohol() {
        return alcohol;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public boolean getCold() {
        return cold;
    }

    @Override
    public boolean isDrink() {
        return drink;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSpiceLevel(int spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }
}
