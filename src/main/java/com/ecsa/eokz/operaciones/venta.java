package com.ecsa.eokz.operaciones;

import com.ecsa.eokz.modelo.producto;

public class venta implements operacionTienda{
    private producto producto;
    private int cantidad;

    public venta(com.ecsa.eokz.modelo.producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    @Override
    public void ejecutar(){
        if (producto.getCantidad() >= cantidad){
            producto.setCantidad(producto.getCantidad() - cantidad);
            System.out.println("Venta completada." +
                    "Cantidad stock: " + producto.getCantidad());
        } else {
            System.err.println("Stock insuficiente para la venta");
        }
    }
}
