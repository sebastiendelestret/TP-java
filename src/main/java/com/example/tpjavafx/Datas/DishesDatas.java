package com.example.tpjavafx.Datas;

public enum DishesDatas {
    SALADE_TOMATE(5,new IngredientsDatas[]{IngredientsDatas.SALADE,IngredientsDatas.TOMATE}),
    SALADE(2,new IngredientsDatas[]{IngredientsDatas.SALADE}),

    POTAGE_OIGNON(3,new IngredientsDatas[]{IngredientsDatas.OIGNON,IngredientsDatas.OIGNON,IngredientsDatas.OIGNON}),
    POTAGE_TOMATE(4,new IngredientsDatas[]{IngredientsDatas.TOMATE,IngredientsDatas.TOMATE,IngredientsDatas.TOMATE}),
    POTAGE_CHAMPIGNONS(4,new IngredientsDatas[]{IngredientsDatas.CHAMPIGNONS,IngredientsDatas.CHAMPIGNONS,IngredientsDatas.CHAMPIGNONS}),

    BURGER_MAX(9,new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.SALADE,IngredientsDatas.TOMATE,IngredientsDatas.VIANDE}),
    BURGER_SALADE(7,new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.SALADE,IngredientsDatas.VIANDE}),
    BURGER_VIANDE(8,new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.VIANDE}),

    PIZZA_FROMAGE(7,new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE}),
    PIZZA_CHAMPIGNONS(7,new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE,IngredientsDatas.CHAMPIGNONS}),
    PIZZA_CHORIZO(8,new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE,IngredientsDatas.CHORIZO}),

    FAJITAS_POULET(11,new IngredientsDatas[]{IngredientsDatas.PAIN_SUEDOIS,IngredientsDatas.RIZ,IngredientsDatas.POULET}),
    FAJITAS_VIANDE(11, new IngredientsDatas[]{IngredientsDatas.PAIN_SUEDOIS,IngredientsDatas.RIZ,IngredientsDatas.VIANDE}),

    CENTS_ANS(100, new IngredientsDatas[]{});

    private int price;
    private IngredientsDatas ingredients[];

    private DishesDatas(int price,  IngredientsDatas ingredients[]) {this.price = price; this.ingredients = ingredients; }

    public int getPrice() {
        return price;
    }

    public IngredientsDatas[] getIngredients() {
        return ingredients;
    }
}
