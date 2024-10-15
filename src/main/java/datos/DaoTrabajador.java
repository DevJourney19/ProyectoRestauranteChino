package datos;

import modelo.Trabajador;

//Vas a llamar a la interface Dao con el tipo Usuario
public interface DaoTrabajador extends Dao<Trabajador>{
	//Se añadirán métodos específicos para el trabajador.
	public boolean agregarTrabajador(Trabajador objeto, String passwordPlano);
}





