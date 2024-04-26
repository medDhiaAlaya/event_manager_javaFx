package com.esprit.autismo.models;

public class Participant {

    private Long id;

    private Boolean status;

    private Event event;

    //private User user;

    private String token;

    // Constructors, getters, and setters

    public Participant() {
    }

    // Getters and setters
    // Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Status
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // Event
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}

    // User
    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    */

//
