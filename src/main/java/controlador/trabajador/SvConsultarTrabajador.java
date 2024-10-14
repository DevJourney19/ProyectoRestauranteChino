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

@WebServlet(name = "SvConsultarTrabajador", urlPatterns = { "/SvConsultarTrabajador" })
public class SvConsultarTrabajador extends HttpServlet {

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
		//Llevamos la consulta realizada al jsp de usuarios
		String archivo = "/vista/administrador/usuarios/usuarios.jsp";
		
		//Asignamos la lista de usuarios con el identificador "trabajadores"
		request.setAttribute("trabajadores", lista);
		RequestDispatcher rs = request.getRequestDispatcher(archivo);
		rs.forward(request, response);
		
		// Esto va a mostrarse en el jsp
		/*
		 * for (int i = 0; i < lista.size(); i++) { //
		 * System.out.println("El trabajador (" + i + ") es " + //
		 * lista.get(i).getRol().getCodigo() // + " y bueno su nombre es: " +
		 * lista.get(i).getNombre()); System.out.println(lista.get(i)); }
		 */
		//Este codigo no es muy util para trabajar con setAtributte -> response.sendRedirect(archivo);

	}
}
