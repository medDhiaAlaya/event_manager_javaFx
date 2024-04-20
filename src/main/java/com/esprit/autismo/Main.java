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
    Don d=new Don(3,1,"samir","alaya","samir@gmail.com","hello","paypal",50);
    ServiceDon sc= new ServiceDon();
    sc.addDon(d);
    ServiceEvent eventsService=new ServiceEvent();
    System.out.println("la liste de dons : ---------------------");
    sc.getDons();
    Event myEvent=new Event(2,"brabbi ekhedmi","helloooo",new Date(),new Date(),"gaming","tesira",galleryImages);
    eventsService.addEvent(myEvent);
    System.out.println(" la liste de tous le events ----------");
    eventsService.getAllEvents();




}
}