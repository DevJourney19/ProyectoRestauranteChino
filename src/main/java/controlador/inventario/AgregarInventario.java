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
            	gestionarImagen subir = new gestionarImagen();
            	subir.guardarImagen(inventario);
                response.sendRedirect("AdmiInventario"); // Redirige a la página de administración de inventario
            }else {
    			response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
    		}
        }else {
			response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
		}
    }
}
