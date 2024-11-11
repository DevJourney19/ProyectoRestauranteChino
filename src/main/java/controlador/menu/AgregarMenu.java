package controlador.menu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import datos.DaoCategoria;
import datos.DaoMenu;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Categoria;
import modelo.Menu;
import modelo.Menu.Estado;

@WebServlet(name = "AgregarMenu", urlPatterns = {"/AgregarMenu"})
public class AgregarMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMenu daoMenu = new DaoMenuImpl();
		DaoCategoria daoCategoria = new DaoCategoriaImpl();
		Menu menu = new Menu();

		try {
		    String nombre = request.getParameter("nombre");
		    String descripcion = request.getParameter("descripcion");
		    String precio = request.getParameter("precio");
		    String categoriaStr = request.getParameter("categoria");
		    String estadoStr = request.getParameter("estado");
		    Part imagenPart = request.getPart("imagen");

		    if (nombre == null || nombre.isEmpty() ||
	                descripcion == null || descripcion.isEmpty() ||
	                precio == null || precio.isEmpty() ||
	                categoriaStr == null || categoriaStr.isEmpty() ||
	                estadoStr == null || estadoStr.isEmpty()) {

	                response.sendRedirect("AdmiMenu?mensaje=Operacion Fallida");
	                return;
	            }

	            // Set values on the Menu object
	            menu.setNombre(nombre);
	            menu.setDescripcion(descripcion);
	            menu.setPrecio(Double.parseDouble(precio));

	            Estado estado = estadoStr.equals("1") ? Estado.Venta : Estado.Desactivado;
	            menu.setEstado(estado);

	            int idCategoria = Integer.parseInt(categoriaStr);
	            Categoria categoria = daoCategoria.obtener(idCategoria);
	            if (categoria == null) {
	                response.sendRedirect("AdmiMenu?mensaje=La categoría seleccionada no existe");
	                return;
	            }
	            menu.setCategoria(categoria);

	            if (imagenPart != null) {
	                String nombreArchivo = Paths.get(imagenPart.getSubmittedFileName()).getFileName().toString();
	                menu.setImagen(nombreArchivo);

	                String uploadPath = getServletContext().getRealPath("/vista/administrador/menu/img/");
	                File uploadDir = new File(uploadPath);
	                if (!uploadDir.exists()) {
	                    uploadDir.mkdir();
	                }
	                imagenPart.write(uploadPath + File.separator + nombreArchivo);
	            }

	            if (daoMenu.agregar(menu)) {
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
