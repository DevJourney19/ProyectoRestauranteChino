package controlador.trabajador;
import java.sql.*;
import java.util.List;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Trabajador;
import util.Conexion;

import java.io.IOException;
@WebServlet(name="SvConsultarTrabajador", urlPatterns = {"/SvConsultarTrabajador"})
public class SvConsultarTrabajador extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
		List<Trabajador> lista = trabajadorDao.consultar();
		System.out.println(lista);
	}
}
