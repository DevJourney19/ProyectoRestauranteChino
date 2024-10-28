package util;

public class Entradas {

	public static boolean validarEntrada(String rol, String ruta) {
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
		case "AdmiCategoria", "AdmiTrabajador", "AdmiPedido", "AdmiInventario", "AdmiMenu" -> true;
		default -> false;
		};
	}

	private static boolean validarMozo(String ruta) {
		return switch (ruta) {
		case "TrabajadorMenu", "TrabajadorPedido", "TrabajadorMesa" -> true;
		default -> false;
		};
	}

	private static boolean validarCocinero(String ruta) {
		return switch (ruta) {
		case "TrabajadorMenu", "TrabajadorCocineroPedido" -> true;
		default -> false;
		};
	}
}
