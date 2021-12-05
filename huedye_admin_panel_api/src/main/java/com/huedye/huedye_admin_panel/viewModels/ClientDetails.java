package com.huedye.huedye_admin_panel.viewModels;

import java.util.List;

public class ClientDetails {

    private int id;

    private String name;

    List<VisitRow> visitRows;

    public ClientDetails() {

    }
    public ClientDetails(int id, String name, List<VisitRow> visitRows) {
        this.id = id;
        this.name = name;
        this.visitRows = visitRows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VisitRow> getVisitRows() {
        return visitRows;
    }

    public void setVisitRows(List<VisitRow> visitRows) {
        this.visitRows = visitRows;
    }

}
