package controlador.pedido;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import datos.DaoCliente;
import datos.DaoMesa;
import datos.DaoPedido;
import datos.impl.DaoClienteImpl;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;
import modelo.Pedido;
import modelo.Trabajador;

@WebServlet(name = "AgregarPedido", urlPatterns = { "/AgregarPedido" })
public class AgregarPedido extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		DaoPedido daoPedido = new DaoPedidoImpl();
		DaoCliente daoCliente = new DaoClienteImpl();
		DaoMesa daoMesa = new DaoMesaImpl();
		Pedido pedido = new Pedido();
		try {
			pedido.setCliente(daoCliente.obtener(Integer.parseInt(request.getParameter("cliente"))));
			pedido.setMesa(daoMesa.obtener(Integer.parseInt(request.getParameter("n_mesa"))));
			pedido.setTipo_recibo(Pedido.TipoRecibo.valueOf(request.getParameter("recibo")));
			pedido.setMetodo_pago(Pedido.MetodoPago.valueOf(request.getParameter("metodo")));
			String totalPagarParam = request.getParameter("totalPagar");
			Double precio = (totalPagarParam != null && !totalPagarParam.isEmpty())
			                ? Double.valueOf(totalPagarParam)
			                : 0.0;

			pedido.setTotal(precio);
			pedido.setTrabajador((Trabajador) session.getAttribute("usuario"));

			if (daoPedido.agregar(pedido) != null) {
				response.sendRedirect("AdmiPedido");
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiPedido?mensaje=Operacion Fallida");
		}
	}

}
