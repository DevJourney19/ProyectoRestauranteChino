<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="mesas.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Mesas</title>
</head>
<body>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<nav class="navbar navbar-expand d-flex align-items-center">
				<button class="toggler-btn" type="button">
					<i class="lni lni-text-align-left"></i>
				</button>
				<div class="navbar-logo collapsed" id="logo">
					<a href="#">Noche en Pekín 北京之夜</a>
				</div>
			</nav>
			<main class="p-3 mx-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class=" text-center d-flex align-items-center justify-content-between">
							<h1>Gestión de Mesas</h1>
							<span class="fs-3 numero-mesas">200 mesas</span>
						</div>
						<div
							class="d-flex align-items-center justify-content-between gap-4">
							<div class="d-flex align-items-center gap-2">
								<!-- Apareceran mas botones con categorias -->
								<button class="btn-filtrar">
									Filtrar <i class="lni lni-funnel"></i>
								</button>
							</div>
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								Nueva Mesa <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<!-- Modal Agregar o Editar (para verificar editar solo ver la url)-->
					<div class="modal fade" id="modalAddEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Agrega Otra Mesa</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div>
												<label for="salon">N&ordm; Salon</label> <input
													type="number" class="form-control" id="salon"
													aria-describedby="emailHelp" placeholder="Enter Number"
													name="numSalon" required>
											</div>
											<div>
												<label for="mesa">N&ordm; Mesa</label> <input type="number"
													class="form-control" id="mesa" placeholder="Enter Number"
													name="numMesa" required>
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


					<!-- Modal de Eliminar -> recibir un data value-->
					<div class="modal fade" id="staticBackdrop"
						data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
						aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body fw-medium fs-4">
								<p>Estas seguro de eliminar la mesa?</p>
								<p>#1</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-warning"
										data-bs-dismiss="modal">Cancelar</button>
										<form action="">
									<button type="button" class="btn btn-danger d-flex align-items-center gap-2"> <i class="lni lni-trash-can"></i>Eliminar</button></form>
								</div>
							</div>
						</div>
					</div>

					<div class="table-responsive overflow-auto">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>N&ordm; Salon</th>
									<th>N&ordm; Mesa</th>
									<th>Estado</th>
									<th>Fecha Creacion</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td><span class="estado-libre">Libre</span></td>
									<td><%=new Date()%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>2</td>
									<td><span class="estado-ocupado">Ocupado</span></td>
									<td><%=new Date()%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>