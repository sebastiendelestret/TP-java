package com.example.tpjavafx.controller;

public class ingredientItem {
    private final String name;
    private final int stocks;

    public ingredientItem(String name, int stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    public int getStocks() {
        return stocks;
    }

    public String getName() {
        return name;
    }
}
