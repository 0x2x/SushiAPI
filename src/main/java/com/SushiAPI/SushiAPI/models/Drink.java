package com.SushiAPI.SushiAPI.models;

public class Drink extends Item {
    private String name;
    private double description;
    private boolean isHot;

    public Drink(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, String name1, double description, boolean isHot1) {
        super(name, price, isDrink, isHot, isAppetizer, isRaw);
        this.name = name1;
        this.description = description;
        this.isHot = isHot1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getDescription() {
        return description;
    }

    public void setDescription(double description) {
        this.description = description;
    }

    @Override
    public boolean isHot() {
        return isHot;
    }

    @Override
    public void setHot(boolean hot) {
        isHot = hot;
    }
}