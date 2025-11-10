package com.SushiAPI.SushiAPI.controller.API.Menu;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.utils.MenuServices;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MenuController {
    @GetMapping("/api/menu")
    public ResponseEntity<List<Item>> getMenu() {
        List<Item> items = MenuServices.getMenuItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @GetMapping("/api/menu/filter/") // api/menu/filter?search
    public boolean searchItem(@RequestParam(required=true, defaultValue="") String searchQuery) {
//        List<Item> items = MenuServices.getMenuItems(searchQuery);
        return true;
    }
}
