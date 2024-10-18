package controlador.categoria;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

import java.io.IOException;
import java.util.List;

import datos.impl.DaoCategoriaImpl;

@WebServlet(name = "AgregarCategoria", urlPatterns = {"/AgregarCategoria"})
public class AgregarCategoria extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCategoriaImpl daoCategoria = new DaoCategoriaImpl();
		Categoria categoria = new Categoria();
	    String nombre = request.getParameter("nombre");
	    String tipo = request.getParameter("tipo");
		if(nombre != "" && tipo != null && !("Selecciona el tipo".equals(tipo))) {
			categoria.setNombre(nombre);
			categoria.setTipo(Categoria.TipoCategoria.valueOf(tipo));
			if(daoCategoria.agregar(categoria)) {
			response.sendRedirect("AdmiCategoria");
			}else {
				response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
			}
		}else {
			response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
		}
	}
	
}
