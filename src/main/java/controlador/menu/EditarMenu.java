package controlador.menu;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import datos.DaoCategoria;
import datos.DaoMenu;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoMenuImpl;
import modelo.Menu;

@WebServlet(name = "EditarMenu", urlPatterns = { "/EditarMenu" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 15) // 15 MB
public class EditarMenu extends HttpServlet {

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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoMenu daoMenu = new DaoMenuImpl();
		DaoCategoria daoCategoria = new DaoCategoriaImpl();

		Menu menu = new Menu();

		try {
			if(request.getPart("file")!=null) {
				Part imagenPart = request.getPart("file");
				if (imagenPart != null && imagenPart.getSize() > 0) {
				    InputStream inputStream = imagenPart.getInputStream();
				    menu.setArchivoImagen(imagenPart);
				}
			}else {
				String imagenBase64 = request.getParameter("imagen");
				if (imagenBase64 != null && !imagenBase64.isEmpty()) {
				    menu.setImagen(imagenBase64);
				    menu.setTipoImagen(request.getParameter("tipo"));
				}

			}


			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			double precio = Double.parseDouble(request.getParameter("precio"));
			String estado = request.getParameter("estado");
			int idCategoria = Integer.parseInt(request.getParameter("categoria"));
			int id = Integer.parseInt(request.getParameter("id"));

			menu.setId(id);
			menu.setNombre(nombre);
			menu.setDescripcion(descripcion);
			menu.setPrecio(precio);
			menu.setEstado(Menu.Estado.valueOf(estado));
			menu.setCategoria(daoCategoria.obtener(idCategoria));

            boolean exito = daoMenu.editar(menu);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (exito) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("{\"mensaje\": \"Edición exitosa\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"mensaje\": \"Operación fallida\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"mensaje\": \"Error en el servidor\"}");
        }
	}
}
