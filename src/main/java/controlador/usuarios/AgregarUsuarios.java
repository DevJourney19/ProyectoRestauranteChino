package Controlador.usuarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Datos.impl.DaoUsuariosImpl;
import Modelo.Trabajador;

@WebServlet(name = "AgregarUsuarios", urlPatterns = {"/AgregarUsuarios"})
public class AgregarUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoUsuariosImpl daoUsuario = new DaoUsuariosImpl();

	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellidos");
	    String usuario = request.getParameter("usuario");
	    String contrasenia = request.getParameter("password");
	    String telefono = request.getParameter("telefono");
	    String rol = request.getParameter("rol");
	    
		Trabajador trabajador = new Trabajador();
		
		if(nombre != null && !nombre.trim().isEmpty() &&
			    apellido != null && !apellido.trim().isEmpty() &&
			    usuario != null && !usuario.trim().isEmpty() &&
			    contrasenia != null && !contrasenia.trim().isEmpty() &&
			    telefono != null && !telefono.trim().isEmpty() &&
			    rol != null && !rol.trim().isEmpty()) {
			trabajador.setNombre(nombre);
			trabajador.setApellido(apellido);
			trabajador.setNombreUsuario(usuario);
			trabajador.setCelular(telefono);
			trabajador.setContrasenia(contrasenia);
			trabajador.setId_rol(Integer.parseInt(rol));
			if(daoUsuario.agregarTrabajador(trabajador, contrasenia)) {
				response.sendRedirect("AdmiUsuarios?status=registrado");
			} else {
			    response.sendRedirect("AdmiUsuarios?status=error");
			}
		}
	}
	
}
