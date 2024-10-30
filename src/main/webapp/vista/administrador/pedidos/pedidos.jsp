<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pedidos" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="mesas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="vista/administrador/pedidos/pedidos.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | PEDIDOS</title>
</head>
<body>
	<%
	List<Object[]> listaPedidos = new ArrayList<>(pedidos);
	List<Mesa> listaMesas = (List<Mesa>) mesas;
	%>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="p-3 mx-lg-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class="text-center d-md-flex align-items-center justify-content-between flex-wrap">
							<h1>GESTIÓN DE PEDIDOS - 订单管理</h1>
							<span class="fs-3 numero-mesas text-center"> <%=listaPedidos != null ? listaPedidos.size() : 0%>
								pedidos
							</span>
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
									<form action="AgregarPedido" class="needs-validation"
										novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">DNI Cliente</label> <input type="text"
												class="form-control" id="client"
												aria-describedby="emailHelp" placeholder="Enter Number"
												name="cliente" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="n_mesa">N&ordm; Mesa</label> <select id="n_mesa"
												name="n_mesa" class="form-select"
												aria-label="Default select example">
												<option selected>Seleccione una mesa</option>
												<%
												for (Mesa mesa : listaMesas) {
													if (Mesa.EstadoMesa.valueOf(mesa.getEstado().toString()) == Mesa.EstadoMesa.Ocupado) {
												%>
												<option value="<%=mesa.getId()%>"><%=mesa.getN_mesa()%></option>
												<%
												}
												}
												%>
											</select>
										</div>
										<div class="form-group mb-4 d-flex gap-2">
											<div class="col-6 col-md">
												<label for="recibo">Tipo Recibo</label> <select id="recibo"
													name="recibo" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione un tipo</option>
													<%
													for (Pedido.TipoRecibo tipo : Pedido.TipoRecibo.values()) {
													%>
													<option value="<%=tipo%>"><%=tipo%></option>
													<%
													}
													%>
												</select>
											</div>
											<div class="col-6 col-md">
												<label for="metodo">Metodo de Pago</label> <select
													id="metodo" name="metodo" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione un metodo</option>
													<%
													for (Pedido.MetodoPago metodo : Pedido.MetodoPago.values()) {
													%>
													<option value="<%=metodo%>"><%=metodo%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Total</label> <input type="number"
												step="0.01" class="form-control" id="totalPagar"
												aria-describedby="emailHelp" placeholder="Enter Total"
												name="totalPagar" required min="0">
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

					<div class="table-responsive overflow-auto">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<!-- Puede ir DNI o nombre para utilizar api de buscar datos -->
									<th>DNI Cliente</th>
									<th>N&ordm; Mesa</th>
									<th>Estado</th>
									<th>Tipo de Recibo</th>
									<th>Metodo de Pago</th>
									<th>Total Pago</th>
									<th>Trabajador</th>
									<th>Fecha Creacion</th>
									<th>Ver Detalle Pedido</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
								if (pedidos.isEmpty()) {
									out.println("No hay pedidos disponibles.");
								}
								for (Object[] item : listaPedidos) {
									String estado = "estado-desconocido";
									switch (item[3].toString()) {
										case "Pendiente" :
									estado = "estado-pendiente";
									break;
										case "Completado" :
									estado = "estado-completado";
									break;
										case "Cancelado" :
									estado = "estado-cancelado";
									break;
									}
								%>
								<tr>
									<td><%=item[0]%></td>
									<td><%=item[1]%></td>
									<td><%=item[2]%></td>
									<td><span class="<%=estado%>"><%=item[3]%></span></td>
									<td><%=item[4]%></td>
									<td><%=item[5]%></td>
									<td>S/<%=item[6]%></td>
									<td><%=item[7]%></td>
									<td>
										<%
										Date date = null;
										try {
											date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) item[8]);
										} catch (ParseException e) {
											e.printStackTrace();
										}

										SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
										String formattedDate = date != null ? dateFormat.format(date) : "Fecha no disponible";

										out.print(formattedDate);
										%>
									</td>
									<!-- pasar un id del pedido para filtrar	 -->
									<td><a href="AdmiDetallePedido?id=<%=item[0]%>"
										class="fs-4 icon-see d-flex justify-content-center"><i
											class="fw-semibold lni lni-eye"></i></a></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=item[0]%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button data-id="<%=item[0]%>"
												data-usuario="<%=item[1]%>"
												data-mesa="<%=item[2]%>"
												data-estado="<%=item[3]%>"
												data-recibo="<%=item[4]%>"
												data-metodo="<%=item[5]%>"
												data-pago="<%=item[6]%>"
												class="icon-action"
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

						<!-- Modal Editar -->
						<div class="modal fade" id="modalEdit" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog-centered modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-3 fw-semibold"
											id="exampleModalLabel">Editar Pedido</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="edCliente">DNI Cliente</label> <input type="text"
												class="form-control" id="edCliente"
												aria-describedby="emailHelp" placeholder="Enter Number"
												name="edCliente" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-6 col-md">
												<label for="edEstado">Estado</label> <select id="edEstado"
													name="edEstado" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione un estado</option>
													<%
													for (Pedido.EstadoPedido estado : Pedido.EstadoPedido.values()) {
													%>
													<option value="<%=estado%>"><%=estado%></option>
													<%
													}
													%>
												</select>
											</div>
											<div class="col-6 col-md">
												<label for="edMesa">N&ordm; Mesa</label> <select id="edMesa"
													name="edMesa" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione una mesa</option>
													<%
													for (Mesa mesa : listaMesas) {
													%>
													<option value="<%=mesa.getId()%>"><%=mesa.getN_mesa()%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex gap-2">
											<div class="col-6 col-md">
												<label for="edRecibo">Tipo Recibo</label> <select
													id="edRecibo" name="edRecibo" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione un tipo</option>
													<%
													for (Pedido.TipoRecibo tipo : Pedido.TipoRecibo.values()) {
													%>
													<option value="<%=tipo%>"><%=tipo%></option>
													<%
													}
													%>
												</select>
											</div>
											<div class="col-6 col-md">
												<label for="edMetodo">Metodo de Pago</label> <select
													id="edMetodo" name="edMetodo" class="form-select"
													aria-label="Default select example">
													<option selected>Seleccione un metodo</option>
													<%
													for (Pedido.MetodoPago metodo : Pedido.MetodoPago.values()) {
													%>
													<option value="<%=metodo%>"><%=metodo%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="edTotal">Total</label> <input type="number"
												step="0.01" class="form-control" id="edTotal"
												aria-describedby="emailHelp" placeholder="Enter Total"
												name="edTotal" required>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button id="editarId" type="button" class="btn btn-warning">
												Editar Pedido</button>
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
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body fw-medium fs-4">
										<p>Estas seguro de eliminar este Pedido?</p>
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
							document
									.getElementById('eliminarId')
									.addEventListener(
											'click',
											function(event) {
												window.location.href = "/ProyectoRestauranteChino/EliminarPedido?id="
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
							let usuario = button.getAttribute('data-usuario');
							let mesa = button.getAttribute('data-mesa');
							let estado = button.getAttribute('data-estado');
							let recibo = button.getAttribute('data-recibo');
							let metodo = button.getAttribute('data-metodo');
							let pago = button.getAttribute('data-pago');

							document.getElementById('edCliente').value = usuario;
							document.getElementById('edMesa').value = mesa;
							document.getElementById('edEstado').value = estado;
							document.getElementById('edRecibo').value = recibo;
							document.getElementById('edMetodo').value = metodo;
							document.getElementById('edTotal').value = pago;

							document.getElementById('editarId').addEventListener('click', function(event) {
							    usuario = document.getElementById('edCliente').value;
							    mesa = document.getElementById('edMesa').value;
							    estado = document.getElementById('edEstado').value;
							    recibo = document.getElementById('edRecibo').value;
							    metodo = document.getElementById('edMetodo').value;
							    pago = document.getElementById('edTotal').value;

							    window.location.href = "/ProyectoRestauranteChino/EditarPedido?id=" 
							        + id + "&usuario=" + encodeURIComponent(usuario) 
							        + "&mesa=" + encodeURIComponent(mesa) 
							        + "&estado=" + encodeURIComponent(estado) 
							        + "&recibo=" + encodeURIComponent(recibo) 
							        + "&metodo=" + encodeURIComponent(metodo) 
							        + "&pago=" + encodeURIComponent(pago);
							});
						});
	</script>
</body>
</html>