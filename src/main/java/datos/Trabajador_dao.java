package datos;
import modelo.*;
import java.sql.*;
//Vas a llamar a la interface Dao con el tipo Usuario
public interface Trabajador_dao extends Dao<Trabajador> {
	//Se añadirán métodos específicos para el trabajador.
	public ResultSet consultar(String rol);
	
}