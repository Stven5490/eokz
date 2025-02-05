package com.ecsa.eokz;

import java.sql.*;
import java.util.List;

public class VentaController {
    public void agregarVenta(Venta venta, List<DetalleVenta> detalles) {
        String sqlVenta = "INSERT INTO Ventas (fecha, valor_total, iva, valor_recibido) VALUES (?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO DetalleVenta (venta_id, producto_id, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
            // Insertar la venta
            pstmtVenta.setString(1, venta.getFecha());
            pstmtVenta.setDouble(2, venta.getValorTotal());
            pstmtVenta.setDouble(3, venta.getIva());
            pstmtVenta.setDouble(4, venta.getValorRecibido());
            pstmtVenta.executeUpdate();

            // Obtener el ID de la venta generada
            ResultSet rs = pstmtVenta.getGeneratedKeys();
            int ventaId = 0;
            if (rs.next()) {
                ventaId = rs.getInt(1);
            }

            // Insertar los detalles de la venta
            try (PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {
                for (DetalleVenta detalle : detalles) {
                    pstmtDetalle.setInt(1, ventaId);
                    pstmtDetalle.setInt(2, detalle.getProductoId());
                    pstmtDetalle.setInt(3, detalle.getCantidad());
                    pstmtDetalle.setDouble(4, detalle.getPrecioUnitario());
                    pstmtDetalle.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
