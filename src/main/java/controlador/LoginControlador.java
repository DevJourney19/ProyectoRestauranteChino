package controlador;

import java.io.IOException;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import modelo.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = { "/LoginControlador" })
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DaoTrabajador trabajadorDAO = new DaoTrabajadorImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		try {
			Trabajador trabajador = ((DaoTrabajadorImpl) trabajadorDAO).validarUsuario(usuario, password);

			// Iniciar sesión
			HttpSession session = request.getSession();
			session.setAttribute("trabajador", trabajador);
			session.setAttribute("nombreUsuario", trabajador.getNombreUsuario());

			// Obtener y guardar el rol en sesión
			String rolNombre = ((DaoTrabajadorImpl) trabajadorDAO).obtenerRol(trabajador.getId_rol());
			session.setAttribute("rolNombre", rolNombre);

			// Redirigir según el rol
			String destino;
			switch (trabajador.getId_rol()) {
			case 1: // Administrador
				destino = "/SvConsultarTrabajador";
				break;
			case 2: // Cajero
				destino = "/vista/trabajadores/pedido/pedido.jsp";
				break;
			case 3: // Cajero
				destino = "/vista/trabajadores/mesas_mozo/mesas_mozo.jsp";
				break;
			default:
				destino = "/vista/error.jsp";
				break;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// Log del error
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/vista/error.jsp?mensaje=Error del sistema");
		}

	}
}
