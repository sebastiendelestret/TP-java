package Screens;

import Datas.DishesDatas;
import Datas.DrinksDatas;
import Datas.IngredientsDatas;
import Objects.Employe;
import Objects.Table;
import Objects.Tools;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Scanner;

import static Objects.Util.listEmploye;
import static Objects.Util.listTable;


public class Monitoring implements Tools {
    public Monitoring() {

    }

    public void update() {
        System.out.println("Ecran Monitoring");

        takeCommand();
    }

    public void takeCommand() {
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
                    displayListeCourse();
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
                    majIngredients();
                    break;

                case 6:
                    programEmploye();
                    break;
                default:
                    break;

            }
        } while (choice != 0);
    }

    public void displayListeCourse() {
        System.out.println("====== Liste de Course ======");

        for (IngredientsDatas data : IngredientsDatas.values()) {
            if (data.getStocks() <= 5) {
                System.out.println(data.toString() + " x 20");
            }
        }
    }

    public void majIngredients() {
        System.out.println("====== Maj Ingédients ======");

        for (IngredientsDatas data : IngredientsDatas.values()) {
            System.out.println(data.toString() + " Nombre : ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            data.addStocks(choice);
        }
    }

    public void addEmploye() {
        System.out.println("Nom :");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        System.out.println("Prénom :");
        Scanner scanner2 = new Scanner(System.in);
        String choice2 = scanner2.next();
        listEmploye.add(new Employe(choice, choice2));
    }

    public void deleteEmploye() {
        System.out.println("Numero :");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        listEmploye.remove(choice);
    }

    public void displayEmploye() {
        System.out.println("=====Employés=====");
        for (int i = 0; i < listEmploye.size(); i++) {
            System.out.println(i + ". " + listEmploye.get(i).name + " " + listEmploye.get(i).firstname + " " + listEmploye.get(i).post);
        }
    }

    public void programEmploye() {
        System.out.println("===== Liste des Employés=====");
        for (int i = 0; i < listEmploye.size(); i++) {
            System.out.println(i + ". " + listEmploye.get(i).name + " " + listEmploye.get(i).firstname + " " + listEmploye.get(i).post);
        }
        System.out.println("===== Prog de la soirée =====");
        int nb = 0;
        System.out.println("Nombre d'employé souhaité :");
        Scanner scanner3 = new Scanner(System.in);
        int choice3 = scanner3.nextInt();
        if(choice3 < 4) {
            System.out.println("Il faut au moins 4 employés");
        }else {

        while(nb < choice3) {

            System.out.println("Numéro :");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(listEmploye.get(choice) != null) {
                if(listEmploye.get(choice).getPost() != "Vide") {
                    System.out.println("Cet employé est deja attribué à un poste !");
                }else {
                    System.out.println("Poste : (Cuisinier -  Serveur - Manager - Barman)");
                    Scanner scanner2 = new Scanner(System.in);
                    String choice2 = scanner2.next();
                    listEmploye.get(choice).setPost(choice2);
                    System.out.println("Employe :" + " " + choice + " Poste : " + choice2);
                    nb++;
                }
            }else {
                System.out.println("Ce numéro d'employé n'existe pas");
            }


        }
        }
    }
}
