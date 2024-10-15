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

	@Override
	public boolean agregar(Menu objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Menu objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Menu obtener(int codigo) {
		// TODO Auto-generated method stub
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
