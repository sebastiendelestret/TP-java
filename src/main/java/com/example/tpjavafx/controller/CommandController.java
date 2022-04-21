package com.example.tpjavafx.controller;

import com.example.tpjavafx.Objects.Stageable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import com.example.tpjavafx.Main;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Objects.FxmlInfo;

import java.io.IOException;

public class CommandController implements Stageable {

    private Stage stage;

    @FXML private void retour(ActionEvent event) throws IOException {
        stage.setScene(Main.getScenes().get(SceneName.MAIN).getScene());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
