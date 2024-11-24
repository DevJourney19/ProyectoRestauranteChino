package controlador.menu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ExportExcelServlet", urlPatterns = {"/ExportExcelServlet"})
public class ExportExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//    	HttpSession session = request.getSession();
//        if (session.getAttribute("usuario") == null) {
//            response.sendRedirect("login.jsp");
//            return;
//        }
//
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setHeader("Content-Disposition", "attachment; filename=reporte.xlsx");
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            Sheet sheet = workbook.createSheet("Datos");
//
//            // Crear estilo para encabezados
//            CellStyle headerStyle = workbook.createCellStyle();
//            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//            // Crear encabezados
//            Row headerRow = sheet.createRow(0);
//            String[] columns = {"ID", "Nombre", "Descripción", "Categoria", "Precio", "Estado"};
//
//            for (int i = 0; i < columns.length; i++) {
//                Cell cell = headerRow.createCell(i);
//                cell.setCellValue(columns[i]);
//                cell.setCellStyle(headerStyle);
//            }
//
//            // Obtener datos usando tu DAO
//            DaoMenu dao = new DaoMenuImpl();
//            List<Menu> data = dao.consultar();
//
//            // Llenar datos
//            int rowNum = 1;
//            for(Menu item : data) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(item.getId());
//                row.createCell(1).setCellValue(item.getNombre());
//                row.createCell(2).setCellValue(item.getDescripcion());
//                row.createCell(3).setCellValue(item.getCategoria().getNombre());
//                row.createCell(4).setCellValue(item.getPrecio());
//                row.createCell(5).setCellValue(item.getEstado().toString());
//            }
//
//            // Autoajustar columnas
//            for (int i = 0; i < columns.length; i++) {
//                sheet.autoSizeColumn(i);
//            }
//
//            workbook.write(response.getOutputStream());
//        } catch (Exception e) {
//            throw new ServletException("Error al generar Excel", e);
//        }
    }
}