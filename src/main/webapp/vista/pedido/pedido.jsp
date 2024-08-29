<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>Mozo</title>
<%@include file="../fragmentos/link_bootstrap.jsp"%>
<link href="../general_css/general_css.css" rel="stylesheet" />
<link href="pedido_css.css" rel="stylesheet" />


</head>
<body class="body">

	<div class="restaurante_nombre">Noche en Pekín 北京之夜</div>
	<div class="pedidos_div">PEDIDOS</div>
	<div
		class="container w-100 d-flex justify-content-center 
	align-items-center p-4">
		<a class="aniadir_pedido" href="../detalle_pedido/detalle_pedido.jsp">
			<img src="../img/boton-mas.png" style="widh: 60px; height: 60px">
			Añadir Pedido
		</a>
	</div>

	<div class="container">

		<div class="table-responsive">
			<table
				class="table w-100 
				 table-bordered table-hover fs-2 text-center">
				<thead>
					<tr class="table-dark">
						<th>ID_PEDIDO</th>
						<th>Mesa</th>
						<th>Fecha</th>
						<th>Estado de pago</th>
						<th>Total</th>
						<th colspan="3">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<tr>

					</tr>
					<tr>


					</tr>
					<tr>


					</tr>
				</tbody>
			</table>
		</div>
	</div>









</body>
</html>