package datos;

import java.util.List;

import modelo.Cliente;
import modelo.Pedido;

public interface DaoPedido extends Dao<Pedido>  {
	 List<Object[]> verData();
	 Cliente dataCliente(Integer idPed);
}
