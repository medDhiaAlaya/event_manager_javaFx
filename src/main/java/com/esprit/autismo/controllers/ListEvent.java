package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListEvent implements Initializable {

    @FXML
    private GridPane CardLayout;

    @FXML
    private Button ajouterbtn;

    private final ServiceEvent serviceEvent = new ServiceEvent();

    private List<Event> loadEvents;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEvents = new ArrayList<>(loadEvents());
        int column = 0;
        int row = 1;

        try {
            for (Event loadEvent : loadEvents) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/eventCard.fxml"));
                HBox cardBox = fxmlloader.load();
                EventCard childCard = fxmlloader.getController();
                childCard.setData(loadEvent);
                if (column == 3) {
                    column = 0;
                    ++row;
                }
                //CardLayout.getChildren().add(cardBox);
                CardLayout.add(cardBox, column++, row);
                GridPane.setMargin(cardBox, new Insets(10));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Event> loadEvents(){
        return new ArrayList<>(serviceEvent.getAllEvents());
    }


    @FXML
    void navigate(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/addEvent.fxml"));
        try {
            Parent fxmlLoader = loader.load();
            ajouterbtn.getScene().setRoot(fxmlLoader);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}