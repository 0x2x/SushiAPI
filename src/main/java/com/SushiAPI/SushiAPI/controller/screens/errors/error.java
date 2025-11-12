package com.SushiAPI.SushiAPI.controller.screens.errors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class error {
    @GetMapping("/error")
    public String showError(Model model) {
        return "error";
    }

}
