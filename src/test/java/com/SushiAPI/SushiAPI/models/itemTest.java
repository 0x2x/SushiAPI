package com.SushiAPI.SushiAPI.models;

import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class itemTest {

    @Test
    void oop() {
        // act
        Roll roll = new Roll("aw", 2, 0, new ArrayList<>(), new ArrayList<>());
        Nigiri nigiri = new Nigiri("test", 2, 0, new ArrayList<>(), new ArrayList<>());

        ArrayList<MenuItem> data = new ArrayList<>();
        data.add(roll);
        data.add(nigiri);
        // action
        for(MenuItem item : data) {
            if (item instanceof  Roll) {
                System.out.println(item.getName() + " is a roll");
                // assert
                assertEquals("roll", item.getCategory().toLowerCase());
            } else if(item instanceof Nigiri) {
                System.out.println(item.getName() + " is Nigiri");
                assertEquals("nigiri", item.getCategory().toLowerCase());
            }
        }
    }
}