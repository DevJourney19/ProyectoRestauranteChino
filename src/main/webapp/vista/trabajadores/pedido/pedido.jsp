<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>PEDIDO - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="pedido.css" rel="stylesheet" />

</head>
<body class="body">
<<<<<<< HEAD
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main>
				<h1 class="text-center">PEDIDOS REALIZADOS- 已下订单</h1>
				<div class="d-flex justify-content-end 
	align-items-center px-5">
					<a class="aniadir_pedido" href="../mesas_mozo/mesas_mozo.jsp">
						<img src="../../img/boton-mas.png"
						style="widh: 40px; height: 40px"> Añadir Pedido
					</a>
=======
		<%@ include file="../fragmentos/sidebar.jsp"%>

	<div class="restaurante_nombre">Noche en Pekín 北京之夜</div>
	<div class="pedidos_div">PEDIDOS</div>
	<div
		class="container w-100 d-flex justify-content-center 
	align-items-center p-4">
		<a class="aniadir_pedido" href="../mesa/mesa.jsp"> <img
			src="../../img/boton-mas.png" style="widh: 40px; height: 40px">
			Añadir Pedido
		</a>
	</div>

	<div class="container" style="background-color: transparent">
		<div class="p-3 border rounded bg-white"
			style="width: 320px; position: relative">
			<div class="mesa_numero">M01</div>
			<div
				style="position: absolute; top: 20px; left: 62px; font-size: 1rem">Cliente</div>
			<div class="completado">
				<i class="fa-solid fa-square-check" style="color: #000000;"></i>
				Completado
			</div>
			<div class="pedido_especifico_numero_pedido">Pedido #0000000</div>
			<div class="d-flex justify-content-between mt-2"
				style="font-size: 0.7rem">
				<div>29/08/2024</div>
				<div>21:00 PM</div>
			</div>
			<hr />
			<div class="table-responsive ">
				<table class="table text-center" style="border: transparent;">
					<thead>
						<tr style="font-size: 0.8rem">
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Subtotal</th>
						</tr>
					</thead>
					<tbody>
						<tr style="font-size: 0.8rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 0.8rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 0.8rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 0.8rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>
						<tr style="font-size: 0.8rem">
							<th>Chaufa</th>
							<th>2</th>
							<th>S/. 40</th>

						</tr>

					</tbody>
				</table>
				<hr />
				<div class="d-flex justify-content-between mb-3"
					style="font-size: 0.8rem; font-weight: 600">
					<div>Total</div>
					<div>S/. 200</div>
>>>>>>> origin/inventario
				</div>

				<div class="container">
					<div class="row row-cols-1  row-cols-xl-3 g-2">
						<%@include file="../fragmentos/pedido_realizado.jsp"%>
						<%@include file="../fragmentos/pedido_realizado.jsp"%>
						<%@include file="../fragmentos/pedido_realizado.jsp"%>
						<%@include file="../fragmentos/pedido_realizado.jsp"%>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>