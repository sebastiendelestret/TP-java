package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;
import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.tpjavafx.Objects.Util.listEmploye;
import static com.example.tpjavafx.Objects.Util.listTable;

/**
 * Controller de l'écran command
 */

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
    private Button menucentans;

    @FXML
    private Label labelTable;

    @FXML
    private Label labelServer;

    private MenuItem newItem;

    @FXML
    private void printNote(ActionEvent event) {
        Tools.printNote(chosenTable);
    }

    @FXML
    private void departClients(ActionEvent event) {
        listTable.get(chosenTable).clientsLeave();
        initiatePage();
    }

    @FXML
    private void serveTable(ActionEvent event) {
        listTable.get(chosenTable).serveClients();
        displayChosenDishesDrinks();
    }

    @FXML
    private void menuCentAnsAction() {
        listTable.get(chosenTable).addDishes(DishesDatas.CENTS_ANS);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiatePage();
    }

    /**
     * Initialisation, tant qu'aucune table n'est choisie aucun bouton ne s'affiche
     */
    private void initiatePage() {
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
        menucentans.setVisible(false);

        labelServer.setText("");
    }

    /**
     * Affiche le menu de sélection de la table
     */
    private void initializeTableDisplay() {
        tableMenuButton.getItems().clear();
        for (Table table : listTable) {
            EventHandler<ActionEvent> eventClick = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    initiatePage();
                    chosenTable = table.getIdTable() - 1;
                    labelTable.setText("table " + (chosenTable + 1));


                    if (listTable.get(chosenTable).getServer() == null) {
                        responsableMenu.setVisible(true);
                    } else displayAll();

                }
            };

            newItem = new MenuItem("table " + table.getIdTable() + " | " + table.getNbPlaces() + " places");
            newItem.setOnAction(eventClick);
            tableMenuButton.getItems().add(newItem);
        }
    }

    /**
     * Une fois que la table est choisie on affiche tous les boutons
     */
    private void displayAll() {
        addDrinksList.setVisible(true);
        addPlatesList.setVisible(true);
        printNoteButton.setVisible(true);
        serveTableButton.setVisible(true);
        serveTableButton.setVisible(true);
        buttonDepart.setVisible(true);
        menucentans.setVisible(true);
        labelServer.setText(listTable.get(chosenTable).getServer().getFirstname() + " " + listTable.get(chosenTable).getServer().getName());
        displayChosenDishesDrinks();

    }

    /**
     * Affiche le menu des choix de boissons
     */
    private void initializeButtonsDrinks() {
        addDrinksList.getItems().clear();
        for (DrinksDatas drinks : DrinksDatas.values()) {
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

    /**
     * Affiche le menu des plats
     * A l'exception du menu CENT ans qui à un fonctionnement différent
     */
    private void initializeButtonsPlates() {
        addPlatesList.getItems().clear();
        for (DishesDatas dishes : DishesDatas.values()) {
            if (dishes != DishesDatas.CENTS_ANS) {
                EventHandler<ActionEvent> eventClick = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (checkStocks(dishes)) {
                            listTable.get(chosenTable).addDishes(dishes);
                            consumeStocks(dishes);
                        }
                        displayChosenDishesDrinks();
                    }
                };

                newItem = new MenuItem(dishes.toString());
                newItem.setOnAction(eventClick);
                if (!checkStocks(dishes)) {
                    newItem.setDisable(true);
                }

                addPlatesList.getItems().add(newItem);
            }
        }
    }

    /**
     * Menu de sélection du serveur qui s'occupe de la table
     */
    private void initializeResponsableMenu() {
        responsableMenu.getItems().clear();
        for (Employe employe : listEmploye) {

            if (employe.getPost() == Posts.Serveur.toString()) {

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

    /**
     * Affichage des commande en attente d'être servie
     */
    private void displayChosenDishesDrinks() {
        dishesListView.getItems().clear();
        for (DishesDatas data : listTable.get(chosenTable).getDishesList()) {
            dishesListView.getItems().add(data.toString());
        }
        drinkListView.getItems().clear();
        for (DrinksDatas data : listTable.get(chosenTable).getDrinkList()) {
            drinkListView.getItems().add(data.toString());
        }

    }


    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean checkStocks(DishesDatas dish) {

        for (IngredientsDatas ingredient : dish.getIngredients()) {
            if (ingredient.getStocks() < 1) {
                return false;
            }
        }

        return true;
    }

    private void consumeStocks(DishesDatas dish) {
        for (IngredientsDatas ingredient : dish.getIngredients()) {
            ingredient.setStocks(ingredient.getStocks() - 1);
        }
    }


}
