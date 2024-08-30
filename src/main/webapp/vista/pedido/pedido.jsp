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
		<a class="aniadir_pedido" href="../mesa/mesa.jsp"> <img
			src="../img/boton-mas.png" style="widh: 40px; height: 40px">
			Añadir Pedido
		</a>
	</div>

	<div class="container" style="background-color: transparent">
		<div class="p-3 border rounded bg-white"
			style="width: 300px; position: relative">
			<div class="mesa_numero">M01</div>
			<div
				style="position: absolute; top: 20px; left: 62px; font-size: 1.2rem">Cliente</div>
			<div class="completado">
				<i class="fa-solid fa-square-check" style="color: #000000;"></i>
				Completado
			</div>
			<div class="pedido_especifico_numero_pedido">Pedido #0000000</div>
			<div class="d-flex justify-content-between mt-2"
				style="font-size: 0.9rem">
				<div>29/08/2024</div>
				<div>21:00 PM</div>
			</div>
			<hr />
			<div class="table-responsive ">
				<table class="table text-center" style="border: transparent;">
					<thead>
						<tr style="font-size: 1rem">
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Importe+incl.</th>
						</tr>
					</thead>
					<tbody>
						<tr style="font-size: 1rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 1rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 1rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 1rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 1rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>

					</tbody>
				</table>
				<hr />
				<div class="d-flex justify-content-between mb-3"
					style="font-size: 1rem; font-weight: 600">
					<div>Total</div>
					<div>S/. 200</div>
				</div>
				<div class="d-flex justify-content-evenly">
					<form action="../detalle_pedido/detalle_pedido.jsp" method="post">
						<button class="btn btn-warning">Detalles</button>
					</form>
					<form action="../pagar/pagar.jsp" method="post">
						<button class="btn btn-success">Pagar</button>
					</form>
				</div>
			</div>

		</div>
	</div>


	<!-- 	<div class="container"> -->

	<!-- 		<div class="table-responsive"> -->
	<!-- 			<table -->
	<!-- 				class="table w-100  -->
	<!-- 				 table-bordered table-hover fs-2 text-center"> -->
	<!-- 				<thead> -->
	<!-- 					<tr class="table-dark"> -->
	<!-- 						<th>ID_PEDIDO</th> -->
	<!-- 						<th>Mesa</th> -->
	<!-- 						<th>Fecha</th> -->
	<!-- 						<th>Estado de pago</th> -->
	<!-- 						<th>Total</th> -->
	<!-- 						<th colspan="3">Acciones</th> -->
	<!-- 					</tr> -->
	<!-- 				</thead> -->
	<!-- 				<tbody> -->
	<!-- 					<tr> -->
	<!-- 						<th>1</th> -->
	<!-- 						<th>2</th> -->
	<!-- 						<th>29/08/2024</th> -->
	<!-- 						<th>Pendiente</th> -->
	<!-- 						<th>100</th> -->
	<!-- 						<th><a class="btn btn-success">PAGAR</a></th> -->
	<!-- 						<th><a href="../detalle_pedido/detalle_pedido.jsp" -->
	<!-- 							class="btn btn-warning">Detalle</a></th> -->
	<!-- 						<th><a class="btn btn-danger">Eliminar</a></th> -->
	<!-- 					</tr> -->
	<!-- 				</tbody> -->
	<!-- 			</table> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>