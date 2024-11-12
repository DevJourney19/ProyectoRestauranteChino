package controlador.mesa;

import java.io.IOException;

import datos.impl.DaoMesaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

@WebServlet(name = "AgregarMesa", urlPatterns = { "/AgregarMesa" })
public class AgregarMesa extends HttpServlet {

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
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		Mesa mesa = new Mesa();
		try {
			String numSalon = request.getParameter("numSalon");
			String numMesa = request.getParameter("numMesa");
			if (!numSalon.isEmpty() && !numMesa.isEmpty()) {
				mesa.setN_salon(Integer.parseInt(numSalon));
				mesa.setN_mesa(Integer.parseInt(numMesa));
				if (daoMesa.agregar(mesa)) {
					response.sendRedirect("AdmiMesa");
				} else {
					response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
				}
			} else {
				response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
			}
		} catch (Exception e) {
			response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
		}
	}

}
