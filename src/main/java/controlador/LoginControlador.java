package controlador;

import java.io.IOException;
import java.io.PrintWriter;

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
	private final DaoTrabajador tra = new DaoTrabajadorImpl();

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
		
		if(usuario.isEmpty() && password.isEmpty()) {
			response.sendRedirect("vista/login.jsp");
			return;
		}

		PrintWriter out = response.getWriter();
		try {
			Trabajador trabajador = tra.validarUsuario(usuario, password);
				// Iniciar sesión
				HttpSession session = request.getSession();
				session.setAttribute("usuario", trabajador);
				// Redirigir según el rol
				String destino;
				switch (trabajador.getRol().getNombre()) {
				case "Administrador":
					destino = "AdmiTrabajador";
					break;
				case "Mozo" :
					destino = "TrabajadorMenu";
					break;
				case "Cocinero":
					destino = "TrabajadorMenu";
					break;
				default:
					destino = "vista/error.jsp";
					break;
				}
				response.sendRedirect(destino);
		} catch (Exception e) {
			// Log del error
			response.sendRedirect("vista/login.jsp");
		}

	}
}
