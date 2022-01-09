package com.huedye.huedye_admin_panel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Visits")
@JsonIgnoreProperties({ "client" })
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Clients client;

    private Date visitDate;

    private Date creationDate;

    private boolean completed;

    private String creationTitle;

    private Double creationCost;

    private String finalTitle;

    private Double finalCost;

    private String albumBefore;

    private String albumAfter;

    private boolean isDeleted;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Procedures> proceduresList;



    public Visits() {

    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreationTitle() {
        return creationTitle;
    }

    public void setCreationTitle(String creationTitle) {
        this.creationTitle = creationTitle;
    }

    public Double getCreationCost() {
        return creationCost;
    }

    public void setCreationCost(Double creationCost) {
        this.creationCost = creationCost;
    }

    public String getFinalTitle() {
        return finalTitle;
    }

    public void setFinalTitle(String finalTitle) {
        this.finalTitle = finalTitle;
    }

    public Double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Double finalCost) {
        this.finalCost = finalCost;
    }

    public String getAlbumBefore() {
        return albumBefore;
    }

    public void setAlbumBefore(String albumBefore) {
        this.albumBefore = albumBefore;
    }

    public String getAlbumAfter() {
        return albumAfter;
    }

    public void setAlbumAfter(String albumAfter) {
        this.albumAfter = albumAfter;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }


    public List<Procedures> getProceduresList() {
        return proceduresList;
    }

    public void setProceduresList(List<Procedures> proceduresList) {
        this.proceduresList = proceduresList;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
