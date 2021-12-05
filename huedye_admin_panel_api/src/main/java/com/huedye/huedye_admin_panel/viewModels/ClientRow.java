package com.huedye.huedye_admin_panel.viewModels;

import java.util.Date;

public class ClientRow {

    private int id;
    private String name;
    private String phone;
    private Date lastVisit;
    private int visitsCount;

    public ClientRow() {
    }

    public ClientRow (int id, String name, String phone, Date lastVisit, int visitsCount) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.lastVisit = lastVisit;
        this.visitsCount = visitsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
