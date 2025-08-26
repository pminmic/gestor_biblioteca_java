package biblioteca.app;
import java.util.Scanner;

import biblioteca.service.BibliotecaService;
import biblioteca.dao.DocumentoDao;
import biblioteca.dao.SocioDao;

public class BibliotecaApp {

    private static String pass = "";

    public static Scanner terminal = new Scanner(System.in);
    public static void main(String[] args) {
        // Inicializa la aplicación de biblioteca
        System.out.println("\nBienvenido a la Biblioteca!");
        System.out.println("\n¿Cuál es tu email?");
        boolean correct = false;
        while (!correct){
            String email = terminal.nextLine();
            if (BibliotecaService.verificarEmail(email)){
                correct = true;
                SocioDao sociodao = new SocioDao();
                String nombre = sociodao.nombreSocio(email);
            // Verificar si hay un Socio con ese email
            // if (es Socio) { Bienvenido }
                if (nombre != "") {
                    System.out.println("\nBienvenido " + nombre + "!");
                }
            // else { registrar, pedir datos }
                else {
                    System.out.println("\nParece que eres nuevo, vamos a registrarte.");
                    System.out.println("\n¿Cuál es tu nombre completo?");
                    nombre = terminal.nextLine();

                    System.out.println("\nPerfecto! ¿Y tu número de telefono?");
                    String telefono = terminal.nextLine();

                    System.out.println("\nAhora voy a añadirte a la base de datos.");
                    if (sociodao.insertarSocio(nombre, email, telefono)) {
                        System.out.println("\nPerfecto, parece que todo esta correcto. Bienvenido " + nombre + "!");
                    }
                    else {
                        System.out.println("Parece que ha habido un error para añadirte a la base de datos.");
                    }

                }
            }
            else {
                System.out.println("\nEl email no tiene un formato correcto, vuelve a introducirlo.");
            }
        }


        mainMenu();

        // Aquí podrías inicializar servicios, cargar datos, etc.
        // Por ejemplo, podrías crear una instancia de BibliotecaService
        // BibliotecaService bibliotecaService = new BibliotecaService();
        
        // Luego podrías llamar a métodos para mostrar libros, dvds, revistas, etc.
        // bibliotecaService.mostrarLibros();
        
        // O cualquier otra funcionalidad que desees implementar
    }

    private static void mainMenu() {
        
        System.out.println("\n¿Qué operación desea realizar?");
        System.out.println("1. Buscar un documento");
        System.out.println("2. Comprobar prestamos");
        System.out.println("3. Datos de socio");
        System.out.println("4. Salir");
        
        
        int option = BibliotecaService.validarIntervalo(terminal, 1, 4, 33);
        switch (option) {
            case 1:
                buscarDocumento();
                break;
            case 2:
                comprobarPrestamos();
                break;
            case 3:
                datosSocio();
                break;
            case 4:
                System.out.println("\nHasta la próxima!!!\n");
                terminal.close();
                break;
            case 33:
                superusuario();
                break;
        }
    }

    private static void buscarDocumento() {
        // Buscar un documento a partir de su título, autor o id. Después dar la opción de prestar.
        System.out.println("\n¿Que tipo de documento quieres buscar?");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Dvd");
        System.out.println("4. Cancelar");

        int opcion = BibliotecaService.validarIntervalo(terminal, 1, 4);
        
        String tipo_doc = "";
        switch(opcion) {
           case 1:
               tipo_doc = "libro";
               break;
           case 2:
               tipo_doc = "revista";
               break;
           case 3:
               tipo_doc = "dvd";
               break;
           case 4:
               mainMenu();
               break;
        }
        
        System.out.println("\nPerfecto, que tipo de búsqueda quieres realizar?");
        if (tipo_doc == "libro") {
            System.out.println("1. Por ISBN");
            System.out.println("2. Por autor");
            System.out.println("3. Por editorial");
        }
        else if (tipo_doc == "revista") {
            System.out.println("1. Por ISSN");
            System.out.println("2. Por autor");
            System.out.println("3. Por editorial");
        }
        else {
            System.out.println("1. Por EAN");
            System.out.println("2. Por director");
            System.out.println("3. Por productora");
        }
        System.out.println("4. Por nombre");

    }

    private static void comprobarPrestamos() {
        // Prestamos activos, y registro de prestamos anteriores.
        mainMenu();
    }

    private static void datosSocio() {
        // Sacar el toString de la clase Socio con los datos de la bd y dar la opción de editarlos.
        mainMenu();
    }
    
    private static void superusuario() {    

        if (pass.equals("")){
            System.out.println("\nLOGON:");
            pass = terminal.nextLine();
            
        }
        int num = 0;
        if (pass.equals("JOSHUA")) num = 1;
        switch(num){
            case 0:
                System.out.println("\nLo siento, no tienes permiso para acceder.");
                mainMenu();
                break;
            case 1:
                System.out.println("\nBIENVENIDO AL MENÚ DE SUPERUSUARIO, ¿que acción desea realizar?");
                System.out.println("1. Añadir un documento");
                System.out.println("2. Eliminar un documento");
                System.out.println("3. Eliminar un usuario");
                System.out.println("4. Salir al menú normal");
                int opcion = BibliotecaService.validarIntervalo(terminal, 1, 4);

                DocumentoDao documentoDao = new DocumentoDao();
                switch(opcion){
                    case 1:
                        if (documentoDao.insertarDocumento(terminal)) {
                            System.out.println("Perfecto! El documento ha sido añadido.");
                        }
                        else {
                            System.out.println("Parece que ha habido un error");
                        }
                        superusuario();
                        break;
                    case 2:
                        if (documentoDao.eliminarDocumento(terminal)) {
                            System.out.println("Documento eliminado correctamente.");
                        }
                        superusuario();
                        break;
                    case 3:
                        superusuario();
                        break;
                    case 4:
                        pass = "";
                        mainMenu();
                        break;
                }
        }
    
    
        
    


    }
}
