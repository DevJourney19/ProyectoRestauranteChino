package controlador.menu;

import java.io.IOException;
import java.util.List;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

@WebServlet(name = "TrabajadorMenu", urlPatterns = { "/TrabajadorMenu" })
public class TrabajadorMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoMenu daoMenu = new DaoMenuImpl();
		List<Menu> menu = daoMenu.consultar();

		request.setAttribute("menu", menu);

		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/menu/menu.jsp");
		rd.forward(request, response);

	}


}
