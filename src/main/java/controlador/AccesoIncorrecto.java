	package controlador;

	import java.io.IOException;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;


	@WebServlet(name = "AccesoIncorrecto", urlPatterns = { "/AccesoIncorrecto" })
	public class AccesoIncorrecto extends HttpServlet {

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
			response.sendRedirect("vista/login.jsp");
		}

	}
