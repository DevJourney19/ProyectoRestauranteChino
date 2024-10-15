package controlador.trabajador;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvEliminarTrabajador", urlPatterns = {"/SvEliminarTrabajador"})
public class SvEliminarTrabajador extends HttpServlet {

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
		int id = Integer.parseInt(request.getParameter("id"));
		trabajadorDao.eliminar(id);
		response.sendRedirect("SvConsultarTrabajador");
	}

}
