package controlador.categoria;

import java.io.IOException;
import java.util.List;

import datos.DaoCategoria;
import datos.impl.DaoCategoriaImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;

@WebServlet(name = "AdmiCategoria", urlPatterns = {"/AdmiCategoria"})
public class AdmiCategoria extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCategoria daoCategoria = new DaoCategoriaImpl();
		List<Categoria> categorias = daoCategoria.consultar();
		request.setAttribute("categorias", categorias);
		 RequestDispatcher rd = request.getRequestDispatcher("vista/administrador/categorias/categorias.jsp");
		 rd.forward(request, response);
	}


}
