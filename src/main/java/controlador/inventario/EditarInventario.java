package controlador.inventario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.Inventario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;
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
        DaoCategoria daoCategoria = new DaoCategoriaImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            Inventario inventarioUpdated = new Inventario();
            inventarioUpdated.setId(Integer.parseInt(request.getParameter("id")));
            inventarioUpdated.setNombre(request.getParameter("nombre"));
            inventarioUpdated.setUnidad(Inventario.Unidad.valueOf(request.getParameter("unidad")));
            inventarioUpdated.setPrecioUnitario(Double.parseDouble(request.getParameter("precio")));
            inventarioUpdated.setInventarioInicial(Integer.parseInt(request.getParameter("inventario")));
            inventarioUpdated.setStock(Integer.parseInt(request.getParameter("stock")));
            inventarioUpdated.setStockMin(Integer.parseInt(request.getParameter("stockMinimo")));
            inventarioUpdated.setCaducidad(LocalDate.parse(request.getParameter("caducidad"), formatter));
            inventarioUpdated.setCategoria(daoCategoria.obtener(Integer.parseInt(request.getParameter("categoria"))));
            
            if (daoInventario.editar(inventarioUpdated)) {
                response.sendRedirect("AdmiInventario");
            }
        }catch(Exception e) {
        	response.sendRedirect("AdmiInventario?mensaje=Operacion Fallida");
        }
    }
}
