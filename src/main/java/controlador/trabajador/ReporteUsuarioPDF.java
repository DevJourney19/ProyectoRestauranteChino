package controlador.trabajador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
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
            table.setWidths(new float[]{3f, 3f, 4f, 3f, 3f, 3f}); // Ajustar proporciones de columnas

            // Crear estilo para encabezados
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            PdfPCell headerCell = new PdfPCell();
            headerCell.setBackgroundColor(new BaseColor(1, 67, 1)); // Color de fondo
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerCell.setFixedHeight(35);

            // Agregar encabezados
            String[] headers = {"CÓDIGO", "NOMBRE", "APELLIDOS", "USUARIO", "CELULAR", "ROL"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setBackgroundColor(new BaseColor(1, 67, 1));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setFixedHeight(25);
                table.addCell(cell);
            }

            // Obtener datos usando tu DAO
            DaoTrabajador trabajadorDao = new DaoTrabajadorImpl();
            List<Trabajador> data = trabajadorDao.consultar();

            // Agregar datos a la tabla
            Font dataFont = new Font(Font.FontFamily.HELVETICA, 10);
            boolean isAlternate = false; // Alternar color de filas
            for(Trabajador item : data) {
            	BaseColor rowColor = isAlternate ? BaseColor.LIGHT_GRAY : BaseColor.WHITE;
            	for (int i = 0; i < 6; i++) {
                    PdfPCell cell = new PdfPCell();
                    cell.setPhrase(new Phrase(
                            switch (i) {
                                case 0 -> String.valueOf(item.getId());
                                case 1 -> item.getNombre();
                                case 2 -> item.getApellido();
                                case 3 -> item.getNombreUsuario();
                                case 4 -> item.getCelular();
                                default -> item.getRol().getNombre();
                            }, dataFont));
                    cell.setBackgroundColor(rowColor);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setFixedHeight(25);
                    table.addCell(cell);
                }
                isAlternate = !isAlternate;
            }

            document.add(table);

            // Agregar pie de página
            Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateString = formatter.format(new Date());
            Paragraph footer = new Paragraph("Generado por el sistema de restaurante - Fecha: " + dateString, footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(new Paragraph(" ")); // Espacio en blanco
            document.add(footer);

            document.close();

        } catch (Exception e) {
            throw new ServletException("Error al generar PDF", e);
        }
    }
}