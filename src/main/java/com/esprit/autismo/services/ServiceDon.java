package com.esprit.autismo.services;

import com.esprit.autismo.interfaces.IDon;
import com.esprit.autismo.models.Don;
import com.esprit.autismo.utiles.MyDataBase;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

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
                d.setId((long) rs.getInt("id"));
                //d.setIdEvent(rs.getObject("id_event_id"));
                d.setFirstNameDonor(rs.getString("first_name_donor"));
                d.setLastNameDonor(rs.getString("last_name_donor"));
                d.setEmailDonor(rs.getString("email_donor"));
                d.setMsgDonor(rs.getString("msg_donor"));
                d.setMethode(rs.getString("methode"));
                d.setDonatedMoney((double) rs.getInt("donated_money"));

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
        String qry="INSERT INTO `don`(`id_event_id`, `first_name_donor`, `last_name_donor`, `email_donor`, `msg_donor`, `methode`, `donated_money`) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=cnx.prepareStatement(qry);
            //pstm.setLong(1,don.getId());
            pstm.setInt(1,don.getIdEvent());
            pstm.setString(2, don.getFirstNameDonor());
            pstm.setString(3,don.getLastNameDonor());
            pstm.setString(4,don.getEmailDonor());
            pstm.setString(5,don.getMsgDonor());
            pstm.setString(6,don.getMethode());
            pstm.setDouble(7,don.getDonatedMoney());
            payDon(don.getEmailDonor(), don.getDonatedMoney());
            pstm.executeUpdate();
            System.out.println("don added ..");
            System.out.println("don has payed ..");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void payDon(String email, Double amount){
        Stripe.apiKey = "sk_test_51OnP9pAm1UzJ6YWEtGsUvZSGeU6toq2ErDia642D5uDU86SJa1toNgmXc42RU7X2imwvuLhgX6wxveFT0DmmJOM3005g638v9i";
        try {
            // Retrieve your account information
            Account account = Account.retrieve();
            System.out.println("Account ID: " + account.getId());
            // Print other account information as needed
        } catch (StripeException e) {
            System.out.println("Error retrieving account information: " + e.getMessage());
            return; // Exit the program if account retrieval fails
        }
        try {
            // Create a PaymentIntent with payment details
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(amount.longValue()) // Amount in cents (e.g., $7.77)
                    .setCurrency("usd")
                    .setCustomer(email)
                    .setReceiptEmail(email)
                    .setPaymentMethod("pm_card_visa") // Test Visa card payment method
                    .setConfirm(true) // Set confirm to true
                    .setReturnUrl("https://www.google.com")
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);

            // If the payment requires action, handle it
            if (intent.getStatus().equals("requires_action")) {
                System.out.println("Payment requires authentication: " + intent.getClientSecret());
            } else if (intent.getStatus().equals("requires_confirmation")) {
                // If the payment requires manual confirmation, confirm the PaymentIntent
                intent = intent.confirm();
                System.out.println("Payment requires manual confirmation. PaymentIntent ID: " + intent.getId());
            } else if (intent.getStatus().equals("succeeded")) {
                // If the payment was successful, display a success message
                System.out.println("Payment successful. PaymentIntent ID: " + intent.getId());
            } else {
                // If the payment failed or is in another state, display an appropriate message
                System.out.println("Payment failed or in unexpected state: " + intent.getStatus());
            }
        } catch (StripeException e) {
            // If there was an error processing the payment, display the error message
            System.out.println("Payment failed. Error: " + e.getMessage());
        }
    }



    @Override
    public void deleteDon(Don don) {
        String reqD="DELETE FROM `don` WHERE `id`=?";
        try{

            PreparedStatement pstm=cnx.prepareStatement(reqD);


            pstm.setInt(1, Math.toIntExact(don.getId()));
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
