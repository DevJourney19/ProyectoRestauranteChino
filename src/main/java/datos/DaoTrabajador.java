package datos;

import modelo.*;
import java.sql.*;
import java.util.List;
//Vas a llamar a la interface Dao con el tipo Usuario
public interface DaoTrabajador extends Dao<Trabajador> {
	//Se añadirán métodos específicos para el trabajador.
	public List<Trabajador> consultar(String rol);
}
=======
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

    
}

