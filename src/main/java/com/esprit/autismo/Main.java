package com.esprit.autismo;

import com.esprit.autismo.models.Don;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.services.ServiceDon;
import com.esprit.autismo.services.ServiceEvent;
import com.esprit.autismo.utiles.MyDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
public class Main  {

 /*
 public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/addEvent.fxml")));

        Scene scene =new Scene(parent);

        stage.setTitle("afficher RendezVous");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }


}
*/

public static void main(String[] args){

    // Creating a list of gallery images
    List<String> galleryImages = new ArrayList<>();
    galleryImages.add("image1.jpg");
    galleryImages.add("image2.jpg");
    galleryImages.add("image3.jpg");
    //Event e= new Event(1,"java event","descriptoon java", new Date());
    ServiceDon sc= new ServiceDon();
    ServiceEvent eventsService=new ServiceEvent();
    System.out.println("la liste de dons : ---------------------");
    sc.getDons();
    System.out.println(" la liste de tous le events ----------");
    eventsService.getAllEvents();
    System.out.println("get event by id");
    Event t=eventsService.getEventById(1);
    System.out.println("deleting event --------");
    //eventsService.deleteEvent(1);
    System.out.println("add event");
    Event eventToAdd = new Event();
    eventToAdd.setTitle("Test Event");
    eventToAdd.setStartDate(new Date());
    eventToAdd.setEndDate(new Date());
    eventToAdd.setType("Test Type");
    eventToAdd.setDescription("This is a test event");
    eventToAdd.setBanner("test_banner.jpg");
    //eventsService.addEvent(eventToAdd);

    System.out.println("code de update event");
    Event updatedEvent = new Event();
    updatedEvent.setId(4L);
    updatedEvent.setTitle("Updated Event Title");
    updatedEvent.setStartDate(new Date()); // Set start date to current date
    updatedEvent.setEndDate(new Date()); // Set end date to current date
    updatedEvent.setType("Updated Type");
    updatedEvent.setDescription("This is an updated event description");
    updatedEvent.setBanner("updated_banner.jpg");

    // Call the updateEvent method to update the event in the database
    eventsService.updateEvent(updatedEvent);

    System.out.println("testing add don -------------------------------------------");
    // Create a new Don object to add
    Don donToAdd = new Don();
    // Assuming you have set all necessary attributes of the Don object

    donToAdd.setIdEvent(Math.toIntExact(t.getId()));
    donToAdd.setFirstNameDonor("John");
    donToAdd.setLastNameDonor("Doe");
    donToAdd.setEmailDonor("john.doe@example.com");
    donToAdd.setMsgDonor("This is a test donation");
    donToAdd.setMethode("Credit Card");
    donToAdd.setDonatedMoney(100.0); // Assuming the donated amount is 100.0

    // Call the addDon method to add the donation to the database
    sc.addDon(donToAdd);






}
}

/*
import com.esprit.autismo.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import org.opencv.core.Core;

public class Main extends Application {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load the FXML file
        Parent root = loader.load();

        // Set up the stage
        primaryStage.setTitle("Image to 3D");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        // Get the controller
        Controller controller = loader.getController();

        // Initialize the 3D content
        controller.initialize3DContent();
    }

    public static void main(String[] args) {
        launch(args);
    }
} */
