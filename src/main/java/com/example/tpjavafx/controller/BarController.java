package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Objects.Stageable;
import com.example.tpjavafx.Objects.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Objects.FxmlInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.tpjavafx.Objects.Util.listTable;


public class BarController implements Stageable, Initializable {

    private Stage stage;

    @FXML private FlowPane barFlowPane;

    @FXML private void refreshScreen(ActionEvent event){
        refresh();
    }

    @FXML private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void refresh(){
        barFlowPane.getChildren().clear();
        for(Table table:listTable){
            if (!table.getDrinkList().isEmpty()){
                ListView<String> tmp = new ListView<>();
                tmp.setMouseTransparent(true);
                tmp.setFocusTraversable(false);
                tmp.setPrefSize(100,150);
                for(DrinksDatas data:table.getDrinkList()){
                    tmp.getItems().add(data.toString());
                }
                barFlowPane.getChildren().add(tmp);
            }
        }
    }
}
