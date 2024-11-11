package controlador.categoria;

import java.io.IOException;

import datos.impl.DaoCategoriaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

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
		try {
			Categoria categoria = new Categoria();
		    String nombre = request.getParameter("nombre");
		    String tipo = request.getParameter("tipo");
				categoria.setNombre(nombre);
				categoria.setTipo(Categoria.TipoCategoria.valueOf(tipo));
				if(daoCategoria.agregar(categoria)) {
					response.sendRedirect("AdmiCategoria");
				}else {
					response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
				}

		}catch (Exception e) {
			response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
		}
	}

}
