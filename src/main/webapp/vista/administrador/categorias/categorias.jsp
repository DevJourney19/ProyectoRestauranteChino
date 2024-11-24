<%@page import="java.util.List"%>
<%@page import="modelo.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="categorias" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="vista/administrador/categorias/categorias.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | CATEGORIAS</title>
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
							<h1>GESTIÓN DE CATEGORIAS - 品类管理</h1>
						</div>
						<div
							class="d-flex align-items-center justify-content-center mt-2 mt-md-0 justify-content-md-end gap-4">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Nueva Categoria <i class="lni lni-plus"></i>
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
										Agregar Categoria</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="AgregarCategoria" class="needs-validation"
										novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="nombre">Nombre</label> <input type="text"
													class="form-control" id="nombre"
													aria-describedby="emailHelp" placeholder="Ingrese Nombre"
													name="nombre" required>
											</div>
											<div class="col-12 col-md">
												<label for="tipo">Tipo</label> <select id="tipo" name="tipo"
													class="form-select" aria-label="Default select example"
													required>
													<option selected disabled>Selecciona el tipo</option>
													<%
													for (Categoria.TipoCategoria tipo : Categoria.TipoCategoria.values()) {
													%>
													<option value="<%=tipo%>"><%=tipo%></option>
													<%
													}
													%>
												</select>
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

					<!-- Modal Editar -->
					<div class="modal fade" id="modalEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Editar Usuario</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="form-group mb-4 d-flex flex-wrap gap-2">
										<div class="col-12 col-md">
											<label for="editNombre">Nombre</label> <input type="text"
												class="form-control" id="editNombre"
												aria-describedby="emailHelp" placeholder="Ingrese Nombre"
												name="nombre" required>
										</div>
										<div class="col-12 col-md">
											<label for="editTipo">Tipo</label> <select id="editTipo"
												name="tipo" class="form-select"
												aria-label="Default select example" required>
												<option selected disabled>Selecciona el tipo</option>
												<%
												for (Categoria.TipoCategoria tipo : Categoria.TipoCategoria.values()) {
												%>
												<option value="<%=tipo%>"><%=tipo%></option>
												<%
												}
												%>
											</select>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Cerrar</button>
										<button id="editarId" type="button" class="btn btn-warning">Editar</button>
									</div>
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
									<p>Estas seguro de eliminar este Usuario?</p>
									<p id="modalIdEliminar">#1</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-warning"
										data-bs-dismiss="modal">Cancelar</button>
									<button type="button" id="eliminarId"
										class="btn btn-danger d-flex align-items-center gap-2">
										<i class="lni lni-trash-can"></i>Eliminar
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="table-responsive overflow-auto">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Tipo</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
								List<Categoria> listaCategorias = (List<Categoria>) categorias;
								for (Categoria categoria : listaCategorias) {
									String estado = "estado-desconocido";
									switch (categoria.getTipo()) {
										case Menu :
									estado = "estado-menu";
									break;
										case Inventario :
									estado = "estado-inventario";
									break;
									}
								%>

								<tr>
									<td><%=categoria.getId()%></td>
									<td><%=categoria.getNombre()%></td>
									<td><span class="<%=estado%>"><%=categoria.getTipo().toString()%></span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=categoria.getId()%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button data-id="<%=categoria.getId()%>"
												data-nombre="<%=categoria.getNombre()%>"
												data-tipo="<%=categoria.getTipo()%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#modalEdit">
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

		// Modal de eliminación
		document
				.getElementById('staticBackdrop')
				.addEventListener(
						'show.bs.modal',
						function(event) {
							const button = event.relatedTarget;
							const id = button.getAttribute('data-id');
							document.getElementById('modalIdEliminar').innerHTML = "#"
									+ id;
							8
							document
									.getElementById('eliminarId')
									.addEventListener(
											'click',
											function(event) {
												window.location.href = "/ProyectoRestauranteChino/EliminarCategoria?id="
														+ id;
											})
						});

		// Modal de edición
		document
				.getElementById('modalEdit')
				.addEventListener(
						'show.bs.modal',
						function(event) {
							const button = event.relatedTarget;
							const id = button.getAttribute('data-id');
							let nombre = button.getAttribute('data-nombre');
							let tipo = button.getAttribute('data-tipo');
							document.getElementById('editNombre').value = nombre;
							document.getElementById('editTipo').value = tipo;
							document
									.getElementById('editarId')
									.addEventListener(
											'click',
											function(event) {
												nombre = document
														.getElementById('editNombre').value
												tipo = document
														.getElementById('editTipo').value
												window.location.href = "/ProyectoRestauranteChino/EditarCategoria?id="
														+ id
														+ "&nombre="
														+ nombre
														+ "&tipo="
														+ tipo;
											})
						});
	</script>

</body>
</html>