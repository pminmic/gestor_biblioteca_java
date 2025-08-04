package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import biblioteca.utils.ConectarDB;
//import biblioteca.utils.ConexionMySQL;

public class SocioDao {
    // Instancias la clase que hemos creado anteriormente
    private ConectarDB SQL = new ConectarDB();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.ConnectMySQL();
    // Query que usarás para hacer lo que necesites
    private String sSQL = "";

    public String nombreSocio (String email){
        String nombre = "";
        this.sSQL = "SELECT nombre FROM socios WHERE email = ?";
        try (PreparedStatement ps = this.conn.prepareStatement(sSQL)) {
            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Ha habido un problema al connectarse a la base de datos.");
        }
        return nombre;
    }

    public boolean insertarSocio (String nombre, String email, String telefono) {
        boolean res = false;
        this.sSQL = "INSERT INTO socios (nombre, email, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.conn.prepareStatement(sSQL)) {
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, telefono);
            int filas = ps.executeUpdate();
            if (filas > 0){
                res = true;
            }
        }
        catch (SQLException e) {
            System.err.println("Ha habido un problema al conectarse a la base de datos.");
        }

        return res;
    }
}
