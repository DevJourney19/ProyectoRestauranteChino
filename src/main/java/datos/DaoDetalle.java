package datos;

import java.util.List;

import modelo.DetallePedido;

public interface DaoDetalle extends Dao<DetallePedido> {
	List<Object[]> verData(int id);
	void eliminarPorPedido(Integer id_pedido);
}
