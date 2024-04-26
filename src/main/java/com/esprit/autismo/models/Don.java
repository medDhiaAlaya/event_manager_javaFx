package com.esprit.autismo.models;


public class Don  {

    private Long id;

    private String firstNameDonor;

    private String lastNameDonor;

    private String emailDonor;

    private String msgDonor;

    private String methode;

    private int idEvent;

    private Double donatedMoney;

    // Constructors, getters, and setters

    public Don() {}

    // Getters and setters
    // Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Don{" +
                "id=" + id +
                ", firstNameDonor='" + firstNameDonor + '\'' +
                ", lastNameDonor='" + lastNameDonor + '\'' +
                ", emailDonor='" + emailDonor + '\'' +
                ", msgDonor='" + msgDonor + '\'' +
                ", methode='" + methode + '\'' +
                ", idEvent=" + idEvent +
                ", donatedMoney=" + donatedMoney +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    // FirstNameDonor
    public String getFirstNameDonor() {
        return firstNameDonor;
    }

    public void setFirstNameDonor(String firstNameDonor) {
        this.firstNameDonor = firstNameDonor;
    }

    // LastNameDonor
    public String getLastNameDonor() {
        return lastNameDonor;
    }

    public void setLastNameDonor(String lastNameDonor) {
        this.lastNameDonor = lastNameDonor;
    }

    // EmailDonor
    public String getEmailDonor() {
        return emailDonor;
    }

    public void setEmailDonor(String emailDonor) {
        this.emailDonor = emailDonor;
    }

    // MsgDonor
    public String getMsgDonor() {
        return msgDonor;
    }

    public void setMsgDonor(String msgDonor) {
        this.msgDonor = msgDonor;
    }

    // Methode
    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    // IdEvent
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    // DonatedMoney
    public Double getDonatedMoney() {
        return donatedMoney;
    }

    public void setDonatedMoney(Double donatedMoney) {
        this.donatedMoney = donatedMoney;
    }
}
