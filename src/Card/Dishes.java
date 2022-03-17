package Card;

import java.util.ArrayList;

public class Dishes {
    private String name;
    private int price;
    private boolean served;
    private ArrayList<Ingredients> ingredientsList = new ArrayList<>();

    public Dishes(String name, int price, ArrayList<Ingredients> ingredients){
        this.served = false;
        this.name = name;
        this.price = price;
        this.ingredientsList = ingredients;
    }

    public void serveDishes(){
        this.served = true;
    }
}
