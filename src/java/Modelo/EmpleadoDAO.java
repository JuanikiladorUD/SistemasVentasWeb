package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aylin Camila Orjuela Leiva & Juan Pablo Cuellar Florez
 */

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    private static final String SQL_READALL = "SELECT * FROM empleado ";
    private static final String VALIDAR_US = "select * from empleado where User=? and Dni=?";
    private static final Conexion coon = Conexion.getInstance();
    
    public Empleado valSesion(Empleado item) {

        Empleado nn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(VALIDAR_US);
            ps.setString(1, item.getNom());
            ps.setString(2, item.getDni());
            rs = ps.executeQuery();

            if (rs.next()) {
                nn = new Empleado(
                        rs.getInt("Id"),
                        rs.getString("Dni"),
                        rs.getString("Nombres"),
                        rs.getString("Telefono"),
                        rs.getString("Estado"),
                        rs.getString("User")
                );
            }

        } catch (SQLException ex) {
            System.out.println("error al validar usuario: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("error al cerrar result: " + ex.getMessage());
                }
            }
            coon.cerrarConexion();
        }
        return nn;
    }
    
    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (SQLException e) {
            System.out.println("Error en metodo validar EmpleadoDAO : " + e.getMessage());
        }
        return em;
    }

    public List<Empleado> listar() {
        String sql = "select * from empleado";
        List<Empleado> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                Lista.add(em);
            }
        } catch (SQLException e) {
            System.out.println("Error metodo listar en clase empleado : " + e.getMessage());
        }
        return Lista;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo agregar de la clase EmpleadoDAO : " + e.getMessage());
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo listarId en la clase EmpleadoDAO : " + e.getMessage());
        }
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo actualizar de la clase EmpleadoDAO : " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo delete de la clase EmpleadoDAO : " + e.getMessage());
        }
    }

}
