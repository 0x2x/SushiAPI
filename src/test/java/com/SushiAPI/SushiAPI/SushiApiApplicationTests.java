package com.SushiAPI.SushiAPI;

import com.SushiAPI.SushiAPI.models.MenuItem;
import com.SushiAPI.SushiAPI.models.Sushi.Nigiri;
import com.SushiAPI.SushiAPI.models.Sushi.Roll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SushiApiApplicationTests {

    @Test
    void testing() {
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
