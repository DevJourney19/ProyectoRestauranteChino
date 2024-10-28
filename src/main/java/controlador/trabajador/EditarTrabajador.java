package controlador.trabajador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rol;
import modelo.Trabajador;

import java.io.IOException;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;

@WebServlet(name = "EditarTrabajador", urlPatterns = { "/EditarTrabajador" })
public class EditarTrabajador extends HttpServlet {
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
		// este trabajador es el que se traerá por su id
		// No se tiene que crear se tiene que traer
		// Trabajador trabajador = new Trabajador();
		DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Trabajador tra = trabajadorDao.obtener(id);

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

		// Actualizar los datos del trabajador
		tra.setNombre(nombre);
		tra.setApellido(apellido);
		tra.setDni(dni);
		tra.setCorreo(correo);
		tra.setNombreUsuario(usuario);
		tra.setContrasenia(password);
		tra.setCelular(celular);
		// Se agrega el int como id del rol, dont forge it
		Rol role = new Rol(id_rol);
		tra.setRol(role);

		trabajadorDao.editar(tra);
		response.sendRedirect("AdmiTrabajador");
	}
}
