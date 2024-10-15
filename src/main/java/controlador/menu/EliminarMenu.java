package controlador.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

import java.io.IOException;

import datos.impl.DaoMenuImpl;

@WebServlet(name = "EliminarMenu", urlPatterns = {"/EliminarMenu"})
public class EliminarMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		DaoMenuImpl daoMenu = new DaoMenuImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		if (daoMenu.eliminar(id)) {
			response.sendRedirect("AdmiMenu");
		}
	}

}
