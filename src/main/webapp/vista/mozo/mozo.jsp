<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mozo</title>

<link href="../general_css/general_css.css" rel="stylesheet">
<link href="mozo_css.css" rel="stylesheet">
<%@include file="../fragmentos/link_bootstrap.jsp"%>
</head>
<body>

	<div class="restaurante_nombre">Noche en Pekín 北京之夜</div>
	<div class="pedidos_div">PEDIDOS</div>
	<div
		class="w-100 d-flex justify-content-center bg-color-primary
	align-items-center p-4">
		<button class="btn btn-primary p-4 px-5">Añadir Pedido</button>

	</div>
	<table class="table">
		<tr>
			<th>ID_PEDIDO</th>
			<th>Mesa</th>
			<th>Fecha</th>
			<th>Estado de pago</th>
			<th>Total</th>
			<th>Acciones</th>
		</tr>

	</table>


</body>
</html>