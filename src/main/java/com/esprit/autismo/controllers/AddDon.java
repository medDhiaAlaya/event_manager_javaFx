package com.esprit.autismo.controllers;


import com.esprit.autismo.models.Don;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.utiles.validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class AddDon {





    @FXML
    private TextField tfArgent;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfMessage;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;





    @FXML
    void add_button(ActionEvent event) {
        if (
                validator.isNonEmpty(tfArgent)
                && validator.isValidEmail(tfEmail.getText())
                && validator.isNonEmpty(tfMessage)
                && validator.isNonEmpty(tfNom)
                && validator.isNonEmpty(tfPrenom)) {
            Don d = new Don();
            d.setMethode("Stripe");
            d.setId_event_id(1);
            d.setFirst_name_donor(tfNom.getText());
            d.setLast_name_donor(tfPrenom.getText());
            d.setDonated_money(Integer.parseInt(tfArgent.getText()));
            d.setMsg_donor(tfPrenom.getText());
            d.setEmail_donor(tfEmail.getText());
            d.setMsg_donor(tfMessage.getText());

            try {
                ServiceDon serviceDon = new ServiceDon();
                serviceDon.addDon(d);
                validator.showAlert("Don Added", "The Don has been successfully added.");
            } catch (Exception eu) {
                System.out.println(eu.getMessage());
                validator.showAlert("Don failed", "An error occurred while adding the Don.");
            }
        } else {
            validator.showAlert("Invalid Input", "Please fill in all fields with valid information.");
        }
    }



    @FXML
    void cancel(MouseEvent event) {

    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



    public void displayDons(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DisplayDons.fxml"));
            Parent parent = loader.load();
            DisplayDons displayDons = loader.getController();
            // displayEventsController.setData(data);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load displayEvents.fxml");
        }
    }
}
