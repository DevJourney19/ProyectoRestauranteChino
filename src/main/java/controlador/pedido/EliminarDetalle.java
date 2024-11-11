package controlador.pedido;

import java.io.IOException;

import datos.DaoDetalle;
import datos.impl.DaoDetalleImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarDetalle", urlPatterns = { "/EliminarDetalle" })
public class EliminarDetalle extends HttpServlet {
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
		DaoDetalle daoDetalle = new DaoDetalleImpl();
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (daoDetalle.eliminar(id)) {
				response.sendRedirect("AdmiDetallePedido?id="+idPedido);
			}else {
				response.sendRedirect("AdmiDetallePedido?id=" + idPedido + "&mensaje=Operacion Fallida");
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiDetallePedido?id=" + idPedido + "&mensaje=Operacion Fallida");
		}
	}

}
