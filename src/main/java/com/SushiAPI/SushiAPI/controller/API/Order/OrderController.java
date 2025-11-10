package com.SushiAPI.SushiAPI.controller.API.Order;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.utils.CartService;
import com.SushiAPI.SushiAPI.utils.MenuServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @PostMapping("/api/order/pay")
    public ResponseEntity<Boolean> payOrder() {
        boolean paidOrder = CartService.pay();
        return new ResponseEntity<Boolean>(paidOrder, HttpStatus.OK);
    }

    @GetMapping("/api/order/totalAmount")
    public ResponseEntity<Double> totalAmountDue() {
        return new ResponseEntity<Double>(CartService.totalAmount()
        , HttpStatus.OK);
    }
}
