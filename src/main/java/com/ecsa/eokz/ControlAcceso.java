package com.ecsa.eokz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ControlAcceso {

    @Value("${security.username}")
    private String usuarioValido;

    @Value("${security.password}")
    private String claveValida;

    public boolean validarCredenciales() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        return usuarioValido.equals(usuario) && claveValida.equals(clave);
    }
}
