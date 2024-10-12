package datos;
import modelo.*;
import java.sql.*;
import java.util.List;
//Vas a llamar a la interface Dao con el tipo Usuario
public interface DaoTrabajador extends Dao<Trabajador> {
	//Se añadirán métodos específicos para el trabajador.
	public List<Trabajador> consultar(String rol);
}