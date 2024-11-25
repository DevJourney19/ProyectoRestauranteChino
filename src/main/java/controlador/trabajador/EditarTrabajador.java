package controlador.trabajador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import datos.DaoRol;
import datos.DaoTrabajador;
import datos.impl.DaoRolImpl;
import datos.impl.DaoTrabajadorImpl;
import modelo.Trabajador;

@WebServlet(name = "EditarTrabajador", urlPatterns = { "/EditarTrabajador" })
public class EditarTrabajador extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
        DaoRol rolDao = new DaoRolImpl();

        try {
        	ObjectMapper objectMapper = new ObjectMapper();
        	Trabajador tra = objectMapper.readValue(request.getInputStream(), Trabajador.class);

        	int id = tra.getId();

        	tra.setRol(rolDao.obtener(tra.getRol().getId()));

        	if (trabajadorDao.editar(tra)) {
        	    response.sendRedirect("AdmiTrabajador");
        	}

        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendRedirect("AdmiTrabajador?mensaje=Operacion Fallida");
        }
    }
}
