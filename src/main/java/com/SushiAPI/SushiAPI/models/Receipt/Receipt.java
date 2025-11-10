package com.SushiAPI.SushiAPI.models.Receipt;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Receipt {
    private LocalDate localDate;
    private double totalAmount;
    private double tax;
    private ArrayList<item> items = new ArrayList<>();

    // Consturcotor

    public Receipt(LocalDate localDate, double totalAmount, double tax, ArrayList<item> items) {
        this.localDate = localDate;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.items = items;
    }
}
