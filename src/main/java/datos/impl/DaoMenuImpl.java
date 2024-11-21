package datos.impl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import datos.DaoCategoria;
import datos.DaoMenu;
import jakarta.servlet.http.Part;
import modelo.Menu;
import util.Conexion;

public class DaoMenuImpl implements DaoMenu {

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
		sql.append("SELECT ").append("id, nombre, descripcion, imagen, precio, estado, id_categoria, tipo_imagen")
				.append(" FROM menu");

		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery()) {

			lista = new ArrayList<>();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt(1));
				menu.setNombre(rs.getString(2));
				menu.setDescripcion(rs.getString(3));
				byte[] imagenBytes = rs.getBytes(4);
				if (imagenBytes != null) {
					String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
					menu.setImagen(imagenBase64);

				} else {
					menu.setImagen(null);
				}

				menu.setPrecio(rs.getDouble(5));
				menu.setEstado(Menu.Estado.valueOf(rs.getString(6)));
				menu.setCategoria(cat.obtener(rs.getInt(7)));
				menu.setTipoImagen(rs.getString(8));
				lista.add(menu);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Menu agregar(Menu menu) {
		String sql = "INSERT INTO menu (nombre, descripcion, precio, estado, id_categoria, imagen, tipo_imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = con.getConexion();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, menu.getNombre());
			pstmt.setString(2, menu.getDescripcion());
			pstmt.setDouble(3, menu.getPrecio());
			pstmt.setString(4, menu.getEstado().name());
			pstmt.setInt(5, menu.getCategoria().getId());

			Part archivoImagen = menu.getArchivoImagen();

			if (archivoImagen != null) {
				pstmt.setBlob(6, archivoImagen.getInputStream());
			} else {
				pstmt.setNull(6, java.sql.Types.BLOB);
			}
			String mimeType = archivoImagen.getContentType();
			pstmt.setString(7, mimeType);

			pstmt.executeUpdate();
			return menu;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editar(Menu menu) {
		String sql = "UPDATE menu SET nombre = ?, descripcion = ?, precio = ?, estado =?, id_categoria = ?, imagen = ?, tipo_imagen = ? WHERE id = ?";
		try (Connection conn = con.getConexion();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, menu.getNombre());
			pstmt.setString(2, menu.getDescripcion());
			pstmt.setDouble(3, menu.getPrecio());
			pstmt.setString(4, menu.getEstado().name());
			pstmt.setInt(5, menu.getCategoria().getId());

			if (menu.getArchivoImagen() != null) {
				Part archivoImagen = menu.getArchivoImagen();
				pstmt.setBlob(6, archivoImagen.getInputStream());
			} else {
				String imagenBase64 = menu.getImagen();
				byte[] imagenBytes = Base64.getDecoder().decode(imagenBase64);

				Blob imagenBlob = conn.createBlob();
				imagenBlob.setBytes(1, imagenBytes);
				pstmt.setBlob(6, imagenBlob);
			}
			pstmt.setString(7, menu.getTipoImagen());

			pstmt.setInt(8, menu.getId());

			return pstmt.executeUpdate() != 0;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	// Eliminar menu
	public boolean eliminar(int id) {
		String sql = "DELETE FROM menu WHERE id = ?";
		try (Connection conn = con.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			int affectedRows = pstmt.executeUpdate();
			return affectedRows != 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	// Obtener un menu por su ID
	public Menu obtener(int id) {
		String sql = "SELECT * FROM menu WHERE id = ?";
		try (Connection conn = con.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
					byte[] imagenBytes = rs.getBytes("imagen");
					if (imagenBytes != null) {
						String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
						menu.setImagen(imagenBase64);
					} else {
						menu.setImagen(null);
					}
					menu.setTipoImagen(rs.getString("tipo_imagen"));
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
		sql.append("SELECT ").append("id, nombre, descripcion, imagen, precio, estado, id_categoria, tipo_imagen")
				.append(" FROM menu WHERE nombre = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString())) {
			ps.setString(1, titulo);
			try (ResultSet rs = ps.executeQuery()) {
				lista = new ArrayList<>();
				while (rs.next()) {
					Menu menu = new Menu();
					menu.setId(rs.getInt(1));
					menu.setNombre(rs.getString(2));
					menu.setDescripcion(rs.getString(3));
					byte[] imagenBytes = rs.getBytes(4);
					if (imagenBytes != null) {
						String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
						menu.setImagen(imagenBase64);
					} else {
						menu.setImagen(null);
					}
					menu.setPrecio(rs.getDouble(5));
					menu.setEstado(Menu.Estado.valueOf(rs.getString(6)));
					menu.setCategoria(cat.obtener(rs.getInt(7)));
					menu.setTipoImagen(rs.getString(8));
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

	private void cerrarRecursos(PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			System.err.println("Error al cerrar recursos: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
