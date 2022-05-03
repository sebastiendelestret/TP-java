package com.example.tpjavafx.controller;

import javafx.scene.control.TextField;

/**
 * La class ingrédientItem décris un ingrédient pour être afficher dans un tableau avec javafx
 */

public class ingredientItem {
    private final String name;
    private final int stocks;
    private final TextField input;

    public ingredientItem(String name, int stocks, TextField input) {
        this.name = name;
        this.stocks = stocks;
        this.input = input;
        this.input.setText("0");
    }

    public int getStocks() {
        return stocks;
    }

    public String getName() {
        return name;
    }

    public TextField getInput() {
        return input;
    }
}
