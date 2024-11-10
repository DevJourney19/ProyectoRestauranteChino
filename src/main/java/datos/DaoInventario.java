package datos;

import modelo.Inventario;

public interface DaoInventario extends Dao<Inventario> {
	public boolean editarImagen(Inventario objeto);
	public boolean editarStock(Inventario objeto);
	public boolean eliminar(int codigo, Inventario objeto);
}
