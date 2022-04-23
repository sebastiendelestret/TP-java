package com.example.tpjavafx.Screens;

import com.example.tpjavafx.Objects.Table;
import com.example.tpjavafx.Objects.Tools;
import java.util.Scanner;
import static com.example.tpjavafx.Objects.Util.listTable;

public class Principal implements Tools {

    private Bar bar = new Bar();
    private Monitoring monitoring = new Monitoring();

    public Principal(){
        this.createTables(8);

    }

    private void createTables(int numberTable){
        for(int i = 0; i<numberTable; i++){
            listTable.add(new Table(Tools.getRandInt(2,8), (i+1)));
        }
    }




}
