package com.huedye.huedye_admin_panel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Brands")
public class Brands {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materials> materialsList;

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

    public List<Materials> getMaterialsList() {
        return materialsList;
    }

    public void setMaterialsList(List<Materials> materialsList) {
        this.materialsList = materialsList;
    }
}
