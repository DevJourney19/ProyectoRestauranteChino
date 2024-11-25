package controlador.mesa;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import datos.DaoMesa;
import datos.impl.DaoMesaImpl;
import modelo.Mesa;

@WebServlet("/MoMostrarMesa")
public class MoMostrarMesa extends HttpServlet {
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

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Se pone DaoMesa porque se obtienen los metodos particulares
		DaoMesa daoMesa = new DaoMesaImpl();

		List<Mesa> listaMesa = daoMesa.consultar();
		// request.setAttribute("listaMesa", listaMesa);

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);
		jsonResponse.put("message", "Se obtuvo el listado de mesas");

		// Convertir listaMesa a JSON
		JSONArray mesasArray = new JSONArray();
		for (Mesa mesa : listaMesa) {
			JSONObject mesaJson = new JSONObject();
			//Se agregan los valores para obtenerlos en js
			mesaJson.put("id", mesa.getId());
			mesaJson.put("nombre", mesa.getN_mesa());
			mesaJson.put("salon", mesa.getN_salon());
			mesaJson.put("estado", mesa.getEstado());
			//Se agrega ese elemento al array
			mesasArray.put(mesaJson);
		}
		// Agregar la lista de mesas al objeto JSON con un identificador llamado "mesas"
		jsonResponse.put("mesas", mesasArray);

		// Brindar la respuesta en JSON
		response.getWriter().write(jsonResponse.toString());
	}
}
