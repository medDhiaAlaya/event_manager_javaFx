package com.esprit.autismo.models;

public class Don {
    private int id;
    private int id_event_id;
    private String first_name_donor;
    private String last_name_donor;
    private String email_donor;
    private String msg_donor;
    private String methode;
    private int donated_money;

    public Don(int id, int id_event_id, String first_name_donor, String last_name_donor, String email_donor, String msg_donor, String methode, int donated_money) {
        this.id = id;
        this.id_event_id = id_event_id;
        this.first_name_donor = first_name_donor;
        this.last_name_donor = last_name_donor;
        this.email_donor = email_donor;
        this.msg_donor = msg_donor;
        this.methode = methode;
        this.donated_money = donated_money;
    }

    public Don() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event_id() {
        return id_event_id;
    }

    public void setId_event_id(int id_event_id) {
        this.id_event_id = id_event_id;
    }

    public String getFirst_name_donor() {
        return first_name_donor;
    }

    public void setFirst_name_donor(String first_name_donor) {
        this.first_name_donor = first_name_donor;
    }

    public String getLast_name_donor() {
        return last_name_donor;
    }

    public void setLast_name_donor(String last_name_donor) {
        this.last_name_donor = last_name_donor;
    }

    public String getEmail_donor() {
        return email_donor;
    }

    public void setEmail_donor(String email_donor) {
        this.email_donor = email_donor;
    }

    public String getMsg_donor() {
        return msg_donor;
    }

    public void setMsg_donor(String msg_donor) {
        this.msg_donor = msg_donor;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public int getDonated_money() {
        return donated_money;
    }

    public void setDonated_money(int donated_money) {
        this.donated_money = donated_money;
    }

    @Override
    public String toString() {
        return "Don{" +
                "id=" + id +
                ", id_event_id=" + id_event_id +
                ", first_name_donor='" + first_name_donor + '\'' +
                ", last_name_donor='" + last_name_donor + '\'' +
                ", email_donor='" + email_donor + '\'' +
                ", msg_donor='" + msg_donor + '\'' +
                ", methode='" + methode + '\'' +
                ", donated_money=" + donated_money +
                '}';
    }
}
