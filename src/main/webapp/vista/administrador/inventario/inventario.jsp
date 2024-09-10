<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="inventario.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Inventario</title>
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
							class="text-center d-md-flex align-items-center justify-content-between flex-wrap mb-2">
							<h1>Gestión de Inventario</h1>
							<span class="fs-3 numero-productos">200 items</span>
						</div>
						<div
							class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between gap-md-4 gap-3">
							<div class="d-flex align-items-center gap-2">
								<!-- Apareceran mas botones con categorias -->
								<button class="btn btn-warning d-flex align-items-center gap-2">
									Filtrar <i class="lni lni-funnel"></i>
								</button>
							</div>
							<button class="btn btn-success d-flex align-items-center gap-2"
								type="button" data-bs-toggle="modal" data-bs-target="#modalAdd">
								Nuevo Item <i class="lni lni-plus"></i>
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
										Agregar Item</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="familia">Categoria</label> <input type="text"
													class="form-control" id="familia" name="familia" required>
											</div>
											<div class="col-12 col-md">
												<label for="producto">Producto</label> <input type="text"
													class="form-control" id="producto" name="producto" required>
											</div>
										</div>


										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="unidad">Unidad</label> <input type="text"
													class="form-control" id="unidad" name="unidad" required>
											</div>
											<div class="col-12 col-md">
												<label for="costo_unitario">Costo Unitario</label> <input
													type="number" class="form-control" id="costo_unitario"
													name="costo_unitario" step="0.01" required min="0" max="500">
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="inventario_inicial">Inventario Inicial</label> <input
													type="number" class="form-control" id="inventario_inicial"
													name="inventario_inicial" required min="0" max="1000">
											</div>

											<div class="col-12 col-md">
												<label for="stock_inicial">Stock Actual</label> <input
													type="number" class="form-control" id="stock_inicial"
													name="stock_inicial" required min="0" max="1000">
											</div>
										</div>

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="stock_minimo">Stock Mínimo</label> <input
													type="number" class="form-control" id="stock_minimo"
													name="stock_minimo" required min="0" max="1000">
											</div>


											<div class="col-12 col-md">
												<label for="dias_caducidad">Días de Caducidad:</label> <input
													type="number" class="form-control" id="dias_caducidad"
													name="dias_caducidad" required min="0" max="500">
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
										Editar Item</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="familia">Categoria</label> <input type="text"
													class="form-control" id="familia" name="familia" required>
											</div>
											<div class="col-12 col-md">
												<label for="producto">Producto</label> <input type="text"
													class="form-control" id="producto" name="producto" required>
											</div>
										</div>


										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="unidad">Unidad</label> <input type="text"
													class="form-control" id="unidad" name="unidad" required>
											</div>
											<div class="col-12 col-md">
												<label for="costo_unitario">Costo Unitario</label> <input
													type="number" class="form-control" id="costo_unitario"
													name="costo_unitario" step="0.01" required min="0"
													max="500">
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="inventario_inicial">Inventario Inicial</label> <input
													type="number" class="form-control" id="inventario_inicial"
													name="inventario_inicial" required min="0" max="1000">
											</div>

											<div class="col-12 col-md">
												<label for="stock_inicial">Stock Actual</label> <input
													type="number" class="form-control" id="stock_inicial"
													name="stock_inicial" required min="0" max="1000">
											</div>
										</div>

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="stock_minimo">Stock Mínimo</label> <input
													type="number" class="form-control" id="stock_minimo"
													name="stock_minimo" required min="0" max="1000">
											</div>


											<div class="col-12 col-md">
												<label for="dias_caducidad">Días de Caducidad:</label> <input
													type="number" class="form-control" id="dias_caducidad"
													name="dias_caducidad" required min="0" max="500">
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
									<p>Estas seguro de eliminar el producto?</
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
									<th>Categoria</th>
									<th>Producto</th>
									<th>Unidad</th>
									<th>Costo Unitario</th>
									<th>Inventario Inicial</th>
									<th>Stock Actual</th>
									<th>Stock Mínimo</th>
									<th>Días de Caducidad</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Frutas</td>
									<td>Manzana</td>
									<td>KG</td>
									<td>2.50</td>
									<td>100</td>
									<td><span class="stock-alto">20</span></td>
									<td>5</td>
									<td><span class="badge rounded-pill text-bg-danger">5
											días</span></td>
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
									<td>2</td>
									<td>Verduras</td>
									<td>Zanahoria</td>
									<td>UND</td>
									<td>1.20</td>
									<td>200</td>
									<td><span class="stock-bajo">5</span></td>
									<td>5</td>
									<td><span class="badge rounded-pill text-bg-success">20
											días</span></td>
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
	<script type="text/javascript" src="inventario.js"></script>
</body>
</html>