package controlador.inventario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Inventario;

import java.io.IOException;

import datos.impl.DaoInventarioImpl;

@WebServlet(name = "EditarInventario", urlPatterns = {"/EditarInventario"})
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
        int id = Integer.parseInt(request.getParameter("id"));
        int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
        String nombre = request.getParameter("nombre");
        String unidad = request.getParameter("unidad");
        double precioUnitario = Double.parseDouble(request.getParameter("precio_unitario"));
        int inventarioInicial = Integer.parseInt(request.getParameter("inventario_inicial"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int stockMin = Integer.parseInt(request.getParameter("stock_min"));
        String caducidad = request.getParameter("caducidad");
        int idTrabajador = Integer.parseInt(request.getParameter("id_trabajador"));

        Inventario inventarioUpdated = new Inventario(id, idCategoria, nombre, unidad, precioUnitario, inventarioInicial, stock, stockMin, caducidad, idTrabajador);
        
        if (daoInventario.editar(inventarioUpdated)) {
            response.sendRedirect("AdmiInventario");
        }
    }
}
