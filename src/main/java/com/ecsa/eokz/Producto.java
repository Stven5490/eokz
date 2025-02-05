package com.ecsa.eokz;

public class Producto {
    private int id;
    private String codigo;
    private String descripcion;
    private String material;
    private String color;
    private double precio;
    private int stock;

    // Constructor, getters y setters
    public Producto(String codigo, String descripcion, String material, String color, double precio, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.material = material;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
