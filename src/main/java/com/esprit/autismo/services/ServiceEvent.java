package com.esprit.autismo.services;
import com.esprit.autismo.interfaces.IEvent;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.utiles.MyDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;




public class ServiceEvent implements IEvent<Event> {
    private Connection cnx;
    public ServiceEvent(){
        cnx= MyDataBase.getInstance().getCnx();

    }
    @Override
    public void addEvent(Event event) {
        String qry="INSERT INTO `event`(`title`, `start_date`, `end_date`, `type`, `description`, `banner`) VALUES (?,?,?,?,?,?)";
        try{

            PreparedStatement pstm=cnx.prepareStatement(qry);
            System.out.println("tw bech nzid title");
            pstm.setString(1,event.getTitle());
            System.out.println("tw bech nzid date");
            pstm.setObject(2,event.getStart_date());
            System.out.println("tw bech nzid date end");
            pstm.setObject(3,event.getEnd_date());
            System.out.println("tw bech nzid 4");
            pstm.setString(4,event.getType());
            System.out.println("tw bech nzid 5");
            pstm.setString(5,event.getDescription());
            System.out.println("tw bech nzid 6");
            pstm.setString(6,event.getBanner());
            System.out.println("tw bech nzid 7 ");
            System.out.println("event added");
            //pstm.setArray(7, cnx.createArrayOf("VARCHAR", event.getGalerie().toArray()));

            pstm.executeUpdate();

        }catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }


    }

    @Override
    public ArrayList<Event> getAllEvents() {
        System.out.println("get all events 1");
        ArrayList<Event> events = new ArrayList<>();
        String qry ="SELECT * FROM `event`";
        try {
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Event e = new Event();
                e.setTitle(rs.getString("title"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                e.setStart_date(rs.getDate("start_date"));
                e.setEnd_date(rs.getDate("end_date"));
                e.setBanner(rs.getString("banner"));
                e.setGalerie(Arrays.asList((String[]) rs.getArray("gallery").getArray()));
                //e.setBanner(rs.getString("dons"));
                events.add(e);
            }
            System.out.println(events);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return events;

    }

    @Override
    public void deleteEvent(Event event) {

        String reqD="DELETE FROM `event` WHERE `id`=?";
        try{

            PreparedStatement pstm=cnx.prepareStatement(reqD);


            pstm.setInt(1,event.getId());
            int rows=pstm.executeUpdate();
            if(rows>0){
                System.out.println("le rendezVous selectioné a été supprimé avec succés");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void updateEvent(Event event) {
        String req="UPDATE `event` SET `title`=?,`start_date`=?,`end_date`=?,`type`=?,`description`=?,`banner`=?,`gallery`=? WHERE `id` = ?";
        try {
            PreparedStatement pstm=cnx.prepareStatement(req);

            pstm.setString(1,event.getTitle());
            pstm.setObject(2,event.getStart_date()); // Convert util.Date to sql.Date
            pstm.setObject(3,event.getEnd_date());   // Convert util.Date to sql.Date
            pstm.setString(4,event.getType());
            pstm.setString(5,event.getDescription());
            pstm.setString(6,event.getBanner());
            pstm.setArray(7, (Array) event.getGalerie());
            pstm.setInt(8, event.getId());


            pstm.executeUpdate();
            System.out.println("event updated :" + event);



        }catch (SQLException e){
            System.out.println(e.getMessage());
}
    }

    @Override
    public Event findEvent(int id) {
        Event event = null;

        try {
            String select = "SELECT * FROM event WHERE  id = '" + id + "' ";
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(select);

            if (result.next()) {
                event = new Event();
                event.setId(id);
                event.setTitle(result.getString("title"));
                event.setStart_date(result.getDate("start_date"));
                event.setEnd_date(result.getDate("end_date"));
                event.setDescription(result.getString("description"));
                event.setType(result.getString("type"));
                event.setBanner(result.getString("banner"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return event;
    }









}
