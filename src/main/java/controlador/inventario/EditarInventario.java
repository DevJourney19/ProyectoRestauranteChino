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
import util.gestionarImagen;

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
        	gestionarImagen gestionarImagen = new gestionarImagen();
          	gestionarImagen.borrarImagen(inventarioUpdated);      
        	gestionarImagen.guardarImagen(inventarioUpdated);
        	if(trabajador == true) {
	            response.sendRedirect("TrabajadorInventario");
	        } else {
	            response.sendRedirect("AdmiInventario");
	        }
        }
    }    
}
