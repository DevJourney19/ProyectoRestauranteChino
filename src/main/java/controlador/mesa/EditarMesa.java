package controlador.mesa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mesa;

import java.io.IOException;

import datos.impl.DaoMesaImpl;

@WebServlet(name = "EditarMesa", urlPatterns = {"/EditarMesa"})
public class EditarMesa extends HttpServlet {

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
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		int mesa = Integer.parseInt(request.getParameter("mesa"));
		int salon = Integer.parseInt(request.getParameter("salon"));
		String estado = request.getParameter("estado");
		if("Selecciona estado de mesa".equals(estado)) {
	    	response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
	    }
		Mesa mesaUpdated = new Mesa(id, salon, mesa, Mesa.EstadoMesa.valueOf(estado));
		if (daoMesa.editar(mesaUpdated)) {
			response.sendRedirect("AdmiMesa");
		}else {
			response.sendRedirect("AdmiMesa?mensaje=Operacion Fallida");
		}
	}

}
