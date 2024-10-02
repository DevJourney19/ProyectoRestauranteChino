<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Inventario - Noche en Pekín</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="inventario.css" rel="stylesheet" />
</head>
<body class="body">
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="container">
				<h1 class="text-center py-4">INVENTARIO - 存货</h1>

				<div class="row overflow-auto inventario_row">
					<div class="col-6 col-md-4 col-lg-3">
						<div class="card mb-4 p-3">
							<div class="row no-gutters">
								<img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
								<div class="card-body text-center">
									<h5 class="card-title">Arroz</h5>
									<p class="card-text">Stock</p>
									<h2 class="fw-semibold">20 KG</h2>
									<button class="btn btn-warning" data-bs-toggle="modal"
										data-bs-target="#modalEdit">
										<i class="fa-solid fa-edit" style="color: #000000;"></i>
										Modificar
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="col-6 col-md-4 col-lg-3">
						<div class="card mb-4 p-3">
							<div class="row no-gutters">
								<img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
								<div class="card-body text-center">
									<h5 class="card-title">Manies</h5>
									<p class="card-text">Stock</p>
									<h2 class="fw-semibold">20 UND</h2>
									<button class="btn btn-warning" data-bs-toggle="modal"
										data-bs-target="#modalEdit">
										<i class="fa-solid fa-edit" style="color: #000000;"></i>
										Modificar
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Editar-->
	<div class="modal fade" id="modalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog-centered modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
						Editar Stock Item</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="" class="needs-validation" novalidate>
						<div class="col-12 col-md">
							<label for="stock_inicial">Stock Actual</label> <input
								type="number" class="form-control" id="stock_inicial"
								name="stock_inicial" required min="0" max="1000">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-warning">Guardar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>

</html>