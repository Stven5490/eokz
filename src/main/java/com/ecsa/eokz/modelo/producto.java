package com.ecsa.eokz.modelo;

public abstract class producto {
    protected int codigo;
    protected String nombre;
    protected int precio;
    protected int cantidad;
    public producto(int codigo, String nombre, int precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public producto(int codigo, String nombre, double precio, int cantidad, String talla) {
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precion) {
        this.precio = precion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public abstract void mostrarDetalles();
}
