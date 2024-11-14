package controlador.mesa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import datos.DaoMesa;
import datos.impl.DaoMesaImpl;
import modelo.Mesa;
import modelo.Mesa.EstadoMesa;

@WebServlet(name = "MesaMozoProceso", urlPatterns = { "/MesaMozoProceso" })
public class MesaMozoProceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Ver los pedidos y ver como agregarlos
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccesRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proccesRequest(request, response);
	}

	protected void proccesRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener numero de mesa
		/*int n_mesa = Integer.parseInt(request.getParameter("mesa"));
		DaoMesa daoM = new DaoMesaImpl();
		Mesa mesa = new Mesa();
		//Actualizamos la mesa que escogió
		mesa.setEstado(EstadoMesa.Ocupado);
		mesa.setN_mesa(n_mesa);
		daoM.editar(mesa);
		*/
		response.sendRedirect("MoConsultarMenu");
	}
}
