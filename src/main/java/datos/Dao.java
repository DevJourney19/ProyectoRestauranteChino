package datos;
import java.sql.*;
public interface Dao<T> {
	public Connection conectarBD();
	public void desconectar();
	public ResultSet consultar();
	public boolean agregar(T objeto);
	public boolean editar(T codigo);
	public boolean eliminar(int codigo);
	public boolean buscar(String nombre);
}
