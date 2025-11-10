package com.SushiAPI.SushiAPI.models.rolls;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.models.extra.Extra;

import java.util.List;

public class Roll extends Item {
    private String description;

    public Roll(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, String description, List<Extra> extras) {
        super(name, price, isDrink, isHot, isAppetizer, isRaw);
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
        return "Roll";
    }
}
