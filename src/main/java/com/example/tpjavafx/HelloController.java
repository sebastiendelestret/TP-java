package com.example.tpjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloController {
    @FXML private Button Commande;
    @FXML private Button Cuisine;
    @FXML private Button Bar;
    @FXML private Button Monitoring;

    @FXML private Button Retour;

    @FXML private MenuBar menu;

    @FXML private AnchorPane rootPane;

    public void close(ActionEvent event) {
        System.exit(-1);
    }

    public void lancerCommande(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commande-view.fxml")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rootPane.getChildren().setAll(pane);

        System.out.println("fenetre commande ouverte");
    }

    public void lancerCuisine(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cuisine-view.fxml")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rootPane.getChildren().setAll(pane);

        System.out.println("fenetre cuisine ouverte");
    }

    public void lancerBar(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bar-view.fxml")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rootPane.getChildren().setAll(pane);

        System.out.println("fenetre bar ouverte");
    }

    public void lancerMonitoring(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("monitoring-view.fxml")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rootPane.getChildren().setAll(pane);

        System.out.println("fenetre monitoring ouverte");
    }

    public void retour(ActionEvent event) {

    }
}
