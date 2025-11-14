package com.SushiAPI.SushiAPI.controller.screens.Receipt;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReceiptScreen {
    @GetMapping("/receipt")
    public String showReceipt(Model model, @RequestBody String receiptData) {
        JSONObject jsonObject = new JSONObject(receiptData);

        StringBuilder htmlBuilder = new StringBuilder();
        JSONArray jsonArray = jsonObject.getJSONArray("items");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            htmlBuilder.append("<div class=\"receipt-row\">")
                    .append("<span class=\"item-name\">").append(item.getString("itemName")).append("</span>")
                    .append("<span class=\"item-price\">$").append(item.getDouble("itemPrice")).append("</span>")
                    .append("</div>");
        }

        model.addAttribute("subTotal", jsonObject.getDouble("subTotal"));
        model.addAttribute("tax", jsonObject.getDouble("tax"));
        model.addAttribute("total", jsonObject.getDouble("total"));
        model.addAttribute("amountPaid", jsonObject.getDouble("amountPaid"));
        model.addAttribute("items", htmlBuilder.toString());
        return "receipt";
    }



}
