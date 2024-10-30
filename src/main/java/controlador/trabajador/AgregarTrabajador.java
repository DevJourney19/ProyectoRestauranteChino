package controlador.trabajador;

import datos.DaoRol;
import datos.DaoTrabajador;
import datos.impl.DaoRolImpl;
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
		DaoRol rolDao = new DaoRolImpl();
		try {
			int id_rol = 0;
			String apellido = request.getParameter("apellido");
			String nombre = request.getParameter("nombre");
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			String celular = request.getParameter("celular");
			String rol_seleccionado = request.getParameter("rol");
			if (rol_seleccionado != null && !rol_seleccionado.isEmpty()) {
				id_rol = Integer.parseInt(rol_seleccionado); // 
			} else {
				System.out.println("No se seleccionó un rol válido.");
			}
			
			Trabajador tra = new Trabajador();
			tra.setApellido(apellido);
			tra.setNombre(nombre);
			tra.setRol(rolDao.obtener(id_rol));
			tra.setNombreUsuario(usuario);
			tra.setContrasenia(password);
			tra.setCelular(celular);
			
			if (trabajadorDao.agregar(tra)) {
				response.sendRedirect("AdmiTrabajador");
			}else {
				response.sendRedirect("AdmiTrabajador?mensaje=Operacion Fallida");
			}
		}catch(Exception e) {
			response.sendRedirect("AdmiTrabajador?mensaje=Operacion Fallida");
		}


	}
}
