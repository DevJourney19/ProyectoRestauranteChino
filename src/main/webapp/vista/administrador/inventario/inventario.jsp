<%@page import="java.util.List"%>
<%@page import="modelo.Inventario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="inventario" class="java.util.ArrayList" scope="request" />	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="inventario.css">

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
							<span class="fs-3 numero-Items">200 items</span>
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

				<div class="table-responsive overflow-auto" style="max-height: 60vh">
				    <table class="table">
				        <thead>
				            <tr>
				                <th>Id</th>
				                <th>N&ordm; Nombre del Item</th>
				                <th>N&ordm; Unidad</th>
				                <th>N&ordm; Precio Unitario</th>
				                <th>N&ordm; Inventario Inicial</th>
				                <th>N&ordm; Stock</th>
				                <th>N&ordm; Stock Mínimo</th>
				                <th>N&ordm; Caducidad</th>
				                <th>Estado</th>
				                <th></th>
				            </tr>
				        </thead>
				        <tbody>
				            <%
				            List<Inventario> listaInventario = (List<Inventario>) inventario;
				            for (Inventario Item : listaInventario) {
				                String estado = "estado-desconocido";
				                if (Item.getStock() <= Item.getStockMin()) {
				                    estado = "estado-agotado";
				                } else if (Item.getStock() > 0) {
				                    estado = "estado-disponible";
				                } else {
				                    estado = "estado-en-orden";
				                }
				            %>
				
				            <tr>
				                <td><%= Item.getId() %></td>
				                <td><%= Item.getNombre() %></td>
				                <td><%= Item.getUnidad() %></td>
				                <td><%= Item.getPrecioUnitario() %></td>
				                <td><%= Item.getInventarioInicial() %></td>
				                <td><%= Item.getStock() %></td>
				                <td><%= Item.getStockMin() %></td>
				                <td><%= Item.getCaducidad() %></td>
				                <td><span class="<%= estado %>"><%= estado %></span></td>
				                <td>
				                    <div class="d-flex align-item-center justify-content-center gap-3">
				                        <button data-id="<%= Item.getId() %>" class="icon-action"
				                            data-bs-toggle="modal" data-bs-target="#staticBackdrop">
				                            <i class="lni lni-trash-can fs-4"></i>
				                        </button>
				                        <!-- Abrir Modal Editar -->
				                        <button data-id="<%= Item.getId() %>"
				                            data-nombre="<%= Item.getNombre() %>"
				                            data-unidad="<%= Item.getUnidad() %>"
				                            data-precio="<%= Item.getPrecioUnitario() %>"
				                            data-inventario-inicial="<%= Item.getInventarioInicial() %>"
				                            data-stock="<%= Item.getStock() %>"
				                            data-stock-min="<%= Item.getStockMin() %>"
				                            data-caducidad="<%= Item.getCaducidad() %>"
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
				    
				<!-- Modal Agregar Item -->
				<div class="modal fade" id="modalAdd" tabindex="-1" aria-labelledby="modalAdditemLabel" aria-hidden="true">
				    <div class="modal-dialog-centered modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <h1 class="modal-title fs-3 fw-semibold" id="modalAdditemLabel">Agregar Item al Inventario</h1>
				                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            </div>
				            <div class="modal-body">
				                <form action="AgregarInventario" class="needs-validation" novalidate>
				                    <div class="form-group mb-4">
				                        <label for="itemName">Nombre del Item</label>
				                        <input type="text" class="form-control" id="itemName" placeholder="Ingrese el nombre del Item" name="nombreItem" required>
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="unit">Unidad</label>
				                        <input type="text" class="form-control" id="unit" placeholder="Ingrese la unidad" name="unidad" required>
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="unitPrice">Precio Unitario</label>
				                        <input type="number" class="form-control" id="unitPrice" placeholder="Ingrese el precio unitario" name="precioUnitario" required min="0">
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="initialInventory">Inventario Inicial</label>
				                        <input type="number" class="form-control" id="initialInventory" placeholder="Ingrese el inventario inicial" name="inventarioInicial" required min="0">
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="stock">Stock</label>
				                        <input type="number" class="form-control" id="stock" placeholder="Ingrese el stock" name="stock" required min="0">
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="minStock">Stock Mínimo</label>
				                        <input type="number" class="form-control" id="minStock" placeholder="Ingrese el stock mínimo" name="stockMinimo" required min="0">
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="expirationDate">Caducidad</label>
				                        <input type="date" class="form-control" id="expirationDate" name="caducidad" required>
				                    </div>
				                    <div class="form-group mb-4">
				                        <label for="status">Estado</label>
				                        <select class="form-control" id="status" name="estado" required>
				                            <option value="" disabled selected>Seleccione el estado</option>
				                            <option value="Disponible">Disponible</option>
				                            <option value="No Disponible">No Disponible</option>
				                        </select>
				                    </div>
				                    <div class="modal-footer">
				                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
				                        <button type="submit" class="btn btn-warning">Crear</button>
				                    </div>
				                </form>
				            </div>
				        </div>
				    </div>
				</div>
			
				<!-- Modal Editar Item -->
				<div class="modal fade" id="modalEdit" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				    <div class="modal-dialog-centered modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">Editar Item del Inventario</h1>
				                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            </div>
				            <div class="modal-body">
				                <form action="EditarInventario" class="needs-validation" novalidate>
				                    <div class="form-group mb-4 d-flex flex-wrap gap-2">
				                        <div class="col-12 col-md">
				                            <label for="editNombreItem">N&ordm; Nombre del Item</label>
				                            <input type="text" class="form-control" id="editNombreItem" placeholder="Ingrese el nombre" name="nombreItem" required>
				                        </div>
				                        <div class="col-12 col-md">
				                            <label for="editUnidad">N&ordm; Unidad</label>
				                            <input type="text" class="form-control" id="editUnidad" placeholder="Ingrese unidad" name="unidad" required>
				                        </div>
				                        <div class="col-12 col-md">
				                            <label for="editPrecioUnitario">N&ordm; Precio Unitario</label>
				                            <input type="number" class="form-control" id="editPrecioUnitario" placeholder="Ingrese precio" name="precioUnitario" required min="0">
				                        </div>
				                        <div class="col-12 col-md">
				                            <label for="editInventarioInicial">N&ordm; Inventario Inicial</label>
				                            <input type="number" class="form-control" id="editInventarioInicial" placeholder="Ingrese cantidad" name="inventarioInicial" required min="0">
				                        </div>
				                        <div class="col-12 col-md">
				                            <label for="editStockMinimo">N&ordm; Stock Mínimo</label>
				                            <input type="number" class="form-control" id="editStockMinimo" placeholder="Ingrese cantidad" name="stockMinimo" required min="0">
				                        </div>
				                        <div class="col-12 col-md">
				                            <label for="editCaducidad">N&ordm; Caducidad</label>
				                            <input type="date" class="form-control" id="editCaducidad" name="caducidad" required>
				                        </div>
				                    </div>
				                    <div class="modal-footer">
				                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
				                        <button id="editarId" type="button" class="btn btn-warning">Guardar</button>
				                    </div>
				                </form>
				            </div>
				        </div>
				    </div>
				</div>

				<!-- Modal de Eliminar Item -->
				<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalEliminarItemLabel" aria-hidden="true">
				    <div class="modal-dialog modal-dialog-centered">
				        <div class="modal-content">
				            <div class="modal-header">
				                <h5 class="modal-title" id="modalEliminarItemLabel">Eliminar Item</h5>
				                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            </div>
				            <div class="modal-body fw-medium fs-4">
				                <p>¿Estás seguro de eliminar este Item del inventario?</p>
				                <p id="modalIdEliminarItem">#1</p> <!-- Aquí se puede mostrar el ID del Item -->
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cancelar</button>
				                <form action="">
				                    <button id="eliminarId" type="button" class="btn btn-danger d-flex align-items-center gap-2">
				                        <i class="lni lni-trash-can"></i>Eliminar
				                    </button>
				                </form>
				            </div>
				        </div>
				    </div>
				</div>
			</main>
		</div>
	</div>
	<!-- <script type="text/javascript" src="inventario.js"></script> -->
	
		<script>
	    // Modal de eliminación para inventario
	    document
	        .getElementById('staticBackdropInventario')
	        .addEventListener('show.bs.modal', function(event) {
	            const button = event.relatedTarget;
	            const id = button.getAttribute('data-id');
	            document.getElementById('modalIdEliminarInventario').innerHTML = "#" + id;
	
	            document
	                .getElementById('eliminarIdInventario')
	                .addEventListener('click', function(event) {
	                    window.location.href = "/ProyectoRestauranteChino/EliminarInventario?id=" + id;
	                });
	        });
	
	    // Modal de edición para inventario
	    document
	        .getElementById('modalEditInventario')
	        .addEventListener('show.bs.modal', function(event) {
	            const button = event.relatedTarget;
	            const id = button.getAttribute('data-id');
	            let nombreItem = button.getAttribute('data-nombre');
	            let unidad = button.getAttribute('data-unidad');
	            let precioUnitario = button.getAttribute('data-precio');
	            let inventarioInicial = button.getAttribute('data-inventario');
	            let stock = button.getAttribute('data-stock');
	            let stockMinimo = button.getAttribute('data-stock-minimo');
	            let caducidad = button.getAttribute('data-caducidad');
	            let estado = button.getAttribute('data-estado');
	
	            document.getElementById('editNombreItem').value = nombreItem;
	            document.getElementById('editUnidad').value = unidad;
	            document.getElementById('editPrecioUnitario').value = precioUnitario;
	            document.getElementById('editInventarioInicial').value = inventarioInicial;
	            document.getElementById('editStock').value = stock;
	            document.getElementById('editStockMinimo').value = stockMinimo;
	            document.getElementById('editCaducidad').value = caducidad;
	            document.getElementById('editEstado').value = estado;
	
	            document
	                .getElementById('editarIdInventario')
	                .addEventListener('click', function(event) {
	                    nombreItem = document.getElementById('editNombreItem').value;
	                    unidad = document.getElementById('editUnidad').value;
	                    precioUnitario = document.getElementById('editPrecioUnitario').value;
	                    inventarioInicial = document.getElementById('editInventarioInicial').value;
	                    stock = document.getElementById('editStock').value;
	                    stockMinimo = document.getElementById('editStockMinimo').value;
	                    caducidad = document.getElementById('editCaducidad').value;
	                    estado = document.getElementById('editEstado').value;
	
	                    window.location.href = "/ProyectoRestauranteChino/EditarInventario?id=" + id +
	                        "&nombre=" + nombreItem +
	                        "&unidad=" + unidad +
	                        "&precio=" + precioUnitario +
	                        "&inventario=" + inventarioInicial +
	                        "&stock=" + stock +
	                        "&stockMinimo=" + stockMinimo +
	                        "&caducidad=" + caducidad +
	                        "&estado=" + estado;
	                });
	        });
	</script>
	
</body>
</html>