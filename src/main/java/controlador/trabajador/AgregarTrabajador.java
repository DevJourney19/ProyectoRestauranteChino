package controlador.trabajador;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rol;
import modelo.Trabajador;

import java.io.IOException;

@WebServlet(name = "AgregarTrabajador", urlPatterns = {"/AgregarTrabajador"})
public class AgregarTrabajador extends HttpServlet {

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
		// Creamos la instancia del dao
		System.out.println("Estamos en el servlet ");
		DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
		int id_rol = 0;
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String correo = request.getParameter("correo");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String celular = request.getParameter("celular");
		String rol_seleccionado = request.getParameter("rol");
		// Comprueba si se seleccionó un rol
		// Si se detecta que el valor escogido tiene un value, me dejará entrar
		if (rol_seleccionado != null && !rol_seleccionado.isEmpty()) {
			id_rol = Integer.parseInt(rol_seleccionado); // Convierte a int
			System.out.println("ID del rol seleccionado: " + id_rol);
		} else {
			System.out.println("No se seleccionó un rol válido.");
		}
		
		// Creamos un trabajador
		Trabajador tra = new Trabajador();
		// Se asignará un objeto rol para cada trabajador.
		// No se va a crear un nuevo rol en la base de datos, ya que si haría eso sería
		// el código autoincremental
		Rol rols =  Rol(id_rol);new
		tra.setApellido(apellido);
		tra.setNombre(nombre);
		tra.setRol(rols);
		tra.setCorreo(correo);
		tra.setNombreUsuario(usuario);
		tra.setContrasenia(password);
		tra.setCelular(celular);

		boolean x = trabajadorDao.agregar(tra);
		
		if (x) {
			System.out.println("Se agrego el trabajador");
			
		}else {
			System.out.println("El trabajador no fue agregado correctamente...");
		}

		response.sendRedirect("AdmiTrabajador");


	}
}
