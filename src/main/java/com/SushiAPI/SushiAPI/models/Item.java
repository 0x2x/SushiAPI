package com.SushiAPI.SushiAPI.models;

import com.SushiAPI.SushiAPI.models.extra.Extra;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    protected String name;
    private double price;
    private boolean isDrink;
    private boolean isHot;
    private boolean isAppetizer;
    private boolean isRaw;
    private int id;
    private List<Extra> extras; // allows users to add extra spicy mayo, side of white rice, gluten-free soysauce
    // Constructor
    protected Item(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw) {
        this.name = name;
        this.price = price;
        this.isDrink = isDrink;
        this.isHot = isHot;
        this.isAppetizer = isAppetizer;
        this.isRaw = isRaw;
    }

    public Item(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, List<Extra> extras) {
        this(name, price, isDrink, isHot, isAppetizer, isRaw);
        this.extras = extras;
    }

    // shared

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

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {this.extras = extras;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //
    public abstract String getCategory();
}
