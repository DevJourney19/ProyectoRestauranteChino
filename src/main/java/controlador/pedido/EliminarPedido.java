package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import datos.DaoCategoria;
import datos.DaoPedido;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoPedidoImpl;

@WebServlet(name = "EliminarPedido", urlPatterns = {"/EliminarPedido"})
public class EliminarPedido extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoPedido daoPedido= new DaoPedidoImpl();
		try {
		int id = Integer.parseInt(request.getParameter("id"));
		if (daoPedido.eliminar(id)) {
			response.sendRedirect("AdmiPedido");
		}
		}catch(Exception e) {
			response.sendRedirect("AdmiPedido?mensaje=Operacion Fallida");
		}
	}

}
