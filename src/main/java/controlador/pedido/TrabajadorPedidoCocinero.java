package controlador.pedido;

import java.io.IOException;
import java.util.List;

import datos.DaoPedido;
import datos.impl.DaoPedidoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TrabajadorPedidoCocinero", urlPatterns = { "/TrabajadorPedidoCocinero" })
public class TrabajadorPedidoCocinero extends HttpServlet {

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
		// Proceso para mostrar todos los menus al mozo
		DaoPedido pedido = new DaoPedidoImpl();
		List<Object[]> listaPedido = pedido.pedidoCocinero();
		
		request.setAttribute("listaPedido", listaPedido);
		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/pedidos_cocinero/pedidos_cocinero.jsp");
		rd.forward(request, response);
	}

}
