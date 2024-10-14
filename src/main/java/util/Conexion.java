package util;
import java.sql.*;

public class Conexion {
    private static Connection connection = null;
    private final String URL = "jdbc:mysql://localhost/restaurante_chino";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "";
    

    public Connection getConexion() throws SQLException {
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return connection;
    }
    
	public void closeConexion() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión: " + e.getMessage());
			}
		}

	}

}
