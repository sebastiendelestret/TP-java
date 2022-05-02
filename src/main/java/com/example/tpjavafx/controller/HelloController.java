package com.example.tpjavafx.controller;

import com.example.tpjavafx.Objects.Employe;
import com.example.tpjavafx.Objects.Stageable;
import com.example.tpjavafx.Screens.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
import com.example.tpjavafx.Objects.Posts;

import static com.example.tpjavafx.Objects.Util.listEmploye;


public class HelloController implements Stageable {

    @FXML
    private Label labelError;

    private Principal principal = new Principal();

    private Stage stage;

    @FXML
    public void lancerCommande(ActionEvent event) throws IOException {
        int barman = 0, cooker = 0, manager = 0, server = 0;
        Posts[] posts = Posts.values();
        for (Employe employe : listEmploye) {
            switch (employe.getPost()) {
                case "Serveur":
                    server++;
                    break;
                case "Cuisinier":
                    cooker++;
                    break;
                case "Barman":
                    barman++;
                    break;
                case "Manager":
                    manager++;
                    break;
            }
        }
        if (cooker >= 4 && server >= 2 && manager >= 1 && barman >= 1) {
            labelError.setText("");

            stage.setScene(Main.getScenes().get(SceneName.COMMAND).getScene());
        } else {
            labelError.setText("Pas assez de personnel");
            stage.setScene(Main.getScenes().get(SceneName.COMMAND).getScene());


        }
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
