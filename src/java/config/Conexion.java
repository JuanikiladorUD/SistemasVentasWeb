package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance = null;
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "";
    
    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexcion Exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexion" + e.getMessage());
        }
        return con;
    }
    
    public static synchronized Conexion getInstance() {
        if(instance == null){
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
    
}
