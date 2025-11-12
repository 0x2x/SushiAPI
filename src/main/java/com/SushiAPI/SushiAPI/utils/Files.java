package com.SushiAPI.SushiAPI.utils;

import java.io.*;

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

    public static void writeFile(String path, boolean Append, StringBuilder content) {
        try (FileWriter writer = new FileWriter(path, Append)){
            writer.write(content.toString());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
