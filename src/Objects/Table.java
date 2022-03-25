package Objects;

import Card.Dishes;
import Card.Drinks;

import java.util.ArrayList;

public class Table {

    private int nbPlaces;
    private int nbClients;
    private Employe server;

    private boolean served;
    private int idTable;


    private ArrayList<Dishes> dishesList = new ArrayList<>();
    private ArrayList<Drinks> drinkList = new ArrayList<>();

    public Table(int nbPlaces, int idTable){
        this.nbPlaces = nbPlaces;
        this.idTable = idTable;
        this.nbClients = 0;
        this.served = false;
    }

    public void addClients(int nbClients){
        this.nbClients = nbClients;
    }

    public void clientsLeave(){
        this.nbClients =0;
    }

    public void addDishes(Dishes newDishes){
        this.dishesList.add(newDishes);
        this.served = false;
    }

    public void addDrink(Drinks newDrink){
        this.served = false;
        this.drinkList.add(newDrink);
    }

    public void serveClients(){
        this.served = true;
        for(int i = 0; i < dishesList.size(); i++){
            this.dishesList.get(i).serveDishes();
            this.drinkList.get(i).serveDrink();
        }
    }

    public int getNbPlaces() {        return nbPlaces;
    }

    public int getNbClients() {
        return nbClients;
    }

    public Employe getServer() {
        return server;
    }

    public boolean isServed() {
        return served;
    }

    public int getIdTable() {
        return idTable;
    }

}
