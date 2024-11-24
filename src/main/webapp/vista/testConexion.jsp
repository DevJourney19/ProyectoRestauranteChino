<%@page import="java.io.File"%>
<%@page import="java.nio.file.Paths"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Conexion" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String rutaBase = System.getProperty("user.dir");

    // En Eclipse, `user.dir` suele ser el directorio temporal de despliegue, por lo que necesitamos corregirlo.
    if (rutaBase.endsWith("eclipse-workspace")) {
        // Subir tres niveles desde el directorio de Eclipse para llegar a la raíz del proyecto
        rutaBase = new File(rutaBase).getParentFile().getParentFile().getParent();
    }

    // Ahora que tenemos la ruta base correcta del proyecto, construimos la ruta a las imágenes
    String rutaImagenes = rutaBase + File.separator + "ProyectoRestauranteChino" + File.separator + "vista" + File.separator + "img" + File.separator + "img_inventario";

    System.out.println(rutaImagenes);
	%>
</body>
</html>