package com.seffar.crm.api.dtos;

import com.seffar.crm.dao.OrderState;
import com.seffar.crm.dao.entity.Client;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class OrderDTO {
    private String type_presta;
    private String designation;
    @ManyToOne
    private Client client;
    private Integer nb_days;
    private Double unit_price;
    private Double total_exclude_taxe;
    private Double total_with_taxe;
    @Enumerated(EnumType.STRING)
    private OrderState state;

    public String getType_presta() {
        return type_presta;
    }

    public void setType_presta(String type_presta) {
        this.type_presta = type_presta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNb_days() {
        return nb_days;
    }

    public void setNb_days(Integer nb_days) {
        this.nb_days = nb_days;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getTotal_exclude_taxe() {
        return total_exclude_taxe;
    }

    public void setTotal_exclude_taxe(Double total_exclude_taxe) {
        this.total_exclude_taxe = total_exclude_taxe;
    }

    public Double getTotal_with_taxe() {
        return total_with_taxe;
    }

    public void setTotal_with_taxe(Double total_with_taxe) {
        this.total_with_taxe = total_with_taxe;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
