package com.seffar.crm.dao.entity;

import com.seffar.crm.dao.OrderState;
import jakarta.persistence.*;

import java.lang.Double;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String type_presta;

    @Column(nullable = false, length = 100)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(nullable = false)
    private Integer nb_days;

    @Column(nullable = false,columnDefinition = "NUMERIC")
    private Double unit_price;

    @Column(nullable = false,columnDefinition = "NUMERIC", insertable = false, updatable = false)
    private Double total_exclude_taxe;

    @Column(nullable = false,columnDefinition = "NUMERIC", insertable = false, updatable = false)
    private Double total_with_taxe;

    @Column(nullable = false)
    private Integer state;

    public Order() {
    }

    public Order(String type_presta, String designation, Client client, Integer nb_days, Double unit_price,
                 Double total_exclude_taxe, Double total_with_taxe, Integer state) {
        this.type_presta = type_presta;
        this.designation = designation;
        this.client = client;
        this.nb_days = nb_days;
        this.unit_price = unit_price;
        this.total_exclude_taxe = total_exclude_taxe;
        this.total_with_taxe = total_with_taxe;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type_presta='" + type_presta + '\'' +
                ", designation='" + designation + '\'' +
                ", client=" + client +
                ", nb_days=" + nb_days +
                ", unit_price=" + unit_price +
                ", total_exclude_taxe=" + total_exclude_taxe +
                ", total_with_taxe=" + total_with_taxe +
                ", state=" + state +
                '}';
    }
}
