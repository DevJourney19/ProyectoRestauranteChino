package controlador.mesa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import datos.DaoCliente;
import datos.DaoMesa;
import datos.DaoPedido;
import datos.impl.DaoClienteImpl;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;
import modelo.Cliente;
import modelo.Mesa;
import modelo.Mesa.EstadoMesa;
import modelo.Pedido;
import modelo.Pedido.EstadoPedido;
import modelo.Trabajador;

@WebServlet(name = "MesaMozoProceso", urlPatterns = { "/MesaMozoProceso" })
public class MesaMozoProceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DaoMesa daoM = new DaoMesaImpl();
	DaoPedido daoPedi = new DaoPedidoImpl();

	// Ver los pedidos y ver como agregarlos
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccesRequest(request, response);
	}

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
		int n_mesa = Integer.parseInt(request.getParameter("mesa"));
		System.out.println("El numero de mesa es: " + n_mesa);
		/*
		 * Mesa mesa = new Mesa(); // Actualizamos la mesa que escogió
		 * mesa.setEstado(EstadoMesa.Ocupado); mesa.setN_mesa(n_mesa);
		 * mesa.setId(n_mesa); //daoM.editar(mesa); // Necesito el id de mesa //Hare con
		 * un foreach para obtener el id de la mesa
		 * 
		 * // Creamos un pedido Pedido pe = new Pedido(); Cliente cliente = new
		 * Cliente(); DaoCliente daoCli = new DaoClienteImpl(); Cliente agregando =
		 * daoCli.agregar(cliente); cliente.setId(agregando.getId()); // Tengo que ver
		 * la manera de poder obtener el ide del pedido que ha sido creado
		 * 
		 * pe.setMesa(null); // Se le asigna la mesa al pedido pe.setCreated_at(new
		 * Date()); pe.setTrabajador(trabajador); pe.setMetodo_pago(null);
		 * pe.setTipo_recibo(null); pe.setTotal(0);
		 * pe.setEstado(EstadoPedido.Pendiente);
		 * System.out.println("El id del pedido es: " + pe.getId()); //
		 * pe.setId(pe.getId()); //Por medio de la configuración que me recomendaste //
		 * pero nada pe.setCliente(cliente); Pedido obtener = daoPedi.agregar(pe); // Lo
		 * estoy agregando
		 * 
		 * pe.setId(obtener.getId());
		 * 
		 * HttpSession mysession = request.getSession();
		 * mysession.setAttribute("pedidoAttribute", pe);
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("MoConsultarMenu");
		 * rd.forward(request, response);
		 */
	}
}
/*
 * System.out.println("Probando ando");
 * System.out.println(pe.getMesa().getN_mesa());
 * System.out.println(pe.getTrabajador().getNombre());
 * System.out.println(pe.getMetodo_pago());
 * System.out.println("------------------");
 */
