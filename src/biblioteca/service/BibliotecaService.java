package biblioteca.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaService {

    // Hacer un método para verificar el formateo de un email para antes de la creación de un socio
    public static boolean verificarEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        String[] partes = email.split("@");
        if (partes.length != 2) return false;

        String usuario = partes[0];
        String dominio = partes[1];

        if (usuario.isEmpty() || dominio.isEmpty()) return false;
        if (!dominio.contains(".")) return false;

        String[] subdominios = dominio.split("\\.");
        for (String sub : subdominios) {
            if (sub.isEmpty()) return false;
        }

        return true;
    }

    public static boolean isSocio(String email){
        boolean res = false;

        // comprobar en a db si es socio
        
        return res;
    }

    public static int validarIntervalo(Scanner terminal, int ini, int fin) {
        int opcion = 0;
        boolean correct = false;
        
        while (!correct) {
            try {
                opcion = terminal.nextInt();
                if (opcion >= ini && opcion <= fin) {
                    correct = true;
                }
                else {
                    System.out.println("Introduce un número valido, porfavor.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Introduce una opción del menú, porfavor.");
            }
        }
        
        
        return opcion;
    }

    public static int validarIntervalo(Scanner terminal, int ini, int fin, int secret) {
        int opcion = 0;
        boolean correct = false;
        
        while (!correct) {
            try {
                opcion = terminal.nextInt();
                if (opcion >= ini && opcion <= fin) {
                    correct = true;
                }
                else if (secret == opcion){
                    correct = true;
                }
                else {
                    System.out.println("Introduce un número valido, porfavor.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Introduce una opción del menú, porfavor.");
            }
        }
        
        
        return opcion;
    }

}