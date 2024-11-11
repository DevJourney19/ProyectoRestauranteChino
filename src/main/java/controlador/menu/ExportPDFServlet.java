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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Menu;

public class ExportPDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	// Verificar si el usuario está autenticado
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_menu.pdf");

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
            table.addCell("Nombre");
            table.addCell("Descripción");
            table.addCell("Categoria");
            table.addCell("Precio");
            table.addCell("Estado");

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