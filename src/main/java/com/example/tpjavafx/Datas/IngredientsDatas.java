package com.example.tpjavafx.Datas;

public enum IngredientsDatas {
    SALADE(0),
    TOMATE(0),
    OIGNON(0),
    CHAMPIGNONS(0),
    PAIN(0),
    VIANDE(0),
    PATE(0),
    FROMAGE(0),
    CHORIZO(0),
    PAIN_SUEDOIS(0),
    RIZ(0),
    POULET(0);

    private int stocks;

    IngredientsDatas(int stocks) {
        this.stocks = stocks;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void addStocks(int stocks) {
        this.stocks += stocks;
    }
}
