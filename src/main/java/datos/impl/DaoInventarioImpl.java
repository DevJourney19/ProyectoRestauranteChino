package datos.impl;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

import datos.DaoCategoria;
import datos.DaoInventario;
import datos.DaoTrabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import modelo.Inventario;
import util.Conexion;
import util.GestionarImagen;

public class DaoInventarioImpl implements DaoInventario {

	Conexion con;
	private DaoCategoria cat;
	private GestionarImagen subir;

	public DaoInventarioImpl() {
		con = new Conexion();
		cat = new DaoCategoriaImpl();
		subir = new GestionarImagen();
	}

	@Override
	public List<Inventario> consultar() {
		List<Inventario> lista = new ArrayList<>();
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, url_imagen FROM inventario";

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
				inventario.setUrlImagen(rs.getString(10));
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

		try (Connection c = con.getConexion()) {
			try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				ps.setInt(1, objeto.getCategoria().getId());
				ps.setString(2, objeto.getNombre());
				ps.setString(3, objeto.getUnidad().toString());
				ps.setDouble(4, objeto.getPrecioUnitario());
				ps.setInt(5, objeto.getInventarioInicial());
				ps.setInt(6, objeto.getStock());
				ps.setInt(7, objeto.getStockMin());
				ps.setString(8, objeto.getCaducidad().toString());

				if (ps.executeUpdate() != 0) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						if (rs.next()) {
							int ultimoRegistro = rs.getInt(1);
							objeto.setId(ultimoRegistro);
							String urlImagen = subir.guardarImagen(objeto);
							if (urlImagen == null) {
								return false;
							}
							objeto.setUrlImagen(urlImagen);
							if (editarImagen(objeto)) {
								return true;
							}
						}
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			Part archivoImagen = objeto.getArchivoImagen();
			if (ps.executeUpdate() != 0) {
				if ((archivoImagen != null || archivoImagen.getSize() != 0) && subir.existeImagen(objeto) && !subir.eliminarImagen(objeto)) {
				    return false;
				}

				String urlImagen = subir.guardarImagen(objeto);
				if (urlImagen == null) {
				    return false;
				}

				objeto.setUrlImagen(urlImagen);
				return editarImagen(objeto);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ServletException e) {
			e.printStackTrace();
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
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, url_imagen FROM inventario WHERE id = ?";

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
					inventario.setUrlImagen(rs.getString(10));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return inventario;
	}

	@Override
	public boolean editarImagen(Inventario objeto) {
		String sql = "UPDATE inventario SET url_imagen = ? WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, objeto.getUrlImagen());
			ps.setInt(2, objeto.getId());
			int filasActualizadas = ps.executeUpdate();
			if (filasActualizadas > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo, Inventario objeto) {
	    String sql = "DELETE FROM inventario WHERE id = ?";

	    try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setInt(1, codigo);

	        if (ps.executeUpdate() != 0) {
	            if (subir.existeImagen(objeto) && subir.eliminarImagen(objeto)) {
	                return true; 
	            } else {
	                return false;
	            }
	        } else {
	            System.out.println("No se pudo eliminar el inventario con id: " + codigo);
	            return false;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error SQL: " + e.getMessage());
	    } catch (ServletException e) {
	        System.out.println("Error al eliminar la imagen: " + e.getMessage());
	    }
	    return false;
	}

	@Override
	public boolean editarStock(Inventario objeto) {
		String sql = "UPDATE inventario SET stock = ? WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, objeto.getStock());
			ps.setInt(2, objeto.getId());
			int filasActualizadas = ps.executeUpdate();
			if (filasActualizadas > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}


}
