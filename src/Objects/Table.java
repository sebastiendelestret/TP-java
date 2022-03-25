package Objects;

import Datas.DishesDatas;
import Datas.DrinksDatas;

import java.util.ArrayList;

public class Table {

    private int nbPlaces;
    private int nbClients;
    private Employe server;

    private boolean served;
    private int idTable;


    private ArrayList<DishesDatas> dishesList = new ArrayList<>();
    private ArrayList<DrinksDatas> drinkList = new ArrayList<>();

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

    public void addDishes(DishesDatas newDishes){
        this.dishesList.add(newDishes);
        this.served = false;
    }

    public void addDrink(DrinksDatas newDrink){
        this.served = false;
        this.drinkList.add(newDrink);
    }

    public void serveClients(){
        this.served = true;
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

    public ArrayList<DishesDatas> getDishesList() {
        return dishesList;
    }

    public ArrayList<DrinksDatas> getDrinkList() {
        return drinkList;
    }
}
