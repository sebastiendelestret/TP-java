package com.example.tpjavafx.Objects;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.tpjavafx.Objects.Util.factureList;

public interface FacturePrint {
    Charset charset = StandardCharsets.UTF_8;
    SimpleDateFormat formatter  = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatterDateHour  = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");


    static void print() throws IOException {
        Date date = new Date(System.currentTimeMillis());
        String filename = "src/main/resources/factures/" + formatter.format(date) + ".txt";
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(filename),charset)){
            for(Facture facture:factureList){
                String dateFacture = formatterDateHour.format(facture.getDate());
                writer.write(dateFacture + "\ttable "+facture.getTable()+ "\t"+facture.getTotal()+"€\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
