<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trabajadores | Inventario</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="inventario.css" rel="stylesheet" />
</head>
<body class="body">

	<main>
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main-content">
			<div class="titulo_inventario">Noche en Pekín 北京之夜</div>
			<div class="container">
				<h2 class="my-2">Inventario</h2>
				<div class="mb-3">
					<form action="crear_item.jsp" method="post">
						<button class="btn btn-success">
							<i class="fa-solid fa-add" style="color: #ffffff;"></i> Nuevo
							Item
						</button>
					</form>
				</div>

				<div class="row">
					<div class="col-6 col-md-4 col-lg-3">
						<div class="card mb-4 p-4">
							<div class="row no-gutters">
								<img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
								<div class="card-body text-center">
									<h5 class="card-title">Arroz</h5>
									<p class="card-text">Stock</p>
									<h1>20 KG</h1>
									<form action="modificar_item.jsp" method="post"
										style="display: inline;">
										<input type="hidden" name="id" value="1">
										<button class="btn btn-warning">
											<i class="fa-solid fa-edit" style="color: #000000;"></i>
											Modificar
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col-6 col-md-4 col-lg-3">
						<div class="card mb-4 p-4">
							<div class="row no-gutters">
								<img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
								<div class="card-body text-center">
									<h5 class="card-title">Manies</h5>
									<p class="card-text">Stock</p>
									<h1>20 UND</h1>
									<form action="modificar_item.jsp" method="post"
										style="display: inline;">
										<input type="hidden" name="id" value="1">
										<button class="btn btn-warning">
											<i class="fa-solid fa-edit" style="color: #000000;"></i>
											Modificar
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col-6 col-md-4 col-lg-3">
						<div class="card mb-4 p-4">
							<div class="row no-gutters">
								<img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
								<div class="card-body text-center">
									<h5 class="card-title">Tomate</h5>
									<p class="card-text">Stock</p>
									<h1>20 KG</h1>
									<form action="modificar_item.jsp" method="post"
										style="display: inline;">
										<input type="hidden" name="id" value="1">
										<button class="btn btn-warning">
											<i class="fa-solid fa-edit" style="color: #000000;"></i>
											Modificar
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</main>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>
