package controlador.inventario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.Inventario;

import java.io.IOException;
import java.util.List;

import datos.DaoCategoria;
import datos.DaoInventario;
import datos.impl.DaoCategoriaImpl;
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
        DaoInventario daoInventario = new DaoInventarioImpl();
        DaoCategoria daoCategoria = new DaoCategoriaImpl();
        List<Inventario> inventarios = daoInventario.consultar();
        List<Categoria> categorias = daoCategoria.filtrar(Categoria.TipoCategoria.Inventario.toString());
        request.setAttribute("inventario", inventarios);
        request.setAttribute("categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/inventario/inventario.jsp");
        rd.forward(request, response);
    }
}
