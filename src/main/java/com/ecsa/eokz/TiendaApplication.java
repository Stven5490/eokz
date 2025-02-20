package com.ecsa.eokz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaApplication implements CommandLineRunner {

    @Autowired
    private ControlAcceso controlAcceso;

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al sistema de la tienda de ropa.");

        if (controlAcceso.validarCredenciales()) {
            System.out.println("Acceso concedido. Iniciando la aplicación...");
            // Aquí puedes iniciar la lógica principal de la aplicación
        } else {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
            System.exit(0); // Cierra la aplicación si las credenciales son incorrectas
        }
    }
}
