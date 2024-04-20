package com.esprit.autismo.services;

import com.esprit.autismo.interfaces.IDon;
import com.esprit.autismo.models.Don;
import com.esprit.autismo.models.Event;
import com.esprit.autismo.utiles.MyDataBase;

import java.sql.*;
import java.util.ArrayList;

public class ServiceDon implements IDon<Don> {
    Connection cnx;

    public ServiceDon(){
        cnx= MyDataBase.getInstance().getCnx();

    }
    public ArrayList<Don> getDons() {
        System.out.println("get all dons 1");
        ArrayList<Don> dons = new ArrayList<>();
        String qry ="SELECT * FROM `don`";
        try {
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Don d = new Don();
                d.setId(rs.getInt("id"));
                d.setId_event_id(rs.getInt("id_event_id"));
                d.setFirst_name_donor(rs.getString("first_name_donor"));
                d.setLast_name_donor(rs.getString("last_name_donor"));
                d.setEmail_donor(rs.getString("email_donor"));
                d.setMsg_donor(rs.getString("msg_donor"));
                d.setMethode(rs.getString("methode"));
                d.setDonated_money(rs.getInt("donated_money"));

                //e.setBanner(rs.getString("banner"));
                //e.setGalerie((List<String>) rs.getArray("gallery"));
                dons.add(d);
            }
            System.out.println(dons);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return dons;

    }


    @Override
    public void addDon(Don don) {
        String qry="INSERT INTO `don`(`id`, `id_event_id`, `first_name_donor`, `last_name_donor`, `email_donor`, `msg_donor`, `methode`, `donated_money`) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=cnx.prepareStatement(qry);
            pstm.setInt(1,don.getId());
            pstm.setInt(2,don.getId_event_id());
            pstm.setString(3, don.getFirst_name_donor());
            pstm.setString(4,don.getLast_name_donor());
            pstm.setString(5,don.getEmail_donor());
            pstm.setString(6,don.getMsg_donor());
            pstm.setString(7,don.getMethode());
            pstm.setInt(8,don.getDonated_money());


            pstm.executeUpdate();
            System.out.println("don added ..");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteDon(Don don) {
        String reqD="DELETE FROM `don` WHERE `id`=?";
        try{

            PreparedStatement pstm=cnx.prepareStatement(reqD);


            pstm.setInt(1,don.getId());
            int rows=pstm.executeUpdate();
            if(rows>0){
                System.out.println("le don selectioné a été supprimé avec succés");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void updateDon(Don don) {

    }


}
