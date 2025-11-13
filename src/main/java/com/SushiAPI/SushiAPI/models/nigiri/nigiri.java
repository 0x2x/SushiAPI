package com.SushiAPI.SushiAPI.models.nigiri;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.models.extra.Extra;
import org.json.JSONArray;

import java.util.List;

public class nigiri extends Item {
    private String description;

    public nigiri(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, String description, JSONArray extras) {
        super(name, price, isDrink, isHot, isAppetizer, isRaw, description,  extras);
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
        return "nigiri";
    }
}
