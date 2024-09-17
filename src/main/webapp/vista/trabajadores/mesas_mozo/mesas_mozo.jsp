<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MESAS - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="mesas_mozo.css" rel="stylesheet" />
</head>
<body>

	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="titulo_mesas bg-success text-white p-3">
				<h1 class="text-center">GESTIONAR MESAS - 管理表</h1>


				<!-- Filtro de búsqueda -->
				<div class="row mb-4 g-2">
					<div class="col-md-6">
						<input type="text" class="form-control"
							placeholder="Buscar mesa (Nro o descripción)">
					</div>
					<div class="col-md-3">
						<select class="form-control">
							<option value="">Estado</option>
							<option value="disponible">Disponible</option>
							<option value="ocupado">Ocupado</option>
							<option value="limpieza">Limpieza</option>
						</select>
					</div>
					<div class="col-md-3">
						<button class="btn btn-primary w-100">Buscar</button>
					</div>
				</div>

				<!-- Tabla de mesas -->
				<div class="table-responsive">
					<table class="table table-bordered text-center">
						<thead>
							<tr>
								<th>Nro de Mesa</th>
								<th>Descripción</th>
								<th>Estado</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Mesa 01</td>
								<td>Cerca de la ventana</td>
								<td><span class="badge bg-success">Disponible</span></td>

								<td><button class="btn btn-primary" data-bs-toggle="modal"
										data-bs-target="#modalAsignar">Asignar Mesa</button></td>
							</tr>
							<tr>
								<td>Mesa 02</td>
								<td>Zona interior</td>
								<td><span class="badge bg-danger">Ocupado</span></td>
								<td>
									<button class="btn btn-secondary" disabled>Asignar
										Mesa</button>
								</td>
							</tr>
							<tr>
								<td>Mesa 03</td>
								<td>Zona exterior</td>
								<td><span class="badge bg-warning">Limpieza</span></td>
								<td><button class="btn btn-primary" data-bs-toggle="modal"
										data-bs-target="#modalAsignar">Asignar Mesa</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- Modal Asignar-->
				<div class="modal fade" id="modalAsignar" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog-centered modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-3 fw-semibold text-dark"
									id="exampleModalLabel">Asignar una Mesa</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form action="" class="needs-validation" novalidate>
									<div class="form-group mb-4 d-flex flex-wrap gap-2">
										<div class="col-12 col-md text-dark">
											<label for="salon">N&ordm; Salon</label> <input type="number"
												class="form-control" id="salon" aria-describedby="emailHelp"
												placeholder="Enter Number" name="numSalon" min="0" max="500"
												required>
										</div>
										<div class="col-12 col-md text-dark">
											<label for="mesa">N&ordm; Mesa</label> <input type="number"
												class="form-control" id="mesa" placeholder="Enter Number"
												name="numMesa" min="0" max="500" required>
										</div>
									</div>

									<div class="modal-footer">

										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Cerrar</button>
										<button type="submit" class="btn btn-warning">Crear</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>
