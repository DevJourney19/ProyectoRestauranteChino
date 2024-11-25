package controlador.mesa;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import datos.impl.DaoMesaImpl;
import modelo.Mesa;

@WebServlet(name = "TrabajadorMesa", urlPatterns = { "/TrabajadorMesa" })
public class TrabajadorMesa extends HttpServlet {
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
		DaoMesaImpl daoMesa = new DaoMesaImpl();
		List<Mesa> mesas = daoMesa.consultar();

		if (request.getParameter("tituloSearch") != null && !request.getParameter("tituloSearch").isEmpty()) {
			int titulo = Integer.parseInt(request.getParameter("tituloSearch"));

			// Filtrar el menú basado en el título
			mesas = mesas.stream().filter(m -> m.getN_mesa() == titulo )
					.collect(Collectors.toList());
		}

		if (request.getParameter("estado") != null && !request.getParameter("estado").isEmpty()) {
			String estado = request.getParameter("estado");

			// Filtrar el menú basado en el título
			mesas = mesas.stream().filter(m -> m.getEstado().toString().equals(estado) )
					.collect(Collectors.toList());
		}


		request.setAttribute("mesas", mesas);
		RequestDispatcher rd = request.getRequestDispatcher("vista/trabajadores/mesas_mozo/mesas_mozo.jsp");
		rd.forward(request, response);
	}

}
