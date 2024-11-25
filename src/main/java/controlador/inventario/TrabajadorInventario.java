package controlador.inventario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import datos.DaoCategoria;
import datos.DaoInventario;
import datos.impl.DaoCategoriaImpl;
import datos.impl.DaoInventarioImpl;
import modelo.Categoria;
import modelo.Inventario;

@WebServlet(name = "TrabajadorInventario", urlPatterns = {"/TrabajadorInventario"})
public class TrabajadorInventario extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
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
        RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/inventario/inventario.jsp");
        rd.forward(request, response);
    }
}
