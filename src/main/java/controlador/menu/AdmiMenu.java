package controlador.menu;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

@WebServlet(name = "AdmiMenu", urlPatterns = { "/AdmiMenu" })
public class AdmiMenu extends HttpServlet {

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

		// Verificar si hay un título de búsqueda
		if (request.getParameter("tituloSearch") != null && !request.getParameter("tituloSearch").isEmpty()) {
			String titulo = request.getParameter("tituloSearch");

			// Filtrar el menú basado en el título
			menu = menu.stream().filter(m -> m.getNombre().toLowerCase().contains(titulo.toLowerCase()))
					.collect(Collectors.toList()); // Guardar el resultado del filtrado
		}

		// Establecer la lista filtrada o completa en el atributo de solicitud
		request.setAttribute("menu", menu);

		// Redirigir a la vista
		RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/menu/menu.jsp");
		rd.forward(request, response);

	}

}
