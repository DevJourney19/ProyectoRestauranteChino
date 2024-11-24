package controlador.pedido;

import java.io.IOException;

import datos.DaoDetalle;
import datos.DaoMenu;
import datos.DaoPedido;
import datos.impl.DaoDetalleImpl;
import datos.impl.DaoMenuImpl;
import datos.impl.DaoPedidoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DetallePedido;

@WebServlet(name = "EditarDetalle", urlPatterns = {"/EditarDetalle"})
public class EditarDetalle extends HttpServlet {
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
		int idPedido = Integer.valueOf(request.getParameter("idPedido"));
		DaoPedido daoPedido = new DaoPedidoImpl();
		DaoMenu daoMenu = new DaoMenuImpl();
		DaoDetalle daoDetalle = new DaoDetalleImpl();
		DetallePedido detalle = new DetallePedido();
		try {
			detalle.setId(Integer.valueOf(request.getParameter("id")));
			detalle.setMenu(daoMenu.obtener(Integer.valueOf(request.getParameter("plato"))));
			detalle.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			detalle.setSubtotal(Double.valueOf(request.getParameter("subtotal")));
			detalle.setPedido(daoPedido.obtener(idPedido));
			if (daoDetalle.editar(detalle)) {
				response.sendRedirect("AdmiDetallePedido?id=" + idPedido);
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiDetallePedido?id=" + idPedido + "&mensaje=Operacion Fallida");
		}
	}

}
