<%@page import="java.util.List"%>
<%@page import="modelo.Mesa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="mesas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="vista/administrador/mesas/mesas.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | MESAS</title>
</head>
<body>
<%
List<Mesa> listaMesas = (List<Mesa>) mesas; %>
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
							<span class="fs-3 numero-mesas"><%=listaMesas != null ? listaMesas.size() : 0%> mesas</span>
						</div>
						<div
							class="d-flex flex-wrap align-items-center justify-content-end gap-md-4 gap-3">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Nueva Mesa <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<div class="table-responsive overflow-auto"
						style="max-height: 60vh">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>N&ordm; Salon</th>
									<th>N&ordm; Mesa</th>
									<th>Estado</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
								for (Mesa mesa : listaMesas) {
									String estado = "estado-desconocido";
									switch (mesa.getEstado()) {
										case Libre :
									estado = "estado-libre";
									break;
										case Reservado :
									estado = "estado-reservado";
									break;
										case Limpieza :
											estado = "estado-limpieza";
											break;
										case Ocupado :
									estado = "estado-ocupado";
									break;
									}
								%>

								<tr>
									<td><%=mesa.getId()%></td>
									<td><%=mesa.getN_salon()%></td>
									<td><%=mesa.getN_mesa()%></td>
									<td><span class="<%=estado%>"><%=mesa.getEstado().toString()%></span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=mesa.getId()%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button data-id="<%=mesa.getId()%>"
												data-mesa="<%=mesa.getN_mesa()%>"
												data-salon="<%=mesa.getN_salon()%>"
												data-estado="<%=mesa.getEstado()%>" class="icon-action"
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

						<!-- Modal Agregar-->
						<div class="modal fade" id="modalAdd" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog-centered modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-3 fw-semibold"
											id="exampleModalLabel">Agrega Otra Mesa</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<form action="AgregarMesa" class="needs-validation" novalidate>
											<div class="form-group mb-4 d-flex flex-wrap gap-2">
												<div class="col-12 col-md">
													<label for="salon">N&ordm; Salon</label> <input
														type="number" class="form-control" id="salon"
														placeholder="Enter Number" name="numSalon" required
														min="0" max="500">
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
										<h1 class="modal-title fs-3 fw-semibold"
											id="exampleModalLabel">Editar Mesa</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="editSalon">N&ordm; Salon</label> <input
													type="number" class="form-control" id="editSalon"
													aria-describedby="emailHelp" placeholder="Enter Number"
													name="numSalon" required>
											</div>
											<div class="col-12 col-md">
												<label for="editMesa">N&ordm; Mesa</label> <input
													type="number" class="form-control" id="editMesa"
													placeholder="Enter Number" name="numMesa" required>
											</div>
											<div class="col-12">
												<label for="editEstado">Estado</label> <select
													id="editEstado" name="estado" class="form-select"
													aria-label="Default select example">
													<option selected disabled>Selecciona estado de mesa</option>
													<%for(Mesa.EstadoMesa estado: Mesa.EstadoMesa.values()) {%>
													<option value="<%=estado%>"><%=estado%></option>
													<%} %>
												</select>
											</div>
										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button id="editarId" type="button" class="btn btn-warning">Guardar</button>
										</div>
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
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body fw-medium fs-4">
										<p>Estas seguro de eliminar la mesa?</p>
										<p id="modalIdEliminar">#1</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-warning"
											data-bs-dismiss="modal">Cancelar</button>
											<button id="eliminarId" type="button"
												class="btn btn-danger d-flex align-items-center gap-2">
												<i class="lni lni-trash-can"></i>Eliminar
											</button>
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
												window.location.href = "/ProyectoRestauranteChino/EliminarMesa?id="
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
							let mesa = button.getAttribute('data-mesa');
							let salon = button.getAttribute('data-salon');
							let estado = button.getAttribute('data-estado');
							document.getElementById('editMesa').value = mesa;
							document.getElementById('editSalon').value = salon;
							document.getElementById('editEstado').value = estado;
							document
									.getElementById('editarId')
									.addEventListener(
											'click',
											function(event) {
												mesa = document
														.getElementById('editMesa').value
												salon = document
														.getElementById('editSalon').value
												estado = document
														.getElementById('editEstado').value
												window.location.href = "/ProyectoRestauranteChino/EditarMesa?id="
														+ id
														+ "&mesa="
														+ mesa
														+ "&salon="
														+ salon
														+ "&estado=" + estado;
											})
						});
	</script>
</body>
</html>