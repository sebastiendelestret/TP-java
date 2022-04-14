package Screens;

import Datas.DishesDatas;
import Datas.DrinksDatas;
import Datas.IngredientsDatas;
import Objects.Table;
import Objects.Tools;

import java.util.Scanner;

import static Objects.Util.listTable;


public class Commands implements Tools {

    private int choosenTable;

    public Commands(){

    }

    public void update(){
        System.out.println("Ecran prise de commande");
        chooseTable();

        System.out.println((choosenTable+1));
        takeCommand();


    }

    public void chooseTable(){
        int choice;
        do {
            Tools.displayTables();

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        }while (choice<=0 || choice >= listTable.size());
        choosenTable = choice -1 ;
    }

    public void takeCommand(){
        int choice;
        do {
            System.out.println("0-Retour");
            System.out.println("1-Choisir repas");
            System.out.println("2-Choisir boissons");
            System.out.println("3-Servir table");
            System.out.println("4-Imprimer note");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    takeDishes(0);
                    break;
                case 2:
                    takeDishes(1);
                    break;
                case 3:
                    listTable.get(choosenTable).serveClients();
                    break;
                case 4:
                    Tools.printNote(choosenTable);
                    break;
                default:
                    break;

            }
        }while (choice != 0);
    }

    public void takeDishes(int dishesOrDrinks){

        DishesDatas tableDishes[] =DishesDatas.values();
        DrinksDatas tableDrinks[]= DrinksDatas.values();
        int choice;
        do {


            Tools.displayTableDishes(choosenTable);
            Tools.displayTableDrinks(choosenTable);
            System.out.println("0-Retour");
            if(dishesOrDrinks == 0)Tools.displayDishesList();
            else Tools.displayDrinksList();

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt() - 1;

            if(0<=choice && choice< tableDishes.length && dishesOrDrinks == 0){
                if(checkStocks(tableDishes[choice])){
                    listTable.get(choosenTable).addDishes(tableDishes[choice]);
                    System.out.println(tableDishes[choice].toString() + " ajouté");
                }
                else{
                    System.out.println("Plus d'ingrédients");
                }
            }

            else if(0<=choice && choice< tableDrinks.length){
                listTable.get(choosenTable).addDrink(tableDrinks[choice]);
                System.out.println(tableDrinks[choice].toString() + " ajouté");
            }

        }while (choice != -1);
    }

    public boolean checkStocks(DishesDatas dishe){


        for(IngredientsDatas ingredient:dishe.getIngredients()){
            if(ingredient.getStocks()<1){
                return false;
            }
        }
        for(IngredientsDatas ingredient:dishe.getIngredients()){
            ingredient.setStocks(ingredient.getStocks()-1);
        }
        return true;

    }




}
