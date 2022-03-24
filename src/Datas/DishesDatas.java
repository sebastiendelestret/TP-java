package Datas;

public enum DishesDatas {
    SALADE_TOMATE(new IngredientsDatas[]{IngredientsDatas.SALADE,IngredientsDatas.TOMATE}),
    SALADE(new IngredientsDatas[]{IngredientsDatas.SALADE}),

    POTAGE_OIGNON(new IngredientsDatas[]{IngredientsDatas.OIGNON,IngredientsDatas.OIGNON,IngredientsDatas.OIGNON}),
    POTAGE_TOMATE(new IngredientsDatas[]{IngredientsDatas.TOMATE,IngredientsDatas.TOMATE,IngredientsDatas.TOMATE}),
    POTAGE_CHAMPIGNONS(new IngredientsDatas[]{IngredientsDatas.CHAMPIGNONS,IngredientsDatas.CHAMPIGNONS,IngredientsDatas.CHAMPIGNONS}),

    BURGER_MAX(new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.SALADE,IngredientsDatas.TOMATE,IngredientsDatas.VIANDE}),
    BURGER_SALADE(new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.SALADE,IngredientsDatas.VIANDE}),
    BURGER_VIANDE(new IngredientsDatas[]{IngredientsDatas.PAIN,IngredientsDatas.VIANDE}),

    PIZZA_FROMAGE(new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE}),
    PIZZA_CHAMPIGNONS(new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE,IngredientsDatas.CHAMPIGNONS}),
    PIZZA_CHORIZO(new IngredientsDatas[]{IngredientsDatas.PATE,IngredientsDatas.TOMATE,IngredientsDatas.FROMAGE,IngredientsDatas.CHORIZO});

    private IngredientsDatas ingredients[];

    private DishesDatas(IngredientsDatas ingredients[]) { this.ingredients = ingredients; }
}
