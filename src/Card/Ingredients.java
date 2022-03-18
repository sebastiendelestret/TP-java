package Card;

public class Ingredients {
    private String name;
    private int stocks;

    public Ingredients(String name, int stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    public boolean consumeStocks(int totalConsumed){
        if(totalConsumed>=stocks){
            this.stocks -= totalConsumed;
            return true;
        }
        else{
            System.out.println("No more "+ name +" in stocks");
            return false;
        }
    }

    public void refileStocks(int addStock){
        if(addStock>0){
            this.stocks += addStock;
        }
        else System.out.println("Cannot refile a negative number");
    }

    public String getName() {
        return name;
    }

    public int getStocks() {
        return stocks;
    }
}
