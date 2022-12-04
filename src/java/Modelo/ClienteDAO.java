package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aylin Camila Orjuela Leiva & Juan Pablo Cuellar Florez
 */

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where Dni=" + dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Errpr en el metodo buscar de la clase ClienteDAO: " + e.getMessage());
        }
        return c;
    }

    public Cliente validar(String dni) {
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM cliente WHERE Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("IdCliente"));
                cli.setDni(rs.getString("Dni"));
                cli.setNom(rs.getString("Nombres"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al Validar Cliente : " + e.getMessage());
        }
        return cli;
    }

    public List listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                Lista.add(cli);
            }
        } catch (SQLException e) {
            System.out.println("Error metodo listar en clase ClienteDAO : " + e.getMessage());
        }
        return Lista;
    }

    public int agregar(Cliente cli) {
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo agregar de la clase ClienteDAO : " + e.getMessage());
        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo listarId en la clase ClienteDAO : " + e.getMessage());
        }
        return cli;
    }

    public int actualizar(Cliente cli) {
        String sql = "UPDATE cliente set Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo actualizar de la clase ClienteDAO : " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en metodo delete de la clase ClienteDAO : " + e.getMessage());
        }
    }
}
