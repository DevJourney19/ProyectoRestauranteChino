package controlador.menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import datos.impl.*;
import datos.*;
import modelo.Menu;

@WebServlet("/MoConsultarMenu")
public class MoConsultarMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		//Proceso para mostrar todos los menus al mozo
		DaoMenu menu = new DaoMenuImpl();
		List<Menu> listaMenu = menu.consultar();
		System.out.println("listaMenu: "+listaMenu);
		request.setAttribute("listaMenu", listaMenu);
		
		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/detalle_pedido/detalle_pedido.jsp");
		rd.forward(request, response);
		
	}
}
