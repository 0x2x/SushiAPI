package com.SushiAPI.SushiAPI.controller.API.Cart;


import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @GetMapping("/api/cart")
    public void getMenu() {
       return;
    }

    @PostMapping("/api/cart/add")
    public boolean addItem(@RequestBody String addItem) {
        JSONObject jsonObject = new JSONObject(addItem);
        return true;
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
