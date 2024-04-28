package com.esprit.autismo.controllers;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
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
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EventCard {

    public Button detailsButton;
    @FXML
    private HBox cardEvent;

    @FXML
    private ImageView eventBanner;

    @FXML
    private Label eventTitle;

    @FXML
    private Label eventType;

    @FXML
    private Button Modifierbtn;

    @FXML
    private Button Deletebtn;

    @FXML
    private Label AgeFx;
    private final ServiceEvent sc = new ServiceEvent();
    long eventId;


    public void setData(Event event){
        eventId=event.getId();
        eventTitle.setText(event.getTitle());
        eventType.setText(event.getType());
        Image image = new Image("/imgs/" + event.getBanner());
        eventBanner.setImage(image);
    }

    @FXML
    void detailsButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/eventDisplay.fxml"));
            Parent root = loader.load();
            EventDisplay eventDisplayController = loader.getController();
            eventDisplayController.getEventData(eventId);
            System.out.println("event id in passed by the button details "+eventId);

            // Get the current scene and set the new root
            Scene currentScene = eventType.getScene(); //
            currentScene.setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void OpenDetails(MouseEvent event) {

    }

}