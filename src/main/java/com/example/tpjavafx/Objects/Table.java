package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;

import java.util.ArrayList;

import static com.example.tpjavafx.Objects.Util.factureList;

/**
 * Décris le fonctionnement d'une table dans le restaurant :
 * contiens toute les information liées à une table, les commandes, le serveur attitré ...
 */

public class Table {


    private final int nbPlaces;
    private Employe server;

    private final int idTable;


    /**
     * Les tableaux dishesList et drinkList contiennent les plats et boissons en attente de préparation
     */
    private ArrayList<DishesDatas> dishesList = new ArrayList<>();
    private ArrayList<DrinksDatas> drinkList = new ArrayList<>();

    /**
     * Les tableaux servedDishesList et servedDrinksList eux contiennent les plats qui ont déjà était servis
     */
    private ArrayList<DishesDatas> servedDishesList = new ArrayList<>();
    private ArrayList<DrinksDatas> servedDrinksList = new ArrayList<>();

    /**
     * Contructeur de la class Table
     *
     * @param nbPlaces nombre de places de la table
     * @param idTable  numéro d'identification de la table
     */
    public Table(int nbPlaces, int idTable) {
        this.nbPlaces = nbPlaces;
        this.idTable = idTable;
    }

    /**
     * Réinitialise la table et sauvegarde la facture quand les clients ont payé
     */
    public void clientsLeave() {

        factureList.add(new Facture(servedDishesList, servedDrinksList, idTable));
        this.server = null;

        dishesList.clear();
        drinkList.clear();
        servedDishesList.clear();
        servedDrinksList.clear();
    }

    /**
     * Ajoute le plat en argument à la liste des plats de la table
     * @param newDishes plat à ajouter
     */
    public void addDishes(DishesDatas newDishes) {
        this.dishesList.add(newDishes);
    }

    /**
     * Ajoute la boisson en argument à la liste des boissons de la table
     */
    public void addDrink(DrinksDatas newDrink) {
        this.drinkList.add(newDrink);
    }

    /**
     * Transfert tous les plats et boisson dans la liste des commandes déjà servies
     */
    public void serveClients() {
        for (int i = 0; i < dishesList.size(); i++) {
            servedDishesList.add(dishesList.get(i));
        }
        for (int i = 0; i < drinkList.size(); i++) {
            servedDrinksList.add(drinkList.get(i));
        }
        dishesList.clear();
        drinkList.clear();
    }


    public int getNbPlaces() {
        return nbPlaces;
    }


    public Employe getServer() {
        return server;
    }

    public void setServer(Employe server) {
        this.server = server;
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

    public ArrayList<DishesDatas> getServedDishesList() {
        return servedDishesList;
    }

    public ArrayList<DrinksDatas> getServedDrinksList() {
        return servedDrinksList;
    }
}
