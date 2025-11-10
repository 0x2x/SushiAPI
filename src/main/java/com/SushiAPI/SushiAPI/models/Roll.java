package com.SushiAPI.SushiAPI.models;

public class Roll extends Item{
    private String name;
    private String price;
    private String description;
    private String extras;

    public Roll(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, String name1, String price1, String description, String extras) {
        super(name, price, isDrink, isHot, isAppetizer, isRaw);
        this.name = name1;
        this.price = price1;
        this.description = description;
        this.extras = extras;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
