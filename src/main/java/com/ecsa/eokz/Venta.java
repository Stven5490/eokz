package com.ecsa.eokz;

import java.util.List;

public class Venta {
    private int id;
    private String fecha;
    private double valorTotal;
    private double iva;
    private double valorRecibido;
    private List<DetalleVenta> detalles;

    // Constructor, getters y setters
    public Venta(String fecha, double valorTotal, double iva, double valorRecibido) {
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.iva = iva;
        this.valorRecibido = valorRecibido;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
    public double getIva() { return iva; }
    public void setIva(double iva) { this.iva = iva; }
    public double getValorRecibido() { return valorRecibido; }
    public void setValorRecibido(double valorRecibido) { this.valorRecibido = valorRecibido; }
    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
}
