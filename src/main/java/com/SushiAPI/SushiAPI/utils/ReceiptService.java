package com.SushiAPI.SushiAPI.utils;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ReceiptService {
    public static ArrayList<HashMap<String, Item>> generateReceipt() {
        ArrayList<HashMap<String, Item>> items = new ArrayList<>();
        main.ReceiptItems.forEach(item -> {
            HashMap<String, Item> itemHashMap = new HashMap<>();
            itemHashMap.put("testing", item);
            items.add(itemHashMap);
        });
        return items;
    }

    public static void saveItems() {
        Date now = new Date();
        SimpleDateFormat sdfReceipt = new SimpleDateFormat("MM/dd/YYYY|hh:mm");
        String receiptFormatDate = sdfReceipt.format(now);
        StringBuilder stringBuilder = new StringBuilder();
        String date = receiptFormatDate.split("\\|")[0];
        String time = receiptFormatDate.split("\\|")[1];

        AtomicReference<Double> Subtotal = new AtomicReference<>((double) 0);
        double tax = 0.080; // 8%
        String paymentMethod = "**** **** **** 1314";

        stringBuilder.append("Date: ").append(date).append("\n");
        stringBuilder.append("Time: ").append(time).append("\n");
        stringBuilder.append("=========ORDER ITEMS================").append("\n");
        main.ReceiptItems.forEach(item -> {
            stringBuilder.append(item.getName()).append("\t\t\t\t$").append(item.getPrice()).append("\n");
            Subtotal.updateAndGet(v -> new Double((double) (v + item.getPrice())));
        });

        double originalNumber = Subtotal.get();
        double amountToAdd = originalNumber * tax;
        double Paid = originalNumber + amountToAdd;
        stringBuilder.append("=========SUB TOTAL================").append("\n");
        stringBuilder.append("Subtotal: $").append(Subtotal.get()).append("\n");
        stringBuilder.append("tax: $").append(amountToAdd).append("\n");
        stringBuilder.append("==========TOTAL====================").append("\n");
        stringBuilder.append("total: $").append(Paid).append("\n");
        stringBuilder.append("============================").append("\n");
        stringBuilder.append("Payment Method: ").append(paymentMethod).append("\n");
        stringBuilder.append("Paid: $").append(Paid).append("\n");

        main.ReceiptItems.forEach(item -> {
            System.out.println(item);
        });

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");

        String formattedDate = sdf.format(now);

        Files.writeFile("C:\\Users\\Student\\Downloads\\SushiAPI\\files\\receipts\\" + formattedDate + ".txt", false, stringBuilder); // save to file
    }
}
