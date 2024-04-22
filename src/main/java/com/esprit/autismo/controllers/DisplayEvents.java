package com.esprit.autismo.controllers;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.services.ServiceEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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
                Label dateStartLabel = new Label("date debut: " + e.getStart_date());
                Label dateEndLabel = new Label("date fin: " + e.getEnd_date());
                Label descriptionLabel = new Label("Description: " + e.getDescription());
                ImageView bannerImageView = new ImageView();
                bannerImageView.setFitWidth(100);
                bannerImageView.setFitHeight(100);

                try {
                    Image image = new Image("file:///C:/Users/ASUS/Downloads/medium-shot-boy-playing-m.jpg");

                    bannerImageView.setImage(image);
                    bannerImageView.setCache(true);
                    imageKid.setImage(image);
                    imageKid.setCache(true);
                } catch (Exception eu) {
                    eu.printStackTrace();
                }




                // Create delete button
                Button deleteButton = new Button("Delete");
                deleteButton.setOnAction(event -> {
                    serviceEvent.deleteEvent(e);
                });

                eventContainer.getChildren().addAll(
                        titleLabel,
                        typeLabel,
                        dateStartLabel,
                        dateEndLabel,
                        descriptionLabel,
                        bannerImageView,
                        deleteButton
                );
                eventsVBox.getChildren().add(eventContainer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
