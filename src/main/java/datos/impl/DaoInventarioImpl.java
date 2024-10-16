package datos.impl;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

import datos.DaoCategoria;
import datos.DaoInventario;
import datos.DaoTrabajador;
import modelo.Inventario;
import util.Conexion;

public class DaoInventarioImpl implements DaoInventario {

	Conexion con;
	private DaoCategoria cat;

	public DaoInventarioImpl() {
		con = new Conexion();
		cat = new DaoCategoriaImpl();
	}

	@Override
	public List<Inventario> consultar() {
		List<Inventario> lista = new ArrayList<>();
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad FROM inventario";

		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Inventario inventario = new Inventario();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				inventario.setId(rs.getInt(1));
				inventario.setCategoria(cat.obtener(rs.getInt(2)));
				inventario.setNombre(rs.getString(3));
				inventario.setUnidad(Inventario.Unidad.valueOf(rs.getString(4)));
				inventario.setPrecioUnitario(rs.getDouble(5));
				inventario.setInventarioInicial(rs.getInt(6));
				inventario.setStock(rs.getInt(7));
				inventario.setStockMin(rs.getInt(8));
				inventario.setCaducidad(LocalDate.parse(rs.getString(9), formato));
				lista.add(inventario);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean agregar(Inventario objeto) {
		String sql = "INSERT INTO inventario (id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, objeto.getCategoria().getId());
			ps.setString(2, objeto.getNombre());
			ps.setString(3, objeto.getUnidad().toString());
			ps.setDouble(4, objeto.getPrecioUnitario());
			ps.setInt(5, objeto.getInventarioInicial());
			ps.setInt(6, objeto.getStock());
			ps.setInt(7, objeto.getStockMin());
			ps.setString(8, objeto.getCaducidad().toString());
			return (ps.executeUpdate() != 0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean editar(Inventario objeto) {
		String sql = "UPDATE inventario SET id_categoria = ?, nombre = ?, unidad = ?, precio_unitario = ?, inventario_inicial = ?, stock = ?, stock_min = ?, caducidad = ? WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, objeto.getCategoria().getId());
			ps.setString(2, objeto.getNombre());
			ps.setString(3, objeto.getUnidad().toString());
			ps.setDouble(4, objeto.getPrecioUnitario());
			ps.setInt(5, objeto.getInventarioInicial());
			ps.setInt(6, objeto.getStock());
			ps.setInt(7, objeto.getStockMin());
			ps.setString(8, objeto.getCaducidad().toString());
			ps.setInt(9, objeto.getId());
			return (ps.executeUpdate() != 0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		String sql = "DELETE FROM inventario WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, codigo);
			return (ps.executeUpdate() != 0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Inventario obtener(int codigo) {
		Inventario inventario = null;
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, id_trabajador FROM inventario WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, codigo);
			try (ResultSet rs = ps.executeQuery()) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				if (rs.next()) {
					inventario = new Inventario();
					inventario.setId(rs.getInt(1));
					inventario.setCategoria(cat.obtener(rs.getInt(2)));
					inventario.setNombre(rs.getString(3));
					inventario.setUnidad(Inventario.Unidad.valueOf(rs.getString(4)));
					inventario.setPrecioUnitario(rs.getDouble(5));
					inventario.setInventarioInicial(rs.getInt(6));
					inventario.setStock(rs.getInt(7));
					inventario.setStockMin(rs.getInt(8));
					inventario.setCaducidad(LocalDate.parse(rs.getString(9), formato));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return inventario;
	}

}
