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
<style>
   body {
      background-color: var(--rojo); /* Cambia el color de fondo a un gris claro */
   }
</style>
</head>
<body class="body">

	<div class="restaurante_nombre">Noche en Pekín 北京之夜</div>
	<div class="pedidos_div">PEDIDOS</div>
	<div
		class="container-full w-100 d-flex justify-content-center bg-color-primary
	align-items-center p-4">
		<button class="btn btn-primary" style="height: 120px; width:400px;">Añadir Pedido</button>

	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table
						class="table w-100 
				table-striped table-bordered fs-2">
						<thead>
							<tr>
								<th>ID_PEDIDO</th>
								<th>Mesa</th>
								<th>Fecha</th>
								<th>Estado de pago</th>
								<th>Total</th>
								<th>Acciones</th>
								<th>Acciones</th>
								<th>Acciones</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>ID_PEDIDO</td>
								<td>Mesa</td>
								<td>Fecha</td>
								<td>Estado de pago</td>
								<td>Total</td>
								<td>Acciones</td>
								<td>Acciones</td>
								<td>Acciones</td>
							</tr>
							<tr>
								<td>ID_PEDIDO</td>
								<td>Mesa</td>
								<td>Fecha</td>
								<td>Estado de pago</td>
								<td>Total</td>
								<td>Acciones</td>
								<td>Acciones</td>
								<td>Acciones</td>
							</tr>
							<tr>
								<td>ID_PEDIDO</td>
								<td>Mesa</td>
								<td>Fecha</td>
								<td>Estado de pago</td>
								<td>Total</td>
								<td>Acciones</td>
								<td>Acciones</td>
								<td>Acciones</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>







</body>
</html>