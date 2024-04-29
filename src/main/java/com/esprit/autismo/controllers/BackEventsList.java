package com.esprit.autismo.controllers;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BackEventsList implements Initializable {

    @FXML
    private VBox CardLayout;

    @FXML
    private Button ajouterbtn;

    private final ServiceEvent serviceEvent = new ServiceEvent();

    private List<Event> loadEvents;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEvents = new ArrayList<>(loadEvents());

        try {
            for (int i = 0; i < loadEvents.size(); i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/backEventCard.fxml"));
                HBox cardBox = fxmlloader.load();
                BackEventCard eventCard = fxmlloader.getController();
                eventCard.setData(loadEvents().get(i));
                CardLayout.getChildren().add(cardBox);

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Event> loadEvents(){
        List<Event> events = new ArrayList<>(serviceEvent.getAllEvents());
        return events;
    }


    @FXML
    void navigate(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addEvent.fxml"));
            Parent parent = loader.load();
            AddEvent addEvent = loader.getController();
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
