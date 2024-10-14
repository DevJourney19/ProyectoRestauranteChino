package controlador.inventario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Inventario;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoInventarioImpl;

@WebServlet(name = "AdmiInventario", urlPatterns = {"/AdmiInventario"})
public class AdmiInventario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoInventarioImpl daoInventario = new DaoInventarioImpl();
        List<Inventario> inventarios = daoInventario.consultar();
        request.setAttribute("inventarios", inventarios);
        RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/inventario/inventarios.jsp");
        rd.forward(request, response);
    }
}
