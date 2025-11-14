package com.SushiAPI.SushiAPI.models;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public interface MenuItem {
    String getName();
    String getCategory();
    List<String> getIngredients();

    double getPrice();
    int getSpiceLevel();
    List<String> getExtras();
    boolean isDrink();
    boolean getCold();
    boolean isAlcohol();
    void setId(int id);
    int getId();
    String toCsv();
}
