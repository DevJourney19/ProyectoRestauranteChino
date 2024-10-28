package controlador.inventario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Inventario; // Asegúrate de tener esta clase creada

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoInventarioImpl; // Asegúrate de tener esta clase creada

@WebServlet(name = "AgregarInventario", urlPatterns = {"/AgregarInventario"})
@MultipartConfig
public class AgregarInventario extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoInventarioImpl daoInventario = new DaoInventarioImpl();
        DaoCategoria daoCategoria = new DaoCategoriaImpl();
        Inventario inventario = new Inventario();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        int idCategoria = Integer.parseInt(request.getParameter("familia"));
        String nombre = request.getParameter("producto");
        String unidad = request.getParameter("unidad");
        double precioUnitario = Double.parseDouble(request.getParameter("costo_unitario"));
        int inventarioInicial = Integer.parseInt(request.getParameter("inventario_inicial"));
        int stock = Integer.parseInt(request.getParameter("stock_inicial"));
        int stockMin = Integer.parseInt(request.getParameter("stock_minimo"));
        String caducidad = request.getParameter("dias_caducidad");
        Part archivoImagen = request.getPart("archivoImagen");
        
        if (idCategoria > 0 && nombre != null && unidad != null) {
            inventario.setCategoria(daoCategoria.obtener(idCategoria));
            inventario.setNombre(nombre);
            inventario.setUnidad(Inventario.Unidad.valueOf(unidad));
            inventario.setPrecioUnitario(precioUnitario);
            inventario.setInventarioInicial(inventarioInicial);
            inventario.setStock(stock);
            inventario.setStockMin(stockMin);
            inventario.setCaducidad(LocalDate.parse(caducidad, formatter));
            inventario.setArchivoImagen(archivoImagen);
            
            if (daoInventario.agregar(inventario)) {
            	agregarImagen(inventario);
                response.sendRedirect("AdmiInventario"); // Redirige a la página de administración de inventario
            }else {
    			response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
    		}
        }else {
			response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
		}
    }
    
    protected void agregarImagen(Inventario inventario) throws ServletException {
        Part archivoImagen = inventario.getArchivoImagen();
        
        if (archivoImagen != null && archivoImagen.getSize() > 0) {
	        String nombreArchivo = archivoImagen.getSubmittedFileName();
	        
	        List<String> extensionesPermitidas = new ArrayList<>();
	        extensionesPermitidas.add("jpg");
	        extensionesPermitidas.add("jpeg");
	        extensionesPermitidas.add("png");
	
            String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
	
	        if (extensionesPermitidas.contains(extensionArchivo)) {
	            String rutaBase = System.getProperty("user.dir") + File.separator + "Escritorio/Desarrollo web integrado/ProyectoRestauranteChino/src/main/webapp/vista/img/img_inventario" + File.separator;
	            
	            File directorio = new File(rutaBase);
	            if (!directorio.exists()) {
	                directorio.mkdirs();
	            }
	
	            Path archivoPath = Paths.get(directorio.getPath(), inventario.getId() + "_" + inventario.getNombre() + "." + extensionArchivo);
	
	            try (InputStream contenidoArchivo = archivoImagen.getInputStream()) {
	                Files.copy(contenidoArchivo, archivoPath, StandardCopyOption.REPLACE_EXISTING);
	            } catch (IOException e) {
	                throw new ServletException("Error al guardar la imagen: " + e.getMessage());
	            }
	        } else {
	            throw new ServletException("Extensión de archivo no permitida: " + extensionArchivo);
	        }
        } else {
            System.out.println("No se ha proporcionado ninguna imagen, se ignorará la carga de imagen.");
        }
    }

}
