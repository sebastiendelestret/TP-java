package Objects;

import Datas.DishesDatas;

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
            for(int i =0; i < tmpTable.getDishesList().size(); i++){
                System.out.println(tmpTable.getDishesList().get(i));
            }
        }
    }

    public static void displayDishesList(){
        for(DishesDatas dishes : DishesDatas.values()){
            System.out.println(dishes.toString());
        }
    }

}
