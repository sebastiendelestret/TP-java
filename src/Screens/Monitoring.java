package Screens;

import Datas.DishesDatas;
import Datas.DrinksDatas;
import Objects.Table;
import Objects.Tools;

import javax.tools.Tool;
import java.util.Scanner;

import static Objects.Util.listTable;


public class Monitoring implements Tools {

    public Monitoring(){

    }

    public void update(){
        System.out.println("Ecran Monitoring");

        takeCommand();
    }

    public void takeCommand(){
        int choice;
        do {
            System.out.println("0-Retour");
            System.out.println("1-Performances du restaurant");
            System.out.println("2-Impression de la liste de course");
            System.out.println("3-Ajouter un employé");
            System.out.println("4-Supprimer un employé");
            System.out.println("5-Mettre à jour les reserves d'aliments");
            System.out.println("6-Programmer les employés pour la soirée");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;

            }
        }while (choice != 0);
    }
}
