package com.SushiAPI.SushiAPI.models.drinks;

import com.SushiAPI.SushiAPI.models.Item;

public class Drink extends Item {
    private String description;

    public Drink(String name, double price, boolean isHot, String description) {
        super(name, price, true, isHot, false, false);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String getCategory() {
        return "Drink";
    }
}