package com.ecsa.eokz.modelo;

public class ropa extends producto{
    private String talla;

    public ropa(int codigo, String nombre, int precion, int cantidad, String talla) {
        super(codigo, nombre, precion, cantidad);
        this.talla = talla;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println(
                "Ropa: " + nombre +
                "Talla: " + talla +
                "Precio: " + precio +
                "Cantidad: " + cantidad);
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
