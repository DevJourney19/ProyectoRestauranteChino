package controlador.trabajador;

import java.util.List;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Trabajador;

import java.io.IOException;

@WebServlet(name = "AdmiTrabajador", urlPatterns = { "/AdmiTrabajador" })
public class AdmiTrabajador extends HttpServlet {

	/**
	 * 
	 */
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
		DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
		List<Trabajador> lista = trabajadorDao.consultar();
		
		// Llevamos la consulta realizada al jsp de usuarios
		request.setAttribute("trabajadores", lista);
		
		String archivo = "vista/administrador/usuarios/usuarios.jsp";
		RequestDispatcher rs = request.getRequestDispatcher(archivo);
		rs.forward(request, response);

	}
}
