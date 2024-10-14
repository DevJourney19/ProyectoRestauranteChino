package Controlador.usuarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Datos.impl.DaoUsuariosImpl;

@WebServlet(name = "EliminarUsuarios", urlPatterns = {"/EliminarUsuarios"})
public class EliminarUsuarios extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoUsuariosImpl daoUsuario = new DaoUsuariosImpl();
		try {
		    int id = Integer.parseInt(request.getParameter("id"));
		    if (daoUsuario.eliminarTrabajador(id)) {
		        response.sendRedirect("AdmiUsuarios?status=eliminado");
		    } else {
		        response.sendRedirect("AdmiUsuarios?status=error");
		    }
		} catch (NumberFormatException e) {
		    response.sendRedirect("AdmiUsuarios?status=id_incorrecto");
		}
	}
}
