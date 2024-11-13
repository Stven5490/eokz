package com.ecsa.eokz.operaciones;

import com.ecsa.eokz.modelo.producto;

public class ingresoMercaderia extends operacionTienda{
    private producto producto;
    private int cantidad,

    public ingresoMercaderia(com.ecsa.eokz.modelo.producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    @Override
    public void ejecutar(){
        producto.setCantidad(producto.getCantidad() + cantidad);
        System.out.println("Ingreso de mercaderia completado." +
                "Nueva cantidad: " + producto.getCantidad());
    }
}
