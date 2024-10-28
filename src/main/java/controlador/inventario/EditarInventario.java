package controlador.inventario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Categoria;
import modelo.Inventario;

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
import datos.impl.DaoInventarioImpl;

@WebServlet(name = "EditarInventario", urlPatterns = {"/EditarInventario"})
@MultipartConfig
public class EditarInventario extends HttpServlet {

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
        DaoInventarioImpl daoInventario = new DaoInventarioImpl();
        DaoCategoria daoCategoria = new DaoCategoriaImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        Inventario.Unidad unidad = Inventario.Unidad.valueOf(request.getParameter("unidad"));
        double precioUnitario = Double.parseDouble(request.getParameter("precio"));
        int inventarioInicial = Integer.parseInt(request.getParameter("inventario"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int stockMin = Integer.parseInt(request.getParameter("stockMinimo"));
        String caducidad = request.getParameter("caducidad");
        Categoria idCategoria = daoCategoria.obtener(Integer.parseInt(request.getParameter("categoria")));
        String imagen = request.getParameter("imagen");
        Boolean trabajador = Boolean.parseBoolean(request.getParameter("trabajador"));
        Part archivoImagen = request.getPart("archivoImagen");

        Inventario inventarioUpdated = new Inventario(id, idCategoria, nombre, unidad, precioUnitario, inventarioInicial, stock, stockMin, LocalDate.parse(caducidad, formatter), imagen, archivoImagen);
        if (daoInventario.editar(inventarioUpdated)) {
        	actualizarImagen(inventarioUpdated);
        	if(trabajador == true) {
	            response.sendRedirect("TrabajadorInventario");
	        } else {
	            response.sendRedirect("AdmiInventario");
	        }
        }
    }
    
    protected void actualizarImagen(Inventario inventario) throws ServletException {
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
