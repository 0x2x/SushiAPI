package com.SushiAPI.SushiAPI.controller.API.Receipt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {
    @GetMapping("/api/receipt/generate")
    public void generateReceipt() {
        return;
    }
}
