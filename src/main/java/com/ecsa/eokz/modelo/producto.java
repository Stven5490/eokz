package com.ecsa.eokz.modelo;

public abstract class producto {
    private int codigo;
    private String nombre;
    private int precion;
    private int cantidad;
    public producto(int codigo, String nombre, int precion, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precion = precion;
        this.cantidad = cantidad;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecion() {
        return precion;
    }
    public void setPrecion(int precion) {
        this.precion = precion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public abstract void mostrarDetalles();
}
