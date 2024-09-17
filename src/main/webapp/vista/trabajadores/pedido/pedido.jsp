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