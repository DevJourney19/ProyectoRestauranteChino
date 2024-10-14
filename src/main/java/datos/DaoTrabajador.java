package datos;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import modelo.Trabajador;
import util.Conexion;

public class DaoTrabajador {
	private final Conexion conexion;

    public DaoTrabajador() {
        this.conexion = new Conexion();
    }

    public Trabajador validarUsuario(String usuario, String password) {
        Trabajador trabajador = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = conexion.getConexion();
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
                        trabajador.setCodigo(rs.getInt("id"));
                        trabajador.setNombre(rs.getString("nombre"));
                        trabajador.setApellido(rs.getString("apellido"));
                        trabajador.setNombreUsuario(rs.getString("usuario"));
                        trabajador.setId_rol(rs.getInt("id_rol"));
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
            conn = conexion.getConexion();
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
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
