package com.example.tpjavafx.Screens;

import com.example.tpjavafx.Objects.Table;
import com.example.tpjavafx.Objects.Tools;
import java.util.Scanner;
import static com.example.tpjavafx.Objects.Util.listTable;

public class Principal implements Tools {

    private Commands commands = new Commands();
    private Kitchen kitchen = new Kitchen();
    private Bar bar = new Bar();
    private Monitoring monitoring = new Monitoring();

    public Principal(){
        this.createTables(8);

    }

    public void update(){
        int screenChoice;
        do {
            screenChoice = startMenu();

            switch (screenChoice) {
                case 1:
                    commands.update();
                    break;
                case 2:
                    kitchen.update();
                    break;
                case 3:
                    bar.update();
                    break;
                case 4:
                    monitoring.update();
                    break;

                default:
                    System.out.println("Il n'y a pas d'écran");
                    break;
            }
        }while (screenChoice!=0);


    }


    private void createTables(int numberTable){
        for(int i = 0; i<numberTable; i++){
            listTable.add(new Table(Tools.getRandInt(2,8), (i+1)));
        }
    }


    private int startMenu(){
        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }

}
