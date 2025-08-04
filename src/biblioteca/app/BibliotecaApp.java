package biblioteca.app;
import java.util.InputMismatchException;
import java.util.Scanner;

import biblioteca.service.BibliotecaService;
import biblioteca.dao.SocioDao;

public class BibliotecaApp {
    public static void main(String[] args) {
        // Inicializa la aplicación de biblioteca
        System.out.println("\nBienvenido a la Biblioteca!");
        System.out.println("\n¿Cuál es tu email?");
        Scanner terminal = new Scanner(System.in);
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

        terminal.close();
    }

    private static void mainMenu() {

        Scanner terminal = new Scanner(System.in);
        
        System.out.println("\n¿Qué operación desea realizar?");
        System.out.println("1. Buscar un documento");
        System.out.println("2. Comprobar prestamos");
        System.out.println("3. Datos de socio");
        System.out.println("4. Salir");
        
        boolean correct = false;
        int option = 0;
        while(!correct){
            try{
                option = terminal.nextInt();
                if (option >= 1 && option <= 4) {
                    correct = true;
                }
                else {
                    System.out.println("\nEsa opción no existe en el menú, vuelve a introducir un número.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("\nPorfavor introduce el tipo de valor correcto.");
                terminal.nextLine();
            }
            
        }

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
                break;
        }

        terminal.close();
    }

    private static void buscarDocumento() {
        // Buscar un documento a partir de su título, autor o id. Después dar la opción de prestar.
        mainMenu();
    }

    private static void comprobarPrestamos() {
        // Prestamos activos, y registro de prestamos anteriores.
        mainMenu();
    }

    private static void datosSocio() {
        // Sacar el toString de la clase Socio con los datos de la bd y dar la opción de editarlos.
        mainMenu();
    }
    
}
