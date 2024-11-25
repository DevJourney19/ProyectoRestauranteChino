package controlador.inventario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoInventarioImpl; // Asegúrate de tener esta clase creada
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Inventario; // Asegúrate de tener esta clase creada

@WebServlet(name = "AgregarInventario", urlPatterns = { "/AgregarInventario" })
@MultipartConfig
public class AgregarInventario extends HttpServlet {

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

		try {
		    Inventario inventario = new Inventario();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		    String nombre = request.getParameter("producto");
		    int idCategoria = Integer.parseInt(request.getParameter("familia"));
		    String unidad = request.getParameter("unidad");
		    double precioUnitario = Double.parseDouble(request.getParameter("costo_unitario"));
		    int inventarioInicial = Integer.parseInt(request.getParameter("inventario_inicial"));
		    int stock = Integer.parseInt(request.getParameter("stock_inicial"));
		    int stockMin = Integer.parseInt(request.getParameter("stock_minimo"));
		    String caducidad = request.getParameter("dias_caducidad");
		    Part archivoImagen = (Part) request.getPart("archivoImagen");

		    inventario.setCategoria(daoCategoria.obtener(idCategoria));
		    inventario.setNombre(nombre);
		    inventario.setUnidad(Inventario.Unidad.valueOf(unidad));
		    inventario.setPrecioUnitario(precioUnitario);
		    inventario.setInventarioInicial(inventarioInicial);
		    inventario.setStock(stock);
		    inventario.setStockMin(stockMin);
		    inventario.setCaducidad(LocalDate.parse(caducidad, formatter));
		    inventario.setArchivoImagen(archivoImagen);

		    if (daoInventario.agregar(inventario) != null) {
		        response.sendRedirect("AdmiInventario");
		    } else {
		        response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
		    }
		} catch (Exception e) {
		    e.printStackTrace();  // O usa un logger para registrar el error
		    response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
		}

	}
}
