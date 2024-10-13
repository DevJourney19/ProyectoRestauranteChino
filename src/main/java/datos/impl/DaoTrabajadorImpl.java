package datos.impl;

import java.sql.*;
import util.Conexion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import datos.DaoTrabajador;
import modelo.Rol;
import modelo.Trabajador;

//La interface Mozo_dao trae tanto sus metodos específicos, como los que extiende.
public class DaoTrabajadorImpl implements DaoTrabajador {

	Conexion con;
	PreparedStatement ps;
	ResultSet rs;
	Rol role;

	public DaoTrabajadorImpl() {
		con = new Conexion();
	}

	@SuppressWarnings("null")
	@Override
	public List<Trabajador> consultar(String rol) {
		List<Trabajador> lista = null;
		role = new Rol(rol);
		String nombre = role.getNombre();

		try {
			String sql = "Select * from trabajadores where rol ='?'";
			ps.setString(1, nombre);
			ps = con.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Trabajador tra = new Trabajador();
				traer_bd(tra);
				lista.add(tra);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("Error en el consultar: " + e.getMessage());
			con.closeConexion();
		}
		return null;
	}

	// Absolutamente todos los trabajadores
	@SuppressWarnings("null")
	@Override
	public List<Trabajador> consultar() {

		List<Trabajador> lista = null;
		String sql = "Select * from trabajadores";
		try {
			ps = con.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				//Corregir
				Trabajador tra = new Trabajador();
				System.out.println(traer_bd(tra).getApellido());
				
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
		int id_rol = Integer.parseInt(valorsitos[5]);
		String sql = "INSERT INTO trabajadores (nombre, apellido, usuario, password, telefono, id_rol) values(?,?,?,?,?,?);";
		try {
			// Preparar la consulta
			ps = con.getConexion().prepareStatement(sql);
			// Asignar a los parametros
			for (int i = 0; i < valorsitos.length; i++) {
				ps.setString((i + 1), valorsitos[i]);
			}
			ps.setInt(6, id_rol);
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
		int id_rol = Integer.parseInt(valorsitos[6]);
		String sql = "UPDATE trabajadores SET codigo=?, nombre=?, "
				+ "apellido=?, usuario=?, contrasenia=?, celular=?, id_rol='?' where codigo=?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			for (int i = 0; i < valorsitos.length; i++) {
				ps.setString((i + 1), valorsitos[i]);
			}
			ps.setInt(7, id_rol);
			// El id del where
			ps.setString(8, valorsitos[0]);
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
		String sql = "delete from trabajadores where codigo='?'";

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
		Trabajador tra = null;
		String sql = "Select * from trabajadores where codigo = ?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			tra = new Trabajador();

			return traer_bd(tra);
		} catch (Exception e) {
			System.out.println("Error en el buscar trabajadores: " + e.getMessage());
			con.closeConexion();
			return null;
		}

	}

	// Metodos para acortar lineas de codigo
	private Trabajador traer_bd(Trabajador tra) throws SQLException {

		tra.setCodigo(rs.getInt("id"));
		tra.setNombre(rs.getString("nombre"));
		tra.setApellido(rs.getString("apellido"));
		// Para el objeto Rol, necesito primero traer el id de la bd que viene a ser la
		// llave foránea, para que posteriormente pueda crear el respectivo objeto.
		int rol_id = rs.getInt("id_rol");
		role = new Rol(rol_id);
		// Asignamos el rol como llave foránea al trabajador
		tra.setRol(role);
		tra.setCelular(rs.getString("telefono"));
		tra.setNombreUsuario(rs.getString("usuario"));
		tra.setContrasenia(rs.getString("password"));
		return tra;
	}

	// Traer el valor de cada columna de de la primera fila
	public String[] obtener_info(Trabajador tra) {
		String[] valores = { tra.getNombre(), tra.getApellido(), tra.getNombreUsuario(), tra.getContrasenia(),
				tra.getCelular(), String.valueOf(tra.getRol().getCodigo()) };
		return valores;
	}

}
