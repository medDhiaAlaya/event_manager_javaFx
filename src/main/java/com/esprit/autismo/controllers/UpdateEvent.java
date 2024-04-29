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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

public class UpdateEvent {

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

    Event e ;

    @FXML
    void add_button(ActionEvent event) {
        // remplir les field avec les ancient valeurs

        e.setTitle(tfTitle.getText());
        e.setDescription(tfDescription.getText());
        e.setType(tfType.getText());
        Date startDate = Date.valueOf(tfDateToStart.getValue());
        e.setStartDate(startDate);
        Date endDate = Date.valueOf(tfDateToEnd.getValue());
        e.setEndDate(endDate);
        try{
            ServiceEvent serviceEvent=new ServiceEvent();
            serviceEvent.updateEvent(e);
            showAlert("Event Updated", "The event has been successfully added.");


        }catch (Exception eu){
            System.out.println(eu.getMessage());
            showAlert("Event Updated", "famma ghalta owwwww.");

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
            e.setBanner(selectedFile.getName());
// Define the path to the target directory
            String targetFolderPath = "C:/Users/ASUS/Desktop/3 A MDA/javafx/autismo/src/main/resources/imgs";
            File targetFolder = new File(targetFolderPath);
            File newFile = new File(targetFolder, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            //image_view.setImage(image);
            //image_view.setFitWidth(200);
            //image_view.setFitHeight(200);
        }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/backendEventsList.fxml"));
            Parent parent = loader.load();
            ListEvent displayEventsController = loader.getController();
            // displayEventsController.setData(data);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            //stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load displayEvents.fxml");
        }


    }


    public void setData(Event event) {
        this.e=event;
        tfTitle.setText(e.getTitle());
        tfDescription.setText(e.getDescription());
        tfType.setText(e.getType());

    }
}
