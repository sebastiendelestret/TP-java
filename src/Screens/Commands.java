package Screens;

import Datas.DrinksDatas;
import Objects.Table;
import Objects.Tools;

import javax.tools.Tool;
import java.util.Scanner;

import static Objects.Util.listTable;


public class Commands implements Tools {

    private int choosenTable;

    public Commands(){

    }

    public void update(){
        System.out.println("Ecran prise de commande");
        chooseTable();

        System.out.println(choosenTable);
        takeCommand();


    }

    public void chooseTable(){
        int choice;
        do {
            Tools.displayTables();

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt() - 1;
        }while (choice<=0 || choice >= listTable.size());
        choosenTable = choice;
    }

    public void takeCommand(){
        int choice;
        do {
            System.out.println("1-Choisir repas");
            System.out.println("2-Choisir boissons");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    takeDishes();
                    break;
                case 2:
                    takeDrinks();
                    break;
                default:
                    break;

            }
        }while (choice != 0);
    }

    public void takeDishes(){

        Tools.displayTableDishes(choosenTable);
        Tools.displayDishesList();




    }

    public void takeDrinks(){

    }


}
