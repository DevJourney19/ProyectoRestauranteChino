package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Trabajador;

import java.io.IOException;

import datos.DaoCliente;
import datos.DaoDetalle;
import datos.DaoMenu;
import datos.DaoMesa;
import datos.DaoPedido;
import datos.impl.DaoClienteImpl;
import datos.impl.DaoDetalleImpl;
import datos.impl.DaoMenuImpl;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;

@WebServlet(name = "AgregarDetalle", urlPatterns = { "/AgregarDetalle" })
public class AgregarDetalle extends HttpServlet {
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
		int idPedido = Integer.valueOf(request.getParameter("id"));
		DaoPedido daoPedido = new DaoPedidoImpl();
		DaoMenu daoMenu = new DaoMenuImpl();
		DaoDetalle daoDetalle = new DaoDetalleImpl();
		DetallePedido detalle = new DetallePedido();
		try {
			detalle.setMenu(daoMenu.obtener(Integer.valueOf(request.getParameter("plato"))));
			detalle.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			detalle.setSubtotal(Double.valueOf(request.getParameter("subtotal")));
			detalle.setPedido(daoPedido.obtener(idPedido));
			if (daoDetalle.agregar(detalle)) {
				response.sendRedirect("AdmiDetallePedido?id=" + idPedido);
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiPedido?id=" + idPedido + "&mensaje=Operacion Fallida");
		}
	}

}
