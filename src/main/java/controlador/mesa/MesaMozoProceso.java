package controlador.mesa;

import java.io.IOException;

import datos.DaoMesa;
import datos.DaoPedido;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Mesa;
import modelo.Mesa.EstadoMesa;
import modelo.Trabajador;

@WebServlet(name = "MesaMozoProceso", urlPatterns = { "/MesaMozoProceso" })
public class MesaMozoProceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoMesa daoM = new DaoMesaImpl();
	DaoPedido daoPedi = new DaoPedidoImpl();

	// Ver los pedidos y ver como agregarlos
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccesRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccesRequest(request, response);
	}

	protected void proccesRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Trabajador trabajador = (Trabajador) session.getAttribute("usuario");

		System.out.println("Estas en MezaMozoProceso");
		// Obtener numero de mesa
		int id_mesa = Integer.parseInt(request.getParameter("mesa"));
		System.out.println("El numero de mesa es: " + id_mesa);

		Mesa mesa = new Mesa(); // Actualizamos la mesa que escogió
		mesa.setEstado(EstadoMesa.Ocupado);
		mesa.setN_mesa(id_mesa);
		mesa.setId(id_mesa);
		daoM.editar(mesa); // Necesito el id de mesa //Hare con
		// un foreach para obtener el id de la mesa

		// ============ ESTO DEBERÍA CREARSE CUANDO SE DE CLIC EN REALIZAR PEDIDO
		// ================= //
		// Creamos un pedido

		/*
		 * Pedido pe = new Pedido(); // Cremamos la clase cliente Cliente cliente = new
		 * Cliente(); // Creamos el daoCliente DaoCliente daoCli = new DaoClienteImpl();
		 *
		 * Cliente agregando = daoCli.agregar(cliente);
		 * cliente.setId(agregando.getId()); // Tengo que ver la manera de poder obtener
		 * el ide del pedido que ha sido creado
		 *
		 * // POSTERIORMENTE SE PODRÁ EDITAR ESE PEDIDO EN ESPECIFICO pe.setMesa(mesa);
		 * // Se le asigna la mesa al pedido pe.setCreated_at(new Date());
		 * pe.setTrabajador(trabajador); pe.setMetodo_pago(null);
		 * pe.setTipo_recibo(null); pe.setTotal(0);
		 * pe.setEstado(EstadoPedido.Pendiente); pe.setCliente(cliente); Pedido obtener
		 * = daoPedi.agregar(pe); // Lo estoy agregando
		 *
		 * pe.setId(obtener.getId()); System.out.println("El id del pedido es: " +
		 * pe.getId()); System.out.println("ALL GOOD");
		 *
		 * HttpSession mysession = request.getSession();
		 * mysession.setAttribute("pedidoAttribute", pe);
		 */
		RequestDispatcher rd = request.getRequestDispatcher("MoConsultarMenu");
		rd.forward(request, response);

	}
}
/*
 * System.out.println("Probando ando");
 * System.out.println(pe.getMesa().getN_mesa());
 * System.out.println(pe.getTrabajador().getNombre());
 * System.out.println(pe.getMetodo_pago());
 * System.out.println("------------------");
 */
