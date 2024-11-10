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
import util.GestionarImagen;

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
        Inventario inventarioUpdated = new Inventario();
        
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
        String imagen = request.getParameter("imagen");
        Boolean trabajador = Boolean.parseBoolean(request.getParameter("trabajador"));
        Part archivoImagen = request.getPart("archivoImagen");
        inventarioUpdated.setUrlImagen(imagen);
        inventarioUpdated.setArchivoImagen(archivoImagen);
        
        boolean operacionExitosa = false;

        if (trabajador) {
            operacionExitosa = daoInventario.editarStock(inventarioUpdated);
            response.sendRedirect(operacionExitosa ? "TrabajadorInventario" : "TrabajadorInventario?mensaje=Operacion Fallida");
        } else {
            operacionExitosa = daoInventario.editar(inventarioUpdated);
            response.sendRedirect(operacionExitosa ? "AdmiInventario" : "AdmiInventario?mensaje=Operacion Fallida");
        }

    }    
}
