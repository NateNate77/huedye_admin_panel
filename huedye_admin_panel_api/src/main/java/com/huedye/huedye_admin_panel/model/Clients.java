package com.huedye.huedye_admin_panel.model;

//
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visits> visitsList;

    public Clients() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Visits> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visits> visitsList) {
        this.visitsList = visitsList;
    }
}
