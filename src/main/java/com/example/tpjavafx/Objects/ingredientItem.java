package com.example.tpjavafx.Objects;

public class ingredientItem {
    private int stocks;
    private String name;

    public ingredientItem(int stocks, String name) {
        this.stocks = stocks;
        this.name = name;
    }

    public int getStocks() {
        return stocks;
    }

    public String getName() {
        return name;
    }
}
