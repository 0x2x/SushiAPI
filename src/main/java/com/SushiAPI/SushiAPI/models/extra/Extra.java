package com.SushiAPI.SushiAPI.models.extra;

import com.SushiAPI.SushiAPI.models.Item;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class Extra{

    private String name;

    public Extra( String name) {
//        if(!VALID_CHOICES.contains(name.toLowerCase())) {
//            throw new IllegalArgumentException("Invalid Extra" + name);
//        }
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
//        if(!VALID_CHOICES.contains(name.toLowerCase())) {
//            throw new IllegalArgumentException("Invalid Extra" + name);
//        }
        this.name = name.toLowerCase();
    }

    //
    @Override
    public String toString() {
        return "Extra{" +
                "name='" + name + '\'' +
                '}';
    }
}
