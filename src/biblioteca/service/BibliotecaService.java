package biblioteca.service;

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

}