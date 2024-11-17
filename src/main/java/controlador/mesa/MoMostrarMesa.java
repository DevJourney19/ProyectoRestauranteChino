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

		// Se pone DaoMesa porque se obtienen los metodos particulares
		DaoMesa daoMesa = new DaoMesaImpl();

		List<Mesa> mesas = daoMesa.consultar();
		List<Mesa> listaMesas = new ArrayList<>();
		// request.setAttribute("listaMesa", listaMesa);
		HttpSession session = request.getSession();

		// Convertir listaMesa a JSON

		for (Mesa mesa : mesas) { // La listaMesa si funciona

			Mesa me = new Mesa();
			me.setId(mesa.getId());
			me.setN_mesa(mesa.getN_mesa());
			me.setN_salon(mesa.getN_salon());
			me.setEstado(mesa.getEstado());
			listaMesas.add(me);
		}

		// Agregar la lista de mesas al objeto JSON
		session.setAttribute("listaMesas", listaMesas);
		// Brindar la respuesta en JSON
		response.setContentType("application/json"); // Asegúrate de que la respuesta sea JSON
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);
		jsonResponse.put("message", "Se obtuvo el listado de mesas");
		// Obtener el PrintWriter para escribir la respuesta
		PrintWriter out = response.getWriter();

		// Escribir el JSON en la respuesta
		out.print(jsonResponse.toString());

		// Cerrar el flujo de salida
		out.flush();
	}
}
