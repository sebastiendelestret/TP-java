package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;

import java.util.Random;

import static com.example.tpjavafx.Objects.Util.listTable;

/**
 * Tools est une inteface contenant des outils pouvant être utils à certains endroits du programme
 */

public interface Tools {

    /**
     * Retourne un entier aléatoire entre deux valeurs
     *
     * @param min valeur minimale
     * @param max valeur maximale
     * @return entier aléatoire
     */
    static int getRandInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Ecris dans la console la facture associée à la table passée en argument.
     * Détail le prix de chaque plat et boissons et le total à régler
     *
     * @param table indice de la table
     */
    static void printNote(int table) {
        Table tmpTable = listTable.get(table);
        System.out.println("====== Reçu ======");
        Facture facture = new Facture(tmpTable.getServedDishesList(), tmpTable.getServedDrinksList(), table);

        int tmpPrice;
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
            String points = ".".repeat(Math.max(0, 25 - dishesDatas.toString().length()));
            System.out.println(dishesDatas + points + tmpPrice + "€");

        }
        for (DrinksDatas drinksDatas : tmpTable.getServedDrinksList()) {
            tmpPrice = drinksDatas.getPrice();
            if (drinks100 > 0) {
                tmpPrice = 0;
                drinks100--;
            }

            String points = ".".repeat(Math.max(0, 25 - drinksDatas.toString().length()));
            System.out.println(drinksDatas+ points + tmpPrice + "€");
        }

        System.out.println("Total...................." + facture.getTotal() + "€");
    }


}
