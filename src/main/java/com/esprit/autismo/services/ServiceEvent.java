package com.esprit.autismo.services;
import com.esprit.autismo.interfaces.IEvent;
import com.esprit.autismo.models.Don;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.utiles.MyDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceEvent implements IEvent<Event> {
    private Connection cnx;
    public ServiceEvent(){
        cnx= MyDataBase.getInstance().getCnx();

    }
    @Override
    public void addEvent(Event event) {
        String query = "INSERT INTO event (title, start_date, end_date, type, description, banner) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, event.getTitle());
            statement.setDate(2, new java.sql.Date(event.getStartDate().getTime()));
            statement.setDate(3, new java.sql.Date(event.getEndDate().getTime()));
            statement.setString(4, event.getType());
            statement.setString(5, event.getDescription());
            statement.setString(6, event.getBanner());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> getAllEvents() {
        System.out.println("get all events ");
        ArrayList<Event> events = new ArrayList<>();
        String qry ="SELECT * FROM `event`";
        try {
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Event e = new Event();
                e.setId(rs.getLong("id"));
                e.setTitle(rs.getString("title"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                e.setStartDate(rs.getDate("start_date"));
                e.setEndDate(rs.getDate("end_date"));
                e.setBanner(rs.getString("banner"));
                List<Don> dons=getDonForEvent(e.getId());
                e.setDons(dons);
                //e.setGalerie(Arrays.asList((String[]) rs.getArray("gallery").getArray()));
                //e.setBanner(rs.getString("dons"));
                events.add(e);
            }
            System.out.println(events);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return events;

    }
    private List<Don> getDonForEvent(long eventId) throws SQLException {
        List<Don> dons = new ArrayList<>();
        String qry = "SELECT * FROM don WHERE id_event_id = ?";
        try (
                PreparedStatement pstm = cnx.prepareStatement(qry))
        {
            pstm.setLong(1, eventId);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Don d = new Don();
                    d.setId(rs.getLong("id"));
                    d.setMsgDonor(rs.getString("msg_donor"));
                    //d.setPost_id(rs.getInt("post_id"));
                    dons.add(d);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e; // Rethrow the exception to handle it in the caller
        }
        return dons;
    }
    public double getDonsAmountForEvent(long eventId) throws SQLException {
        double sum = 0;
        String qry = "SELECT donated_money FROM don WHERE id_event_id = ?";
        try (PreparedStatement pstm = cnx.prepareStatement(qry)) {
            pstm.setLong(1, eventId);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    double donatedMoney = rs.getDouble("donated_money");
                    sum += donatedMoney;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e; // Rethrow the exception to handle it in the caller
        }
        return sum;
    }







    @Override
    public void deleteEvent(long eventId) {
        String query = "DELETE FROM event WHERE id=?";
        // Delete associated donations


        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setLong(1, eventId);
            ServiceDon serviceDon= new ServiceDon();
            List<Don> dons=getEventById(eventId).getDons();
            for (Don d:dons) {
                serviceDon.deleteDon(d);
            }


            statement.executeUpdate();
            System.out.println("event deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Event event) {
        String query = "UPDATE event SET title=?, start_date=?, end_date=?, type=?, description=?, banner=? WHERE id=?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, event.getTitle());
            statement.setDate(2, new java.sql.Date(event.getStartDate().getTime()));
            statement.setDate(3, new java.sql.Date(event.getEndDate().getTime()));
            statement.setString(4, event.getType());
            statement.setString(5, event.getDescription());
            statement.setString(6, event.getBanner());
            statement.setLong(7, event.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event getEventById(long eventId) {
        Event event = null;
        String query = "SELECT * FROM event WHERE id=?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setLong(1, eventId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    event = new Event();
                    System.out.println("hello");
                    event.setId(resultSet.getLong("id"));
                    event.setTitle(resultSet.getString("title"));
                    event.setStartDate(resultSet.getDate("start_date"));
                    event.setEndDate(resultSet.getDate("end_date"));
                    event.setType(resultSet.getString("type"));
                    event.setDescription(resultSet.getString("description"));
                    event.setBanner(resultSet.getString("banner"));
                    List<Don> dons=getDonForEvent(event.getId());
                    event.setDons(dons);
                    System.out.println(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }








}
