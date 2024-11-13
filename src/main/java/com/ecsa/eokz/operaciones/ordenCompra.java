package com.ecsa.eokz.operaciones;

import com.ecsa.eokz.modelo.producto;

public class ordenCompra implements operacionTienda{
    private producto producto;
    private int cantidad;

    public ordenCompra(com.ecsa.eokz.modelo.producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    @Override
    public void ejecutar(){
        System.out.println("Orden de compra generada para: " + producto.getNombre() +
                "con cantidad: " + cantidad);
    }
}
