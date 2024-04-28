package com.esprit.autismo.controllers;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EventDisplay {

    @FXML
    private Label descriptionArea;

    @FXML
    private Label endDateLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label startDateLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label typeLabel;
    Long e;

    public void init(long id){
        getEventData(id);

    }

    public void getEventData(long eventId){
        ServiceEvent serviceEvent=new ServiceEvent();
        Event event=serviceEvent.getEventById(eventId);
        System.out.println(event);
        titleLabel.setText(event.getTitle());
        typeLabel.setText(event.getType());
        descriptionArea.setText(event.getDescription());
        Image image = new Image("/imgs/" + event.getBanner());
        imageView.setImage(image);
        startDateLabel.setText(event.getStartDate().toString());
        endDateLabel.setText(event.getEndDate().toString());
        e=event.getId();
    }

    //button function to go to the add don screen
    public void addDon(MouseEvent mouseEvent) {
        System.out.println("--------- hani fi navigate to add  don  function  ---------- ");
        System.out.println(e);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addDon.fxml"));
            Parent root = loader.load();
            // Pass the event ID to the controller of the new screen
            AddDon addDonController = loader.getController();
            addDonController.getEventId(e);
            System.out.println(e);

            // Get the current scene and set the new root
            Scene currentScene = titleLabel.getScene(); // Assuming scene1Button is a node in the current scene
            currentScene.setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void participateButton(MouseEvent mouseEvent) {
    }
}
