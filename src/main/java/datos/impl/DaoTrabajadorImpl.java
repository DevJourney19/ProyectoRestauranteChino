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
				Trabajador tra = traer_bd(rs);
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
		int id_rol = Integer.parseInt(valorsitos[6]);
		String sql = "INSERT INTO trabajadores (nombre, apellido, usuario, password, telefono, id_rol) values(?,?,?,?,?,?);";
		try {
			// Preparar la consulta
			ps = con.getConexion().prepareStatement(sql);
			// Asignar a los parametros
			for (int i = 1; i < valorsitos.length; i++) {
				ps.setString((i), valorsitos[i]);
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
		
		String sql = "UPDATE trabajadores SET nombre=?, "
				+ "apellido=?, usuario=?, password=?, telefono=?, id_rol=? where id=?";
		try {
			ps = con.getConexion().prepareStatement(sql);
			for (int i = 1; i < valorsitos.length; i++) {
				ps.setString((i), valorsitos[i]);
			}
			int id = Integer.parseInt(valorsitos[0]);
			int id_rol = Integer.parseInt(valorsitos[6]);
			ps.setInt(6, id_rol);
			// El id del where
			ps.setInt(7, id);
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
		String[] valores = { String.valueOf(tra.getCodigo()), tra.getNombre(), 
				tra.getApellido(), tra.getNombreUsuario(), tra.getContrasenia(),
				tra.getCelular(), String.valueOf(tra.getRol().getCodigo()) };
		System.out.println("Codigo rol"+tra.getRol().getCodigo());
		return valores;
	}

}
