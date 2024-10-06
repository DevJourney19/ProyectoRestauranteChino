package controlador.pedido;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoPedidoImpl;

@WebServlet(name = "CargarPedido", urlPatterns = {"/CargarPedido"})
public class CargarPedido extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPedidoImpl daoPedido= new DaoPedidoImpl();
		List<Mesa> mesas = daoMesa.consultar();
		request.setAttribute("mesas", mesas);
		 RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/mesas/mesas.jsp");
		    rd.forward(request, response);
	}
	

}
