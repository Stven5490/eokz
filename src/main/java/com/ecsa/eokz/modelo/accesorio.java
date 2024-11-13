package com.ecsa.eokz.modelo;

public class accesorio extends producto{
    private String tipo;

    public accesorio(int codigo, String nombre, int precion, int cantidad, String tipo) {
        super(codigo, nombre, precion, cantidad);
        this.tipo = tipo;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println(
                "Accesorio: " + nombre +
                        "Tipo: " + tipo +
                        "Precio: " + precio +
                        "Cantidad: " + cantidad
        );
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
