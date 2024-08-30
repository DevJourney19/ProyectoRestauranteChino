<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="pedidos.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Detalle Pedido</title>
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
							<h1>Gestión de Detalle Pedido</h1>
						</div>
						<div class="d-flex align-items-center justify-content-end gap-4">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								Agregar Detalles Pedidos <i class="lni lni-plus"></i>
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
										Agrega Detalle</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">Platos</label>
											<!-- realizar busqueda -->
											<select class="form-select" aria-label="Default select example" required>
  <option selected>Seleccionar Platos</option>
  <option value="1">Arroz Con Pollo - Principal</option>
  <option value="2">Cheescake - Postre</option>
  <option value="3">Ceviche - Principal</option>
</select>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div>
												<label for="cantidad">Cantidad</label> <input type="number"
													step="1" class="form-control" id="cantidad"
													aria-describedby="emailHelp" placeholder="Enter Mesa"
													name="numMesa" required>
											</div>
											<div>
												<label for="subtotal">Subtotal</label> <input type="number"
													step="0.01" class="form-control" id="subtotal"
													aria-describedby="emailHelp" placeholder="Enter Total"
													name="totalPagar" required>
											</div>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">
												Agregar</button>
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
									<p>Estas seguro de eliminar este Detalle?</p>
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
									<th>Producto</th>
									<th>Cantidad</th>
									<th>Subtotal</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>95784638</td>
									<td>1</td>
									<td>35.6</td>
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
								<tr>
									<td>1</td>
									<td>95784638</td>
									<td>2</td>
									<td>35.6</td>
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
					<div class="regresar">
						<a href="pedidos.jsp"><i class="lni lni-arrow-left"></i>Regresar Pedidos</a>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>