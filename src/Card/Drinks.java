package Card;

public class Drinks {
    private String name;

    private int price;

    private boolean served;

    public Drinks(String name, int price){
        this.name = name;
        this.price = price;
        this.served = false;
    }

    public boolean isServed() {
        return served;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public void serveDrink(){
        this.served = true;
    }
}
