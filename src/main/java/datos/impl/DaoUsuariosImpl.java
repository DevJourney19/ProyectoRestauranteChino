package datos.impl;

import java.sql.*;
import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

import datos.DaoUsuarios;
import modelo.Trabajador;
import util.Conexion;

public class DaoUsuariosImpl implements DaoUsuarios {

	@Override
	public List<Trabajador> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregar(Trabajador objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Trabajador objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trabajador obtener(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	Conexion con;
	
	public DaoUsuariosImpl() {
        con = new Conexion();
    }
	// Lista de trabajadores
	@Override
	public List<Trabajador> consultar() {
		List<Trabajador> trabajadores = new ArrayList<>();
		String sql = "SELECT * FROM trabajadores";
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
            	Trabajador trabajador = new Trabajador();
            	trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellido(rs.getString("apellido"));
                trabajador.setNombreUsuario(rs.getString("usuario"));
                trabajador.setCelular(rs.getString("telefono"));
                trabajador.setId_rol(rs.getInt("id_rol"));
                trabajadores.add(trabajador);
            }
        } catch (Exception e) {
        	System.out.println("Error al listar trabajadores: " + e.getMessage());
        }
        return trabajadores;
	}

	// Crear (Insertar) un nuevo trabajador
	@Override
    public boolean agregar(Trabajador trabajador) {
        String sql = "INSERT INTO trabajadores (nombre, apellido, usuario, password, telefono, id_rol) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, trabajador.getNombre());
            pstmt.setString(2, trabajador.getApellido());
            pstmt.setString(3, trabajador.getNombreUsuario());
            pstmt.setString(4, BCrypt.hashpw(trabajador.getContrasenia(), BCrypt.gensalt()));
            pstmt.setString(5, trabajador.getCelular());
            pstmt.setInt(6, trabajador.getId_rol());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
	// Actualizar un trabajador existente
    public boolean editar(Trabajador trabajador) {
		String sql = "UPDATE trabajadores SET nombre = ?, apellido = ?, usuario = ?, telefono =?, id_rol = ? WHERE id = ?";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, trabajador.getNombre());
            pstmt.setString(2, trabajador.getApellido());
            pstmt.setString(3, trabajador.getNombreUsuario());
            pstmt.setString(4, trabajador.getCelular());
            pstmt.setInt(5, trabajador.getId_rol());
            pstmt.setInt(6, trabajador.getCodigo());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
    // Eliminar un trabajador
    public boolean eliminar(int id) {
        String sql = "DELETE FROM trabajadores WHERE id = ?";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
    // Obtener un trabajador por su ID
    public Trabajador obtener(int id) {
        String sql = "SELECT * FROM trabajadores WHERE id = ?";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Trabajador trabajador = new Trabajador();
                    trabajador.setd(rs.getInt("id"));
                    trabajador.setNombre(rs.getString("nombre"));
                    trabajador.setApellido(rs.getString("apellido"));
                    trabajador.setNombreUsuario(rs.getString("usuario"));
                    trabajador.setCelular(rs.getString("telefono"));
                    trabajador.setId_rol(rs.getInt("id_rol"));
                    return trabajador;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */
}
