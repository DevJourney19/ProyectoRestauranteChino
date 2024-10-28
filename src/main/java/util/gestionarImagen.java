package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import modelo.Inventario;

public class gestionarImagen {
    
    public void guardarImagen(Inventario inventario) throws ServletException {
        Part archivoImagen = inventario.getArchivoImagen();

        if (archivoImagen != null && archivoImagen.getSize() > 0) {
	        String nombreArchivo = archivoImagen.getSubmittedFileName();
	        
	        List<String> extensionesPermitidas = new ArrayList<>();
	        extensionesPermitidas.add("jpg");
	        extensionesPermitidas.add("jpeg");
	        extensionesPermitidas.add("png");
	
            String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
	
	        if (extensionesPermitidas.contains(extensionArchivo)) {
	            String rutaBase = System.getProperty("user.dir") + File.separator + "Escritorio/Desarrollo web integrado/ProyectoRestauranteChino/src/main/webapp/vista/img/img_inventario" + File.separator;
	            
	            File directorio = new File(rutaBase);
	            if (!directorio.exists()) {
	                directorio.mkdirs();
	            }
	
	            Path archivoPath = Paths.get(directorio.getPath(), inventario.getId() + "_" + inventario.getNombre() + "." + extensionArchivo);
	
	            try (InputStream contenidoArchivo = archivoImagen.getInputStream()) {
	                Files.copy(contenidoArchivo, archivoPath, StandardCopyOption.REPLACE_EXISTING);
	            } catch (IOException e) {
	                throw new ServletException("Error al guardar la imagen: " + e.getMessage());
	            }
	        } else {
	            throw new ServletException("Extensión de archivo no permitida: " + extensionArchivo);
	        }
        } else {
            System.out.println("No se ha proporcionado ninguna imagen, se ignorará la carga de imagen.");
        }
    }
    
    public boolean borrarImagen(Inventario inventario) throws ServletException {
        String rutaBase = System.getProperty("user.dir") + File.separator + "Escritorio/Desarrollo web integrado/ProyectoRestauranteChino/src/main/webapp/vista/img/img_inventario" + File.separator;
        
        String nombreArchivo = inventario.getId() + "_" + inventario.getImagen();
        Path archivoPath = Paths.get(rutaBase, nombreArchivo);

        File archivo = archivoPath.toFile();

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Imagen eliminada: " + nombreArchivo);
            } else {
                throw new ServletException("No se pudo eliminar la imagen: " + nombreArchivo);
            }
        } else {
            System.out.println("La imagen no existe: " + nombreArchivo);
        }
		return false;
    }

}
