package com.example.tpjavafx.controller;

import com.example.tpjavafx.Datas.DishesDatas;
import com.example.tpjavafx.Datas.DrinksDatas;
import com.example.tpjavafx.Datas.IngredientsDatas;
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

import com.example.tpjavafx.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.tpjavafx.Objects.Util.allServedDrinks;
import static com.example.tpjavafx.Objects.Util.allServedDishes;
import static com.example.tpjavafx.Objects.Util.listEmploye;

public class MonitoringController implements Stageable, Initializable, Tools {

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


    @FXML
    private TableView<ingredientItem> tableIngredients;
    @FXML
    private TableColumn<ingredientItem, String> name;
    @FXML
    private TableColumn<ingredientItem, Integer> stocks;
    @FXML
    private TableColumn<ingredientItem, TextField> addStocks;

    @FXML
    private TableView<employeeItem> tableEmployee;
    @FXML
    private TableColumn<employeeItem, String> employeeName;
    @FXML
    private TableColumn<employeeItem, String> employeeFirstName;
    @FXML
    private TableColumn<employeeItem, String> employeePost;

    public ObservableList<ingredientItem> listIngredient = FXCollections.observableArrayList();

    public ObservableList<employeeItem> listEmployeeObservable = FXCollections.observableArrayList();

    @FXML
    private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @FXML
    private void refreshTable(ActionEvent event) {
        refresh();
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh();
        for(Posts post:Posts.values()){
            inputPost.getItems().add(post.toString());
        }

    }

    private void refresh() {
        tableIngredients.getItems().clear();
        for (IngredientsDatas data : IngredientsDatas.values()) {
            listIngredient.add(new ingredientItem(data.toString(), data.getStocks(), new TextField()));
        }
        name.setCellValueFactory(new PropertyValueFactory<ingredientItem, String>("name"));
        stocks.setCellValueFactory(new PropertyValueFactory<ingredientItem, Integer>("stocks"));
        addStocks.setCellValueFactory(new PropertyValueFactory<ingredientItem, TextField>("input"));
        tableIngredients.setItems(listIngredient);
    }

    @FXML
    private void refreshEmployee() {
        tableEmployee.getItems().clear();
        for (Employe employe : listEmploye) {
            System.out.println(employe.getName());

            listEmployeeObservable.add(new employeeItem(employe.getName(), employe.getFirstname(), employe.getPost()));
        }
        employeeName.setCellValueFactory(new PropertyValueFactory<employeeItem, String>("name"));
        employeeFirstName.setCellValueFactory(new PropertyValueFactory<employeeItem, String>("firstName"));
        employeePost.setCellValueFactory(new PropertyValueFactory<employeeItem, String>("post"));
        tableEmployee.setItems(listEmployeeObservable);
    }

    @FXML private void addEmployee(ActionEvent event){
        listEmploye.add(new Employe(inputName.getText(), inputFirstName.getText(), inputPost.getValue()));
        inputFirstName.setText("");inputName.setText("");
        refreshEmployee();

    }

    @FXML
    public void performances(ActionEvent event) {
        hidePanes();
        performancePane.setVisible(true);

        int totalDishes = 0;
        int totalDrinks = 0;
        int totalSales = 0;

        for (DishesDatas data : allServedDishes) {
            totalDishes++;
            totalSales += data.getPrice();
        }
        for (DrinksDatas data : allServedDrinks) {
            totalDrinks++;
            totalSales += data.getPrice();
        }

        labelDishes.setText(Integer.toString(totalDishes));
        labelDrinks.setText(Integer.toString(totalDrinks));
        labelSales.setText(Integer.toString(totalSales) + "€");


    }

    @FXML
    void remplirStocks(ActionEvent event) {
        for (int i = 0; i < IngredientsDatas.values().length; i++) {

            IngredientsDatas.values()[i].addStocks(
                    Integer.parseInt(tableIngredients.getItems().get(i).getInput().getText())
            );
        }
        refresh();
    }

    @FXML
    public void afficherStocks(ActionEvent event) {
        hidePanes();
        stocksPane.setVisible(true);
    }


    @FXML
    public void generateList(ActionEvent event) {
    }

    private void hidePanes() {
        performancePane.setVisible(false);
        stocksPane.setVisible(false);
        employeePane.setVisible(false);
    }


    @FXML
    public void onEmploye(ActionEvent event) {
        hidePanes();
        employeePane.setVisible(true);
        refreshEmployee();
    }
}
