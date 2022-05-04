package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.IngredientsDatas;
import javafx.util.Pair;

import static com.example.tpjavafx.Objects.Util.listEmploye;

import java.io.*;
import java.util.ArrayList;

/**
 * Register enregistre et lis des informations dans des fichier binaire
 * Sauvegarde les stocks d'ingrédients et la liste d'employés
 */

public class Register {
    private String ingredientFile = "src/main/resources/ingredients";

    public Register() {
        readFile();
    }

    public void registerFile() {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ingredientFile)))) {
            ArrayList<Integer> stocks = new ArrayList<Integer>();
            for (IngredientsDatas datas : IngredientsDatas.values()) {
                stocks.add(datas.getStocks());
            }
            out.writeObject(stocks);

            out.writeInt(listEmploye.size());
            for (Employe employe : listEmploye) {
                out.writeUTF(employe.getName());
                out.writeUTF(employe.getFirstname());
                if(employe.getNbSoirs()==3)out.writeInt(0);
                else out.writeInt(employe.getNbSoirs());
            }


            System.out.println("File registered");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ingredientFile)))) {
            ArrayList<Integer> stocks = (ArrayList<Integer>) in.readObject();
            for (int i = 0; i < stocks.size(); i++) {
                IngredientsDatas.values()[i].setStocks(stocks.get(i));
            }

            int size = in.readInt();
            for (int i=0; i<size; i++) {
                listEmploye.add(new Employe(in.readUTF(), in.readUTF()," ", in.readInt() ));
            }
            System.out.println("File read");


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
