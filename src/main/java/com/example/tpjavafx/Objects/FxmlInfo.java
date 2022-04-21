package com.example.tpjavafx.Objects;


import com.example.tpjavafx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.example.tpjavafx.Objects.SceneName;

import java.io.IOException;

public class FxmlInfo {

    private String ressourceName;
    private SceneName sceneName;
    private Stage stage;
    private Scene scene;

    public FxmlInfo(String ressourceName, SceneName sceneName, Stage stage){
        this.ressourceName = ressourceName;
        this.sceneName = sceneName;
        this.stage = stage;
    }

    public String getRessourceName() {
        return ressourceName;
    }

    public SceneName getSceneName() {
        return sceneName;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() throws IOException {
        if (scene == null) {
            scene = new FxmlLoad().load(this);
        }
        return scene;
    }

    public boolean hasScene(){
        return scene != null;
    }

    public Stage getStage() {
        return stage;
    }
}
