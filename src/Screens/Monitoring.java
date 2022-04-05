package Screens;

import Datas.DishesDatas;
import Datas.DrinksDatas;
import Objects.Employe;
import Objects.Table;
import Objects.Tools;

import javax.tools.Tool;
import java.util.Scanner;

import static Objects.Util.listEmploye;
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
                    addEmploye();
                    displayEmploye();
                    break;
                case 4:
                    displayEmploye();
                    deleteEmploye();
                    displayEmploye();
                    break;
                case 5:
                    Tools.displayStocks();
                    break;
                default:
                    break;

            }
        }while (choice != 0);
    }

    public void addEmploye() {
        System.out.println("Nom :");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        System.out.println("Prénom :");
        Scanner scanner2 = new Scanner(System.in);
        String choice2 = scanner2.next();
        System.out.println("Poste :");
        Scanner scanner3 = new Scanner(System.in);
        String choice3 = scanner3.next();
        listEmploye.add(new Employe(choice,choice2,choice3));
    }

    public void deleteEmploye() {
        System.out.println("Numero :");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        listEmploye.remove(choice);
    }

    public void displayEmploye() {
        System.out.println("=====Employés=====");
        for(int i = 0; i < listEmploye.size(); i++) {
            System.out.println(i+". "+listEmploye.get(i).name+ " "+listEmploye.get(i).firstname+" "+listEmploye.get(i).post);
        }
    }
}
