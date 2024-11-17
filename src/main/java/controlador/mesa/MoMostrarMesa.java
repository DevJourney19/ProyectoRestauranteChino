package controlador.mesa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Mesa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import datos.DaoMesa;
import datos.impl.DaoMesaImpl;

@WebServlet("/MoMostrarMesa")
public class MoMostrarMesa extends HttpServlet {
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

		response.setContentType("application/json"); // Asegúrate de que la respuesta sea JSON
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
			mesaJson.put("id", mesa.getId());
			mesaJson.put("nombre", mesa.getN_mesa());
			mesaJson.put("salon", mesa.getN_salon());
			mesaJson.put("estado", mesa.getEstado());
			mesasArray.put(mesaJson);
		}
		// Agregar la lista de mesas al objeto JSON
		jsonResponse.put("mesas", mesasArray);

		// Brindar la respuesta en JSON
		response.getWriter().write(jsonResponse.toString());
	}
}
