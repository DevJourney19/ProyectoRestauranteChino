package datos.impl;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import util.Conexion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import datos.DaoTrabajador;
import modelo.Rol;
import modelo.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import modelo.Trabajador;
import util.Conexion;

//La interface Mozo_dao trae tanto sus metodos específicos, como los que extiende.
public class DaoTrabajadorImpl implements DaoTrabajador {

	Conexion con;
	PreparedStatement ps;
	ResultSet rs;
	Rol role;

	public DaoTrabajadorImpl() {
		con = new Conexion();
	}


	// Absolutamente todos los trabajadores
	@Override
	public List<Trabajador> consultar() {

		List<Trabajador> lista = new ArrayList<>();
		String sql = "Select * from trabajadores";
		try {
			ps = con.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// Pongo rs como parametro porque es el resultado obtenido de la consulta
				Trabajador trabajador = traer_bd(rs);
				lista.add(trabajador);
				System.out.println("trabajador: " + trabajador);
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
		// creo un array
		String[] valorsitos = obtener_info(trabajador);
		// almaceno la informacion del trabajador a agregar a la base de datos

		String sql = "INSERT INTO trabajadores (apellido, nombre, dni, correo, usuario, password, celular, id_rol) values(?,?,?,?,?,?,?,?);";
		try {
			// Preparar la consulta
			ps = con.getConexion().prepareStatement(sql);
			int id_rol = Integer.parseInt(valorsitos[8]);
			// Asignar a los parametros
			for (int i = 1; i < valorsitos.length; i++) {
				ps.setString((i), valorsitos[i]);
			}
			ps.setInt(8, id_rol);
			// Ejecutamos la consulta correspondiente
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
		String valorsitos[] = obtener_info(trabajador);

		String sql = "UPDATE trabajadores SET apellido=?, "
				+ "nombre=?, dni=?, correo=?, usuario=?, password=?, celular=?, id_rol=? where id=?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			for (int i = 1; i < valorsitos.length; i++) {
				ps.setString((i), valorsitos[i]);
			}
			int id = Integer.parseInt(valorsitos[0]);
			int id_rol = Integer.parseInt(valorsitos[8]);
			ps.setInt(8, id_rol);
			// El id del where
			ps.setInt(9, id);
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
		String sql = "delete from trabajadores where id=?";

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

		String sql = "Select * from trabajadores where id = ?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			// tra = new Trabajador();

			// Mueve el cursor a la primera fila
			if (rs.next()) {
				return traer_bd(rs); // Solo llama a traer_bd si hay una fila
			} else {
				System.out.println("No se encontraron trabajadores con el ID proporcionado.");
				return null; // No hay resultados
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
			tra.setApellido(rs.getString("apellido"));
			tra.setNombre(rs.getString("nombre"));
			tra.setDni(rs.getString("dni"));
			tra.setCorreo(rs.getString("correo"));
			tra.setCelular(rs.getString("celular"));
			tra.setNombreUsuario(rs.getString("usuario"));
			tra.setContrasenia(rs.getString("password"));
			// Para el objeto Rol, necesito primero traer el id de la bd que viene a ser la
			// llave foránea, para que posteriormente pueda crear el respectivo objeto.
			int rol_id = rs.getInt("id_rol");
			role = new Rol(rol_id);
			// Asignamos el rol como llave foránea al trabajador
			tra.setRol(role);
			return tra;

		} catch (Exception e) {
			System.out.println("Error en traer_bd: " + e.getMessage());
		}
		return null;

	}

	// Traer el valor de cada columna de de la primera fila
	public String[] obtener_info(Trabajador tra) {
		String[] valores = { String.valueOf(tra.getId()), tra.getApellido(), tra.getNombre(), tra.getDni(),
				tra.getCorreo(), tra.getNombreUsuario(), tra.getContrasenia(), tra.getCelular(),
				String.valueOf(tra.getRol().getId()) };
		System.out.println("Codigo rol" + tra.getRol().getId());
		return valores;
	}

	/* LOGIN TRABAJADOR */
	public Trabajador validarUsuario(String usuario, String password) {
		Trabajador trabajador = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = con.getConexion();
			if (conn == null) {
				throw new SQLException("No se pudo establecer la conexión a la base de datos");
			}

			String sql = "SELECT * FROM trabajadores WHERE usuario = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				byte[] storedHash = rs.getBytes("password");
				if (storedHash != null) {
					String storedHashStr = new String(storedHash, StandardCharsets.UTF_8);

					if (BCrypt.checkpw(password, storedHashStr)) {
						trabajador = new Trabajador();
						trabajador.setId(rs.getInt("id"));
						trabajador.setNombre(rs.getString("nombre"));
						trabajador.setApellido(rs.getString("apellido"));
						trabajador.setNombreUsuario(rs.getString("usuario"));
						// trabajador.setId_rol(rs.getInt("id_rol"));
						trabajador.setCelular(rs.getString("telefono"));
					}

				}
			}
		} catch (SQLException e) {
			System.err.println("Error SQL en validarUsuario: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error general en validarUsuario: " + e.getMessage());
			e.printStackTrace();
		} finally {
			cerrarRecursos(conn, stmt, rs);
		}

		return trabajador;
	}

	public String obtenerRol(int id_rol) {
		String rol = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = con.getConexion();
			if (conn == null) {
				throw new SQLException("No se pudo establecer la conexión a la base de datos");
			}

			String sql = "SELECT nombre FROM rol WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_rol);
			rs = ps.executeQuery();

			if (rs.next()) {
				rol = rs.getString("nombre");
			} else {
				System.out.println("No se encontró el rol con ID: " + id_rol);
			}
		} catch (SQLException e) {
			System.err.println("Error SQL en obtenerRol: " + e.getMessage());
			e.printStackTrace();
		} finally {
			cerrarRecursos(conn, ps, rs);
		}

		return rol;
	}

	private void cerrarRecursos(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar recursos: " + e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	public boolean agregarTrabajador(Trabajador objeto, String passwordPlano) {
		// TODO Auto-generated method stub
		return false;
	}
}
