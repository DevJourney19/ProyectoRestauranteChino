package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Trabajador;
import modelo.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datos.DaoCliente;
import datos.DaoDetalle;
import datos.DaoMenu;
import datos.DaoPedido;
import datos.impl.DaoClienteImpl;
import datos.impl.DaoDetalleImpl;
import datos.impl.DaoMenuImpl;
import datos.impl.DaoPedidoImpl;

@WebServlet("/MoAsignarDetaPedi")
public class MoAsignarDetaPedi extends HttpServlet {
	DaoDetalle daoDetalle = new DaoDetalleImpl();
	DaoMenu daoMenu = new DaoMenuImpl();

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
		HttpSession session = request.getSession(false);
		Trabajador trabajador = (Trabajador) session.getAttribute("usuario");
		DaoCliente daoCli = new DaoClienteImpl();

		Map<String, String[]> parametros = request.getParameterMap();
		List<Map<String, String>> detalles = new ArrayList<>();
		int index = 0;
		String importe = request.getParameter("importe");
		String impuesto = request.getParameter("impuesto");
		String total = request.getParameter("total");

		System.out.println("El total es: " + importe);
		while (parametros.containsKey("detalle[" + index + "][id_pedido]")) {
			Map<String, String> detalle = new HashMap<>();
			detalle.put("id_menu", request.getParameter("detalle[" + index + "][id_menu]"));
			detalle.put("id_pedido", request.getParameter("detalle[" + index + "][id_pedido]"));
			detalle.put("nombre", request.getParameter("detalle[" + index + "][nombre]"));
			detalle.put("cantidad", request.getParameter("detalle[" + index + "][cantidad]"));
			detalle.put("precio", request.getParameter("detalle[" + index + "][precio]"));
			detalle.put("subtotal", request.getParameter("detalle[" + index + "][subtotal]"));

			detalles.add(detalle);
			index++;
		}
		// Pedido pedido= new Pedido();
		DaoPedido daoPedi = new DaoPedidoImpl();
		// Obtener el total como un parámetro separado

		// Aquí, puedes procesar los detalles, guardarlos en la base de datos, etc.
		for (Map<String, String> detalle : detalles) {
			Pedido pee = daoPedi.obtener(Integer.parseInt(detalle.get("id_pedido")));

			System.out.println("Total de la base de datos antes de sobrescribir: " + pee.getTotal());
			pee.setImporte(Double.parseDouble(importe));
			pee.setImpuesto(Double.parseDouble(impuesto));
			pee.setTotal(Double.parseDouble(total));

			HttpSession sessionCliente = request.getSession(false);
			Cliente clientee = (Cliente) session.getAttribute("cliente");

			pee.setCliente(clientee);
			pee.setTrabajador(trabajador);
			boolean x = daoPedi.editar(pee);
			Pedido pedidoEditar = null;
			if (x) {
				System.out.println("Pedido actualizado correctamente.");
				pedidoEditar = pee;
			} else {
				System.out.println("Error al actualizar el pedido.");
			}

			System.out.println("Total después de sobrescribir con el frontend: " + pee.getTotal());

			// Menu mee = daoMenu.obtenerMenuPorNombre(detalle.get("nombre"));
			Menu mee = daoMenu.obtener(Integer.parseInt(detalle.get("id_menu")));
			DetallePedido dp = new DetallePedido();
			dp.setCantidad(Integer.parseInt(detalle.get("cantidad")));
			dp.setSubtotal(Double.parseDouble(detalle.get("subtotal")));
			dp.setMenu(mee);
			dp.setPedido(pedidoEditar);

			System.out.println("Producto: " + detalle.get("nombre"));
			System.out.println("El total del produto es: " + pee.getTotal());
			daoDetalle.agregar(dp);
		}

		// Responder al cliente
		response.setContentType("application/json");
		response.getWriter().write("{\"status\":\"success\"}");
	}
}
