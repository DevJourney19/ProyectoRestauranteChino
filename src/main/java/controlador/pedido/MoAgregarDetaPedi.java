package controlador.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DetallePedido;
import modelo.Menu;

@WebServlet("/MoAgregarDetaPedi")
public class MoAgregarDetaPedi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoMenu daoMenu = new DaoMenuImpl();
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

		menu.setId(menuEncontrado.getId());
		menu.setNombre(menuEncontrado.getNombre());
		menu.setDescripcion(menuEncontrado.getDescripcion());
		menu.setPrecio(menuEncontrado.getPrecio());
		menu.setImagen(menuEncontrado.getImagen());
		menu.setCategoria(menuEncontrado.getCategoria());
		menu.setTipoImagen(menuEncontrado.getTipoImagen());

		// Serializamos para enviar la respuesta como JSON
		JSONObject menuJSON = new JSONObject();
		menuJSON.put("id", menu.getId());
		menuJSON.put("nombre", menu.getNombre());
		menuJSON.put("descripcion", menu.getDescripcion());
		menuJSON.put("precio", menu.getPrecio());
		menuJSON.put("archivo_imagen", menu.getImagen());
		menuJSON.put("categoria", menu.getCategoria());
		menuJSON.put("tipo_imagen", menu.getTipoImagen());
		// System.out.println(detPedidoJSON.toString());
		JSONObject responseJSON = new JSONObject();
		responseJSON.put("success", true);
		responseJSON.put("message", "Producto agregado correctamente");


		JSONObject JSONresponse = new JSONObject();
		JSONresponse.put("menuJSON", menuJSON);
		JSONresponse.put("responseJSON", responseJSON);


		response.getWriter().write(JSONresponse.toString());
	}
}
