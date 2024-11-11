package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import modelo.Inventario;

public class GestionarImagen {

	private ConfiguracionProperties configuracion;

	public GestionarImagen() {
		this.configuracion = new ConfiguracionProperties();
	}

	public String guardarImagen(Inventario inventario) throws ServletException {
		Part archivoImagen = inventario.getArchivoImagen();

		if (archivoImagen == null || archivoImagen.getSize() == 0) {
			throw new ServletException("No se ha proporcionado ninguna imagen.");
		}

		String nombreArchivo = archivoImagen.getSubmittedFileName();

		Set<String> extensionesPermitidas = new HashSet<>(Arrays.asList("jpg", "jpeg", "png", "webp"));
		String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();

		if (!extensionesPermitidas.contains(extensionArchivo)) {
			throw new ServletException("Extensión de archivo no permitida: " + extensionArchivo);
		}

		String rutaBaseProyecto = configuracion.obtenerRutaImagenes();

		String rutaImagenes = rutaBaseProyecto + File.separator + "vista" + File.separator + "img" + File.separator
				+ "img_inventario";

		File directorio = new File(rutaImagenes);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}

		Path archivoPath = Paths.get(directorio.getPath(),
				inventario.getId() + "_" + inventario.getNombre() + "." + extensionArchivo);

		try (InputStream contenidoArchivo = archivoImagen.getInputStream()) {
			Files.copy(contenidoArchivo, archivoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new ServletException("Error al guardar la imagen: " + e.getMessage());
		}

		return "./vista/img/img_inventario/" + inventario.getId() + "_" + inventario.getNombre() + "."
				+ extensionArchivo;
	}

	public boolean eliminarImagen(Inventario inventario) throws ServletException {
		String urlImagen = inventario.getUrlImagen();
		String rutaImagen = "";
		if (urlImagen.startsWith(".")) {
			rutaImagen = urlImagen.substring(1);
		}

		String rutaBaseProyecto = configuracion.obtenerRutaImagenes();

		String rutaImagenes = rutaBaseProyecto + rutaImagen;

		File archivo = new File(rutaImagenes);

		if(existeImagen(inventario)) {
			if (archivo.delete()) {
				System.out.println("Imagen eliminada: " + rutaImagen);
				return true;
			} else {
				throw new ServletException("No se pudo eliminar la imagen: " + rutaImagen);
			}
		}
		return false;
	}

	public boolean existeImagen(Inventario inventario) {
		String urlImagen = inventario.getUrlImagen();
		String rutaImagen = "";
		if (urlImagen.startsWith(".")) {
			rutaImagen = urlImagen.substring(1);
		}

		String rutaBaseProyecto = configuracion.obtenerRutaImagenes();

		String rutaImagenes = rutaBaseProyecto + rutaImagen;

		File archivo = new File(rutaImagenes);

		if (archivo.exists()) {
			System.out.println("La imagen existe: " + rutaImagen);
			return true;
		}
		return false;
	}

}
