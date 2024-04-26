package com.esprit.autismo.controllers;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.services.ServiceEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DisplayEvents {

    public ImageView imageKid;
    @FXML
    private VBox eventsVBox;

    @FXML
    public void initialize() {
        displayEvents();
    }

    private void displayEvents() {
        try {
            ServiceEvent serviceEvent = new ServiceEvent();
            ServiceDon serviceDon = new ServiceDon();

            List<Event> events = serviceEvent.getAllEvents();

            for (Event e : events) {
                VBox eventContainer = new VBox();
                eventContainer.getStyleClass().add("don-container");
                Label titleLabel = new Label("Title: " + e.getTitle());
                Label typeLabel = new Label("Type: " + e.getType());
                Label dateStartLabel = new Label("date debut: " + e.getStartDate());
                Label dateEndLabel = new Label("date fin: " + e.getEndDate());
                Label descriptionLabel = new Label("Description: " + e.getDescription());
                ImageView bannerImageView = new ImageView();
                bannerImageView.setFitWidth(100);
                bannerImageView.setFitHeight(100);
                try {

                    //Image image = new Image("imgs/kid.png");
                    Image image = new Image("imgs/"+e.getBanner());

                    bannerImageView.setImage(image);
                    bannerImageView.setCache(true);
                } catch (Exception eu) {
                    eu.printStackTrace();
                }




                // Create delete button
                Button deleteButton = new Button("Delete");
                deleteButton.setOnAction(event -> {
                    serviceEvent.deleteEvent(e.getId());
                });

                Button viewButton = new Button("add Don");
                viewButton.setOnAction(event -> {
                    navigateToAddDon(e.getId());
                });


                // ajouter don button
                eventContainer.getChildren().addAll(
                        titleLabel,
                        typeLabel,
                        dateStartLabel,
                        dateEndLabel,
                        descriptionLabel,
                        bannerImageView,
                        deleteButton,
                        viewButton
                );
                eventsVBox.getChildren().add(eventContainer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateToAddDon(Long eventId) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addDon.fxml"));
            Parent root = loader.load();

            // Pass the event ID to the controller of the new screen
            AddDon addDonController = loader.getController();
            addDonController.getEventId(eventId);
            System.out.println(eventId);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
