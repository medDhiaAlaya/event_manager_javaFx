package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import com.esprit.autismo.utiles.Navigate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class BackEventCard {

    public Label eventTitle;
    public Label eventType;
    public Label dons;
    public Label participants;
    public HBox cardEvent;

    @FXML
    private ImageView ChildImageFx;

    @FXML
    private Button updateEvent;

    @FXML
    private Button deleteEvent;

    private Event e;

    public void setData(Event event) throws SQLException {
        this.e = event; // Set the Child field to the child object passed as a parameter
        eventTitle.setText(event.getTitle());
        eventType.setText(event.getType());
        ServiceEvent serviceEvent=new ServiceEvent();

        dons.setText(String.valueOf(serviceEvent.getDonsAmountForEvent(event.getId())));
        Image image = new Image("/imgs/" + event.getBanner());
        ChildImageFx.setImage(image);
    }

    @FXML
    void deleteEvent(ActionEvent event) {
        ServiceEvent serviceEvent = new ServiceEvent();
        serviceEvent.deleteEvent(e.getId()); // Call the delete function with the id of the child
        // Reload the page here
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/backEventsList.fxml"));
            Parent root = loader.load();

            // Get the current scene and set the new root
            deleteEvent.getScene().setRoot(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void updateEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/updateEvent.fxml"));
            Parent parent = loader.load();
            UpdateEvent updateEvent = loader.getController();
            updateEvent.setData(e);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}