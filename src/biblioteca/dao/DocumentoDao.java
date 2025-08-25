package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;

import biblioteca.utils.ConectarDB;

public class DocumentoDao {
    // Instancias la clase que hemos creado anteriormente
    private ConectarDB SQL = new ConectarDB();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.ConnectMySQL();
    // Query que usarás para hacer lo que necesites
    private String sSQL = "";

    public boolean insertarDocumento(Scanner terminal) {
        boolean res = false;
        System.out.println("\nBuena elección, vamos a añadir un documento.");
        while(!res) {   
            try {
                System.out.println("Título del documento:");
                String titulo = terminal.nextLine();
                System.out.println("Identificador del documento (ISBN, ISSN, EAN):");
                String id = terminal.next();
                terminal.nextLine();
                System.out.println("¿De cuantos ejemplares disponemos?");
                int ejemplares = terminal.nextInt();
                terminal.nextLine();
                System.out.println("¿Cuando se publicó? (Escribe en el formato YYYY-MM-DD)");
                String fecha = terminal.nextLine();
                LocalDate localDate = LocalDate.parse(fecha);
                Date fecha_publi = Date.valueOf(localDate);
                boolean correct = false;
                System.out.println("¿Qué tipo de documento es? (escribelo en minúsculas)");
                String tipo_doc = "";
                while(!correct) {
                    tipo_doc = terminal.nextLine();
                    if (tipo_doc.equals("libro") || tipo_doc.equals("revista") || tipo_doc.equals("dvd")) {
                        correct = true;
                    }
                    else {
                        System.out.println("Escibe bien el tipo de documento. (libro, revista o dvd)");
                    }
                }

                String autor = null;
                String director = null;
                String editorial = null;
                String productora = null;
                
                if (tipo_doc.equals("dvd")) {
                    System.out.println("¿Quien dirije esta cinta?");
                    director = terminal.nextLine();
                    System.out.println("¿Y su productora?");
                    productora = terminal.nextLine();
                }
                else {
                    System.out.println("Tiene autor? (s/n)");
                    String op_autor = terminal.nextLine();
                    if (op_autor.equals("s")) {
                        System.out.println("¿Quién es?");
                        autor = terminal.nextLine();
                    }
                    System.out.println("¿De que editorial es?");
                    editorial = terminal.nextLine();
                }

                this.sSQL = "INSERT INTO documentos (identificador, titulo, ejemplares, fecha_publi, autor, director, editorial, productora, tipo_doc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement ps = this.conn.prepareStatement(sSQL)) {
                    ps.setString(1, id);
                    ps.setString(2, titulo);
                    ps.setInt(3, ejemplares);
                    ps.setDate(4, fecha_publi);
                    ps.setString(5, autor);
                    ps.setString(6, director);
                    ps.setString(7, editorial);
                    ps.setString(8, productora);
                    ps.setString(9, tipo_doc);
                    int filas = ps.executeUpdate();
                    if (filas > 0) {
                        res = true;
                    }
                }
                catch (SQLException e) {
                    System.err.println("Ha habido un problema al conectarse a la base de datos.");
                    e.printStackTrace();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Introduce el tipo de datos correcto porfavor.");
            }
        }

        return res;
    } 

}
