package datos;

import modelo.Trabajador;

//Vas a llamar a la interface Dao con el tipo Usuario
public interface DaoTrabajador extends Dao<Trabajador>{
	Trabajador validarUsuario(String usuario, String password);
}





