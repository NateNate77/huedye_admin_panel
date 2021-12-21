package com.huedye.huedye_admin_panel.viewModels;

import com.huedye.huedye_admin_panel.model.Visits;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProcedureRow {


    private int id;

    private Visits visit;

    private String conditionBefore;

    private String description;

    private String conditionAfter;

    private String comment;

    public ProcedureRow() {

    }

    public ProcedureRow(int id, String conditionBefore, String description, String conditionAfter, String comment) {
        this.id = id;
        this.conditionBefore = conditionBefore;
        this.description = description;
        this.conditionAfter = conditionAfter;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visits getVisit() {
        return visit;
    }

    public void setVisit(Visits visit) {
        this.visit = visit;
    }

    public String getConditionBefore() {
        return conditionBefore;
    }

    public void setConditionBefore(String conditionBefore) {
        this.conditionBefore = conditionBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditionAfter() {
        return conditionAfter;
    }

    public void setConditionAfter(String conditionAfter) {
        this.conditionAfter = conditionAfter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
