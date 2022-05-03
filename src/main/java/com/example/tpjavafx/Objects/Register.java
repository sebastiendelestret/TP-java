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

            ArrayList<Pair<String, String>> Employees = new ArrayList<>();
            for (Employe employe : listEmploye) {
                Employees.add(new Pair<>(employe.getName(), employe.getFirstname()));
            }
            out.writeObject(Employees);


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
            ArrayList<Pair<String, String>> Employees = (ArrayList<Pair<String, String>>) in.readObject();
            for (Pair<String, String> employee : Employees) {
                listEmploye.add(new Employe(employee.getKey(), employee.getValue(), "", System.currentTimeMillis()));
            }
            System.out.println("File read");


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
