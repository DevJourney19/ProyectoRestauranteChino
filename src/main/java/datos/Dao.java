package datos;

import java.util.List;
public interface Dao<T> {
	public List<T> consultar();
	public T agregar(T objeto);
	public boolean editar(T objeto);
	public boolean eliminar(int codigo);
	public T obtener(int codigo);
}

