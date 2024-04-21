package com.esprit.autismo.controllers;


import com.esprit.autismo.models.Don;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;
import java.sql.Date;

public class AddDon {

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

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
        Don d =new Don();
        d.setMethode("Stripe");
        d.setId_event_id(1);
        d.setFirst_name_donor(tfNom.getText());
        d.setLast_name_donor(tfPrenom.getText());
        d.setDonated_money(Integer.parseInt(tfArgent.getText()));
        d.setMsg_donor(tfPrenom.getText());
        d.setEmail_donor(tfEmail.getText());

        try{
            ServiceDon serviceDon=new ServiceDon();
            serviceDon.addDon(d);
            showAlert("Don Added", "The Don has been successfully added.");
        }catch (Exception eu){
            System.out.println(eu.getMessage());
            showAlert("Don failed", "famma ghalta owwwww.");

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


}
