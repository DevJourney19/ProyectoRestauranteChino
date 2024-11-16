package controlador.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import datos.impl.*;
import datos.*;
import modelo.DetallePedido;
import modelo.Menu;
import modelo.Pedido;
import modelo.Pedido.EstadoPedido;

@WebServlet("/MoAgregarDetaPedi")
public class MoAgregarDetaPedi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoMenu daoMenu = new DaoMenuImpl();
	DaoDetalle daoDetalleP = new DaoDetalleImpl();
	int count = 0;
	int cantidad = 1;
	List<DetallePedido> listaDetaPedi = new ArrayList<>();

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
		response.setCharacterEncoding("UTF-8"); // Codificación en UTF-8
		// count++;
		int id_menu = Integer.parseInt(request.getParameter("id_input"));
		
		System.out.println("El id pasado por el fetch es........: " + id_menu);
		Menu valorMenu = daoMenu.obtener(id_menu);
		System.out.println("El objeto menu encontrado es: " + valorMenu.getNombre() + " y con un precio de: "
				+ valorMenu.getPrecio());
		Menu me = new Menu();
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);
		jsonResponse.put("message", "Producto agregado correctamente");

		response.getWriter().write(jsonResponse.toString()); // Enviar el JSON al cliente // Enviar el JSON al cliente

		DetallePedido dp = new DetallePedido();
		me.setId(valorMenu.getId());
		me.setNombre(valorMenu.getNombre());
		me.setDescripcion(valorMenu.getDescripcion());
		me.setPrecio(valorMenu.getPrecio());
		me.setArchivoImagen(valorMenu.getArchivoImagen());
		me.setCategoria(valorMenu.getCategoria());
		me.setTipoImagen(valorMenu.getTipoImagen());
		me.setPrecio(valorMenu.getPrecio());

		dp.setMenu(me);
		dp.setSubtotal(cantidad * valorMenu.getPrecio());
		dp.setCantidad(cantidad);
		// Se debe traer el pedido creado en mesa

		HttpSession session = request.getSession();
		
		//Se obtiene el pedido creado previamente
		Pedido pe = (Pedido) session.getAttribute("pedidoAttribute");
		
		System.out.println("---------------------");
		// System.out.println("El id del pedido es: "+pe.getId()); //El problema seguro
		// es porque no lo he asignado
		System.out.println("El nombre es: " + pe.getTrabajador().getNombre());
		System.out.println("El total es: " + pe.getTotal());
		//System.out.println("El estado de la mesa es: " + pe.getMesa().getEstado());
		System.out.println("---------------------");
		System.out.println("ESTO ABAJO DE LA INSTANCIA DE PEDIDO pe");
		dp.setPedido(pe);

		listaDetaPedi.add(dp);
		daoDetalleP.agregar(dp);

		request.setAttribute("contador", listaDetaPedi.size());

		// La idea es que no se actualice la página
		// request.getRequestDispatcher("MoConsultarMenu").forward(request, response);

	}
}
