<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.*"%>
<jsp:useBean id="detallesPedido" class="java.util.ArrayList"
	scope="request" />
<jsp:useBean id="menu" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="vista/administrador/pedidos/pedidos.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>Admin | Detalle Pedido</title>
</head>
<body>
	<%
	double precio = 0;
	int id = Integer.valueOf(request.getParameter("id"));
	List<Object[]> listaDetalle = new ArrayList<>(detallesPedido);
	List<Menu> listaMenu = (List<Menu>) menu;
	%>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="p-3 mx-lg-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class="text-center d-flex align-items-center justify-content-center justify-content-md-start">
							<h1>Gestión de Detalle Pedido</h1>
						</div>
						<div
							class="d-flex align-items-center justify-content-center mt-2 mt-md-0 justify-content-md-end gap-4">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Agregar Detalles Pedidos <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<div class="modal fade" id="modalAdd" tabindex="-1"
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
									<form action="AgregarDetalle"
										class="needs-validation" novalidate>
										<input type="hidden" name="id" value="<%=id%>">
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="platos">Platos</label> <select id="platos"
												name="plato" class="form-select"
												aria-label="Default select example">
												<option selected disabled>Seleccione un platillo</option>
												<%
												for (Menu men : listaMenu) {
												%>
												<option value="<%=men.getId()%>" data-precio="<%=men.getPrecio()%>"><%=men.getNombre()%></option>
												<%
												}
												%> 
											</select>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="cantidad">Cantidad</label> <input type="number"
													step="1" class="form-control" id="cantidad"
													aria-describedby="emailHelp" placeholder="Enter Mesa"
													name="cantidad" required min="1" max="500" onchange="calcularSubtotal()">
											</div>
											<div class="col-12 col-md">
												<label for="subtotal">Subtotal</label> <input readonly type="number"
													step="0.01" class="form-control" id="subtotal"
													aria-describedby="emailHelp" placeholder="Enter Total"
													name="subtotal" min="0" value="">
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

					<!-- Modal Editar -->
					<div class="modal fade" id="modalEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Editar Detalle</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="form-group mb-4 d-flex flex-wrap gap-2">
										<label for="edPlato">Platos</label> 
										<select id="edPlato"
											name="edPlato" class="form-select"
											aria-label="Default select example">
											<option selected disabled>Seleccione un platillo</option>
											<%
											for (Menu men : listaMenu) {
											%>
											<option value="<%=men.getId()%>" data-precio="<%=men.getPrecio()%>"><%=men.getNombre()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="form-group mb-4 d-flex flex-wrap gap-2">
										<div class="col-12 col-md">
											<label for="edCantidad">Cantidad</label> <input type="number"
												step="1" class="form-control" id="edCantidad"
												aria-describedby="emailHelp" placeholder="Enter Mesa"
												name="edCantidad" onchange="calcularSubtotalEdit()" min="1" max="500" required>
										</div>
										<div class="col-12 col-md">
											<label for="edSubtotal">Subtotal</label> <input readonly
												type="number" step="0.01" class="form-control" id="edSubtotal"
												aria-describedby="emailHelp" placeholder="Enter Total"
												name="edSubtotal" required>
										</div>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Cerrar</button>
										<button type="submit" class="btn btn-warning" id="editarId">Editar</button>
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
									<p>Estas seguro de eliminar este Detalle?</p>
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
								<%
								for (Object[] item : listaDetalle) {
								%>
								<tr>
									<td><%=item[0]%></td>
									<td><%=item[1]%></td>
									<td><%=item[2]%></td>
									<td><%=item[3]%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=item[0]%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button data-id="<%=item[0]%>" data-producto="<%=item[1]%>"
												data-cantidad="<%=item[2]%>" data-subtotal="<%=item[3]%>"
												class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
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
					<div class="regresar">
						<a href="AdmiPedido"><i class="lni lni-arrow-left"></i>Regresar
							Pedidos</a>
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
            urlParams.delete('mensaje');
            window.history.replaceState({}, document.title, window.location.pathname + (urlParams.toString() ? '?' + urlParams.toString() : ''));
        }
    };
    function calcularSubtotal() {
        var selectPlato = document.getElementById('platos');
        var selectedOption = selectPlato.options[selectPlato.selectedIndex];
        var precioPlato = parseFloat(selectedOption.getAttribute('data-precio')) || 0;
        var cantidad = document.getElementById('cantidad').value || 0;
        var subtotal = precioPlato * cantidad;
        document.getElementById('subtotal').value = subtotal.toFixed(2);
    }
    
    function calcularSubtotalEdit() {
        var selectPlato = document.getElementById('edPlato');
        var selectedOption = selectPlato.options[selectPlato.selectedIndex];
        var precioPlato = parseFloat(selectedOption.getAttribute('data-precio')) || 0;
        var cantidad = document.getElementById('edCantidad').value || 0;
        var subtotal = precioPlato * cantidad;
        document.getElementById('edSubtotal').value = subtotal.toFixed(2);
    }

		// Modal de eliminación
		document
				.getElementById('staticBackdrop')
				.addEventListener(
						'show.bs.modal',
						function(event) {
							const button = event.relatedTarget;
							const id = button.getAttribute('data-id');
							const idPedido = <%=id%>;
							document.getElementById('modalIdEliminar').innerHTML = "#"
									+ id;
							document
									.getElementById('eliminarId')
									.addEventListener(
											'click',
											function(event) {
												window.location.href = "/ProyectoRestauranteChino/EliminarDetalle?idPedido="+idPedido+"&id="
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
							const idPedido = <%=id%>;
							let producto = button.getAttribute('data-producto');
							let cantidad = button.getAttribute('data-cantidad');
							let subtotal = button.getAttribute('data-subtotal');

							document.getElementById('edPlato').value = producto;
							document.getElementById('edCantidad').value = cantidad;
							document.getElementById('edSubtotal').value = subtotal;

							document.getElementById('editarId').addEventListener('click', function(event) {
							    producto = document.getElementById('edPlato').value;
							    cantidad = document.getElementById('edCantidad').value;
							    subtotal = document.getElementById('edSubtotal').value;

							    window.location.href = "/ProyectoRestauranteChino/EditarDetalle?idPedido="+idPedido+"&id=" 
							        + id + "&plato=" + encodeURIComponent(producto) 
							        + "&cantidad=" + encodeURIComponent(cantidad) 
							        + "&subtotal=" + encodeURIComponent(subtotal);
							});
						});
	</script>
</body>
</html>