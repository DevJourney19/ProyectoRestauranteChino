package controlador.mesa;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import datos.impl.DaoMesaImpl;
import modelo.Mesa;

@WebServlet(name = "AdmiMesa", urlPatterns = {"/AdmiMesa"})
public class AdmiMesa extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
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
