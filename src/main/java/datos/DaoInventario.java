package datos;

import modelo.Inventario;

public interface DaoInventario extends Dao<Inventario> {
	public boolean editarStock(Inventario objeto);
}
