package controlador.pedido;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.DetallePedido;

import java.io.IOException;
import java.util.List;

import datos.DaoCategoria;
import datos.DaoDetalle;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoDetalleImpl;

@WebServlet(name = "AdmiDetallePedido", urlPatterns = {"/AdmiDetallePedido"})
public class AdmiDetallePedido extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoDetalle daoDetalle = new DaoDetalleImpl();
		int id = Integer.valueOf(request.getParameter("id"));
		List<DetallePedido> detalle = daoDetalle.obtener(id);
		request.setAttribute("detallesPedido", detalle);
		 RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/pedidos/detalle_pedido.jsp");
		 rd.forward(request, response);
	}
	

}
