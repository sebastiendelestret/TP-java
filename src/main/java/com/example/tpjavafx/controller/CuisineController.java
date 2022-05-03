package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Objects.Stageable;
import com.example.tpjavafx.Objects.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.tpjavafx.Objects.Util.listTable;

/**
 * Controller de l'écran cuisine
 */

public class CuisineController implements Stageable, Initializable {

    private Stage stage;

    @FXML
    private FlowPane kitchenFlowPane;

    @FXML
    private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @FXML
    private void refreshScreen(ActionEvent event) {
        refresh();
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh();

    }

    private void refresh() {
        kitchenFlowPane.getChildren().clear();
        for (Table table : listTable) {
            if (!table.getDishesList().isEmpty()) {
                ListView<String> tmp = new ListView<>();
                tmp.setMouseTransparent(true);
                tmp.setFocusTraversable(false);
                tmp.setPrefSize(100, 150);
                for (DishesDatas data : table.getDishesList()) {
                    tmp.getItems().add(data.toString());

                }
                kitchenFlowPane.getChildren().add(tmp);
            }
        }
    }
}
