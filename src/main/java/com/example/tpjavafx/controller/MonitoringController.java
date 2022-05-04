package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.IngredientsDatas;
import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.tpjavafx.Objects.Util.factureList;
import static com.example.tpjavafx.Objects.Util.listEmploye;

/**
 * MonitoringController est le controller de la page fxml controller
 * On y retrouve l'aperçu des performance de la journée, la gestion des employés,
 * la gestion des stocks.
 */

public class MonitoringController implements Stageable, Initializable, Tools, ShoppingList {

    @FXML
    private TextField inputName;
    @FXML
    private TextField inputFirstName;
    @FXML
    private ChoiceBox<String> inputPost;
    @FXML
    private Label labelDishes;
    @FXML
    private Label labelDrinks;
    @FXML
    private Label labelSales;
    @FXML
    private Pane performancePane;
    @FXML
    private Pane stocksPane;
    @FXML
    private Pane employeePane;
    private Stage stage;

    /**
     * Variables associées au tableau d'ingrédients pour la gestion des stocks
     */
    @FXML
    private TableView<ingredientItem> tableIngredients;
    @FXML
    private TableColumn<ingredientItem, String> name;
    @FXML
    private TableColumn<ingredientItem, Integer> stocks;
    @FXML
    private TableColumn<ingredientItem, TextField> addStocks;

    /**
     * Variables associées au tableau d'employés pour la gestion des employés
     */
    @FXML
    private TableView<employeeItem> tableEmployee;
    @FXML
    private TableColumn<employeeItem, String> employeeName;
    @FXML
    private TableColumn<employeeItem, String> employeeFirstName;
    @FXML
    private TableColumn<employeeItem, String> employeePost;
    @FXML
    private TableColumn<employeeItem, Integer> employeeSoiree;

    public ObservableList<ingredientItem> listIngredient = FXCollections.observableArrayList();

    public ObservableList<employeeItem> listEmployeeObservable = FXCollections.observableArrayList();

    /**
     * A l'appui du boutton, renvoie vers la page principale
     */
    @FXML
    private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshStocks();
        for (Posts post : Posts.values()) {
            inputPost.getItems().add(post.toString());
        }

    }


    /**
     * Les fonctions suivantes servent à la gestion des stocks
     */
    @FXML
    private void refreshTable(ActionEvent event) {
        refreshStocks();
    }

    /**
     * Permet d'actualiser le tableau d'ingrédients
     */
    private void refreshStocks() {
        tableIngredients.getItems().clear();
        for (IngredientsDatas data : IngredientsDatas.values()) {
            listIngredient.add(new ingredientItem(data.toString(), data.getStocks(), new TextField()));
        }
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stocks.setCellValueFactory(new PropertyValueFactory<>("stocks"));
        addStocks.setCellValueFactory(new PropertyValueFactory<>("input"));
        tableIngredients.setItems(listIngredient);
    }

    /**
     * Permet de remplir les stocks d'ingrédients avec les quantitées indiquées dans le formulaire
     */
    @FXML
    void remplirStocks(ActionEvent event) {
        for (int i = 0; i < IngredientsDatas.values().length; i++) {

            IngredientsDatas.values()[i].addStocks(
                    Integer.parseInt(tableIngredients.getItems().get(i).getInput().getText())
            );
        }
        refreshStocks();
    }


    /**
     * Les fonctions suivantes servent à la gestion des employés
     * <p>
     * Valider Posts permet de sauvegarder les posts indiqués par l'utilisateur pour chaque employé
     */
    @FXML
    private void validerPosts(ActionEvent event) {
        for (employeeItem employee : tableEmployee.getItems()) {
            listEmploye.get(listEmploye.indexOf(employee.getEmployee())).setPost(employee.getPost().getValue());
        }
        refreshEmployee();
    }

    /**
     * Supprime l'employé selectionné dans le tableau
     */
    @FXML
    private void supprimer(ActionEvent event) {
        listEmploye.remove(tableEmployee.getSelectionModel().getSelectedItem().getEmployee());
        refreshEmployee();

    }

    /**
     * Crée un nouvel employé à partir du formulaire
     */
    @FXML
    private void addEmployee(ActionEvent event) {
        listEmploye.add(new Employe(inputName.getText(), inputFirstName.getText(), inputPost.getValue(), 0));
        inputFirstName.setText("");
        inputName.setText("");
        refreshEmployee();

    }

    /**
     * Actualise le tableau d'employés
     */
    @FXML
    private void refreshEmployee() {
        tableEmployee.getItems().clear();
        for (Employe employe : listEmploye) {
            if(employe.getNbSoirs()<=3)listEmployeeObservable.add(new employeeItem(employe));
        }
        employeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeePost.setCellValueFactory(new PropertyValueFactory<>("post"));
        employeeSoiree.setCellValueFactory(new PropertyValueFactory<>("nbSoirs"));
        tableEmployee.setItems(listEmployeeObservable);

    }

    /**
     * Performances donne les indicateur de performance du restaurant sur la journée en cours
     */
    @FXML
    public void performances(ActionEvent event) {
        hidePanes();
        performancePane.setVisible(true);

        int totalDishes = 0;
        int totalDrinks = 0;
        int totalSales = 0;

        for (Facture facture : factureList) {
            totalDishes += facture.totalDishes();
            totalDrinks += facture.totalDrinks();
            totalSales += facture.getTotal();
        }

        labelDishes.setText(Integer.toString(totalDishes));
        labelDrinks.setText(Integer.toString(totalDrinks));
        labelSales.setText(totalSales + "€");


    }

    /**
     * A l'appui du bouton, imprime une liste de course
     */
    @FXML
    public void generateList(ActionEvent event) {
        ShoppingList.create();
    }


    /**
     * Les fonctions suivantes permettent de naviguer entre les différents panel de la page monitoring
     */
    @FXML
    public void afficherStocks(ActionEvent event) {
        hidePanes();
        refreshStocks();
        stocksPane.setVisible(true);
    }

    @FXML
    public void onEmploye(ActionEvent event) {
        hidePanes();
        employeePane.setVisible(true);
        refreshEmployee();
    }

    private void hidePanes() {
        performancePane.setVisible(false);
        stocksPane.setVisible(false);
        employeePane.setVisible(false);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
