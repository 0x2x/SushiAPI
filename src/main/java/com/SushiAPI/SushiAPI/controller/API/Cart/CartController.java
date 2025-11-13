package com.SushiAPI.SushiAPI.controller.API.Cart;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.models.appetizers.appetizers;
import com.SushiAPI.SushiAPI.models.drinks.Drink;
import com.SushiAPI.SushiAPI.models.extra.Extra;
import com.SushiAPI.SushiAPI.models.nigiri.nigiri;
import com.SushiAPI.SushiAPI.models.rolls.Roll;
import com.SushiAPI.SushiAPI.utils.CartService;
import com.SushiAPI.SushiAPI.utils.MenuServices;
import com.SushiAPI.SushiAPI.utils.utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CartController {
    @GetMapping("/api/cart")
    public ResponseEntity<String> getMenu() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CartService.allItemsAsJson().toString());

    }

    @PostMapping("/api/cart/add")
    public boolean addItem(@RequestBody String addItem) {
        JSONObject jsonObject = new JSONObject(addItem);
        Item item = null;

        JSONArray extras = jsonObject.getJSONArray("extras");

        if(jsonObject.getString("category").equalsIgnoreCase("roll")) {
            item = new Roll(jsonObject.getString("name"), jsonObject.getDouble("price"), false, jsonObject.getBoolean("isHot"), jsonObject.getBoolean("isAppetizer"), jsonObject.getBoolean("isRaw"), null, extras);
        } else if(jsonObject.getString("category").equalsIgnoreCase("drink")) {
            item = new Drink(jsonObject.getString("name"), jsonObject.getDouble("price"), jsonObject.getBoolean("isHot"), jsonObject.getString("description"));
        } else if (jsonObject.getString("category").equalsIgnoreCase("nigiri")) {
            item = new nigiri(jsonObject.getString("name"), jsonObject.getDouble("price"), false, jsonObject.getBoolean("isHot"), jsonObject.getBoolean("isAppetizer"), jsonObject.getBoolean("isRaw"), null, extras);
        } else if (jsonObject.getString("category").equalsIgnoreCase("appetizer")) {
            item = new appetizers(jsonObject.getString("name"), jsonObject.getDouble("price"), false, jsonObject.getBoolean("isHot"), true, jsonObject.getBoolean("isRaw"), null, extras);
        }
        CartService.addItem(item);
        return true;
    }

    @PostMapping("/api/cart/remove")
    public boolean removeItem(@RequestBody String removeItem) {
        JSONObject jsonObject = new JSONObject(removeItem);
        Item item = null;
        if(jsonObject.getString("category").equalsIgnoreCase("roll")) {
            JSONArray myExtras = new JSONArray();
            item = new Roll(jsonObject.getString("name"), jsonObject.getDouble("price"), false, jsonObject.getBoolean("isHot"), jsonObject.getBoolean("isAppetizer"), jsonObject.getBoolean("isRaw"), "Eel + avocado", myExtras);
        } else if(jsonObject.getString("category").equalsIgnoreCase("drink")) {
            item =  new Drink(jsonObject.getString("name"), jsonObject.getDouble("price"), jsonObject.getBoolean("isHot"), jsonObject.getString("description"));
        } else if (jsonObject.getString("category").equalsIgnoreCase("nigiri")) {
            JSONArray myExtras = new JSONArray();
            item = new nigiri(jsonObject.getString("name"), jsonObject.getDouble("price"), false, jsonObject.getBoolean("isHot"), jsonObject.getBoolean("isAppetizer"), jsonObject.getBoolean("isRaw"), "Eel + avocado", myExtras);
        }
        CartService.removeItem(item);
        return true;
    }

    @GetMapping("/api/cart/search")
    public ResponseEntity<List<Item>> searchCart(@RequestBody String searchItem) {
        JSONObject jsonObject = new JSONObject(searchItem);
        List<Item> items = CartService.searchItems(jsonObject.getString("query"));
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

}
