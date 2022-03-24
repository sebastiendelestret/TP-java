package Screens;
import Objects.Table;
import Objects.Tools;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal implements Tools {
    private static ArrayList<Table> listTable = new ArrayList<>();

    public Principal(){

    }

    public void update(){
        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");

        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        System.out.println("Vous avez choisi l'écran: " + choixEcran);
    }




}
