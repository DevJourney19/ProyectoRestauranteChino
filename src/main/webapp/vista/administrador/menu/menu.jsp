<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/menu.css">
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
							class="text-center d-md-flex align-items-center justify-content-between">
							<h1>Gestión del Menú</h1>
						</div>
						<div class="d-flex align-items-center justify-content-center justify-content-md-end flex-wrap gap-md-4 gap-3">
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

					<div class="table-responsive overflow-auto">
						<table class="table">
							<thead>
								<tr>
									<th>Imagen</th>
									<th>Código</th>
									<th>Nombre</th>
									<th>Descripción</th>
									<th>Categoria</th>
									<th>Stock</th>
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
									<td>14</td>
									<td>12.00</td>									
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
									<td><img src="img/1.png" class="img-menu img-fluid"></td>
									<td>P002</td>
									<td>Chijaukay</td>
									<td>Este plato contiene...</td>
									<td>Comida China</td>
									<td>0</td>
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
									<td>11</td>
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
									<td>20</td>
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
									<td>38</td>
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
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li class="page-item"><a class="page-link" href="#">1</a></li>
					    <li class="page-item"><a class="page-link" href="#">2</a></li>
					    <li class="page-item"><a class="page-link" href="#">3</a></li>
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
				</div>
				
			</main>
		</div>
	</div>
</body>
</html>