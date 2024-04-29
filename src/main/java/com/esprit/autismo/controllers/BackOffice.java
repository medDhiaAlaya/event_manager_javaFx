package com.esprit.autismo.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class BackOffice {

    public AnchorPane currentScreen;
    @FXML
    private Button Children;

    @FXML
    private Button Dashboard;

    @FXML
    private Button Event;

    @FXML
    private Button Logout;

    @FXML
    private VBox Menu;

    @FXML
    private Button Notifications;

    @FXML
    private Button Profile;

    @FXML
    private Button Settings;

    @FXML
    private ImageView UserImage;

    @FXML
    private Label UserName;

    @FXML
    void Logout(ActionEvent event) {

    }

    @FXML
    void OpenUserPanel(MouseEvent event) {
        // Check if the Menu is currently visible
        if (Menu.isVisible()) {
            // If it is visible, hide it
            Menu.setVisible(false);
        } else {
            // If it is not visible, show it
            Menu.setVisible(true);
        }

    }

    @FXML
    void ToChildren(ActionEvent event) {

    }

    @FXML
    void ToDashboard(ActionEvent event) {

    }

    @FXML
    void ToEvents(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/backEventsList.fxml"));
            AnchorPane eventScreen = fxmlLoader.load();

            Event.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d0d99; -fx-font-family: 'Roboto';");



            // Get the controller of the loaded FXML (if needed)
            // EventController eventController = fxmlLoader.getController();

            // Replace the current screen with the loaded event screen
            currentScreen.getChildren().setAll(eventScreen);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }

    @FXML
    void ToNotifications(ActionEvent event) {

    }

    @FXML
    void ToProfile(ActionEvent event) {

    }

    @FXML
    void ToSettings(ActionEvent event) {

    }

}