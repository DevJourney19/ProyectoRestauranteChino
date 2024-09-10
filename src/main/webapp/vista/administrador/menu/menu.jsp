<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./menu.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Menú</title>
</head>
<body>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="p-3 mx-md-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class="text-center d-flex align-items-center justify-content-center justify-content-lg-between flex-wrap mb-3 mb-md-2 gap-2">
							<h1>Gestión del Menú</h1>
							<button type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd"
								class="btn btn-warning fw-semibold d-flex align-items-center gap-2">
								<i class="lni lni-plus fw-bold"></i> Agregar Platillo
							</button>
						</div>
						<div
							class="d-flex align-items-center justify-content-center justify-content-md-end flex-wrap gap-md-4 gap-3">
							<button class="btn-pdf" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								<i class="lni lni-download"></i> Descargar PDF
							</button>

							<button class="btn-excel" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								<i class="lni lni-download"></i> Descargar Excel
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
										Agregar Platillo</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="nombre">Nombre</label> <input type="text"
													name="nombre" class="form-control" id="nombre"
													name="nombre" required>
											</div>
											<div class="col-12 col-md">
												<label for="categoria">Categoria</label> <input type="text"
													name="categoria" class="form-control" id="categoria"
													name="categoria" required>
											</div>
										</div>


										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="precio">Precio</label> <input type="number"
													class="form-control" id="precio" name="descripcion" min="0"
													name="number" step="0.01" required>
											</div>
											<div class="col-12 col-md">
												<label for="estado">Estado</label> <select
													class="form-select" aria-label="Default select example"
													name="estado" required>
													<option selected>En Venta</option>
													<option value="1">Desactivado</option>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="image" class="form-label">Imagen</label> <input
													class="form-control" type="file" id="image" name="image">
											</div>
										</div>

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md form-floating">
												<textarea class="form-control" name="descripcion"
													placeholder="Leave a comment here" id="descripcion"
													style="height: 100px"></textarea>
												<label for="descripcion">Descripcion</label>
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
										Editar Platillo</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="nombre">Nombre</label> <input type="text"
													name="nombre" class="form-control" id="nombre"
													name="nombre" required>
											</div>
											<div class="col-12 col-md">
												<label for="categoria">Categoria</label> <input type="text"
													name="categoria" class="form-control" id="categoria"
													name="categoria" required>
											</div>
										</div>


										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="precio">Precio</label> <input type="number"
													class="form-control" id="precio" name="descripcion" min="0"
													name="number" step="0.01" required>
											</div>
											<div class="col-12 col-md">
												<label for="estado">Estado</label> <select
													class="form-select" aria-label="Default select example"
													name="estado" required>
													<option selected>En Venta</option>
													<option value="1">Desactivado</option>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="image" class="form-label">Imagen</label> <input
													class="form-control" type="file" id="image" name="image">
											</div>
										</div>

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md form-floating">
												<textarea class="form-control" name="descripcion"
													placeholder="Leave a comment here" id="descripcion"
													style="height: 100px"></textarea>
												<label for="descripcion">Descripcion</label>
											</div>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">Editar</button>
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
									<p>Estas seguro de eliminar el platillo?</p>
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
									<th>Imagen</th>
									<th>Código</th>
									<th>Nombre</th>
									<th>Descripción</th>
									<th>Categoria</th>
									<th>Precio</th>
									<th>Estado</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><img src="img/1.png" class="img-menu img-fluid"></td>
									<td>P001</td>
									<td>Saltado de Pollo</td>
									<td>Este plato contiene...</td>
									<td>Comida China</td>
									<td>12.00</td>
									<td><span class="en-venta">En Venta</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can i_eliminar fs-4"></i>
											</button>
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td><img src="img/1.png" class="img-menu img-fluid"></td>
									<td>P002</td>
									<td>Chijaukay</td>
									<td>Este plato contiene...</td>
									<td>Comida China</td>
									<td>12.00</td>
									<td><span class="desactivado">Desactivado</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can i_eliminar fs-4"></i>
											</button>
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td><img src="img/1.png" class="img-menu img-fluid"></td>
									<td>P003</td>
									<td>Enrrollado de Pollo</td>
									<td>Este plato contiene...</td>
									<td>Comida China</td>
									<td>14.00</td>
									<td><span class="en-venta">En Venta</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can i_eliminar fs-4"></i>
											</button>
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td><img src="img/2.png" class="img-menu img-fluid"></td>
									<td>P004</td>
									<td>Torta de Chocolate</td>
									<td>Este postre contiene...</td>
									<td>Postres</td>
									<td>8.00</td>
									<td><span class="en-venta">En Venta</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can i_eliminar fs-4"></i>
											</button>
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td><img src="img/3.png" class="img-menu img-fluid"></td>
									<td>P005</td>
									<td>Inka Kola</td>
									<td>Esta bebida contiene...</td>
									<td>Bebidas</td>
									<td>10.00</td>
									<td><span class="en-venta">En Venta</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can i_eliminar fs-4"></i>
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
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>

			</main>
		</div>
	</div>
</body>
</html>
