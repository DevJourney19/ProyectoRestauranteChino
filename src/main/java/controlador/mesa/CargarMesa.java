package controlador.mesa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoMesaImpl;

@WebServlet(name = "CargarMesa", urlPatterns = {"/CargarMesa"})
public class CargarMesa extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		List<Mesa> mesas = daoMesa.consultar();
		request.setAttribute("mesas", mesas);
		 RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/mesas/mesas.jsp");
		    rd.forward(request, response);
	}
	

}
