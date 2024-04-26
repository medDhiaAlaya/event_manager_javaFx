package com.esprit.autismo.services;

import com.esprit.autismo.interfaces.IParticipation;
import com.esprit.autismo.models.Participant;
import com.esprit.autismo.utiles.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceParticipation implements IParticipation <Participant> {
    Connection cnx;
    void serviceParticipation(){
        cnx= MyDataBase.getInstance().getCnx();
    }

    @Override
    public boolean deleteParticipation(Participant p) {
        String qry = "DELETE FROM  WHERE `id`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);

            pstm.setLong(1, p.getId());

            pstm.executeUpdate();
            System.out.println("Child deleted with success");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Shit ! something went wrong");
            return false;
        }

    }


    @Override
    public void addParticipation(Participant participation) {

    }

    @Override
    public ArrayList<Participant> getAllParticippation() {
        return null;
    }

    @Override
    public void getParticipationById(Participant participation) {

    }
}
