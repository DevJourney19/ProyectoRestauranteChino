package controlador.categoria;

import java.io.IOException;

import datos.impl.DaoCategoriaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

@WebServlet(name = "EditarCategoria", urlPatterns = {"/EditarCategoria"})
public class EditarCategoria extends HttpServlet {

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
		DaoCategoriaImpl daoCategoria = new DaoCategoriaImpl();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		    String nombre = request.getParameter("nombre");
		    String tipo = request.getParameter("tipo");
		    if("Selecciona el tipo".equals(tipo)) {
		    	response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
		    }
		    Categoria categoriaUpdated = new Categoria();
		    categoriaUpdated.setId(id);
		    categoriaUpdated.setNombre(nombre);
		    categoriaUpdated.setTipo(Categoria.TipoCategoria.valueOf(tipo));
			if (daoCategoria.editar(categoriaUpdated)) {
				response.sendRedirect("AdmiCategoria");
			}else {
				response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
			}
		}catch(Exception e) {
			response.sendRedirect("AdmiCategoria?mensaje=Operacion Fallida");
		}
	}

}
