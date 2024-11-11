<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
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
<title>Inventario - Noche en Pekín</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="vista/trabajadores/inventario/inventario.css" rel="stylesheet" />
</head>
<body class="body">
<%
List<Inventario> cantInventario = (List<Inventario>) inventario;
%>
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="container">
				<div class="mb-3">
					<div
						class="text-center d-md-flex align-items-center justify-content-between flex-wrap mb-2">
						<h1 class="text-center py-4">INVENTARIO - 存货</h1>
						<span class="fs-3 numero-productos"><%=cantInventario.size() %> items</span>
					</div>
				<div class="d-flex align-items-center gap-3 mb-4">
				    <select id="inputCategoria" name="inputCategoria" class="form-select" aria-label="Selecciona categoria">
				        <option selected disabled>Selecciona categoría</option>
				        <%
				        List<Categoria> listaCategorias = (List<Categoria>) categorias;
				        for (Categoria categoria : listaCategorias) {
				        %>
				        <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
				        <%
				        }
				        %>
				    </select>
				    <button id="filtrarBtn" class="btn btn-success" type="button">
				        Filtrar
				    </button>
				</div>
				</div>
				<div class="row overflow-auto inventario_row">
					<%
					List<Inventario> listaInventario = (List<Inventario>) inventario;
					for (Inventario producto : listaInventario) {
						String stock = "stock-desconocido";
						if (producto.getStock() <= producto.getStockMin()) {
							stock = "stock-bajo";
						} else if (producto.getStock() > 0) {
							stock = "stock-alto";
						}
					    LocalDate fechaActual = LocalDate.now();
						String estado = "badge rounded-pill text-bg-warning";

						if (producto.getCaducidad().isBefore(fechaActual)) {
							estado = "badge rounded-pill text-bg-danger";
						} else if (producto.getStock() > 0) {
							estado = "badge rounded-pill text-bg-success";
						}
					%>
					<div class="col-6 col-md-4 col-lg-3 inventario-item" data-categoria="<%=producto.getCategoria().getId()%>">
						<div class="card mb-4 p-3">
							<div class="row no-gutters">
								<img src="<%=producto.getUrlImagen()%>" class="img-inventario card-img-top">
								<div class="card-body text-center">
									<h5 class="card-title"><%=producto.getNombre()%> </h5>
									<p class="card-text">Stock</p>
									<h2 class="fw-semibold <%=stock%>"><%=producto.getStock()%></h2>
									<p class="card-text">Caducidad</p>
									<h2 class="mb-4 fw-semibold <%=estado%>"><%=producto.getCaducidad()%></h2><br>
									<button data-id="<%=producto.getId()%>"
										data-nombre="<%=producto.getNombre()%>"
										data-categoria="<%=producto.getCategoria().getId()%>"
										data-unidad="<%=producto.getUnidad()%>"
										data-precio="<%=producto.getPrecioUnitario()%>"
										data-inventario-inicial="<%=producto.getInventarioInicial()%>"
										data-stock="<%=producto.getStock()%>"
										data-stock-min="<%=producto.getStockMin()%>"
										data-caducidad="<%=producto.getCaducidad()%>"
										data-imagen="<%=producto.getUrlImagen()%>"
										class="btn btn-warning" data-bs-toggle="modal"
										data-bs-target="#modalEditInventario">
										<i class="fa-solid fa-edit" style="color: #000000;"></i>
										Modificar
									</button>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Editar-->
	<div class="modal fade" id="modalEditInventario" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog-centered modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
						Editar Stock Item</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
						<div class="col-12 col-md">
							<label for="editStock">Stock Actual</label> <input
								type="number" class="form-control" id="editStock"
								name="editStock" required min="0" max="1000">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-warning"
							id="editarIdInventario">Guardar</button>
						</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
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
						let imagen = button.getAttribute('data-imagen');

						document.getElementById('editStock').value = stock;

						document
								.getElementById('editarIdInventario')
								.addEventListener(
										'click',
										function(event) {
											stock = document
													.getElementById('editStock').value;

										    const formElement = document.createElement('form');
										    formElement.setAttribute('enctype', 'multipart/form-data');
										    formElement.setAttribute('method', 'POST');
										    formElement.setAttribute('action', 'EditarInventario');

										    const inputs = [
										        { name: 'nombre', value: nombreProducto, type: 'text' },
										        { name: 'unidad', value: unidad, type: 'text' },
										        { name: 'precio', value: precioUnitario, type: 'number' },
										        { name: 'inventario', value: inventarioInicial, type: 'number' },
										        { name: 'stock', value: stock, type: 'number' },
										        { name: 'stockMinimo', value: stockMinimo, type: 'number' },
										        { name: 'caducidad', value: caducidad, type: 'date' },
										        { name: 'categoria', value: categoria, type: 'hidden' },
										        { name: 'imagen', value: imagen, type: 'hidden' },
										        { name: 'trabajador', value: true, type: 'hidden' },
										        { name: 'id', value: id, type: 'hidden' } 
										    ];

										    inputs.forEach(input => {
										        const el = document.createElement('input');
										        el.setAttribute('type', input.type);
										        el.setAttribute('name', input.name);
										        el.setAttribute('value', input.value);
										        formElement.appendChild(el);
										    });

										    document.body.appendChild(formElement);
										    formElement.submit();
										});
					});
	
	document.getElementById('filtrarBtn').addEventListener('click', function() {
		const selectedCategory = document.getElementById('inputCategoria').value;
		const items = document.querySelectorAll('.inventario-item');

	 items.forEach(item => {
			const itemCategory = item.getAttribute('data-categoria');
			if (selectedCategory === "Selecciona categoria" || itemCategory === selectedCategory) {
				item.style.display = 'block';
			} else {
				item.style.display = 'none';
			}
		});
	});
	
	</script>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>

</html>