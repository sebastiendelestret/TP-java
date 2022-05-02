package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.IngredientsDatas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public interface ShoppingList {
    Charset charset = Charset.forName("windows-1252");
    SimpleDateFormat formatter  = new SimpleDateFormat("dd-MM-yyyy");

    static void create(){
        Date date = new Date(System.currentTimeMillis());
        String filename = "src/main/resources/" + formatter.format(date) + ".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filename), charset)) {
            writer.write("Liste du "+formatter.format(date)+"\n\n");
            for (IngredientsDatas data : IngredientsDatas.values()) {
                if (data.getStocks() <= 5) {
                    writer.write(data.toString());
                    for(int i =data.toString().length(); i< 20; i++){
                        writer.write(".");
                    }
                    writer.write("20\n");
                }
            }

            System.out.println("Shopping list created");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
