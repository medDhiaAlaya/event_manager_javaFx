package com.esprit.autismo.models;

public class Participation {
    private int id;
    private int event_id;
    private int user_id;
    private String status;
    private String token;

    public Participation(int id, int event_id, int user_id, String status, String token) {
        this.id = id;
        this.event_id = event_id;
        this.user_id = user_id;
        this.status = status;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
