<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="mesas.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | MESAS</title>
</head>
<body>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="p-3 mx-lg-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class=" text-center d-md-flex align-items-center justify-content-between">
							<h1>GESTIÓN DE MESAS - 餐桌管理</h1>
							<span class="fs-3 numero-mesas">200 mesas</span>
						</div>
						<div
							class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between gap-md-4 gap-3">
							<div class="d-flex align-items-center gap-2">
								<!-- Apareceran mas botones con categorias -->
								<button class="btn-filtrar">
									Filtrar <i class="lni lni-funnel"></i>
								</button>
							</div>
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Nueva Mesa <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<!-- Modal Agregar-->
					<div class="modal fade" id="modalAdd" tabindex="-1"
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
											<div class="col-12 col-md">
												<label for="salon">N&ordm; Salon</label> <input
													type="number" class="form-control" id="salon"
													aria-describedby="emailHelp" placeholder="Enter Number"
													name="numSalon" required min="0" max="500">
											</div>
											<div class="col-12 col-md">
												<label for="mesa">N&ordm; Mesa</label> <input type="number"
													class="form-control" id="mesa" placeholder="Enter Number"
													name="numMesa" required min="0" max="500">
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

					<!-- Modal Editar-->
					<div class="modal fade" id="modalEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Editar Mesa</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="salon">N&ordm; Salon</label> <input
													type="number" class="form-control" id="salon"
													aria-describedby="emailHelp" placeholder="Enter Number"
													name="numSalon" required>
											</div>
											<div class="col-12 col-md">
												<label for="mesa">N&ordm; Mesa</label> <input type="number"
													class="form-control" id="mesa" placeholder="Enter Number"
													name="numMesa" required>
											</div>
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
										<button type="button"
											class="btn btn-danger d-flex align-items-center gap-2">
											<i class="lni lni-trash-can"></i>Eliminar
										</button>
									</form>
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
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>2</td>
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