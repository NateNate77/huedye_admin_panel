package com.huedye.huedye_admin_panel.viewModels;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MaterialRow {

    private Integer id;

    private String brandName;

    private String name;

    private Double cost;

    private Integer amount;

    public MaterialRow() {

    }

    public MaterialRow (int id, String brandName, String name, Double cost, int amount) {
        this.id = id;
        this.brandName = brandName;
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
