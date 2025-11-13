package com.SushiAPI.SushiAPI.models.Sushi;

import java.util.List;

public class Roll extends Sushi{
    private String name;
    private double price;
    private List<String> ingredients;
    private List<String> extras;
    private int id;
    public Roll(String name, double price, int spiceLevel, List<String> ingredients, List<String> extras) {
        super(name + " roll", price, spiceLevel, "roll", ingredients, extras);
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.extras = extras;
    }

    public List<String> getExtras() {
        return extras;
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

    @Override
    public void setId(int itemId) {
        itemId = id;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", extras=" + extras +
                '}';
    }


}
