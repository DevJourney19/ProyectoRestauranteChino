package datos.impl;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import util.Conexion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import datos.DaoRol;
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

		String sql = "INSERT INTO trabajador (nombre, apellido, usuario, password, telefono, id_rol) values(?,?,?,?,?,?);";
		try {
			// Preparar la consulta
			ps = con.getConexion().prepareStatement(sql);
			int id_rol = Integer.parseInt(valorsitos[8]);
			// Asignar a los parametros
			for (int i = 1; i < valorsitos.length; i++) {
				ps.setString((i), valorsitos[i]);
			}
			String passHash = BCrypt.hashpw(valorsitos[6], BCrypt.gensalt()); // Generar el Hash
			ps.setString(6, passHash);
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

		String sql = "UPDATE trabajador SET apellido=?, "
				+ "nombre=?, correo=?, usuario=?, password=?, celular=?, id_rol=? where id=?";
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

	// Traer el valor de cada columna de de la primera fila
	public String[] obtener_info(Trabajador tra) {
		String[] valores = { String.valueOf(tra.getId()), tra.getApellido(), tra.getNombre(),
				tra.getCorreo(), tra.getNombreUsuario(), tra.getContrasenia(), tra.getCelular(),
				String.valueOf(tra.getRol().getId()) };
		System.out.println("Codigo rol" + tra.getRol().getId());
		return valores;
	}

	/* LOGIN TRABAJADOR */
	@Override
	public Trabajador validarUsuario(String usuario, String password) {
		Trabajador trabajador = null;
		ps = null;
		rs = null;
		String sql = "SELECT id, nombre, apellido, usuario, password, telefono, id_rol FROM trabajador WHERE usuario = ?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, usuario);
			rs = ps.executeQuery();

			if (rs.next()) {
				String pass_bd = rs.getString("password");
				System.out.println("Contraseña ingresada: " + password);
				System.out.println("Contraseña cifrada (BD): " + pass_bd);
				System.out.println("¿Las contraseñas coinciden? " + BCrypt.checkpw(password, pass_bd));
				/*Se utilizará la salt de pass_bd para poder convertir password a hash y poder verificar si son iguales*/
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
		} catch (
		SQLException e) {
			System.err.println("Error SQL en validarUsuario: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error general en validarUsuario: " + e.getMessage());
			e.printStackTrace();
		} finally {
			cerrarRecursos(ps, rs);
		}

		return trabajador;
	}

	private void cerrarRecursos(PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException e) {
			System.err.println("Error al cerrar recursos: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
