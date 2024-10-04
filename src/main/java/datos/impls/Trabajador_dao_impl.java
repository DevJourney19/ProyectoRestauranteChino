package datos.impls;

import java.sql.*;
import java.util.Iterator;

import datos.Trabajador_dao;
import modelo.Rol;
import modelo.Trabajador;

//La interface Mozo_dao trae tanto sus metodos específicos, como los que extiende.
public class Trabajador_dao_impl implements Trabajador_dao {

	String url = "jdbc:mysql://localhost:3306/restaurante";
	String driver = "com.mysql.cj.jdbc.Driver";
	String usuario = "root";
	String clave = "";

	Connection con;
	PreparedStatement ps;

	@Override
	public Connection conectarBD() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, clave);

		} catch (Exception e) {
			System.out.println("Error en la conexión: " + e.getMessage());
			desconectar();
		}
		return con;
	}

	@Override
	public ResultSet consultar(String rol) {
		ResultSet rs = null;
		Rol role = new Rol(rol);
		String nombre = role.getNombre();
		try {
			String sql = "Select * from trabajadores where rol ='?'";
			ps.setString(1, nombre);
			ps = conectarBD().prepareStatement(sql);
			rs = ps.executeQuery();

		} catch (Exception e) {
			System.out.println("Error en el consultar: " + e.getMessage());
			desconectar();
		}
		return rs;
	}

	// Absolutamente todos los trabajadores
	@Override
	public ResultSet consultar() {
		ResultSet rs = null;
		String sql = "Select * from trabajadores";
		try {
			ps = conectarBD().prepareStatement(sql);
			rs = ps.executeQuery();

		} catch (Exception e) {
			System.out.println("Error en el consultar a todos los trabajadores: " + e.getMessage());
			desconectar();
		}
		return rs;
	}

	@Override
	public boolean agregar(Trabajador trabajador) {
		String[] valorsito = obtener_info(trabajador);
		int id_rol = Integer.parseInt(valorsito[6]);
		String sql = "insert into trabajador values (?,?,?,?,?,?,?);";
		try {
			ps.setString(1, valorsito[0]);
			ps.setString(2, valorsito[1]);
			ps.setString(3, valorsito[2]);
			ps.setString(4, valorsito[3]);
			ps.setString(5, valorsito[4]);
			ps.setString(6, valorsito[5]);
			ps.setInt(6, id_rol);

			ps = conectarBD().prepareStatement(sql);
			int rs = ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el agregar trabajadores: " + e.getMessage());
			desconectar();
		}
		return false;
	}

	@Override
	public boolean editar(Trabajador trabajador) {

		String valorsitos[] = obtener_info(trabajador);
		int id_rol = Integer.parseInt(valorsitos[6]);
		String sql = "UPDATE trabajadores SET codigo=?, nombre=?, "
				+ "apellido=?, usuario=?, contrasenia=?, celular=?, id_rol='?'";
		try {
			ps.setString(1, valorsitos[0]);
			ps.setString(2, valorsitos[1]);
			ps.setString(3, valorsitos[2]);
			ps.setString(4, valorsitos[3]);
			ps.setString(5, valorsitos[4]);
			ps.setString(6, valorsitos[5]);
			ps.setInt(7, id_rol);
			ps = conectarBD().prepareStatement(sql);
			int rs = ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el actualizar trabajadores: " + e.getMessage());
			desconectar();
		}
		return false;
	}

	public String[] obtener_info(Trabajador trabajadoor) {

		String[] valores = { trabajadoor.getCodigo(), trabajadoor.getNombre(), trabajadoor.getApellido(),
				trabajadoor.getNombreUsuario(), trabajadoor.getContrasenia(), trabajadoor.getCelular(),
				String.valueOf(trabajadoor.getId_rol()) };
		return valores;
	}

	@Override
	public boolean eliminar(int codigo) {
		String sql = "delete from trabajadores where codigo='?'";

		try {
			ps.setInt(1, codigo);
			ps = conectarBD().prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el eliminar trabajadores: " + e.getMessage());
			desconectar();
		}
		return false;
	}

	@Override
	public boolean buscar(String nombre) {

		String sql = "Select * from trabajadores where nombre = ?";
		try {
			ps.setString(1, nombre);
			ps = conectarBD().prepareStatement(sql);
			ps.executeQuery();
			return true;
		} catch (Exception e) {
			System.out.println("Error en el buscar trabajadores: " + e.getMessage());
			desconectar();
		}
		return false;
	}

	@Override
	public void desconectar() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión: " + e.getMessage());
			}
		}

	}

}
