package controlador.inventario;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoInventarioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Inventario;

@WebServlet(name = "EditarInventario", urlPatterns = { "/EditarInventario" })
@MultipartConfig
public class EditarInventario extends HttpServlet {

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
		DaoInventarioImpl daoInventario = new DaoInventarioImpl();
		DaoCategoria daoCategoria = new DaoCategoriaImpl();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Inventario inventarioUpdated = new Inventario();
		try {
			inventarioUpdated.setId(Integer.parseInt(request.getParameter("id")));
			inventarioUpdated.setNombre(request.getParameter("nombre"));
			inventarioUpdated.setUnidad(Inventario.Unidad.valueOf(request.getParameter("unidad")));
			inventarioUpdated.setPrecioUnitario(Double.parseDouble(request.getParameter("precio")));
			inventarioUpdated.setInventarioInicial(Integer.parseInt(request.getParameter("inventario")));
			inventarioUpdated.setStock(Integer.parseInt(request.getParameter("stock")));
			inventarioUpdated.setStockMin(Integer.parseInt(request.getParameter("stockMinimo")));
			inventarioUpdated.setCaducidad(LocalDate.parse(request.getParameter("caducidad"), formatter));
			inventarioUpdated.setUnidad(Inventario.Unidad.valueOf(request.getParameter("unidad")));
			inventarioUpdated.setCategoria(daoCategoria.obtener(Integer.parseInt(request.getParameter("categoria"))));

			if (request.getPart("file") != null) {
			    Part imagenPart = request.getPart("file");
			    if (imagenPart != null && imagenPart.getSize() > 0) {
			        inventarioUpdated.setArchivoImagen(imagenPart);
			    }
			} else {
			    String imagenBase64 = request.getParameter("imagen");
			    if (imagenBase64 != null && !imagenBase64.isEmpty()) {
			        inventarioUpdated.setImagen(imagenBase64);
			        inventarioUpdated.setTipoImagen(request.getParameter("tipo"));
			    }
			}


			boolean exito = daoInventario.editar(inventarioUpdated);

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
