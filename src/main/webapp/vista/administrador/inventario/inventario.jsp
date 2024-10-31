<%@page import="java.util.List"%>
<%@page import="modelo.Inventario"%>
<%@page import="modelo.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="inventario" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="categorias" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="vista/administrador/inventario/inventario.css">

<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | INVENTARIO</title>
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
							<h1>GESTIÓN DE INVENTARIO - 库存管理</h1>
							<span class="fs-3 numero-productos">200 items</span>
						</div>
						<div
							class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between gap-md-4 gap-3">
							<div class="d-flex align-items-center gap-2">
								<!-- Apareceran mas botones con categorias -->
								<button
									class="btn btn-warning d-flex align-items-center gap-2 fw-bolder">
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
									<form action="AgregarInventario" class="needs-validation"
										novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="producto">Producto</label> <input type="text"
													class="form-control" id="producto" name="producto" required>
											</div>
											<div class="col-12 col-md">
												<label for="familia">Categoria</label> <select id="familia"
													name="familia" class="form-select"
													aria-label="Default select example">
													<option selected>Selecciona categoria</option>
													<%
													List<Categoria> listaCategorias = (List<Categoria>) categorias;
													for (Categoria categoria : listaCategorias) {
													%>

													<option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>

										<!-- <div class="my-3">
											<label for="formFile" class="form-label">Elegir una
												imagen</label> <input class="form-control" type="file" id="formFile">
										</div>-->

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="unidad">Unidad</label> <select id="unidad"
													name="unidad" class="form-select"
													aria-label="Default select example">
													<option selected>Selecciona unidad</option>
													<%
													for (Inventario.Unidad unidad : Inventario.Unidad.values()) {
													%>
													<option value="<%=unidad%>"><%=unidad%></option>
													<%
													}
													%>
												</select>
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
												<label for="dias_caducidad">Días de Caducidad</label> <input
													type="date" class="form-control" id="dias_caducidad"
													name="dias_caducidad" placeholder="yyyy-MM-dd" required>
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

					<div class="table-responsive overflow-auto"
						style="max-height: 60vh">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Categoria</th>
									<th>Unidad</th>
									<th>Precio Unitario</th>
									<th>Inventario Inicial</th>
									<th>Stock</th>
									<th>Stock Mínimo</th>
									<th>Caducidad</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
								List<Inventario> listaInventario = (List<Inventario>) inventario;
								for (Inventario producto : listaInventario) {
									String estado = "estado-desconocido";
									if (producto.getStock() <= producto.getStockMin()) {
										estado = "estado-agotado";
									} else if (producto.getStock() > 0) {
										estado = "estado-disponible";
									} else {
										estado = "estado-en-orden";
									}
								%>

								<tr>
									<td><%=producto.getId()%></td>
									<td><%=producto.getNombre()%></td>
									<td><%=producto.getCategoria().getNombre()%></td>
									<td><%=producto.getUnidad()%></td>
									<td><%=producto.getPrecioUnitario()%></td>
									<td><%=producto.getInventarioInicial()%></td>
									<td><%=producto.getStock()%></td>
									<td class="<%=estado%>"><%=producto.getStockMin()%></td>
									<td><%=producto.getCaducidad()%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=producto.getId()%>" class="icon-action"
												data-bs-toggle="modal"
												data-bs-target="#staticBackdropInventario">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button data-id="<%=producto.getId()%>"
												data-nombre="<%=producto.getNombre()%>"
												data-categoria="<%=producto.getCategoria().getId()%>"
												data-unidad="<%=producto.getUnidad()%>"
												data-precio="<%=producto.getPrecioUnitario()%>"
												data-inventario-inicial="<%=producto.getInventarioInicial()%>"
												data-stock="<%=producto.getStock()%>"
												data-stock-min="<%=producto.getStockMin()%>"
												data-caducidad="<%=producto.getCaducidad()%>"
												class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEditInventario">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>

						<!-- Modal de eliminación -->
						<div class="modal fade" id="staticBackdropInventario"
							tabindex="-1" aria-labelledby="staticBackdropLabel"
							aria-hidden="true">
							<div class="modal-dialog-centered modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="staticBackdropLabel">Eliminar
											Producto</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body fw-medium fs-4">
										¿Estás seguro de que deseas eliminar el producto con ID <span
											id="modalIdEliminarInventario"></span>?
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Cerrar</button>
										<button type="button" class="btn btn-warning"
											id="eliminarIdInventario">Eliminar</button>
									</div>
								</div>
							</div>
						</div>

						<!-- Modal de edición -->
						<div class="modal fade" id="modalEditInventario" tabindex="-1"
							aria-labelledby="modalEditInventarioLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modalEditInventarioLabel">Editar
											Producto</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<div class="mb-3">
												<label for="editNombreProducto" class="form-label">Nombre</label>
												<input type="text" class="form-control"
													id="editNombreProducto">
											</div>
											<div class="mb-3">
												<label for="editCategoria">Categoria</label> <select id="editCategoria"
													name="editCategoria" class="form-select"
													aria-label="Default select example">
													<option selected>Selecciona categoria</option>
													<%
													for (Categoria categoria : listaCategorias) {
													%>
													<option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
													<%
													}
													%>
												</select>
											</div>
											<div class="mb-3">
												<label for="editUnidad">Unidad</label> <select id="editUnidad"
													name="editUnidad" class="form-select"
													aria-label="Default select example">
													<option selected>Selecciona unidad</option>
													<%
													for (Inventario.Unidad unidad : Inventario.Unidad.values()) {
													%>
													<option value="<%=unidad%>"><%=unidad%></option>
													<%
													}
													%>
												</select>
											</div>
											<div class="form-group mb-4 d-flex flex-wrap gap-2">
												<div class="col-12 col-md">
													<label for="editPrecioUnitario" class="form-label">Precio
														Unitario</label> <input type="number" class="form-control"
														id="editPrecioUnitario">
												</div>
												<div class="col-12 col-md">
													<label for="editInventarioInicial" class="form-label">Inventario
														Inicial</label> <input type="number" class="form-control"
														id="editInventarioInicial">
												</div>
											</div>
											<div class="form-group mb-4 d-flex flex-wrap gap-2">
												<div class="col-12 col-md">
													<label for="editStock" class="form-label">Stock</label> <input
														type="number" class="form-control" id="editStock">
												</div>
												<div class="col-12 col-md">
													<label for="editStockMinimo" class="form-label">Stock
														Mínimo</label> <input type="number" class="form-control"
														id="editStockMinimo">
												</div>
											</div>
											<div class="mb-3">
												<label for="editCaducidad" class="form-label">Caducidad</label>
												<input type="date" class="form-control" id="editCaducidad">
											</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Cerrar</button>
										<button type="button" class="btn btn-warning"
											id="editarIdInventario">Guardar Cambios</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<script>
    window.onload = function() {
        const urlParams = new URLSearchParams(window.location.search);
        const mensaje = urlParams.get('mensaje');

        if (mensaje) {
            alert(mensaje);
            // Eliminar el parámetro 'mensaje' de la URL
            urlParams.delete('mensaje');
            // Actualizar la URL sin recargar la página
            window.history.replaceState({}, document.title, window.location.pathname + (urlParams.toString() ? '?' + urlParams.toString() : ''));
        }
    };
		// Modal de eliminación para inventario
		document
				.getElementById('staticBackdropInventario')
				.addEventListener(
						'show.bs.modal',
						function(event) {
							const button = event.relatedTarget;
							const id = button.getAttribute('data-id');
							document
									.getElementById('modalIdEliminarInventario').innerHTML = "#"
									+ id;

							document
									.getElementById('eliminarIdInventario')
									.addEventListener(
											'click',
											function(event) {
												window.location.href = "/ProyectoRestauranteChino/EliminarInventario?id="
														+ id;
											});
						});

		// Modal de edición para inventario
		document
				.getElementById('modalEditInventario')
				.addEventListener(
						'show.bs.modal',
						function(event) {
							const button = event.relatedTarget;
							const id = button.getAttribute('data-id');
							let nombreProducto = button
									.getAttribute('data-nombre');
							let unidad = button.getAttribute('data-unidad');
							let precioUnitario = button
									.getAttribute('data-precio');
							let inventarioInicial = button
									.getAttribute('data-inventario-inicial');
							let stock = button.getAttribute('data-stock');
							let stockMinimo = button
									.getAttribute('data-stock-min');
							let caducidad = button
									.getAttribute('data-caducidad');
							let categoria = button.getAttribute('data-categoria');

							document.getElementById('editNombreProducto').value = nombreProducto;
							document.getElementById('editUnidad').value = unidad;
							document.getElementById('editPrecioUnitario').value = precioUnitario;
							document.getElementById('editInventarioInicial').value = inventarioInicial;
							document.getElementById('editStock').value = stock;
							document.getElementById('editStockMinimo').value = stockMinimo;
							document.getElementById('editCaducidad').value = caducidad;
							document.getElementById('editCategoria').value = categoria;

							document
									.getElementById('editarIdInventario')
									.addEventListener(
											'click',
											function(event) {
												nombreProducto = document
														.getElementById('editNombreProducto').value;
												unidad = document
														.getElementById('editUnidad').value;
												precioUnitario = document
														.getElementById('editPrecioUnitario').value;
												inventarioInicial = document
														.getElementById('editInventarioInicial').value;
												stock = document
														.getElementById('editStock').value;
												stockMinimo = document
														.getElementById('editStockMinimo').value;
												caducidad = document
														.getElementById('editCaducidad').value;
												estado = document
														.getElementById('editCategoria').value;

												window.location.href = "/ProyectoRestauranteChino/EditarInventario?id="
														+ id
														+ "&nombre="
														+ nombreProducto
														+ "&unidad="
														+ unidad
														+ "&precio="
														+ precioUnitario
														+ "&inventario="
														+ inventarioInicial
														+ "&stock="
														+ stock
														+ "&stockMinimo="
														+ stockMinimo
														+ "&caducidad="
														+ caducidad
														+ "&categoria=" + categoria;
											});
						});
	</script>

</body>
</html>