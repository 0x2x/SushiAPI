package com.SushiAPI.SushiAPI.controller.API.Receipt;

import com.SushiAPI.SushiAPI.models.Item;
import com.SushiAPI.SushiAPI.utils.CartService;
import com.SushiAPI.SushiAPI.utils.ReceiptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class ReceiptController {
    @GetMapping("/api/receipt/generate")
    public ResponseEntity<ArrayList<HashMap<String, Item>>> generateReceipt() {
        ArrayList<HashMap<String, Item>> paidOrder = ReceiptService.generateReceipt();
        return new ResponseEntity<ArrayList<HashMap<String, Item>>>(paidOrder, HttpStatus.OK);
    }
}
