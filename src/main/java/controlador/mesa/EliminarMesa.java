package controlador.mesa;

import java.io.IOException;

import datos.impl.DaoMesaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarMesa", urlPatterns = { "/EliminarMesa" })
public class EliminarMesa extends HttpServlet {

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
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (daoMesa.eliminar(id)) {
				response.sendRedirect("AdmiMesa");
			} else {
				response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
		}
	}

}
