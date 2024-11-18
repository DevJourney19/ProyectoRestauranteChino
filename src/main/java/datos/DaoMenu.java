package datos;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.Part;
import modelo.Menu;

public interface DaoMenu extends Dao<Menu> {
	List<Menu> filtrar(String titulo);
	String convertirImagenBase64(Part archivoImagen) throws IOException;
}
