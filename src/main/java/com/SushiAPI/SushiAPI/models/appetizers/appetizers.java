package com.SushiAPI.SushiAPI.models.appetizers;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.models.extra.Extra;
import org.json.JSONArray;

import java.util.List;

public class appetizers extends Item {
    public appetizers(String name, double price, boolean isDrink, boolean isHot, boolean isAppetizer, boolean isRaw, String ingredients, JSONArray extras) {
        super(name, price, isDrink, isHot, isAppetizer, isRaw, ingredients, extras);
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return ingredients;
    }

    public void setDescription(String description) {
        this.ingredients = description;
    }

    @Override
    public String getCategory() {
        return "Appetizer";
    }
}
