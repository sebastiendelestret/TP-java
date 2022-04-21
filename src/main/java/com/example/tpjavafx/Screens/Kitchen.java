package com.example.tpjavafx.Screens;

import com.example.tpjavafx.Objects.Tools;

import java.util.Scanner;

import static com.example.tpjavafx.Objects.Util.listTable;

public class Kitchen implements Tools {

    public Kitchen(){

    }

    public void update(){
        System.out.println("Ecran cuisine");

        displayAllCommands();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    }

    public void displayAllCommands(){

        for(int i=0; i<listTable.size(); i++){
            if(!listTable.get(i).isServed()){
                System.out.println("===== Repas table " + (i+1) + " =====");
                Tools.displayTableDishes(i);
            }
        }

    }
}
