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

		 PrintWriter out = response.getWriter();
		try {
			Trabajador trabajador = tra.validarUsuario(usuario, password);
				// Iniciar sesión
				HttpSession session = request.getSession();

				// Obtener y guardar el rol en sesión
				session.setAttribute("rol", trabajador.getRol().getNombre());

				// Redirigir según el rol
				String destino;
				switch (trabajador.getRol().getNombre()) {
				case "administrador":
					destino = "/AdmiTrabajador";
					break;
				case "mozo" :
					destino = "/vista/trabajadores/pedido/pedido.jsp";
					break;
				case "cocinero":
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

			out.println(usuario);
			//response.sendRedirect(request.getContextPath() + "/vista/error.jsp?mensaje=Error del sistema");
		}

	}
}
