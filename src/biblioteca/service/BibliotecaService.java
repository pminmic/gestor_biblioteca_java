package biblioteca.service;

public class BibliotecaService {

    // Hacer un método para verificar el formateo de un email para antes de la creación de un socio
    public static boolean verificarEmail(String email) {
        boolean res = false;
        String[] temp1 = email.split("@");
        if (temp1.length == 2){
            String[] temp2 = temp1[1].split(".");
            if (temp2.length > 1){
                res = true;
            }
        }
        return res;
    }

    public static boolean isSocio(String email){
        boolean res = false;

        // comprobar en a db si es socio
        
        return res;
    }

}