package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tpjavafx.Objects.Util.listTable;

public interface Tools {
    static int getRandInt(int min, int max){
        return new Random().nextInt((max - min)+1) +min;
    }


    static void printNote(int table){
        Table tmpTable = listTable.get(table);
        System.out.println("====== Reçu ======");
        ArrayList<DishesDatas> tmpDishes = new ArrayList<>();
        ArrayList<DrinksDatas> tmpDrinks = new ArrayList<>();

        int totalPrice =0;

        for(int i =0; i< tmpTable.getServedDishesList().size(); i++){
            tmpDishes = tmpTable.getServedDishesList();
            System.out.println(tmpDishes.get(i).toString() + ".........." + tmpDishes.get(i).getPrice());
            totalPrice+= tmpDishes.get(i).getPrice();
        }
        for(int i =0; i< tmpTable.getServedDrinksList().size(); i++){
            tmpDrinks = tmpTable.getServedDrinksList();
            System.out.println(tmpDrinks.get(i).toString() + ".........." + tmpDrinks.get(i).getPrice());
            totalPrice+= tmpDrinks.get(i).getPrice();
        }

        System.out.println("Total ............." + totalPrice);
    }

    static void displayStocks(){
        for(IngredientsDatas ingredients:IngredientsDatas.values()){
            System.out.println(ingredients.toString() + " : " + ingredients.getStocks());
        }
    }

}
