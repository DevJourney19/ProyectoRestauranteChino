<%@page import="java.util.List"%>
<%@page import="modelo.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="menu" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="vista/administrador/menu/menu.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | MENÚ</title>
</head>
<body>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>

			<main class="p-3 mx-5">
				<div class="container-fluid">
					<div class="mb-3">
						<div
							class=" text-center d-flex align-items-center justify-content-between">
							<h1>GESTIÓN DEL MENÚ - 菜单管理</h1>
						</div>
						<div class="d-flex justify-content-between gap-4 flex-wrap">
						<form class="d-flex gap-2 align-items-center" action="AdmiMenu" method="GET">
						<input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Busca por titulo..." name="tituloSearch">
						<button type="submit" class="btn btn-dark d-flex gap-2 align-items-center fw-bolder fs-4"><i class="lni lni-search"></i></button>
						</form>
						<div class="d-flex align-items-center justify-content-end gap-4">
							<button class="btn-pdf" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								<i class="lni lni-download"></i> Descargar PDF
							</button>

							<button class="btn-excel" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								<i class="lni lni-download"></i> Descargar Excel
							</button>

							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAddEdit">
								<i class="lni lni-plus"></i> Nuevo Producto
							</button>
						</div></div>
					</div>

					<!-- Modal Agregar o Editar (para verificar editar solo ver la url)-->
					<div class="modal fade" id="modalAddEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Agrega Producto</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="" class="needs-validation" novalidate>
										<div class="form-group mb-4 ">
											<div>
												<label for="cliente">Nombre</label> <input type="text"
													class="form-control" name="nombre" required>
											</div>
										</div>
										<div class="form-group mb-4 ">
											<div>
												<label for="cliente">Categoría</label> <select
													class="form-select" aria-label="large select example">
													<option selected>- Selecciona -</option>
													<option value="1">Comida China</option>
													<option value="2">Postre</option>
													<option value="3">Bebida</option>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div>
												<label for="cliente">Stock:</label> <input type="number"
													class="form-control" name="stock" required>
											</div>
											<div>
												<label for="cliente">Precio:</label> <input type="text"
													class="form-control" name="precio" required>
											</div>
										</div>
										<div class="form-group mb-4">
											<div>
												<label for="cliente">Estado:</label> <select
													class="form-select" aria-label="Default select example">
													<option selected>- Selecciona -</option>
													<option value="1">Venta</option>
													<option value="2">Desactivado</option>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">Imagen:</label> <input
												class="form-control" type="file" id="formFileMultiple"
												multiple>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Descripción:</label>
											<textarea class="form-control"
												id="exampleFormControlTextarea1" rows="3"></textarea>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">
												Agregar Producto</button>
										</div>
									</form>
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
									<p>¿Estas seguro de eliminar este Producto?</p>
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
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%
								List<Menu> listaMenu = (List<Menu>) menu;
								for (Menu menus : listaMenu) {
									String estado = "estado-desconocido";
									switch (menus.getEstado()) {
										case Venta :
									estado = "en-venta";
									break;
										case Desactivado :
									estado = "desactivado";
									break;
									}
								%>

								<tr>
									<td><img src="<%=menus.getImagen() %>" class="img-menu img-fluid"></td>
									<td><%=menus.getId()%></td>
									<td><%=menus.getNombre()%></td>
									<td><%=menus.getDescripcion()%></td>
									<td><%=menus.getCategoria().getNombre()%></td>
									<td><%=menus.getPrecio()%></td>
									<td><span class="<%=estado%>"><%=menus.getEstado()%></span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=menus.getId()%>" class="icon-action"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button data-id="<%=menus.getId()%>"
												data-nombre="<%=menus.getNombre()%>"
												data-categoria="<%=menus.getCategoria().getId()%>" class="icon-action"
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
	<script>
    window.onload = function() {
        const urlParams = new URLSearchParams(window.location.search);
        const mensaje = urlParams.get('mensaje');

        if (mensaje) {
            alert(mensaje);
            // Eliminar el parámetro 'mensaje' de la URL
            urlParams.delete('mensaje');
        }
        // Actualizar la URL sin recargar la página
        window.history.replaceState({}, document.title, window.location.pathname + (urlParams.toString() ? '?' + urlParams.toString() : ''));
    };
	</script>
</body>
</html>
