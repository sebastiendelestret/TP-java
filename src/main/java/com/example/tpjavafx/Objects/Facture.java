package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Facture {
    private Map<DishesDatas, Integer> dishes = new HashMap<>();
    private Map<DrinksDatas, Integer> drinks = new HashMap<>();
    private int total;
    private String dateHeure;


    public Facture(ArrayList<DishesDatas> dishesList, ArrayList<DrinksDatas> drinksList, int table){
        SimpleDateFormat formatter  = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date(System.currentTimeMillis());
        this.dateHeure = formatter.format(date);


        for(DishesDatas dishesDatas:DishesDatas.values()){
            this.dishes.put(dishesDatas,0);
        }
        for(DrinksDatas drinksDatas:DrinksDatas.values()){
            this.drinks.put(drinksDatas,0);
        }

        for(DishesDatas dishesDatas:dishesList){
            this.dishes.put(dishesDatas, dishes.get(dishesDatas)+1);
            total+=dishesDatas.getPrice();
        }
        for(DrinksDatas drinksDatas:drinksList){
            this.drinks.put(drinksDatas, drinks.get(drinksDatas)+1);
            total+=drinksDatas.getPrice();

        }
    }

    public int totalDrinks(){
        int count =0;
        for (DrinksDatas drinksDatas:DrinksDatas.values()){
            count+=drinks.get(drinksDatas);
        }
        return count;
    }

    public int totalDishes(){
        int count =0;
        for (DishesDatas dishesDatas:DishesDatas.values()){
            count+=dishes.get(dishesDatas);
        }
        return count;
    }

    public int getTotal() {
        return total;
    }
}
