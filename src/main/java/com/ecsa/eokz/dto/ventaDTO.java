package com.ecsa.eokz.dto;

import java.util.Date;
public class ventaDTO {
    private Date fecha;
    private int valorTotal;
    private int IVA;
    private int valorRecibido;

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
