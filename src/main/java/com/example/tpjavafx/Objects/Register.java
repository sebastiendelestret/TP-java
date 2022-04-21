package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.IngredientsDatas;

import java.io.*;
import java.util.ArrayList;

public class Register {
    private String ingredientFile = "src/main/resources/ingredients";

    public Register() {
        readIngredientsStocks();
    }

    public void registerIngredientsStocks() {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ingredientFile)))) {
            ArrayList<Integer>stocks = new ArrayList<Integer>();
            for(IngredientsDatas datas:IngredientsDatas.values()){
                stocks.add(datas.getStocks());
            }
            out.writeObject(stocks);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readIngredientsStocks() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ingredientFile)))) {
            ArrayList<Integer>stocks = (ArrayList<Integer>) in.readObject();
            for(int i =0; i<stocks.size(); i++){
                IngredientsDatas.values()[i].setStocks(stocks.get(i));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
