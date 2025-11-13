package com.SushiAPI.SushiAPI.controller.API.Menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {
    @GetMapping("/api/menu") // grab data from CSV
    public void getMenu() {
        return;
    }

    @GetMapping("/api/menu/filter/") // api/menu/filter?search
    public void searchItem(@RequestParam(required=true, defaultValue="") String searchQuery) {
        return;
    }
}
