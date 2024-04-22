package com.esprit.autismo.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Home extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //FXMLLoader fxml=new FXMLLoader(getClass().getResource("/addEvent.fxml"));
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/addDon.fxml"));

        try {

            Parent fxmlLoader=fxml.load();
            Scene scene=new Scene(fxmlLoader);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
