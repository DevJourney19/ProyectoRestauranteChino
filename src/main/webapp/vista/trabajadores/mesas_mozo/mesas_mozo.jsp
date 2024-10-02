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
			<div class="titulo_mesas text-white p-3">
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

								<td><button class="btn btn-primary">Asignar Mesa</button></td>
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
								<td><button class="btn btn-primary">Asignar Mesa</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>
