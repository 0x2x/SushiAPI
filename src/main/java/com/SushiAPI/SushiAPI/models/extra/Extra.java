package com.SushiAPI.SushiAPI.models.extra;

import com.SushiAPI.SushiAPI.models.Item;

import java.util.ArrayList;
import java.util.List;

public class Extra{
    private static final List<String> VALID_CHOICES = List.of(
        "wasabi",
        "white rice",
        "gluten free soysauce"
    );
    private String name;

    public Extra( String name) {
        if(!VALID_CHOICES.contains(name.toLowerCase())) {
            throw new IllegalArgumentException("Invalid Extra" + name);
        }
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!VALID_CHOICES.contains(name.toLowerCase())) {
            throw new IllegalArgumentException("Invalid Extra" + name);
        }
        this.name = name.toLowerCase();
    }

    //
    public static List<String> getValidChoices() {
        return VALID_CHOICES;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "name='" + name + '\'' +
                '}';
    }
}
