package com.esprit.autismo.utiles;

import com.esprit.autismo.controllers.AddEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigate {

    public void switchScene(String fxmlFileToGo , Object controller) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+fxmlFileToGo));
            Parent parent = loader.load();
            controller = loader.getController();
            // displayEventsController.setData(data);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
