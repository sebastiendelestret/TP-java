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
    private int table;
    private Date date;


    public Facture(ArrayList<DishesDatas> dishesList, ArrayList<DrinksDatas> drinksList, int table){

        this.date = new Date(System.currentTimeMillis());
        this.table = table;

        for(DishesDatas dishesDatas:DishesDatas.values()){
            this.dishes.put(dishesDatas,0);
        }
        for(DrinksDatas drinksDatas:DrinksDatas.values()){
            this.drinks.put(drinksDatas,0);
        }

        int dishes100 =0;
        int drinks100 = 0;
        for(DishesDatas dishesDatas:dishesList){
            this.dishes.put(dishesDatas, dishes.get(dishesDatas)+1);
            if(dishesDatas == DishesDatas.CENTS_ANS){
                total+= dishesDatas.getPrice();
                dishes100=7;
                drinks100=7;
            }
            else if(dishes100>0)dishes100--;
            else total+=dishesDatas.getPrice();
        }

        for(DrinksDatas drinksDatas:drinksList){
            this.drinks.put(drinksDatas, drinks.get(drinksDatas)+1);
            if(drinks100>0)drinks100--;
            else total+=drinksDatas.getPrice();

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

    public Date getDate() {
        return date;
    }

    public int getTable() {
        return table;
    }
}
