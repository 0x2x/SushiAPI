package com.SushiAPI.SushiAPI.controller.API.Menu;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Appetizer.Seafoods;
import com.SushiAPI.SushiAPI.models.Appetizer.Traditional;
import com.SushiAPI.SushiAPI.models.Drinks.Alcohol;
import com.SushiAPI.SushiAPI.models.Drinks.Soda;
import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import com.SushiAPI.SushiAPI.utils.Files;
import com.SushiAPI.SushiAPI.utils.Services.CartService;
import com.SushiAPI.SushiAPI.utils.Services.MenuService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;


@RestController
public class MenuController {
    @GetMapping("/api/menu")
    public ResponseEntity<HashMap<String, ArrayList<MenuItem>>> getMenu() {
        HashMap<String, ArrayList<MenuItem>> items = MenuService.getMenuItems();
        return new ResponseEntity<HashMap<String, ArrayList<MenuItem>>>(items, HttpStatus.OK);
    }
    @GetMapping("/api/menu/filter/") // api/menu/filter?search
    public void searchItem(@RequestParam(required=true, defaultValue="") String searchQuery) {
        return;
    }

    @PostMapping("/api/menu/addItem")
    public ResponseEntity<String> addMenuItem(@RequestBody String addItem) {
        JSONObject jsonObject = new JSONObject(addItem);

        String itemType = jsonObject.getString("category");
        String[] itemIngredients = jsonObject.getString("ingredients").split(",");
        String itemName = jsonObject.getString("name");
        double itemPrice = jsonObject.getDouble("price");
        int itemSpicy = jsonObject.getInt("spiceLevel");

        MenuItem item = null;
        String csvChoice = "";
        if(itemType.equalsIgnoreCase("traditional")) {
            item = new Traditional(itemName, itemPrice, itemSpicy, null, null);
            csvChoice = "Appetizers";
        } else if(itemType.equalsIgnoreCase("seafood")) {
            item = new Seafoods(itemName, itemPrice, itemSpicy, null, null);
            csvChoice = "Appetizers";
        } else if(itemType.equalsIgnoreCase("soda")) {
            boolean itemAlcohol = jsonObject.getBoolean("isAlcohol");
            boolean itemCold = jsonObject.getBoolean("isCold");
            item = new Soda(itemName, itemPrice, itemCold, itemAlcohol, null, null);
            csvChoice = "Drinks";

        } else if(itemType.equalsIgnoreCase("alcohol")) {
            boolean itemAlcohol = jsonObject.getBoolean("isAlcohol");
            boolean itemCold = jsonObject.getBoolean("isCold");
            item = new Alcohol(itemName, itemPrice, itemCold, itemAlcohol, null, null);
            csvChoice = "Drinks";

        } else if(itemType.equalsIgnoreCase("nigiri")) {
            item = new Nigiri(itemName, itemPrice, itemSpicy, null, null);
            csvChoice = "Nigiri";
        } else if(itemType.equalsIgnoreCase("roll")) {
            item = new Roll(itemName, itemPrice, itemSpicy, null, null);
            csvChoice = "Rolls";
        }
        main.items.add(item); // add to menu
        Files.writeFile("files/menus/" + csvChoice + ".csv", true, item.toString());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(item.toCsv() + "\n");
    }

    private static void extracted(String itemName, double itemPrice, int itemSpicy) {
    }
}
