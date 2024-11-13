package com.ecsa.tienda;

import com.ecsa.eokz.modelo.producto;
import com.ecsa.eokz.modelo.ropa;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductoForm extends JFrame {
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtTalla;
    private JLabel lblCodigo;
    private JLabel lblFotoRuta;
    private JButton btnGuardar, btnSeleccionarFoto;
    private String rutaFoto;
    private static final String EXCEL_FILE_PATH = "src/main/resources/productos.xlsx";
    private static int codigoActual = 1;

    public ProductoForm() {
        setTitle("Nuevo Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        lblCodigo = new JLabel("Código: " + codigoActual);
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtCantidad = new JTextField();
        txtTalla = new JTextField();
        lblFotoRuta = new JLabel("Foto no seleccionada");
        btnGuardar = new JButton("Guardar Producto");
        btnSeleccionarFoto = new JButton("Seleccionar Foto");

        add(new JLabel("Código:"));
        add(lblCodigo);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Precio:"));
        add(txtPrecio);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(new JLabel("Talla:"));
        add(txtTalla);
        add(new JLabel("Fotografía:"));
        add(btnSeleccionarFoto);
        add(lblFotoRuta);
        add(btnGuardar);

        btnSeleccionarFoto.addActionListener(e -> seleccionarFoto());
        btnGuardar.addActionListener(e -> guardarProducto());

        verificarCodigo();
    }

    private void seleccionarFoto() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Path destino = Paths.get("src/main/resources/fotos/" + codigoActual + "_" + selectedFile.getName());
                Files.copy(selectedFile.toPath(), destino);
                rutaFoto = destino.toString();
                lblFotoRuta.setText("Foto seleccionada: " + destino.getFileName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void verificarCodigo() {
        File file = new File(EXCEL_FILE_PATH);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);
                if (sheet.getLastRowNum() > 0) {
                    Row lastRow = sheet.getRow(sheet.getLastRowNum());
                    codigoActual = (int) lastRow.getCell(0).getNumericCellValue() + 1;
                }
                lblCodigo.setText("Código: " + codigoActual);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void guardarProducto() {
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String talla = txtTalla.getText();

        // Crear un producto
        producto producto = new ropa(nombre, precio, cantidad, talla);

        // Guardar en Excel
        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook workbook = fis.available() > 0 ? new XSSFWorkbook(fis) : new XSSFWorkbook()) {
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) sheet = workbook.createSheet("Productos");

            int lastRowNum = sheet.getLastRowNum();
            Row newRow = sheet.createRow(lastRowNum + 1);

            newRow.createCell(0).setCellValue(codigoActual);
            newRow.createCell(1).setCellValue(nombre);
            newRow.createCell(2).setCellValue(precio);
            newRow.createCell(3).setCellValue(cantidad);
            newRow.createCell(4).setCellValue(talla);
            newRow.createCell(5).setCellValue(rutaFoto);

            try (FileOutputStream fos = new FileOutputStream(EXCEL_FILE_PATH)) {
                workbook.write(fos);
                JOptionPane.showMessageDialog(this, "Producto guardado exitosamente.");
            }
            codigoActual++;
            lblCodigo.setText("Código: " + codigoActual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductoForm().setVisible(true));
    }
}
