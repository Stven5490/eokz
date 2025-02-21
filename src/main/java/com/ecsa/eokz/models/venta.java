package com.ecsa.eokz.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private int valorTotal;
    private int IVA;
    private int valorRecibido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(int valorRecibido) {
        this.valorRecibido = valorRecibido;
    }
}
