package controlador.menu;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Menu;

@WebServlet(name = "ReporteMenuPDF", urlPatterns = {"/ReporteMenuPDF"})
public class ReporteMenuPDF extends HttpServlet {

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
        response.setHeader("Content-Disposition", "attachment; filename=Reporte_Menu.pdf");

        try {
            // Crear documento PDF
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            // Agregar título
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Menu", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            // Crear tabla
            PdfPTable table = new PdfPTable(6); // Ajusta el número de columnas según tus datos
            table.setWidthPercentage(100);

            // Agregar encabezados
            table.addCell("ID");
            table.addCell("NOMBRE");
            table.addCell("DESCRIPCIÓN");
            table.addCell("CATEGORIA");
            table.addCell("PRECIO");
            table.addCell("ESTADO");

            // Obtener datos usando tu DAO
            DaoMenu dao = new DaoMenuImpl();
            List<Menu> data = dao.consultar();

            // Agregar datos a la tabla
            for(Menu item : data) {
                table.addCell(String.valueOf(item.getId()));
                table.addCell(item.getNombre());
                table.addCell(item.getDescripcion());
                table.addCell(item.getCategoria().getNombre());
                table.addCell(String.format("%.2f", item.getPrecio()));
                table.addCell(String.valueOf(item.getEstado()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new ServletException("Error al generar PDF", e);
        }
    }
}