package com.SushiAPI.SushiAPI.models.Receipt;

import java.time.LocalDate;
import java.util.ArrayList;

public class item extends Receipt {
    private String itemName;
    private double itemPrice;
    private String itemDescription;

    public item(LocalDate localDate, double totalAmount, double tax, ArrayList<item> items, String itemName, double itemPrice, String itemDescription) {
        super(localDate, totalAmount, tax, items);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }
}
