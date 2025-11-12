package com.SushiAPI.SushiAPI.controller.API.Menu;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.utils.CartService;
import com.SushiAPI.SushiAPI.utils.MenuServices;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MenuController {
    @GetMapping("/api/menu")
    public ResponseEntity<HashMap<String, ArrayList<Item>>> getMenu() {
        HashMap<String, ArrayList<Item>> items = MenuServices.getMenuItems();
        return new ResponseEntity<HashMap<String, ArrayList<Item>>>(items, HttpStatus.OK);
    }

    @GetMapping("/api/menu/filter/") // api/menu/filter?search
    public boolean searchItem(@RequestParam(required=true, defaultValue="") String searchQuery) {
//        List<Item> items = MenuServices.getMenuItems(jsonObject.getString("query"));
        return true;
    }
}
