package com.huedye.huedye_admin_panel.viewModels;

import java.util.Date;
import java.util.List;

public class VisitDetails {

    private int id;

    private Date visitDate;

    private Date creationDate;

    private Boolean completed;

    private String creationTitle;

    private Double creationCost;

    private String finalTitle;

    private Double finalCost;

    private String albumBefore;

    private String albumAfter;

    private List<ProcedureRow> procedureRows;



    public VisitDetails() {

    }

    public VisitDetails(int id, Date visitDate, Boolean completed, String finalTitle, String creationTitle, Double finalCost, List<ProcedureRow> procedureRows) {
        this.id = id;
        this.visitDate = visitDate;
        this.completed = completed;
        this.finalTitle = finalTitle;
        this.creationTitle = creationTitle;
        this.finalCost = finalCost;
        this.procedureRows = procedureRows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
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


    public Double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Double finalCost) {
        this.finalCost = finalCost;
    }

    public String getAlbumAfter() {
        return albumAfter;
    }

    public void setAlbumAfter(String albumAfter) {
        this.albumAfter = albumAfter;
    }

    public String getAlbumBefore() {
        return albumBefore;
    }

    public void setAlbumBefore(String albumBefore) {
        this.albumBefore = albumBefore;
    }

    public String getFinalTitle() {
        return finalTitle;
    }

    public void setFinalTitle(String finalTitle) {
        this.finalTitle = finalTitle;
    }


    public List<ProcedureRow> getProcedureRows() {
        return procedureRows;
    }

    public void setProcedureRows(List<ProcedureRow> procedureRows) {
        this.procedureRows = procedureRows;
    }
}
