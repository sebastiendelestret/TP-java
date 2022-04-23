package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.IngredientsDatas;
import com.example.tpjavafx.Objects.Stageable;
import com.example.tpjavafx.Objects.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MonitoringController implements Stageable, Initializable, Tools {

    private Stage stage;

    @FXML private TableView<ingredientItem> tableIngredients;
    @FXML private TableColumn<ingredientItem, String> name;
    @FXML private TableColumn<ingredientItem, Integer> stocks;

    public ObservableList<ingredientItem> listIngredient = FXCollections.observableArrayList(
    );

    @FXML private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @FXML private void refreshTable(ActionEvent event){
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

    private void refresh(){
        tableIngredients.getItems().clear();
        for(IngredientsDatas data:IngredientsDatas.values()){
            listIngredient.add(new ingredientItem(data.toString(), data.getStocks()));
        }
        name.setCellValueFactory(new PropertyValueFactory<ingredientItem, String>("name"));
        stocks.setCellValueFactory(new PropertyValueFactory<ingredientItem, Integer>("stocks"));
        tableIngredients.setItems(listIngredient);
    }
}
