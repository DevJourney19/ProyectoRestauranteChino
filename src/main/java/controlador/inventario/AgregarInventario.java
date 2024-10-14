package controlador.inventario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Inventario; // Asegúrate de tener esta clase creada

import java.io.IOException;
import datos.impl.DaoInventarioImpl; // Asegúrate de tener esta clase creada

@WebServlet(name = "AgregarInventario", urlPatterns = {"/AgregarInventario"})
public class AgregarInventario extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoInventarioImpl daoInventario = new DaoInventarioImpl();
        Inventario inventario = new Inventario();
        
        String idCategoria = request.getParameter("idCategoria");
        String nombre = request.getParameter("nombre");
        String unidad = request.getParameter("unidad");
        String precioUnitario = request.getParameter("precioUnitario");
        String inventarioInicial = request.getParameter("inventarioInicial");
        String stock = request.getParameter("stock");
        String stockMin = request.getParameter("stockMin");
        String caducidad = request.getParameter("caducidad");
        String idTrabajador = request.getParameter("idTrabajador");

        if (idCategoria != null && nombre != null && unidad != null) {
            inventario.setIdCategoria(Integer.parseInt(idCategoria));
            inventario.setNombre(nombre);
            inventario.setUnidad(unidad);
            inventario.setPrecioUnitario(Double.parseDouble(precioUnitario));
            inventario.setInventarioInicial(Integer.parseInt(inventarioInicial));
            inventario.setStock(Integer.parseInt(stock));
            inventario.setStockMin(Integer.parseInt(stockMin));
            inventario.setCaducidad(caducidad);
            inventario.setIdTrabajador(Integer.parseInt(idTrabajador));

            if (daoInventario.agregar(inventario)) {
                response.sendRedirect("AdmiInventario"); // Redirige a la página de administración de inventario
            }
        }
    }
}
