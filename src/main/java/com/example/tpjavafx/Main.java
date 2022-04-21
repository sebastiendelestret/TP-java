package com.example.tpjavafx;

import com.example.tpjavafx.Objects.Register;
import com.example.tpjavafx.Objects.SceneName;
import com.example.tpjavafx.Screens.Principal;
import com.example.tpjavafx.Objects.FxmlInfo;
import com.example.tpjavafx.Objects.SceneName;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Principal screenMenu;

    private static final String mainFXML = "hello-view.fxml";
    private static final String commandFXML = "commande-view.fxml";
    private static final String barFXML = "bar-view.fxml";
    private static final String cuisineFXML = "cuisine-view.fxml";
    private static final String monitoringFXML = "monitoring-view.fxml";

    private static Map<SceneName, FxmlInfo> scenes = new HashMap<>();

    public static void main(String[] args){

        Register fileRegister = new Register();

        launch();

        fileRegister.registerIngredientsStocks();
    }


    @Override
    public void start(Stage stage) throws IOException {

        scenes.put(SceneName.MAIN, new FxmlInfo(mainFXML, SceneName.MAIN, stage));
        scenes.put(SceneName.COMMAND, new FxmlInfo(commandFXML, SceneName.COMMAND, stage));
        scenes.put(SceneName.BAR, new FxmlInfo(barFXML, SceneName.BAR, stage));
        scenes.put(SceneName.CUISINE, new FxmlInfo(cuisineFXML, SceneName.CUISINE, stage));
        scenes.put(SceneName.MONITORING, new FxmlInfo(monitoringFXML, SceneName.MONITORING, stage));

        stage.setTitle("Menu Ecrans");
        stage.setScene(scenes.get(SceneName.MAIN).getScene());
        stage.show();
    }

    public static Map<SceneName, FxmlInfo> getScenes() {
        return scenes;
    }

    public static void updateScenes(SceneName name, FxmlInfo info) {
        scenes.put(name, info);
    }
}
