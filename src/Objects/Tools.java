package Objects;

import Datas.DishesDatas;
import Datas.DrinksDatas;

import java.util.Random;

import static Objects.Util.listTable;

public interface Tools {
    public static int getRandInt(int min, int max){
        return new Random().nextInt((max - min)+1) +min;
    }

    public static void displayTables(){
        for(int i=0; i < listTable.size(); i++){
            Table tmp = listTable.get(i);
            System.out.println("Table " + tmp.getIdTable() + " : " + tmp.getNbPlaces() + " places" );
        }
    }

    public static void displayTableDishes(int idTable){
        Table tmpTable = listTable.get(idTable);
        if(tmpTable.getDishesList().size() == 0){
            System.out.println("Aucun plat");
        }
        else{
            System.out.println("=========Plats choisis==========");
            for(int i =0; i < tmpTable.getDishesList().size(); i++) {
                System.out.println(tmpTable.getDishesList().get(i));
            }

        }
    }
    public static void displayTableDrinks(int idTable){
        Table tmpTable = listTable.get(idTable);
        if(tmpTable.getDishesList().size() == 0){
            System.out.println("Aucune boisson");
        }
        else{
            System.out.println("===========Boissons=============");
            for(int i =0; i < tmpTable.getDrinkList().size(); i++){
                System.out.println(tmpTable.getDrinkList().get(i));
            }

        }
    }



    public static void displayDishesList(){
        int i=1;
        for(DishesDatas dishes : DishesDatas.values()){
            System.out.println(i + "-" +dishes.toString());
            i++;
        }
    }

    public static void displayDrinksList(){
        int i=1;
        for(DrinksDatas drinks : DrinksDatas.values()){
            System.out.println(i + "-" +drinks.toString());
            i++;
        }
    }

}
