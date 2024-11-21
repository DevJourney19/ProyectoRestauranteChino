package datos;

import java.util.List;

import modelo.Menu;

public interface DaoMenu extends Dao<Menu> {
	List<Menu> filtrar(String titulo);
}
