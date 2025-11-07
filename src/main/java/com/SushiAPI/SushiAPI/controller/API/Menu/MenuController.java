package com.SushiAPI.SushiAPI.controller.API.Menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {
    @GetMapping("/api/menu")
    public String getMenu() {
        return "";
    }
}
