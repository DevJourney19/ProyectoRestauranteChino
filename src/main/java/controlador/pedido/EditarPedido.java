package controlador.pedido;

import java.io.IOException;

import datos.DaoCliente;
import datos.DaoMesa;
import datos.DaoPedido;
import datos.DaoTrabajador;
import datos.impl.DaoClienteImpl;
import datos.impl.DaoMesaImpl;
import datos.impl.DaoPedidoImpl;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Pedido;
import modelo.Trabajador;

@WebServlet(name = "EditarPedido", urlPatterns = {"/EditarPedido"})
public class EditarPedido extends HttpServlet {
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
		DaoPedido daoPedido= new DaoPedidoImpl();
		DaoCliente daoCliente = new DaoClienteImpl();
		DaoMesa daoMesa = new DaoMesaImpl();
		DaoTrabajador daoTrabajador = new DaoTrabajadorImpl();
		HttpSession session = request.getSession(false);
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		    Pedido pedidoUpdated = new Pedido();
		    pedidoUpdated.setId(id);
		    pedidoUpdated.setCliente(daoCliente.obtener(Integer.valueOf(request.getParameter("usuario"))));
		    pedidoUpdated.setMesa(daoMesa.obtener(Integer.valueOf(request.getParameter("mesa"))));
		    pedidoUpdated.setEstado(Pedido.EstadoPedido.valueOf(request.getParameter("estado")));
		    pedidoUpdated.setTipo_recibo(Pedido.TipoRecibo.valueOf(request.getParameter("recibo")));
		    pedidoUpdated.setMetodo_pago(Pedido.MetodoPago.valueOf(request.getParameter("metodo")));
		    pedidoUpdated.setTotal(Double.valueOf(request.getParameter("pago")));
		    pedidoUpdated.setTrabajador((Trabajador)session.getAttribute("usuario"));
			if (daoPedido.editar(pedidoUpdated)) {
				response.sendRedirect("AdmiPedido");
			}else {
				response.sendRedirect("AdmiPedido?mensaje=Operacion Fallida");
			}
		}catch(Exception e) {
			response.sendRedirect("AdmiPedido?mensaje=Operacion Fallida");
		}
	}

}
