package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DetallePedido;

import java.io.IOException;
import java.util.List;

import datos.DaoDetalle;
import datos.DaoPedido;
import datos.impl.DaoDetalleImpl;
import datos.impl.DaoPedidoImpl;

@WebServlet("/MoEliminarPedido")
public class MoEliminarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el id
		int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));

		DaoDetalle daoDetalle = new DaoDetalleImpl();
		// De ahi primero se debe eliminar el detalle de pedido
		daoDetalle.eliminarPorPedido(id_pedido);
		// Segundo se debe eliminar el pedido
		DaoPedido daoPedido = new DaoPedidoImpl();
		daoPedido.eliminar(id_pedido);
		response.sendRedirect("TrabajadorPedido");
	}

}
