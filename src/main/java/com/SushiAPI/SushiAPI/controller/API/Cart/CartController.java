package com.SushiAPI.SushiAPI.controller.API.Cart;


import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Appetizer.Seafoods;
import com.SushiAPI.SushiAPI.models.Appetizer.Traditional;
import com.SushiAPI.SushiAPI.models.Drinks.Alcohol;
import com.SushiAPI.SushiAPI.models.Drinks.Soda;
import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import com.SushiAPI.SushiAPI.utils.Services.CartService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class CartController {
    @GetMapping("/api/cart")
    public ResponseEntity<String> getMenu() { return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(CartService.AllItems().toString()); }

    @PostMapping("/api/cart/add")
    public ResponseEntity<String> addItem(@RequestBody String addItem) {
        JSONObject jsonObject = new JSONObject(addItem);
        JSONArray extras = jsonObject.getJSONArray("extras");
        MenuItem result = CartService.addItemByName(jsonObject.getString("name"));
        if(result != null) {
            if(!extras.isEmpty())  {
                 List<String> extrasList = IntStream.range(0, extras.length()).mapToObj(extras::getString).toList();
                 if(result.getCategory().equalsIgnoreCase("soda")) {
                     result = new Soda(result.getName(), result.getPrice(), result.getCold(), result.isAlcohol(), result.getIngredients(), extrasList);
                 } else if(result.getCategory().equalsIgnoreCase("Alcohol")) {
                     result = new Alcohol(result.getName(), result.getPrice(), result.getCold(), result.isAlcohol(), result.getIngredients(), extrasList);
                 } else if(result.getCategory().equalsIgnoreCase("Seafood Appetizer")) {
                     result = new Seafoods(result.getName(), result.getPrice(), result.getSpiceLevel(), result.getIngredients(), extrasList);
                 } else if(result.getCategory().equalsIgnoreCase("Traditional Appetizer")) {
                     result = new Traditional(result.getName(), result.getPrice(), result.getSpiceLevel(),  result.getIngredients(), extrasList);
                 } else if(result.getCategory().equalsIgnoreCase("roll")) {
                     result = new Roll(result.getName(), result.getPrice(), result.getSpiceLevel(),  result.getIngredients(), extrasList);
                 } else if(result.getCategory().equalsIgnoreCase("nigiri")) {
                     result = new Nigiri(result.getName(), result.getPrice(), result.getSpiceLevel(),  result.getIngredients(), extrasList);
                 }
            }
            main.Cart.add(result);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result.toString());
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result.toString());
    }

    @PostMapping("/api/cart/remove")
    public boolean removeItem(@RequestBody String removeItem) {
        return true;
    }


    @PostMapping("/api/cart/delete")
    public boolean deleteAllItems() {
        return true;
    }


    @GetMapping("/api/cart/search")
    public void searchCart(@RequestBody String searchItem) {
    }

}
