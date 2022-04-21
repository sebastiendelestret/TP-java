package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tpjavafx.Objects.Util.listTable;

public interface Tools {
    public static int getRandInt(int min, int max){
        return new Random().nextInt((max - min)+1) +min;
    }

    public static void displayTables(){
        for(int i=0; i < listTable.size(); i++){
            Table tmp = listTable.get(i);
            System.out.println("Table " + tmp.getIdTable() + " : " + tmp.getNbPlaces() + " places" );
        }
    }

    public static void displayTableDishes(int idTable){
        Table tmpTable = listTable.get(idTable);
        if(tmpTable.getDishesList().size() == 0){
            System.out.println("Aucun plat");
        }
        else{
            System.out.println("=========Plats choisis==========");
            for(int i =0; i < tmpTable.getDishesList().size(); i++) {
                System.out.println(tmpTable.getDishesList().get(i));
            }

        }
    }
    public static void displayTableDrinks(int idTable){
        Table tmpTable = listTable.get(idTable);
        if(tmpTable.getDishesList().size() == 0){
            System.out.println("Aucune boisson");
        }
        else{
            System.out.println("===========Boissons=============");
            for(int i =0; i < tmpTable.getDrinkList().size(); i++){
                System.out.println(tmpTable.getDrinkList().get(i));
            }

        }
    }



    public static void displayDishesList(){
        int i=1;
        for(DishesDatas dishes : DishesDatas.values()){
            System.out.println(i + "-" +dishes.toString());
            i++;
        }
    }

    public static void displayDrinksList(){
        int i=1;
        for(DrinksDatas drinks : DrinksDatas.values()){
            System.out.println(i + "-" +drinks.toString());
            i++;
        }
    }


    public static void printNote(int table){
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

    public static void displayStocks(){
        for(IngredientsDatas ingredients:IngredientsDatas.values()){
            System.out.println(ingredients.toString() + " : " + ingredients.getStocks());
        }
    }

}
