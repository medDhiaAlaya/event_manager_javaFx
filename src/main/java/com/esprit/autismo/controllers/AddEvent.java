package com.esprit.autismo.controllers;

import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceEvent;
import com.google.protobuf.Empty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class AddEvent {

    @FXML
    private DatePicker tfDateToEnd;

    @FXML
    private DatePicker tfDateToStart;

    @FXML
    private Text imagePathText;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfType;

    Event e = new Event();

    @FXML
    void add_button(ActionEvent event) {
        e.setTitle(tfTitle.getText());
        e.setDescription(tfDescription.getText());
        e.setType(tfType.getText());

        Date startDate = Date.valueOf(tfDateToStart.getValue());
        e.setStart_date(startDate);
        Date endDate = Date.valueOf(tfDateToEnd.getValue());
        e.setEnd_date(endDate);

        try{
            ServiceEvent serviceEvent=new ServiceEvent();
            serviceEvent.addEvent(e);
            showAlert("Event Added", "The event has been successfully added.");
        }catch (Exception eu){
            System.out.println(eu.getMessage());
            showAlert("Event failed", "famma ghalta owwwww.");

        }
    }
    @FXML
    void upload_image_button(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Image");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagePathText.setText(selectedFile.getAbsolutePath());
            e.setBanner(selectedFile.getPath());
            //image_view.setImage(image);
            //image_view.setFitWidth(200);
            //image_view.setFitHeight(200);
        }
        System.out.println(selectedFile.toURI().toString());
        System.out.println(selectedFile.getPath());
        System.out.println(selectedFile.getName());



    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    public void goToDisplay(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displayEvents.fxml"));
            Parent parent = loader.load();
            DisplayEvents displayEventsController = loader.getController();
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
