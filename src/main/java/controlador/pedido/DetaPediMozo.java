package controlador.pedido;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "DetaPediMozo", urlPatterns = { "/DetaPediMozo" })
public class DetaPediMozo extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		response.sendRedirect("vista/trabajadores/detalle_pedido/detalle_pedido.jsp");
	}
}
