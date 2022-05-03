package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tpjavafx.Objects.Util.listTable;

public interface Tools {
    static int getRandInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }


    static void printNote(int table) {
        Table tmpTable = listTable.get(table);
        System.out.println("====== Reçu ======");
        Facture facture = new Facture(tmpTable.getServedDishesList(), tmpTable.getServedDrinksList(), table);

        int tmpPrice = 0;
        int drinks100 = 0;
        int dishes100 = 0;
        for (DishesDatas dishesDatas : tmpTable.getServedDishesList()) {
            tmpPrice = dishesDatas.getPrice();
            if (dishesDatas == DishesDatas.CENTS_ANS) {
                dishes100 = 7;
                drinks100 = 7;
            } else if (dishes100 > 0) {
                tmpPrice = 0;
                dishes100--;
            }
            String points = "";
            for (int i = dishesDatas.toString().length(); i < 25; i++) {
                points += ".";
            }
            System.out.println(dishesDatas.toString()+ points + tmpPrice + "€");

        }
        for (DrinksDatas drinksDatas : tmpTable.getServedDrinksList()) {
            tmpPrice = drinksDatas.getPrice();
            if (drinks100 > 0) {
                tmpPrice = 0;
                drinks100--;
            }
            String points = "";

            for (int i = drinksDatas.toString().length(); i < 25; i++) {
                points += ".";
            }
            System.out.println(drinksDatas.toString()+ points + tmpPrice + "€");
        }

        System.out.println("Total...................." + facture.getTotal() + "€");
    }

    static void displayStocks() {
        for (IngredientsDatas ingredients : IngredientsDatas.values()) {
            System.out.println(ingredients.toString() + " : " + ingredients.getStocks());
        }
    }

}
