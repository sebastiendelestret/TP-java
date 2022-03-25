package Objects;

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

}
