package controlador.menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;

@WebServlet(name = "TrabajadorMenu", urlPatterns = { "/TrabajadorMenu" })
public class TrabajadorMenu extends HttpServlet {
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

		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/menu/menu.jsp");
		rd.forward(request, response);

	}


}
