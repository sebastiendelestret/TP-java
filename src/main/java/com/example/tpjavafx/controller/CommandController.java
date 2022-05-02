package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;
import com.example.tpjavafx.Objects.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.example.tpjavafx.Main;

import static com.example.tpjavafx.Objects.Util.listTable;
import static com.example.tpjavafx.Objects.Util.listEmploye;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandController implements Stageable, Initializable, Tools {

    private Stage stage;

    private int chosenTable;

    @FXML
    private MenuButton tableMenuButton;
    @FXML
    private MenuButton responsableMenu;
    @FXML
    private MenuButton addPlatesList;
    @FXML
    private MenuButton addDrinksList;
    @FXML
    private ListView<String> dishesListView;
    @FXML
    private ListView<String> drinkListView;

    @FXML
    private Button printNoteButton;
    @FXML
    private Button serveTableButton;
    @FXML
    private Button buttonDepart;

    @FXML
    private Label labelTable;

    @FXML
    private Label labelServer;

    private MenuItem newItem;

    @FXML
    private void printNote(ActionEvent event){
        Tools.printNote(chosenTable);
    }

    @FXML
    private void departClients(ActionEvent event){

        listTable.get(chosenTable).clientsLeave();
        initiatePage();
    }

    @FXML
    private void serveTable(ActionEvent event){
        listTable.get(chosenTable).serveClients();
        displayChosenDishesDrinks();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initiatePage();



    }

    private void initiatePage(){
        initializeTableDisplay();
        initializeButtonsDrinks();
        initializeButtonsPlates();
        initializeResponsableMenu();

        addDrinksList.setVisible(false);
        addPlatesList.setVisible(false);
        printNoteButton.setVisible(false);
        serveTableButton.setVisible(false);
        responsableMenu.setVisible(false);
        buttonDepart.setVisible(false);

        labelServer.setText("");
    }

    private void initializeButtonsDrinks(){
        addDrinksList.getItems().clear();
        for(DrinksDatas drinks:DrinksDatas.values()){
            EventHandler<ActionEvent> eventClick = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    listTable.get(chosenTable).addDrink(drinks);
                    displayChosenDishesDrinks();
                }
            };

            newItem = new MenuItem(drinks.toString());
            newItem.setOnAction(eventClick);
            addDrinksList.getItems().add(newItem);
        }
    }

    private void initializeButtonsPlates(){
        addPlatesList.getItems().clear();
        for(DishesDatas dishes:DishesDatas.values()){
            EventHandler<ActionEvent> eventClick = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (checkStocks(dishes)){
                        listTable.get(chosenTable).addDishes(dishes);
                        consumeStocks(dishes);
                    }
                    displayChosenDishesDrinks();
                }
            };

            newItem = new MenuItem(dishes.toString());
            newItem.setOnAction(eventClick);
            if(!checkStocks(dishes)){
                newItem.setDisable(true);
            }

            addPlatesList.getItems().add(newItem);
        }
    }

    private void initializeTableDisplay(){
        tableMenuButton.getItems().clear();
        for (Table table : listTable) {
            EventHandler<ActionEvent> eventClick = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    initiatePage();
                    chosenTable = table.getIdTable() - 1;
                    labelTable.setText("table " + (chosenTable + 1));


                    if(listTable.get(chosenTable).getServer() == null){
                        responsableMenu.setVisible(true);
                    }
                    else displayAll();

                }
            };

            newItem = new MenuItem("table " + table.getIdTable() + " | " + table.getNbPlaces() + " places");
            newItem.setOnAction(eventClick);
            tableMenuButton.getItems().add(newItem);
        }
    }

    private void displayAll(){
        addDrinksList.setVisible(true);
        addPlatesList.setVisible(true);
        printNoteButton.setVisible(true);
        serveTableButton.setVisible(true);
        serveTableButton.setVisible(true);
        buttonDepart.setVisible(true);
        labelServer.setText(listTable.get(chosenTable).getServer().getFirstname() + " " + listTable.get(chosenTable).getServer().getName());
        displayChosenDishesDrinks();

    }

    private void initializeResponsableMenu(){
        responsableMenu.getItems().clear();
        for(Employe employe:listEmploye){

            if(employe.getPost() == Posts.Serveur.toString()){

                EventHandler<ActionEvent> click = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {


                        listTable.get(chosenTable).setServer(employe);
                        displayAll();

                    }
                };

                newItem = new MenuItem(employe.getFirstname());
                newItem.setOnAction(click);
                responsableMenu.getItems().add(newItem);
            }



        }
    }




    private void displayChosenDishesDrinks(){
        dishesListView.getItems().clear();
        for(DishesDatas data:listTable.get(chosenTable).getDishesList()){
            dishesListView.getItems().add(data.toString());
        }
        drinkListView.getItems().clear();
        for(DrinksDatas data:listTable.get(chosenTable).getDrinkList()){
            drinkListView.getItems().add(data.toString());
        }

    }


    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean checkStocks(DishesDatas dish){

        for(IngredientsDatas ingredient:dish.getIngredients()){
            if(ingredient.getStocks()<1){
                return false;
            }
        }

        return true;
    }

    private void consumeStocks(DishesDatas dish){
        for(IngredientsDatas ingredient:dish.getIngredients()){
            ingredient.setStocks(ingredient.getStocks()-1);
        }
    }


}
