package controlador;

import java.io.IOException;

import datos.DaoTrabajador;
import modelo.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {
    
    private final DaoTrabajador trabajadorDAO = new DaoTrabajador();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        try {
            Trabajador trabajador = trabajadorDAO.validarUsuario(usuario, password);

            if (trabajador != null) {
            	
                // Iniciar sesión
                HttpSession session = request.getSession();
                session.setAttribute("trabajador", trabajador);
                session.setAttribute("nombreUsuario", trabajador.getNombreUsuario());
                
                // Obtener y guardar el rol en sesión
                String rolNombre = trabajadorDAO.obtenerRol(trabajador.getId_rol());
                session.setAttribute("rolNombre", rolNombre);

                // Redirigir según el rol
                String destino;
                switch (trabajador.getId_rol()) {
                    case 1: // Administrador
                        destino = "/AdmiUsuarios";
                        break;
                    case 2: // Cajero
                        destino = "/vista/trabajadores/pedido/pedido.jsp";
                        break;
                    case 3: // Cajero
                        destino = "/vista/trabajadores/mesas_mozo/mesas_mozo.jsp";
                        break;
                    default:
                        destino = "/vista/error.jsp";
                        break;
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
                dispatcher.forward(request, response);
            } else {
//                System.out.println("Login fallido");
                response.sendRedirect(request.getContextPath() + 
                    "/vista/login.jsp?error=Credenciales incorrectas");
            }
        } catch (Exception e) {
            // Log del error
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + 
                "/vista/error.jsp?mensaje=Error del sistema");
        }
    }

}
