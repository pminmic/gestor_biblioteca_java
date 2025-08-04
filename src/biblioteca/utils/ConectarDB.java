package biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB{
    
    public Connection ConnectMySQL(){
        Connection conexion;
        String host = "jdbc:mysql://localhost/";
        String user = "root";
        String pass = System.getenv("MYSQL_PASS");
        String bd = "biblioteca";

        System.out.println("Conectando...");
        try {
            conexion = DriverManager.getConnection(host+bd, user, pass);
            System.out.println("Conexion Existosa!!!");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        return conexion;
    }
}
