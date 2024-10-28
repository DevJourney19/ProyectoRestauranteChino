package util;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Trabajador;

@WebFilter("/*") // Aplica a todas las rutas, ajusta según sea necesario
public class Entradas implements Filter {

	public static boolean validarEntrada(Trabajador trabajador, String ruta) {
		String rol = trabajador.getRol().getNombre();
		switch (rol.toLowerCase()) {
		case "administrador":
			return validarAdmin(ruta);
		case "mozo":
			return validarMozo(ruta);
		case "cocinero":
			return validarCocinero(ruta);
		default:
			return false;
		}
	}

	private static boolean validarAdmin(String ruta) {
		return switch (ruta) {
		case "AdmiCategoria", "AdmiTrabajador", "AdmiPedido", "AdmiInventario", "AdmiMenu", "AdmiMesa", "AgregarCategoria", "EditarCategoria", "EliminarCategoria", "AgregarTrabajador", "EditarTrabajador", "EliminarTrabajador", "AgregarPedido", "EditarPedido", "EliminarPedido", "AgregarInventario", "EditarInventario", "EliminarInventario","AgregarMesa",  "EditarMesa", "EliminarMesa", "AgregarMenu",  "EditarMenu", "EliminarMenu" -> true;
		default -> false;
		};
	}

	private static boolean validarMozo(String ruta) {
		return switch (ruta) {
		case "TrabajadorMenu", "TrabajadorPedido", "TrabajadorMesa", "AgregarPedido", "EditarPedido", "EliminarPedido", "EditarMesa" -> true;
		default -> false;
		};
	}

	private static boolean validarCocinero(String ruta) {
		return switch (ruta) {
		case "TrabajadorMenu", "TrabajadorCocineroPedido", "EditarPedido" -> true;
		default -> false;
		};
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String requestURI = httpRequest.getRequestURI();
		
		if (requestURI.endsWith("LogoutControlador")) {
			chain.doFilter(request, response); // Permitir acceso
			return;
		}
		

		// Obtener la sesión
		HttpSession session = httpRequest.getSession(false);
		
	    if (requestURI.endsWith(".css") || requestURI.endsWith(".js") || requestURI.endsWith(".jpg") || requestURI.endsWith(".png") || requestURI.endsWith(".jsp")) {
	        chain.doFilter(request, response);
	        return;
	    }

		
		// Verificar si la sesión existe y si el usuario está en la sesión
		if (session == null || session.getAttribute("usuario") == null) {

			if (requestURI.endsWith("login.jsp") || requestURI.endsWith("LoginControlador")|| requestURI.endsWith("LogoutControlador")) {
				chain.doFilter(request, response); // Permitir acceso
				return;
			}
			
	        httpResponse.sendRedirect("vista/login.jsp");
	        return;
		}

		Trabajador trabajador = (Trabajador) session.getAttribute("usuario");

		String ruta = httpRequest.getServletPath().substring(1);

		// Validar acceso
		if (!Entradas.validarEntrada(trabajador, ruta)) {
			httpResponse.sendRedirect("AccesoIncorrecto");
			return;
		}

		chain.doFilter(request, response);
	}

}
