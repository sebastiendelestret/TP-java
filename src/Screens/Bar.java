package Screens;

import Objects.Tools;

import java.util.Scanner;

public class Bar implements Tools {
    public Bar(){

    }

    public void update(){
        System.out.println("Ecran bar");
        Tools.displayTables();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    }
}
