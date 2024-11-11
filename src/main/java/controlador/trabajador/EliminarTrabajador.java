package controlador.trabajador;

import java.io.IOException;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarTrabajador", urlPatterns = {"/EliminarTrabajador"})
public class EliminarTrabajador extends HttpServlet {

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
		DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			trabajadorDao.eliminar(id);
			response.sendRedirect("AdmiTrabajador");
		}catch(Exception e) {
			response.sendRedirect("AdmiTrabajador?mensaje=Operacion Fallida");
		}
	}

}
