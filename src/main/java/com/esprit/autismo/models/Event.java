package com.esprit.autismo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Event  {

    private Long id;
    private String title;

    private java.util.Date startDate;

    private java.util.Date endDate;

    private String type;

    private String description;

    private String banner;

    private List<String> gallery = new ArrayList<>();

    //private User idSuperAdmin;



    private List<Don> dons = new ArrayList<>();






    private Collection<Participant> participations = new ArrayList<>();

    // Constructors, getters, and setters

    public Event() {}

    // Getters and setters
    // Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Start Date
    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    // End Date
    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    // Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Banner
    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    // Gallery
    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }
/*
    // IdSuperAdmin
    public User getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(User idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
    }
    */

    // Dons
    public List<Don> getDons() {
        return dons;
    }

    public void setDons(List<Don> dons) {
        this.dons = dons;
    }

    // Participations
    public Collection<Participant> getParticipations() {
        return participations;
    }

    public void setParticipations(Collection<Participant> participations) {
        this.participations = participations;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", banner='" + banner + '\'' +
                ", gallery=" + gallery +
                ", dons=" + dons +
                ", participations=" + participations +
                '}';
    }
}
