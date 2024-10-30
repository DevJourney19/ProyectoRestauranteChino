package controlador.inventario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Inventario;
import util.gestionarImagen;

import java.io.IOException;

import datos.impl.DaoInventarioImpl;

@WebServlet(name = "EliminarInventario", urlPatterns = {"/EliminarInventario"})
public class EliminarInventario extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
      	gestionarImagen gestionarImagen = new gestionarImagen();
      	gestionarImagen.borrarImagen(daoInventario.obtener(id));      
        
    	if (daoInventario.eliminar(id)) {
            response.sendRedirect("AdmiInventario");
        }
    }
}
