package controlador.menu;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import datos.DaoCategoria;
import datos.DaoMenu;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

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
		DaoMenu daoMenu = new DaoMenuImpl();
		DaoCategoria daoCategoria = new DaoCategoriaImpl();

		try {
        	ObjectMapper objectMapper = new ObjectMapper();
        	Menu men = objectMapper.readValue(request.getInputStream(), Menu.class);

        	int id = men.getId();

        	men.setCategoria(daoCategoria.obtener(men.getCategoria().getId()));

        	if (daoMenu.editar(men)) {
        	    response.sendRedirect("AdmiMenu");
        	}

        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendRedirect("AdmiMenu?mensaje=Operacion Fallida");
        }
	}

}
