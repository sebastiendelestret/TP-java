package Screens;

import Objects.Tools;
import java.util.Scanner;

public class Kitchen implements Tools {

    public Kitchen(){

    }

    public void update(){
        System.out.println("Ecran cuisine");
        Tools.displayTables();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    }
}
