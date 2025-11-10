package com.SushiAPI.SushiAPI.models;

public class Item {
    private String name;
    private double price;
    private boolean isDrink;
    private boolean isHot;
    private boolean isAppetizer;
    private boolean isRaw;
    // Constructor
    public Item(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw) {
        this.name = name;
        this.price = price;
        this.isDrink = isDrink;
        this.isHot = isHot;
        this.isAppetizer = isAppetizer;
        this.isRaw = isRaw;
    }
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isAppetizer() {
        return isAppetizer;
    }

    public void setAppetizer(boolean appetizer) {
        isAppetizer = appetizer;
    }

    public boolean isRaw() {
        return isRaw;
    }

    public void setRaw(boolean raw) {
        isRaw = raw;
    }
}
