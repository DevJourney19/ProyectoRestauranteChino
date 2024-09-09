<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="pedidos.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Pedidos</title>
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
							class="text-center d-md-flex align-items-center justify-content-between flex-wrap">
							<h1>Gestión de Pedidos</h1>
							<span class="fs-3 numero-mesas text-center">200 pedidos</span>
						</div>
						<div
							class="d-flex align-items-center justify-content-center mt-2 mt-md-0 justify-content-md-end gap-4">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Nuevo Pedido <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<!-- Modal Agregar -->
					<div class="modal fade" id="modalAdd" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Agrega Pedido</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">DNI Cliente</label> <input type="text"
												class="form-control" id="client"
												aria-describedby="emailHelp" placeholder="Enter Number"
												name="cliente" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">N&ordm; Mesa</label> <input
												type="number" step="1" class="form-control" id="client"
												aria-describedby="emailHelp" placeholder="Enter Mesa"
												name="numMesa" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Total</label> <input type="number"
												step="0.01" class="form-control" id="totalPagar"
												aria-describedby="emailHelp" placeholder="Enter Total"
												name="totalPagar" required>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">
												Agregar Pedido</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal Editar -->
					<div class="modal fade" id="modalEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Editar Pedido</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">DNI Cliente</label> <input type="text"
												class="form-control" id="client"
												aria-describedby="emailHelp" placeholder="Enter Number"
												name="cliente" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">N&ordm; Mesa</label> <input
												type="number" step="1" class="form-control" id="client"
												aria-describedby="emailHelp" placeholder="Enter Mesa"
												name="numMesa" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Total</label> <input type="number"
												step="0.01" class="form-control" id="totalPagar"
												aria-describedby="emailHelp" placeholder="Enter Total"
												name="totalPagar" required>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">
												Editar Pedido</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal de Eliminar -> recibir un data value -->
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
									<p>Estas seguro de eliminar este Pedido?</p>
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
									<!-- Puede ir DNI o nombre para utilizar api de buscar datos -->
									<th>DNI Cliente</th>
									<th>N&ordm; Mesa</th>
									<th>Estado</th>
									<th>Total Pago</th>
									<th>Fecha Creacion</th>
									<th>Ver Detalle Pedido</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>95784638</td>
									<td>1</td>
									<td><span class="estado-cancelado">Cancelado</span></td>
									<td>35.6</td>
									<td><%=new Date()%></td>
									<!-- pasar un id del pedido para filtrar -->
									<td><a href="detalle_pedido.jsp"
										class="fs-4 icon-see d-flex justify-content-center"><i
											class="fw-semibold lni lni-eye"></i></a></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>95784638</td>
									<td>2</td>
									<td><span class="estado-pendiente">Pendiente</span></td>
									<td>35.6</td>
									<td><%=new Date()%></td>
									<!-- pasar un id del pedido para filtrar -->
									<td><a href="detalle_pedido.jsp"
										class="fs-4 icon-see d-flex justify-content-center"><i
											class="fw-semibold lni lni-eye"></i></a></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
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