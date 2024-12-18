package controlador.menu;

import java.io.IOException;
import java.util.List;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

@WebServlet("/MoConsultarMenu")
public class MoConsultarMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		// Proceso para mostrar todos los menus al mozo
		DaoMenu menu = new DaoMenuImpl();
		List<Menu> listaMenu = menu.consultar();

		request.setAttribute("listaMenu", listaMenu);

		// Obtenemos el id de pedido de la card de pedido
		int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
		request.setAttribute("id_pedido", id_pedido);

		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/detalle_pedido/detalle_pedido.jsp");
		rd.forward(request, response);

	}
}
