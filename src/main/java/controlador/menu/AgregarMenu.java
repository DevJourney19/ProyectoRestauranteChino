package controlador.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

import java.io.IOException;

import datos.impl.DaoMenuImpl;

@WebServlet(name = "AgregarMenu", urlPatterns = {"/AgregarMenu"})
public class AgregarMenu extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMenuImpl daoMenu = new DaoMenuImpl();
		Menu menu = new Menu();
	    String nombre = request.getParameter("nombre");
	    String descripcion = request.getParameter("descripcion");
	    String precio = request.getParameter("precio");
	    String categoria = request.getParameter("categoria");
		if(nombre != null && descripcion != null && precio != null && categoria != null) {
			menu.setNombre(nombre);
			menu.setDescripcion(descripcion);
			menu.setPrecio(Double.parseDouble(precio));
			menu.setId_categoria(Integer.parseInt(categoria));
			if(daoMenu.agregar(menu)) {
			response.sendRedirect("AdmiMenu");
			}
		}
	}
	
}
