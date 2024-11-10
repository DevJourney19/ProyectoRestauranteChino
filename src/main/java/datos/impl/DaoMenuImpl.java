package datos.impl;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCategoria;
import datos.DaoMenu;
import modelo.Categoria;
import modelo.Inventario;
import modelo.Menu;
import util.Conexion;

public class DaoMenuImpl implements DaoMenu{
	
	Conexion con;
    private DaoCategoria cat;

	public DaoMenuImpl() {
		con = new Conexion();
        cat = new DaoCategoriaImpl();
	}


	@Override
	public List<Menu> consultar() {
		List<Menu> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre, descripcion, imagen, precio, estado, id_categoria").append(" FROM menu");
		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt(1));
				menu.setNombre(rs.getString(2));
				menu.setDescripcion(rs.getString(3));
				menu.setImagen(rs.getString(4));
				menu.setPrecio(rs.getDouble(5));
				menu.setEstado(Menu.Estado.valueOf(rs.getString(6)));
				menu.setCategoria(cat.obtener(rs.getInt(7)));
				lista.add(menu);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
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
	            pstmt.setInt(4, menu.getCategoria().getId());
	            
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
	            pstmt.setInt(5, menu.getCategoria().getId());
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
	        String sql = "SELECT * FROM menu WHERE id = ?";
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
	                    menu.setEstado(Menu.Estado.valueOf(rs.getString("estado")));
	                    menu.setCategoria(cat.obtener(rs.getInt("id_categoria")));
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
		List<Menu> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre, descripcion, imagen, precio, estado, id_categoria").append(" FROM menu WHERE nombre = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString())) {
			ps.setString(1, titulo);
			try (ResultSet rs = ps.executeQuery()) {
				lista = new ArrayList<>();
				while (rs.next()) {
					Menu menu = new Menu();
					menu.setId(rs.getInt(1));
					menu.setNombre(rs.getString(2));
					menu.setDescripcion(rs.getString(3));
					menu.setImagen(rs.getString(4));
					menu.setPrecio(rs.getDouble(5));
					menu.setEstado(Menu.Estado.valueOf(rs.getString(6)));
					menu.setCategoria(cat.obtener(rs.getInt(7)));
					lista.add(menu);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}


}
