package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.IngredientsDatas;
import com.example.tpjavafx.Objects.Stageable;
import com.example.tpjavafx.Objects.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Objects.FxmlInfo;
import com.example.tpjavafx.Objects.ingredientItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MonitoringController implements Stageable, Initializable, Tools {

    private Stage stage;

    @FXML private TableView<ingredientItem> tableIngredients;
    @FXML private TableColumn<String, String> ingredientsColumn;
    @FXML private TableColumn<String, Integer> stocksColumn;

    @FXML private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(IngredientsDatas data:IngredientsDatas.values()){
            tableIngredients.getItems().add(new ingredientItem(data.getStocks(), data.toString()));
        }
    }
}
