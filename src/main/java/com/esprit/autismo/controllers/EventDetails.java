package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.services.ServiceEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class EventDetails {
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
                    System.out.println("--------- hani fi butooonnn to add  don  function  ---------- ");

                    navigateToAddDon(eventsVBox,e.getId());
                    System.out.println("--------- hani fi kmmlt to add  don  function  ---------- ");

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

    private void navigateToAddDon(Node s, Long eventId) {
        System.out.println("--------- hani fi navigate to add  don  function  ---------- ");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addDon.fxml"));
            Parent root = loader.load();

            // Pass the event ID to the controller of the new screen
            AddDon addDonController = loader.getController();
            addDonController.getEventId(eventId);
            System.out.println(eventId);

            // Get the current scene and set the new root
            Scene currentScene = s.getScene(); // Assuming scene1Button is a node in the current scene
            currentScene.setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addDon(MouseEvent mouseEvent) {
    }

    public void participateButton(MouseEvent mouseEvent) {

    }
}
