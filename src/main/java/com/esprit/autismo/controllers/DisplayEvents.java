package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DisplayEvents implements Initializable {


    @FXML
    private VBox cardContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceEvent serviceEvent = new ServiceEvent();
        List<Event> events = serviceEvent.getAllEvents();

        // Create and add cards for each event
        for (Event event : events) {
            // Create a card node for the event
            HBox card = createEventCard(event);
            // Add the card to the VBox
            cardContainer.getChildren().add(card);
        }
    }
    // Method to create a card for an event
    private HBox createEventCard(Event event) {
        // Create a layout for the card
        HBox card = new HBox();
        card.getStyleClass().add("event-card"); // Add CSS class for styling

        // Add labels to represent event details
        Label titleLabel = new Label("Title: " + event.getTitle());
        Label descriptionLabel = new Label("Description: " + event.getDescription());
        Label typeLabel = new Label("Type: " + event.getType());
        // Add other labels as needed

        // Add the UI elements to the card
        card.getChildren().addAll(titleLabel, descriptionLabel, typeLabel /* Add other UI elements here */);

        return card;
    }


}
