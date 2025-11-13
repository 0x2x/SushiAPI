package com.SushiAPI.SushiAPI.models;

import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;

import java.util.ArrayList;

public class test {
    static void main() {
        Roll roll = new Roll("aw", 2, 0, new ArrayList<>(), new ArrayList<>());
        Nigiri nigiri = new Nigiri("test", 2, 0, new ArrayList<>(), new ArrayList<>());

        ArrayList<MenuItem> data = new ArrayList<>();
        data.add(roll);
        data.add(nigiri);
        for(MenuItem item : data) {
            if (item instanceof  Roll) {
                System.out.println(item.getName() + " is a roll");
            }
        }
    }
}
