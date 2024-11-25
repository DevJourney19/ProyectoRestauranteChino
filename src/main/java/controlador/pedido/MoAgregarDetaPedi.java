package controlador.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import modelo.DetallePedido;
import modelo.Menu;

@WebServlet("/MoAgregarDetaPedi")
public class MoAgregarDetaPedi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoMenu daoMenu = new DaoMenuImpl();
	//DaoDetalle daoDetalleP = new DaoDetalleImpl();
	//int cantidad = 1;
	List<DetallePedido> listaDetaPedi = new ArrayList<>();

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
		response.setContentType("application/json"); // Asegúrate de que la respuesta sea JSON
		response.setCharacterEncoding("UTF-8"); // Codificación en UTF-8
		// count++;
		int id_menu_seleccionado = Integer.parseInt(request.getParameter("id_input"));

		Menu menuEncontrado = daoMenu.obtener(id_menu_seleccionado);

		Menu menu = new Menu();

		//DetallePedido dp = new DetallePedido();
		menu.setId(menuEncontrado.getId());
		menu.setNombre(menuEncontrado.getNombre());
		menu.setDescripcion(menuEncontrado.getDescripcion());
		menu.setPrecio(menuEncontrado.getPrecio());

		// SOLUCIONAR - Lo que pasa es que no lo obtiene correctamente, aunque en la bd
		// si existe

		menu.setImagen(menuEncontrado.getImagen());
		// System.out.println(menuEncontrado.getArchivoImagen());

		menu.setCategoria(menuEncontrado.getCategoria());
		menu.setTipoImagen(menuEncontrado.getTipoImagen());

		// Serializamos para enviar la respuesta como JSON
		JSONObject menuJSON = new JSONObject();
		menuJSON.put("nombre", menu.getNombre());
		menuJSON.put("descripcion", menu.getDescripcion());
		menuJSON.put("precio", menu.getPrecio());
		menuJSON.put("archivo_imagen", menu.getImagen());
		menuJSON.put("categoria", menu.getCategoria());
		menuJSON.put("tipo_imagen", menu.getTipoImagen());




		/*
		dp.setMenu(menu);
		dp.setSubtotal(cantidad * menuEncontrado.getPrecio());
		dp.setCantidad(cantidad);*/
		// Se debe traer el pedido creado en mesa

		// Se obtiene el pedido creado previamente
		/*
		 * Pedido pe = (Pedido) session.getAttribute("pedidoAttribute");
		 * dp.setPedido(pe);
		 *
		 * // AGREGAR DETALLE PEDIDO daoDetalleP.agregar(dp);
		 *///
			// Serializar
		/*
		 * JSONObject detPedidoJSON = new JSONObject(); detPedidoJSON.put("subtotal",
		 * dp.getSubtotal()); detPedidoJSON.put("cantidad", dp.getCantidad());
		 */

		// SE AGREGA EL DETALLE PEDIDO PARA CONTABILIZAR CUANTOS PEDIDOS SE ENCONTRARON
		// listaDetaPedi.add(dp);
		// JSONObject cantidadProductosJSON = new JSONObject();
		// cantidadProductosJSON.put("size", listaDetaPedi.size());
		// System.out.println("Buenas buenas");

		/*
		 * JSONObject dpJSON = new JSONObject(); dpJSON.put("detalleJSON", detalleJSON);
		 */

		// System.out.println(detPedidoJSON.toString());
		JSONObject responseJSON = new JSONObject();
		responseJSON.put("success", true);
		responseJSON.put("message", "Producto agregado correctamente");

		JSONObject JSONresponse = new JSONObject();
		// JSONresponse.put("detPedidoJSON", detPedidoJSON);
		JSONresponse.put("menuJSON", menuJSON);
		// JSONresponse.put("cantidadProductosJSON", cantidadProductosJSON);
		JSONresponse.put("responseJSON", responseJSON);
		response.getWriter().write(JSONresponse.toString());

		// En mi opinión el detalle de pedido no se debe de crear hasta que se de en
		// crear pedido, para evitar asi gastas de memoria

		// Creo que el pedido también se debe de crear solo y si le da clic en el bocon
		// de crear pedido
	}
}
