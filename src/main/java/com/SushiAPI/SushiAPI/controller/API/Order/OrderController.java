package com.SushiAPI.SushiAPI.controller.API.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @PostMapping("/api/order/pay") // pay order
    public void payOrder() {
    }

    @GetMapping("/api/order/totalAmount") // ?tip=24 not required
    public void totalAmountDue(@RequestParam(required = false, name = "tip") String tip) {

    }
}
