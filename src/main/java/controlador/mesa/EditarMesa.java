package controlador.mesa;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import datos.impl.DaoMesaImpl;
import modelo.Mesa;

@WebServlet(name = "EditarMesa", urlPatterns = { "/EditarMesa" })
public class EditarMesa extends HttpServlet {

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
		try {
			String estado = "Libre";
			int id = Integer.parseInt(request.getParameter("id"));
			int mesa = Integer.parseInt(request.getParameter("mesa"));
			int salon = Integer.parseInt(request.getParameter("salon"));
			Mesa mesaUpdated = new Mesa();
			mesaUpdated.setId(id);
			mesaUpdated.setN_mesa(mesa);
			mesaUpdated.setN_salon(salon);
			mesaUpdated.setEstado(Mesa.EstadoMesa.valueOf(estado));
			if (request.getParameter("accion") != null) {
				estado = request.getParameter("accion");
				mesaUpdated.setEstado(Mesa.EstadoMesa.valueOf(estado));
				if (daoMesa.editar(mesaUpdated)) {
					response.sendRedirect("TrabajadorMesa");
				} else {
					response.sendRedirect("TrabajadorMesa?mensaje=Operacion Fallida");
				}
			} else {
				estado = request.getParameter("estado");
				mesaUpdated.setEstado(Mesa.EstadoMesa.valueOf(estado));
				if (daoMesa.editar(mesaUpdated)) {
					response.sendRedirect("AdmiMesa");
				} else {
					response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
				}
			}

		} catch (Exception e) {
			response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
		}

	}

}
