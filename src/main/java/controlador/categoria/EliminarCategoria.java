package controlador.categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;

@WebServlet(name = "EliminarCategoria", urlPatterns = {"/EliminarCategoria"})
public class EliminarCategoria extends HttpServlet {

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
		DaoCategoria daoCategoria= new DaoCategoriaImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		if (daoCategoria.eliminar(id)) {
			response.sendRedirect("AdmiCategoria");
		}else {
			response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
		}
	}

}
