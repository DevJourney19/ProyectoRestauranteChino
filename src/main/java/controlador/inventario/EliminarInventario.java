package controlador.inventario;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import datos.impl.DaoInventarioImpl;
import modelo.Inventario;

@WebServlet(name = "EliminarInventario", urlPatterns = {"/EliminarInventario"})
public class EliminarInventario extends HttpServlet {

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
        Inventario in = new Inventario();
        try {
        	int id = Integer.parseInt(request.getParameter("id"));
            if (daoInventario.eliminar(id)) {
                response.sendRedirect("AdmiInventario");
            }else {
    			response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
    		}
        }catch(Exception e) {
        	response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
        }
    }
}
