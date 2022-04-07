package Datas;

public enum IngredientsDatas {
    SALADE(20),
    TOMATE(30),
    OIGNON(4),
    CHAMPIGNONS(25),
    PAIN(15),
    VIANDE(20),
    PATE(2),
    FROMAGE(20),
    CHORIZO(30);

    private int stocks;

    IngredientsDatas(int stocks) {this.stocks = stocks; }

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
