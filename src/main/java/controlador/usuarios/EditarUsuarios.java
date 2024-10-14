package Controlador.usuarios;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Modelo.Trabajador;

import java.io.IOException;

import Datos.impl.DaoUsuariosImpl;

@WebServlet(name = "EditarUsuarios", urlPatterns = {"/EditarUsuarios"})
public class EditarUsuarios extends HttpServlet {

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
        DaoUsuariosImpl daoUsuario = new DaoUsuariosImpl();
        
        // Obtener los parámetros del formulario de edición
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String telefono = request.getParameter("telefono");
        int rol = Integer.parseInt(request.getParameter("rol"));

        // Crear un objeto Trabajador con los nuevos datos
        Trabajador trabajador = new Trabajador();
        trabajador.setCodigo(id);
        trabajador.setNombre(nombre);
        trabajador.setApellido(apellido);
        trabajador.setNombreUsuario(usuario);
        trabajador.setCelular(telefono);
        trabajador.setId_rol(rol);

        // Intentar actualizar el trabajador en la base de datos
        if (daoUsuario.editarTrabajador(trabajador)) {
            // Si la actualización es exitosa, redirigir a la lista de usuarios
            response.sendRedirect("AdmiUsuarios?status=actualizado");
        } else {
            // Si ocurre un error, redirigir con un mensaje de error
            response.sendRedirect("AdmiUsuarios?status=error");
        }
    }
}

