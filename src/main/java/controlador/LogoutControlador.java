package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutControlador", urlPatterns = { "/LogoutControlador" })
public class LogoutControlador extends HttpServlet {
	
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
		// Obtener la sesión actual
        HttpSession session = request.getSession(false);
        
        // Invalidar la sesión si existe
        if (session != null) {
            session.invalidate(); // Esto elimina la sesión
        }

        // Redirigir al usuario a la página de inicio de sesión
        response.sendRedirect(request.getContextPath() + "/vista/login.jsp");
	}

}
