package com.example.tpjavafx.Objects;

import com.example.tpjavafx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class FxmlLoad {

    public Scene load(FxmlInfo fxmlInfo) throws IOException {
        if (fxmlInfo.hasScene()){
            return fxmlInfo.getScene();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlInfo.getRessourceName()));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        fxmlInfo.setScene(scene);
        Main.updateScenes(fxmlInfo.getSceneName(), fxmlInfo);

        Stageable controller = fxmlLoader.getController();
        if (controller != null) {
            controller.setStage(fxmlInfo.getStage());
        }

        return scene;

    }
}
