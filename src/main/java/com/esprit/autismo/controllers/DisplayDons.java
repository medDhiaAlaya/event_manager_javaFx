package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Don;
import com.esprit.autismo.services.ServiceDon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class DisplayDons {

    @FXML
    private VBox donsVBox;

    @FXML
    public void initialize() {
        displayDons();
    }

    private void displayDons() {
        try {
            ServiceDon serviceDon = new ServiceDon();
            List<Don> dons = serviceDon.getDons();

            for (Don don : dons) {
                HBox donContainer = new HBox();
                donContainer.getStyleClass().add("don-container");

                Label idLabel = new Label("ID: " + don.getId());
                Label firstNameLabel = new Label("First Name: " + don.getFirstNameDonor());
                Label lastNameLabel = new Label("Last Name: " + don.getLastNameDonor());
                Label amountLabel = new Label("Amount Donated: " + don.getDonatedMoney());
                Button deleteButton = new Button("Delete");

                deleteButton.setOnAction(event -> serviceDon.deleteDon(don));

                donContainer.getChildren().addAll(idLabel, firstNameLabel, lastNameLabel, amountLabel, deleteButton);

                donsVBox.getChildren().add(donContainer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
