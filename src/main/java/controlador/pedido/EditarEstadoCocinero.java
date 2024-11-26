package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.DetallePedido;
import modelo.Mesa;
import modelo.Pedido;

import java.io.IOException;

import datos.DaoDetalle;
import datos.DaoPedido;
import datos.impl.DaoDetalleImpl;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;

@WebServlet(name = "EditarEstadoCocinero", urlPatterns = { "/EditarEstadoCocinero" })
public class EditarEstadoCocinero extends HttpServlet {
       
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
		DaoPedido daoPedido = new DaoPedidoImpl();
		DaoDetalle daoDetalle = new DaoDetalleImpl();
		try {
			int id = Integer.parseInt(request.getParameter("idDet"));
		    DetallePedido det = daoDetalle.obtener(id);
		    Pedido pedidoUpdated = daoPedido.obtener(det.getPedido().getId());
		    pedidoUpdated.setEstado(Pedido.EstadoPedido.valueOf(request.getParameter("estado")));
			if (daoPedido.editarEstadoCocinero(pedidoUpdated)) {
				response.sendRedirect("TrabajadorPedidoCocinero");
			}else {
				response.sendRedirect("TrabajadorPedidoCocinero?mensaje=Operacion Fallida");
			}
		}catch(Exception e) {
			response.sendRedirect("TrabajadorPedidoCocinero?mensaje=Operacion Fallida");
		}
	}

}
