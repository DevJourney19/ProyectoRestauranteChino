<%@page import="java.sql.*"%>
<%@page import="util.Conexion"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	  Conexion con = new Conexion();
	%>
	<%= con.getConexion().toString() %>
</body>
</html>