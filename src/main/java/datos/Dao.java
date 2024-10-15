package datos;

import java.util.List;
public interface Dao<T> {
	public List<T> consultar();
	public boolean agregar(T objeto);
	public boolean editar(T objeto);
	public boolean eliminar(int codigo);
	public T obtener(int codigo);
}
/*
public interface Dao<U> {
	public List<U> listarTrabajador();
	
	public boolean editarTrabajador(U objeto);
	public boolean eliminarTrabajador(int codigo);
	public U obtenerTrabajador(int codigo);
}
*/
