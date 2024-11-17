package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import datos.impl.*;
import datos.*;
import modelo.DetallePedido;
import modelo.Menu;
import modelo.Pedido;
import modelo.Pedido.EstadoPedido;

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
		response.setContentType("application/json"); // Asegúrate de que la respuesta sea JSON
		response.setCharacterEncoding("UTF-8"); // Codificación en UTF-8
		// count++;
		int id_menu_seleccionado = Integer.parseInt(request.getParameter("id_input"));

		Menu menuEncontrado = daoMenu.obtener(id_menu_seleccionado);

		Menu menu = new Menu();
		

		DetallePedido dp = new DetallePedido();
		menu.setId(menuEncontrado.getId());
		menu.setNombre(menuEncontrado.getNombre());
		menu.setDescripcion(menuEncontrado.getDescripcion());
		menu.setPrecio(menuEncontrado.getPrecio());
		menu.setArchivoImagen(menuEncontrado.getArchivoImagen());
		menu.setCategoria(menuEncontrado.getCategoria());
		menu.setTipoImagen(menuEncontrado.getTipoImagen());
		menu.setPrecio(menuEncontrado.getPrecio());

		dp.setMenu(menu);
		dp.setSubtotal(cantidad * menuEncontrado.getPrecio());
		dp.setCantidad(cantidad);
		// Se debe traer el pedido creado en mesa

		HttpSession session = request.getSession();

		// Se obtiene el pedido creado previamente
		Pedido pe = (Pedido) session.getAttribute("pedidoAttribute");

		dp.setPedido(pe);

		DetallePedido detallePedido = daoDetalleP.agregar(dp);
		listaDetaPedi.add(dp);

		session.setAttribute("contador", listaDetaPedi.size());
		System.out.println("Buenas buenas");

		
		JSONObject jsonDP = new JSONObject();
		jsonDP.put("detallePedido",detallePedido);
				
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);
		jsonResponse.put("message", "Producto agregado correctamente");

		JSONObject responseJson = new JSONObject();
		responseJson.put("jsonDP", jsonDP);
		responseJson.put("jsonResponse", jsonResponse);
		response.getWriter().write(responseJson.toString());

	}
}
