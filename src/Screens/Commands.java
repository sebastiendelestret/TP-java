package Screens;

import Objects.Tools;
import java.util.Scanner;


public class Commands implements Tools {


    public Commands(){

    }

    public void update(){
        System.out.println("Ecran prise de commande");
        Tools.displayTables();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

    }


}
