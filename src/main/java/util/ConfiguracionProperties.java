package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfiguracionProperties {
	private Properties propiedades;

    public ConfiguracionProperties() {
        propiedades = new Properties();
        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se pudo encontrar el archivo de configuración.");
            }
            propiedades.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtener la ruta donde guardar las imágenes
    public String obtenerRutaImagenes() {
        return propiedades.getProperty("local.path");
    }
}
