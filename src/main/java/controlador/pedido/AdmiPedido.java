package controlador.pedido;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

@WebServlet(name = "AdmiPedido", urlPatterns = {"/AdmiPedido"})
public class AdmiPedido extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPedidoImpl daoPedido = new DaoPedidoImpl();
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		List<Object[]> pedidos = daoPedido.verData();
		request.setAttribute("pedidos", pedidos);
		List<Mesa> mesas = daoMesa.consultar();
		request.setAttribute("mesas", mesas);
		RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/pedidos/pedidos.jsp");
		rd.forward(request, response);
	}


}
