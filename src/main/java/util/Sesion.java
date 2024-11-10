package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Sesion {

    public static Object obtenerAtributo(HttpServletRequest request, String nombreAtributo) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(nombreAtributo);
        }
        return null;
    }
}
