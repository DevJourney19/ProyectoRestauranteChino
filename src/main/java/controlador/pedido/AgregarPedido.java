package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

import java.io.IOException;

import datos.impl.DaoMesaImpl;

@WebServlet(name = "AgregarPedido", urlPatterns = {"/AgregarPedido"})
public class AgregarPedido extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		Mesa mesa = new Mesa();
	    String numSalon = request.getParameter("numSalon");
	    String numMesa = request.getParameter("numMesa");
		if(numSalon != null && numMesa != null) {
			mesa.setN_salon(Integer.parseInt(numSalon));
			mesa.setN_mesa(Integer.parseInt(numMesa));
			if(daoMesa.agregar(mesa)) {
			response.sendRedirect("AdmiMesa");
			}
		}
	}

}
