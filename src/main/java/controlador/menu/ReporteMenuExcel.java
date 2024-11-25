package controlador.menu;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import datos.DaoMenu;
import datos.impl.DaoMenuImpl;
import modelo.Menu;

@WebServlet(name = "ReporteMenuExcel", urlPatterns = {"/ReporteMenuExcel"})
public class ReporteMenuExcel extends HttpServlet {

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

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Reporte_Menu.xlsx");

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Listado del Menu");

            // Estilos para encabezados
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerStyle.setFont(headerFont);

            // Estilo para datos
            CellStyle dataStyle = workbook.createCellStyle();
            dataStyle.setBorderBottom(BorderStyle.THIN);
            dataStyle.setBorderTop(BorderStyle.THIN);
            dataStyle.setBorderLeft(BorderStyle.THIN);
            dataStyle.setBorderRight(BorderStyle.THIN);
            dataStyle.setAlignment(HorizontalAlignment.CENTER);
            dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            CellStyle alternateStyle = workbook.createCellStyle();
            alternateStyle.cloneStyleFrom(dataStyle);
            alternateStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            alternateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Crear encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.setHeightInPoints(25); // Ajustar altura de encabezados
            String[] columns = {"ID", "NOMBRE", "DESCRIPCIÓN", "CATEGORIA", "PRECIO", "ESTADO"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Obtener datos usando tu DAO
            DaoMenu dao = new DaoMenuImpl();
            List<Menu> data = dao.consultar();

            // Llenar datos
            int rowNum = 1;
            boolean isAlternate = false; // Alternar color de las filas
            for (Menu item : data) {
                Row row = sheet.createRow(rowNum++);
                row.setHeightInPoints(25); // Ajustar altura de las celdas
                for (int i = 0; i < columns.length; i++) {
                    Cell cell = row.createCell(i);
                    // Asignar valores
                    switch (i) {
                        case 0 -> cell.setCellValue(item.getId());
                        case 1 -> cell.setCellValue(item.getNombre());
                        case 2 -> cell.setCellValue(item.getDescripcion());
                        case 3 -> cell.setCellValue(item.getCategoria().getNombre());
                        case 4 -> cell.setCellValue(item.getPrecio());
                        case 5 -> cell.setCellValue(item.getEstado().toString());
                    }
                    // Aplicar estilo y alternar color
                    if (isAlternate) {
                        dataStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
                        dataStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    } else {
                        dataStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                        dataStyle.setFillPattern(FillPatternType.NO_FILL);
                    }
                    cell.setCellStyle(isAlternate ? alternateStyle : dataStyle);
                }
                isAlternate = !isAlternate;
            }

            // Autoajustar columnas
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            sheet.createFreezePane(0, 1); // Congela la primera fila
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            throw new ServletException("Error al generar Excel", e);
        }
    }
}