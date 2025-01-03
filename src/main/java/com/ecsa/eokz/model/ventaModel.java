package com.ecsa.eokz.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ventaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cliente;
    private int total;
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ventaModel(Integer id, String cliente, int total, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }
}
