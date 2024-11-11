package datos.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

import datos.DaoRol;
import datos.DaoTrabajador;
import modelo.Trabajador;
import util.Conexion;

//La interface Mozo_dao trae tanto sus metodos específicos, como los que extiende.
public class DaoTrabajadorImpl implements DaoTrabajador {

	Conexion con;
	PreparedStatement ps;
	ResultSet rs;
	DaoRol rol;

	public DaoTrabajadorImpl() {
		con = new Conexion();
		rol = new DaoRolImpl();
	}

	// Absolutamente todos los trabajadores
	@Override
	public List<Trabajador> consultar() {

		List<Trabajador> lista = new ArrayList<>();
		String sql = "Select * from trabajador";
		try {
			ps = con.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Trabajador trabajador = traer_bd(rs);
				lista.add(trabajador);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("Error en el consultar a todos los trabajadores: " + e.getMessage());
			con.closeConexion();
		}
		return null;
	}

	@Override
	public boolean agregar(Trabajador trabajador) {

		String sql = "INSERT INTO trabajador (nombre, apellido, usuario, password, telefono, id_rol) values(?,?,?,?,?,?);";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, trabajador.getNombre());
			ps.setString(2, trabajador.getApellido());
			ps.setString(3, trabajador.getNombreUsuario());
			String passHash = BCrypt.hashpw(trabajador.getContrasenia(), BCrypt.gensalt()); // Generar el Hash
			ps.setString(4, passHash);
			ps.setString(5, trabajador.getCelular());
			ps.setInt(6, trabajador.getRol().getId());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el agregar trabajadores: " + e.getMessage());
			con.closeConexion();
		}
		return false;
	}

	@Override
	public boolean editar(Trabajador trabajador) {

		String sql = "UPDATE trabajador SET apellido=?, "
				+ "nombre=?, usuario=?, password=?, telefono=?, id_rol=? where id=?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, trabajador.getApellido());
			ps.setString(2, trabajador.getNombre());
			ps.setString(3, trabajador.getNombreUsuario());
			String passHash = BCrypt.hashpw(trabajador.getContrasenia(), BCrypt.gensalt()); // Generar el Hash
			ps.setString(4, passHash);
			ps.setString(5, trabajador.getCelular());
			ps.setInt(6, trabajador.getRol().getId());
			ps.setInt(7, trabajador.getId());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el actualizar trabajadores: " + e.getMessage());
			con.closeConexion();
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		String sql = "delete from trabajador where id=?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el eliminar trabajadores: " + e.getMessage());
			con.closeConexion();
			return false;
		}

	}

	@Override
	public Trabajador obtener(int codigo) {

		String sql = "Select * from trabajador where id = ?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			if (rs.next()) {
				return traer_bd(rs);
			} else {
				System.out.println("No se encontraron trabajadores con el ID proporcionado.");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error en el buscar trabajadores: " + e.getMessage());
			con.closeConexion();
			return null;
		}

	}

	// Metodos para acortar lineas de codigo
	private Trabajador traer_bd(ResultSet rs) throws SQLException {
		Trabajador tra = new Trabajador();
		try {

			tra.setId(rs.getInt("id"));
			tra.setNombre(rs.getString("nombre"));
			tra.setApellido(rs.getString("apellido"));
			tra.setNombreUsuario(rs.getString("usuario"));
			tra.setContrasenia(rs.getString("password"));
			tra.setCelular(rs.getString("telefono"));
			tra.setRol(rol.obtener(rs.getInt("id_rol")));
			return tra;

		} catch (Exception e) {
			System.out.println("Error en traer_bd: " + e.getMessage());
		}
		return null;

	}

	/* LOGIN TRABAJADOR */
	@Override
	public Trabajador validarUsuario(String usuario, String password) {
		Trabajador trabajador = null;
		ps = null;
		rs = null;
		String sql = "SELECT * FROM trabajador WHERE usuario = ?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, usuario);
			rs = ps.executeQuery();

			if (rs.next()) {
				String pass_bd = rs.getString("password");
				if (BCrypt.checkpw(password, pass_bd)) {
					trabajador = new Trabajador();
					trabajador.setId(rs.getInt("id"));
					trabajador.setNombre(rs.getString("nombre"));
					trabajador.setApellido(rs.getString("apellido"));
					trabajador.setNombreUsuario(rs.getString("usuario"));
					trabajador.setContrasenia(rs.getString("password"));
					trabajador.setCelular(rs.getString("telefono"));
					trabajador.setRol(rol.obtener(rs.getInt("id_rol")));
				}

			} else {
				System.out.println("Usuario no encontrado");
				return null;
			}
			return trabajador;
		} catch (SQLException e) {
			System.err.println("Error SQL en validar Usuario: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error general en validar Usuario: " + e.getMessage());
			e.printStackTrace();
		} finally {
			cerrarRecursos(ps, rs);
		}

		return trabajador;
	}

	@Override
	public List<Trabajador> filtrar(String titulo) {
		List<Trabajador> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre, apellido, usuario, password, telefono, id_rol").append(" FROM trabajador WHERE nombre = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString())) {
			ps.setString(1, titulo);
			try (ResultSet rs = ps.executeQuery()) {
				lista = new ArrayList<>();
				while (rs.next()) {
					Trabajador trab = new Trabajador();
					trab.setId(rs.getInt(1));
					trab.setNombre(rs.getString(2));
					trab.setApellido(rs.getString(3));
					trab.setNombreUsuario(rs.getString(4));
					trab.setContrasenia(rs.getString(5));
					trab.setCelular(rs.getString(6));
					trab.setRol(rol.obtener(rs.getInt(7)));
					lista.add(trab);
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
