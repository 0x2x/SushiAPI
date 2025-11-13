package com.SushiAPI.SushiAPI.utils.Services;

import com.SushiAPI.SushiAPI.main;
import com.SushiAPI.SushiAPI.models.Appetizer.Seafoods;
import com.SushiAPI.SushiAPI.models.Appetizer.Traditional;
import com.SushiAPI.SushiAPI.models.Drinks.Alcohol;
import com.SushiAPI.SushiAPI.models.Drinks.Soda;
import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import com.SushiAPI.SushiAPI.utils.Files;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class ReceiptService {

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
            stringBuilder.append(String.join(", ", item.getExtras())).append("\t $" ).append("\n");
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
        stringBuilder.append("--------------UNFORMATTED-------------------------").append("\n");
        main.ReceiptItems.forEach(item -> {
            if(item instanceof Soda) {
                stringBuilder.append("Soda: ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            } else if(item instanceof Alcohol) {
                stringBuilder.append("Alcohol: ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            } else if(item instanceof Traditional) {
                stringBuilder.append("Appetizer Traditional: ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            } else if(item instanceof Seafoods) {
                stringBuilder.append("Sea Food Appetizer: ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            } else if(item instanceof Nigiri) {
                stringBuilder.append("Nigiri: ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            } else if(item instanceof Roll) {
                stringBuilder.append("Roll : ").append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
            }
        });
        stringBuilder.append("Subtotal: $").append(Subtotal.get()).append("\n");
        stringBuilder.append("tax: $").append(amountToAdd).append("\n");
        stringBuilder.append("total: $").append(Paid).append("\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");

        String formattedDate = sdf.format(now);

        Files.writeFile("C:\\Users\\Student\\Downloads\\SushiAPI\\files\\receipts\\" + formattedDate + ".txt", false, stringBuilder); // save to file
    }
}
