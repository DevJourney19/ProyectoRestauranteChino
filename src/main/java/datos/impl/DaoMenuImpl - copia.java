package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DaoMenu;
import modelo.Menu;
import util.Conexion;

public class DaoMenuImpl implements DaoMenu{
Conexion con;
	
	public DaoMenuImpl() {
        con = new Conexion();
    }
	// Lista de trabajadores
	@Override
	public List<Menu> consultar() {
		List<Menu> trabajadores = new ArrayList<>();
		String sql = "SELECT * FROM menu";
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
            	Menu menu = new Menu();
            	menu.setId(rs.getInt("id"));
            	menu.setNombre(rs.getString("nombre"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setPrecio(rs.getDouble("precio"));
                menu.setEstado(Menu.EstadoMenu.valueOf(rs.getString("estado")));
                menu.setCategoria(rs.getInt("id_categoria"));
                trabajadores.add(menu);
            }
        } catch (Exception e) {
        	System.out.println("Error al listar menu: " + e.getMessage());
        }
        return trabajadores;
	}

	// Crear (Insertar) un nuevo trabajador
	@Override
    public boolean agregar(Menu menu) {
        String sql = "INSERT INTO menu (nombre, descripcion, precio, id_categoria) VALUES (null, ?, ?, ?, ?)";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, menu.getNombre());
            pstmt.setString(2, menu.getDescripcion());
            pstmt.setDouble(3, menu.getPrecio());
            pstmt.setInt(4, menu.getCategoria());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
	// Actualizar un trabajador existente
    public boolean editar(Menu menu) {
		String sql = "UPDATE menu SET nombre = ?, descripcion = ?, precio = ?, estado =?, id_categoria = ? WHERE id = ?";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, menu.getNombre());
            pstmt.setString(2, menu.getDescripcion());
            pstmt.setDouble(3, menu.getPrecio());
            pstmt.setString(4, menu.getEstado().toString());
            pstmt.setInt(5, menu.getCategoria());
            pstmt.setInt(6, menu.getId());
            
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
        String sql = "DELETE FROM menu WHERE id = ?";
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
    public Menu obtener(int id) {
        String sql = "SELECT * FROM trabajador WHERE id = ?";
        try (Connection conn = con.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getInt("id"));
                    menu.setNombre(rs.getString("nombre"));
                    menu.setDescripcion(rs.getString("descripcion"));
                    menu.setPrecio(rs.getDouble("precio"));
                    menu.setEstado(Menu.EstadoMenu.valueOf(rs.getString("estado")));
                    menu.setCategoria(rs.getInt("id_categoria"));
                    return menu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public List<Menu> filtrar(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}
}
