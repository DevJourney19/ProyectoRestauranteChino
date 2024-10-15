package controlador.usuarios;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoUsuariosImpl;
import modelo.Trabajador;

@WebServlet(name = "AgregarUsuarios", urlPatterns = { "/AgregarUsuarios" })
public class AgregarUsuarios extends HttpServlet {

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

		DaoUsuariosImpl daoUsuarios = new DaoUsuariosImpl();
		try {
			List<Trabajador> trabajadores = daoUsuarios.consultar();
			request.setAttribute("trabajador", trabajadores);
			RequestDispatcher rd = request.getRequestDispatcher("/vista/administrador/usuarios/usuarios.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Error al obtener la lista de trabajadores: " + e.getMessage());
		}
	}
}
