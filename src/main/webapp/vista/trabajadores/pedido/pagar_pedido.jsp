<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cliente" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>PEDIDO - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link
	href="${pageContext.request.contextPath}/vista/trabajadores/pedido/pedido.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="body">
	<div class="d-flex">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="container">
				<h1 class="text-center pt-4 pb-2">PEDIDOS REALIZADOS - 已下订单</h1>

				<div class="d-flex justify-content-between gap-4 flex-wrap mb-4"
					style="padding-top: 20px">
					<!-- Formulario de búsqueda de cliente -->
					<div class="d-flex gap-2 align-items-center">
						<h5>Buscar Cliente por DNI</h5>

						<input type="text" class="form-control me-2" id="dniCliente"
							name="dni" placeholder="Ingrese DNI" required>
						<button id="buscar_dni" type="submit" class="btn btn-primary">Buscar</button>

					</div>
					<div class="d-flex align-items-center justify-content-end gap-4">
						<button
							class="fs-5 d-flex align-items-center gap-2 btn btn-warning rounded-pill"
							data-bs-toggle="modal" data-bs-target="#nuevoCliente"
							id="botoncito_modal_pago">
							<img
								src="${pageContext.request.contextPath}/vista/img/boton-mas.png"
								alt="Pagar" style="width: 20px; height: 20px"> <span>Pagar</span>
						</button>
					</div>
				</div>

				<!-- Modal para registrar nuevo cliente -->
				<div class="modal fade" id="nuevoCliente" tabindex="-1">
					<div class="modal-dialog-centered modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h2>Registrar Nuevo Cliente</h2>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">

					<form id="registrarClienteForm">
						

							<!-- Modal para registrar nuevo cliente -->
							<div class="modal fade" id="nuevoCliente" tabindex="-1">
								<div class="modal-dialog-centered modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h2>Registrar Nuevo Cliente</h2>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">

											<form id="registrarClienteForm">
												<div class="p-3">
													<div class="mb-3">
														<label for="telefonoCliente" class="form-label">Teléfono
															del Cliente</label> <input type="tel" class="form-control"
															id="telefonoCliente" name="telefonoCliente" required>
													</div>
													<div class="mb-3">
														<label for="emailCliente" class="form-label">Email
															: 
													</div>

													<!-- Modal para registrar nuevo cliente -->
													<div class="modal fade" id="nuevoCliente" tabindex="-1">
														<div class="modal-dialog-centered modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h2>Registrar Nuevo Cliente</h2>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
															</div>
														</div>
													</div>
													<div class="modal-body">

														<form id="registrarClienteForm">
															<div class="p-3">
																<div class="mb-3">
																	<label for="telefonoCliente" class="form-label">Teléfono
																		del Cliente</label> <input type="tel" class="form-control"
																		id="telefonoCliente" name="telefonoCliente" required>
																</div>
																<div class="mb-3">
																	<label for="emailCliente" class="form-label">Email
																		del Cliente</label> <input type="email" class="form-control"
																		id="emailCliente" name="emailCliente" required>
																</div>
															</div>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-danger"
															data-bs-dismiss="modal">Cerrar</button>
														<button type="submit" class="btn btn-success">Registrar
															Cliente</button>
													</div>
												</div>
										</div>
									</div>
								</div>
					</form>
				</div>
				<div class="row">
					<div class="col-md-4">
						<!-- Formulario de pago -->
						<%
						List<Cliente> listaCliente = (List<Cliente>) cliente;
						String telefonoCliente = "";
						String emailCliente = "";

						// Verificar que haya al menos un cliente en la lista
						if (listaCliente != null && !listaCliente.isEmpty()) {
							Cliente cl = listaCliente.get(0); // Obtener el primer cliente
							telefonoCliente = cl.getTelefono();
							emailCliente = cl.getCorreo(); // Asumiendo que el modelo Cliente tiene un método getCorreo()
						}
						%>
						<h2>Formulario de Pago</h2>
						<form id="pagoForm">
							<div class="mb-3">
								<label for="nombreCompleto" class="form-label">Nombre
									completo del Cliente</label> <input type="text" class="form-control"
									id="nombreCompleto" name="nombreCompleto" required> <label
									for="telefonoCliente" class="form-label">Teléfono del
									Cliente</label> <input type="tel" class="form-control"
									id="telefonoCliente" name="telefonoCliente"
									value="<%=telefonoCliente%>" required> <label
									for="emailCliente" class="form-label">Email del Cliente</label>
								<input type="email" class="form-control" id="emailCliente"
									name="emailCliente" value="<%=emailCliente%>" required>
								<label for="montoPago" class="form-label">Monto a Pagar</label>
								<input type="number" class="form-control" id="montoPago"
									name="montoPago" required>
							</div>
							<div class="mb-3">
								<label for="metodoPago" class="form-label">Método de
									Pago</label> <select class="form-select" id="metodoPago"
									name="metodoPago" required>
									<option value="Efectivo">Efectivo</option>
									<option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
									<option value="Transferencia">Transferencia</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Realizar
								Pago</button>
						</form>
					</div>

					<div class="col-md-8">
						<!-- Sección para mostrar pedidos realizados -->
						<h2 class="text-center">Pedidos Realizados</h2>
						<div class="table-responsive">
							<table class="table table-bordered text-center">
								<thead>
									<tr>
										<th>ID Pedido</th>
										<th>Cliente</th>
										<th>Estado</th>
										<th>Fecha</th>
										<th>Hora</th>
										<th>Detalles</th>
									</tr>
								</thead>
								<tbody id="tablaPedidos">
									<tr>
										<td>M01</td>
										<td>Cliente Completado</td>
										<td>Completado</td>
										<td>29/08/2024</td>
										<td>21:00 PM</td>
										<td>
											<button class="btn btn-info" data-bs-toggle="modal"
												data-bs-target="#modalDetalles" onclick="mostrarDetalles()">Ver
												Detalles</button>
										</td>
									</tr>
									<!-- Repetir para más pedidos -->
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<!-- Modal de detalles del pedido -->
	<div class="modal fade" id="modalDetalles" tabindex="-1"
		aria-labelledby="modalDetallesLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-3 fw-semibold" id="modalDetallesLabel">Detalles
						del Pedido</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Cerrar"></button>
				</div>
				<div class="modal-body">
					<h5>Productos</h5>
					<table class="table">
						<thead>
							<tr>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Subtotal</th>
							</tr>
						</thead>
						<tbody id="tablaDetalles">
							<tr>
								<td>Chaufa</td>
								<td>2</td>
								<td>S/. 40</td>
							</tr>
							<tr>
								<td>Chaufa</td>
								<td>2</td>
								<td>S/. 40</td>
							</tr>
							<tr>
								<td>Chaufa</td>
								<td>2</td>
								<td>S/. 40</td>
							</tr>
							<tr>
								<td>Chaufa</td>
								<td>2</td>
								<td>S/. 40</td>
							</tr>
							<tr>
								<td>Chaufa</td>
								<td>2</td>
								<td>S/. 40</td>
							</tr>
						</tbody>
					</table>
					<h5>Total: S/. 200</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://kit.fontawesome.com/c353473263.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/vista/trabajadores/pedido/buscar_dni.js"></script>
	<script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function() {
            const pagoForm = document.getElementById("pagoForm");

            pagoForm.addEventListener("submit", async function(event) {
                event.preventDefault();
                const montoPago = document.getElementById("montoPago").value;
                const metodoPago = document.getElementById("metodoPago").value;

                // Aquí iría la lógica para procesar el pago
                const response = await fetch("RealizarPago", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: new URLSearchParams({
                        montoPago: montoPago,
                        metodoPago: metodoPago
                    })
                });

                if (response.ok) {
                    alert("Pago realizado exitosamente por un monto de: S/. " + montoPago);
                    pagoForm.reset();
                } else {
                    alert("Error al realizar el pago. Intente nuevamente.");
                }
            });
        });

        function mostrarDetalles() {
            const tablaDetalles = document.getElementById("tablaDetalles");
            tablaDetalles.innerHTML = `
                <tr>
                    <td>Chaufa</td>
                    <td>2</td>
                    <td>S/. 40</td>
                </tr>
                <tr>
                    <td>Chaufa</td>
                    <td>2</td>
                    <td>S/. 40</td>
                </tr>
                <tr>
                    <td>Chaufa</td>
                    <td>2</td>
                    <td>S/. 40</td>
                </tr>
                <tr>
                    <td>Chaufa</td>
                    <td>2</td>
                    <td>S/. 40</td>
                </tr>
                <tr>
                    <td>Chaufa</td>
                    <td>2</td>
                    <td>S/. 40</td>
                </tr>
            `;
        }
    </script>
</body>
</html>