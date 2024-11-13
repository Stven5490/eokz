package com.ecsa.eokz;

import com.ecsa.eokz.modelo.ropa;
import com.ecsa.eokz.operaciones.ingresoMercaderia;
import com.ecsa.eokz.operaciones.operacionTienda;
import com.ecsa.eokz.operaciones.ordenCompra;
import com.ecsa.eokz.operaciones.venta;

import javax.swing.*;
import java.awt.*;

public class tiendaEokzApp extends JFrame {
   public tiendaEokzApp(){
        setTitle("Eokz // American Closeth");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton btnIngresoMercaderia = new JButton("Ingreso de Mercaderia");
        JButton btnVenta = new JButton("Venta de Mercaderia");
        JButton btnOrdenCompra = new JButton("Orden de Compra");
        btnIngresoMercaderia.addActionListener(e -> {
            ropa ropa = new ropa(1,"Camisa", 15, 10, "M");
            operacionTienda ingreso = new ingresoMercaderia(ropa, 5);
            ingreso.ejecutar();
        });
        btnVenta.addActionListener(e -> {
            ropa ropa = new ropa(1, "Camisa", 15, 10, "M");
            operacionTienda venta = new venta(ropa, 3);
            venta.ejecutar();
        });
        btnOrdenCompra.addActionListener(e -> {
            ropa ropa = new ropa(1, "Camisa", 15, 10, "M");
            operacionTienda orden = new ordenCompra(ropa, 20);
            orden.ejecutar();
        });
        add(btnIngresoMercaderia);
        add(btnVenta);
        add(btnOrdenCompra);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            new tiendaEokzApp().setVisible(true);
        });
    }
}
