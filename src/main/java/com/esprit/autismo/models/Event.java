package com.esprit.autismo.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Event {
    private int id;
    private int id_super_admin_id;
    //private List<Don> dons;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private String type;
    private String banner;
    private List<String> galerie;

    public Event(int id, String title, String description, Date start_date, Date end_date, String type, String banner, List<String> galerie) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.type = type;
        this.banner = banner;
        this.galerie = galerie;
    }

    public Event() {

    }

    public Event(int i, String javaEvent, String descriptoonJava, Date date) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getStart_date() {
        return (java.sql.Date) start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<String> getGalerie() {
        return galerie;
    }

    public void setGalerie(List<String> galerie) {
        this.galerie = galerie;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", type='" + type + '\'' +
                ", banner='" + banner + '\'' +
                ", galerie=" + galerie +
                '}';
    }
}
