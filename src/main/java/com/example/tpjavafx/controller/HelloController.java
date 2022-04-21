package com.example.tpjavafx.controller;

import com.example.tpjavafx.Objects.Stageable;
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

import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Objects.Stageable;


public class HelloController implements Stageable {


    private Stage stage;

    @FXML
    public void close(ActionEvent event) {
        System.exit(-1);
    }

    @FXML
    public void lancerCommande(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.COMMAND).getScene());
    }

    @FXML
    public void lancerCuisine(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.CUISINE).getScene());


    }

    @FXML
    public void lancerBar(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.BAR).getScene());

    }

    @FXML
    public void lancerMonitoring(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MONITORING).getScene());

    }


    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
