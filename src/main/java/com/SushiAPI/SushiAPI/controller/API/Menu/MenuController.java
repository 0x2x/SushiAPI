package com.SushiAPI.SushiAPI.controller.API.Menu;

import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.utils.Services.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


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
}
