package com.SushiAPI.SushiAPI.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class Files {
    public static StringBuilder readFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            if(bufferedReader.readLine() != null || bufferedReader.readLine().toLowerCase().startsWith("name")) {
                // this is the top of CSV
            }

            String input;
            while((input = bufferedReader.readLine()) != null) {
                stringBuilder.append(input).append("\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: while reading File");
        }
        return stringBuilder;
    }

}
