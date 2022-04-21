package com.example.tpjavafx.Screens;

import com.example.tpjavafx.Objects.Tools;

import java.util.Scanner;

import static com.example.tpjavafx.Objects.Util.listTable;

public class Bar implements Tools {
    public Bar(){

    }

    public void update(){
        System.out.println("Ecran bar");
        displayAllCommands();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    }

    public void displayAllCommands(){

        for(int i=0; i<listTable.size(); i++){
            if(!listTable.get(i).isServed()){
                System.out.println("===== Boisson table " + (i+1) + " =====");
                Tools.displayTableDrinks(i);
            }
        }

    }
}
