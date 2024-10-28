package controlador.trabajador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rol;
import modelo.Trabajador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson; // Ensure you have Gson dependency in your project
import datos.DaoRol;
import datos.DaoTrabajador;
import datos.impl.DaoRolImpl;
import datos.impl.DaoTrabajadorImpl;

@WebServlet(name = "EditarTrabajador", urlPatterns = { "/EditarTrabajador" })
public class EditarTrabajador extends HttpServlet {
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
        DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
        DaoRol rolDao = new DaoRolImpl();
        Gson gson = new Gson();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String jsonData = jsonBuilder.toString();

            // Parse JSON to object
            Trabajador tra = gson.fromJson(jsonData, Trabajador.class);
            int id = tra.getId(); 
            
            tra.setRol(rolDao.obtener(tra.getRol().getId())); 

            if(trabajadorDao.editar(tra)) {
            	response.sendRedirect("AdmiTrabajador");
            }
            

        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendRedirect("AdmiTrabajador?mensaje=Operacion Fallida");
        }
    }
}
