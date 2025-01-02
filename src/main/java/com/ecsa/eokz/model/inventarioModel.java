package com.ecsa.eokz.model;

import jakarta.persistence.*;

@Entity
public class inventarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producto;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public inventarioModel(Long id, String producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
