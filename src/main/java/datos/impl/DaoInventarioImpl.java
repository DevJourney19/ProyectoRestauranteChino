package datos.impl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import datos.DaoCategoria;
import datos.DaoInventario;
import jakarta.servlet.http.Part;
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
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, imagen, tipo_imagen FROM inventario";

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
				byte[] imagenBytes = rs.getBytes(10);
				if (imagenBytes != null) {
					String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
					inventario.setImagen(imagenBase64);
				} else {
					inventario.setImagen(null);
				}
				inventario.setTipoImagen(rs.getString(11));
				lista.add(inventario);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Inventario agregar(Inventario objeto) {
		String sql = "INSERT INTO inventario (id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, imagen, tipo_imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

				Part archivoImagen = objeto.getArchivoImagen();

				if (archivoImagen != null) {
					ps.setBlob(9, archivoImagen.getInputStream());
				} else {
					ps.setNull(9, java.sql.Types.BLOB);
				}
				String mimeType = archivoImagen.getContentType();
				ps.setString(10, mimeType);

				ps.executeUpdate();
				return objeto;
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editar(Inventario objeto) {
		String sql = "UPDATE inventario SET id_categoria = ?, nombre = ?, unidad = ?, precio_unitario = ?, inventario_inicial = ?, stock = ?, stock_min = ?, caducidad = ?, imagen = ?, tipo_imagen = ? WHERE id = ?";

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, objeto.getCategoria().getId());
			ps.setString(2, objeto.getNombre());
			ps.setString(3, objeto.getUnidad().toString());
			ps.setDouble(4, objeto.getPrecioUnitario());
			ps.setInt(5, objeto.getInventarioInicial());
			ps.setInt(6, objeto.getStock());
			ps.setInt(7, objeto.getStockMin());
			ps.setString(8, objeto.getCaducidad().toString());

			if (objeto.getArchivoImagen() != null) {
				Part archivoImagen = objeto.getArchivoImagen();
				ps.setBlob(9, archivoImagen.getInputStream());
			} else {
				String imagenBase64 = objeto.getImagen();
				byte[] imagenBytes = Base64.getDecoder().decode(imagenBase64);

				Blob imagenBlob = c.createBlob();
				imagenBlob.setBytes(1, imagenBytes);
				ps.setBlob(9, imagenBlob);
			}
			ps.setString(10, objeto.getTipoImagen());

			ps.setInt(11, objeto.getId());
			return ps.executeUpdate() != 0;
		} catch (SQLException | IOException e) {
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
		String sql = "SELECT id, id_categoria, nombre, unidad, precio_unitario, inventario_inicial, stock, stock_min, caducidad, i FROM inventario WHERE id = ?";

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
					byte[] imagenBytes = rs.getBytes(10);
					if (imagenBytes != null) {
						String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
						inventario.setImagen(imagenBase64);
					} else {
						inventario.setImagen(null);
					}
					inventario.setTipoImagen(rs.getString(11));
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
