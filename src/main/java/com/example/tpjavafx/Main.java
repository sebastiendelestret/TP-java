package com.example.tpjavafx;

import Objects.Register;
import Screens.Principal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Principal screenMenu;

    public static void main(String[] args){
        launch();

        Register fileRegister = new Register();

        screenMenu = new Principal();
        screenMenu.update();

        fileRegister.registerIngredientsStocks();
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),520,440);
        stage.setTitle("Menu Ecrans");
        stage.setScene(scene);
        stage.show();
    }
}
