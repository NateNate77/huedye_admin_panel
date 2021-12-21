package com.huedye.huedye_admin_panel.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Procedures")
@JsonIgnoreProperties({ "visit" })
public class Procedures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitId")
    private Visits visit;

    private String conditionBefore;

    private String description;

    private String conditionAfter;

    private String comment;

    public Procedures() {

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
