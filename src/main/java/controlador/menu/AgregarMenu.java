package controlador.menu;

import java.io.IOException;

import datos.DaoCategoria;
import datos.DaoMenu;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Categoria;
import modelo.Menu;
import modelo.Menu.Estado;

@WebServlet(name = "AgregarMenu", urlPatterns = { "/AgregarMenu" })
@MultipartConfig
public class AgregarMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMenu daoMenu = new DaoMenuImpl();
		DaoCategoria daoCategoria = new DaoCategoriaImpl();
		Menu menu = new Menu();

		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String categoriaStr = request.getParameter("categoria");
			String estadoStr = request.getParameter("estado");
			Part imagenPart = request.getPart("imagen");

			menu.setNombre(nombre);
			menu.setDescripcion(descripcion);
			menu.setPrecio(Double.valueOf(request.getParameter("precio")));
			menu.setArchivoImagen(imagenPart);

			Estado estado = estadoStr.equals("1") ? Estado.Venta : Estado.Desactivado;
			menu.setEstado(estado);

			int idCategoria = Integer.valueOf(categoriaStr);
			Categoria categoria = daoCategoria.obtener(idCategoria);
			if (categoria == null) {
				response.sendRedirect("AdmiMenu?mensaje=La categoría seleccionada no existe");
				return;
			}
			menu.setCategoria(categoria);
			Menu x = daoMenu.agregar(menu);
			if (x != null) {
				System.out.println("Registro exitoso - Nombre: " + menu.getNombre());
				response.sendRedirect("AdmiMenu?mensaje=Registro Exitoso");
			} else {
				System.out.println("Fallo en la operación de registro en la base de datos.");
				response.sendRedirect("AdmiMenu?mensaje=Operacion Fallida 1");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AdmiMenu?mensaje=Operacion Fallida 2");
		}
	}

}
