package com.example.tpjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController {

    @FXML
    Label welcomeText;

    @FXML public void onHelloButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("SUCE MA BITE");
    }
}
