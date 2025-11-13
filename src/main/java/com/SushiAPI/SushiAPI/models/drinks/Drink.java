package com.SushiAPI.SushiAPI.models.drinks;

import com.SushiAPI.SushiAPI.models.Item;

public class Drink extends Item {

    public Drink(String name, double price, boolean isHot, String ingredients) {
        super(name, price, true, isHot, false, false, ingredients);
    }

    public String getDescription() {
        return ingredients;
    }

    public void setDescription(String description) {
        this.ingredients = description;
    }


    @Override
    public String getCategory() {
        return "Drink";
    }
}