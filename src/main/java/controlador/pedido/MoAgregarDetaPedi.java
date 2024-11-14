package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.impl.*;
import datos.*;
import modelo.DetallePedido;
import modelo.Menu;

@WebServlet("/MoAgregarDetaPedi")
public class MoAgregarDetaPedi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoMenu daoMenu = new DaoMenuImpl();
	DaoDetalle daoDetalleP = new DaoDetalleImpl();
	int count = 0;
	int cantidad = 1;
	List<DetallePedido> listaDetaPedi = new ArrayList<>();

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
		// count++;
		int id_menu = Integer.parseInt(request.getParameter("id_input"));
		System.out.println(id_menu);
		Menu valorMenu = daoMenu.obtener(id_menu);
		System.out.println("El objeto menu encontrado es: " + valorMenu.getNombre() +" y con un precio de: "+ valorMenu.getPrecio());
		// DetallePedido dp = new DetallePedido();
		Menu me = new Menu();

		me.setNombre(valorMenu.getNombre());
		me.setArchivoImagen(valorMenu.getArchivoImagen());
		me.setCategoria(valorMenu.getCategoria());
		me.setTipoImagen(valorMenu.getTipoImagen());
		me.setPrecio(valorMenu.getPrecio());
		/*
		 * dp.setMenu(me); dp.setSubtotal(cantidad * valorMenu.getPrecio());
		 * dp.setCantidad(cantidad); dp.setPedido(null); listaDetaPedi.add(dp);
		 * 
		 * daoDetalleP.agregar(dp);
		 */
		// request.setAttribute("contador", listaDetaPedi.size());
		//request.getRequestDispatcher("vista/trabajadores/detalle_pedido/detalle_pedido.jsp").forward(request, response);
		;
	}
}
