package controlador.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

import java.io.IOException;

import datos.impl.DaoMenuImpl;

@WebServlet(name = "EditarMenu", urlPatterns = {"/EditarMenu"})
public class EditarMenu extends HttpServlet {

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
		String nombre = request.getParameter("nombre");
	    String descripcion = request.getParameter("descripcion");
	    double precio = Double.parseDouble(request.getParameter("precio"));
	    int categoria = Integer.parseInt(request.getParameter("categoria"));
	    Menu.EstadoMenu estado = Menu.EstadoMenu.valueOf(request.getParameter("estado"));
	    
		Menu menuUpdated = new Menu(id, nombre, descripcion, precio, estado, categoria);
		if (daoMenu.editar(menuUpdated)) {
			response.sendRedirect("AdmiMenu");
		}
	}

}
