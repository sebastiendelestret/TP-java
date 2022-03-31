package Datas;

public enum IngredientsDatas {
    SALADE(20),
    TOMATE(30),
    OIGNON(12),
    CHAMPIGNONS(25),
    PAIN(15),
    VIANDE(20),
    PATE(7),
    FROMAGE(20),
    CHORIZO(30);

    private int stocks;

    IngredientsDatas(int stocks) {this.stocks = stocks; }
}
