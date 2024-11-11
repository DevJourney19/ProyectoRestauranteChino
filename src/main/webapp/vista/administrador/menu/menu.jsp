<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
<%@ page import="datos.DaoCategoria" %>
<%@ page import="datos.impl.DaoCategoriaImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="menu" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="categoria" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="vista/administrador/menu/menu.css">
<%@ include file="../fragmentos/head.jsp"%>
<title>ADMIN | MENÚ</title>
</head>
<body>
	<%
	List<Menu> listaMenu = (List<Menu>) menu;
	DaoCategoria daoCategoria = new DaoCategoriaImpl();
    List<Categoria> listaCategoria = daoCategoria.consultar();
	%>
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
						<div class="d-flex justify-content-between gap-4 flex-wrap" style="padding-top: 20px">
							<form class="d-flex gap-2 align-items-center" action="AdmiMenu" method="GET">
								<input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Busca por nombre..." name="tituloSearch">
								<button type="submit" class="btn btn-dark d-flex gap-2 align-items-center fw-bolder fs-4"><i class="lni lni-search"></i></button>
							</form>
							<div class="d-flex align-items-center justify-content-end gap-4">
							
								<a href="exportPDF" class="btn-pdf"><i class="lni lni-download"></i> Exportar PDF</a>
								<a href="exportExcel" class="btn-excel"><i class="lni lni-download"></i> Exportar Excel</a>
								
	
								<button class="btn-agregar" type="button" data-bs-toggle="modal"
									data-bs-target="#modalAdd">
									<i class="lni lni-plus"></i> Nuevo Producto
								</button>
							</div>
						</div>
					</div>

					<!-- Modal Agregar -->
					<div class="modal fade" id="modalAdd" tabindex="-1"
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
									<form action="AgregarMenu" class="needs-validation"
										novalidate method="POST" enctype="multipart/form-data">
										<div class="form-group mb-4 ">
											<div>
												<label for="cliente">Nombre</label> <input type="text"
													class="form-control" name="nombre" id="nombre" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div>
												<label for="cliente">Categoría</label> 
												<select	class="form-select" aria-label="large select example" name="categoria" id="categoria">
													<option selected>- Selecciona -</option>
													<% if(listaCategoria != null && !listaCategoria.isEmpty()) { %>
					                                    <% for(Categoria cat : listaCategoria) { %>
					                                        <option value="<%= cat.getId() %>"><%= cat.getNombre() %></option>
					                                    <% } %>
					                                <% } %>
												</select>
											</div>
											<div>
												<label for="cliente">Precio:</label> <input type="text"
													class="form-control" name="precio" id="precio" required>
											</div>
										</div>
										<div class="form-group mb-4">
											<div>
												<label for="cliente">Estado:</label> <select
													class="form-select" aria-label="Default select example" name="estado" id="estado">
													<option selected>- Selecciona -</option>
													<%for(Menu.Estado estado: Menu.Estado.values()) {%>
													<option value="<%=estado%>"><%=estado%></option>
													<%} %>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">Imagen:</label> 
											<input class="form-control" type="file" id="imagen" name="imagen" accept="image/*" >
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Descripción:</label>
											<textarea class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
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

					

					<!-- Modal Editar -->
					<div class="modal fade" id="modalEdit" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog-centered modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
										Editar Menu</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form action="EditarMenu" class="needs-validation"
										novalidate method="POST" enctype="multipart/form-data">
										<div class="form-group mb-4 ">
											<div>
												<label for="cliente">Nombre</label> <input type="text"
													class="form-control" name="nombre" id="nombreE" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div>
												<label for="cliente">Categoría</label> 
												<select	class="form-select" aria-label="large select example" name="categoria" id="categoriaE">
													<option selected>- Selecciona -</option>
													<%for(Categoria item: listaCategoria) {%>
														<option value="<%=item.getId()%>"><%=item.getNombre()%></option>
													<%} %>
												</select>
											</div>
											<div>
												<label for="cliente">Precio:</label> <input type="text"
													class="form-control" name="precio" id="precioE" required>
											</div>
										</div>
										<div class="form-group mb-4">
											<div>
												<label for="cliente">Estado:</label> <select
													class="form-select" aria-label="Default select example" name="estado" id="estadoE">
													<option selected>- Selecciona -</option>
													<%for(Menu.Estado estado: Menu.Estado.values()) {%>
													<option value="<%=estado%>"><%=estado%></option>
													<%} %>
												</select>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="cliente">Imagen:</label> 
											<input class="form-control" type="file" id="imagenE" name="imagen" multiple>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="totalPagar">Descripción:</label>
											<textarea class="form-control" id="descripcionE" name="descripcion" rows="3"></textarea>
										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="button" class="btn btn-warning" id="editarId">
												Editar</button>
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
									<p>¿Estas seguro de eliminar este Menu? <span
										id="modalIdEliminarMenu"></span></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-warning"
										data-bs-dismiss="modal">Cancelar</button>
									<input type="hidden" name="id" id="menuIdForm">
									<!-- Campo oculto para enviar el id con JS -->

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
									<th>Imagen</th>
									<th>Código</th>
									<th>Nombre</th>
									<th>Descripción</th>
									<th>Categoria</th>
									<th>Precio</th>
									<th>Estado</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
							<%
							if (menu != null && !menu.isEmpty()) {
								for (Menu menus : listaMenu) {
									String estadoMenu = "estado-desconocido";
									switch (menus.getEstado()) {
										case Venta :
											estadoMenu = "en-venta";
									break;
										case Desactivado :
											estadoMenu = "desactivado";
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
									<td><span class="<%=estadoMenu%>"><%=menus.getEstado()
									%></span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button data-id="<%=menus.getId()%>" class="icon-action btn_eliminar"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<!-- Abrir Modal Editar -->
											<button data-id="<%=menus.getId()%>"
												data-nombre="<%=menus.getNombre()%>"
												data-categoria="<%=menus.getCategoria().getId()%>"
												data-descripcion="<%=menus.getDescripcion()%>" 
												data-precio="<%=menus.getPrecio()%>"
												data-estado="<%=menus.getEstado()%>"
												data-imagen="<%=menus.getImagen()%>" class="icon-action btn_editar_input"
												data-bs-toggle="modal" data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<%
								}}
								 else {
								out.write("No se registraron menus...");
								System.out.println("No hay registros");
								}
								%>
								
								
							</tbody>
						</table>
					</div>
				</div>

			</main>
		</div>
	</div>
	<script src="vista/administrador/menu/menu.js"></script>
</body>
</html>
