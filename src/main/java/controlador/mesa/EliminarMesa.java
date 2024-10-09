package controlador.mesa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

import java.io.IOException;

import datos.impl.DaoMesaImpl;

@WebServlet(name = "EliminarMesa", urlPatterns = {"/EliminarMesa"})
public class EliminarMesa extends HttpServlet {

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
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		if (daoMesa.eliminar(id)) {
			response.sendRedirect("AdmiMesa");
		}
	}

}
