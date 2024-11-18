package controlador.trabajador;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import datos.DaoTrabajador;
import datos.impl.DaoTrabajadorImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Trabajador;

@WebServlet(name = "ReporteUsuarioPDF", urlPatterns = {"/ReporteUsuarioPDF"})
public class ReporteUsuarioPDF extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Reporte_Usuarios.pdf");

        try {
            // Crear documento PDF
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            // Agregar título
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Usuarios", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            // Crear tabla
            PdfPTable table = new PdfPTable(6); // Ajusta el número de columnas según tus datos
            table.setWidthPercentage(100);

            // Agregar encabezados
            table.addCell("CÓDIGO");
            table.addCell("NOMBRE");
            table.addCell("APELLIDOS");
            table.addCell("USUARIO");
            table.addCell("CELULAR");
            table.addCell("ROL");

            // Obtener datos usando tu DAO
            DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
            List<Trabajador> data = trabajadorDao.consultar();

            // Agregar datos a la tabla
            for(Trabajador item : data) {
                table.addCell(String.valueOf(item.getId()));
                table.addCell(item.getNombre());
                table.addCell(item.getApellido());
                table.addCell(item.getNombreUsuario());
                table.addCell(item.getCelular());
                table.addCell(item.getRol().getNombre());
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new ServletException("Error al generar PDF", e);
        }
        
    }
}