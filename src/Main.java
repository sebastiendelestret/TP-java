import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Tools tools;
    private static ArrayList<Table>listTable = new ArrayList<>();

    public static void main(String[] args){
        tools =new Tools();

        createTable(10);
        displayTables();

        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");

        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        System.out.println("Vous avez choisi l'écran: " + choixEcran);
    }

    private static void createTable(int numTable){
        for(int i = 0; i<numTable; i++){
            listTable.add(new Table(tools.getRandInt(2,8), i+1));
        }
    }

    private static void displayTables(){
        for (int i = 0; i< listTable.size(); i++){
            System.out.println("Table "+listTable.get(i).getIdTable()+" : "+listTable.get(i).getNbPlaces()+" places" );
        }
    }

}
