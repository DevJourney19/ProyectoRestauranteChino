package datos;

import java.util.List;

import modelo.Categoria;

public interface DaoCategoria extends Dao<Categoria> {
	List<Categoria> filtrar(String tipo);
}
