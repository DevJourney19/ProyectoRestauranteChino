

<%@page import="modelo.Trabajador"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="modelo.Trabajador"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/vista/administrador/usuarios/usuarios.css">


<%@ include file="../fragmentos/head.jsp"%>

<title>ADMIN | USUARIOS</title>
</head>
<body>
	<%
	List<Trabajador> trabajadores = (List<Trabajador>) request.getAttribute("trabajadores");
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
							<h1>GESTIÓN DE USUARIOS - 用户管理</h1>
						</div>
						<div
							class="d-flex align-items-center justify-content-center mt-2 mt-md-0 justify-content-md-end gap-4">
							<button class="btn-agregar" type="button" data-bs-toggle="modal"
								data-bs-target="#modalAdd">
								Nuevo Usuario <i class="lni lni-plus"></i>
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
										Agrega Usuario</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
				
									<form
										action="${pageContext.request.contextPath}/SvAgregarTrabajador"
										class="needs-validation" novalidate method="POST">
	
										<div class="form-group d-flex flex-wrap gap-2">
											<!-- NOMBRE -->
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="nombre">Apellido</label> <input type="text"
													class="form-control" id="nombre"
													aria-describedby="emailHelp"
													placeholder="Ingrese Apellidos" name="apellido" required>
											</div>
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="nombre">Nombre</label> <input type="text"
													class="form-control" id="nombre"
													aria-describedby="emailHelp" placeholder="Ingrese Nombres"
													name="nombre" required>
											</div>
										</div>
										<!-- DNI -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="dni">DNI</label> <input type="text"
													class="form-control" id="dni" aria-describedby="emailHelp"
													placeholder="Ingrese DNI" maxlength="8" name="dni" required>

											</div>
											<!-- CORREO -->
											<div class="col-12 col-md">

												<label for="correo">Correo</label> <input type="text"
													class="form-control" id="correo"
													aria-describedby="emailHelp" placeholder="Ingrese Correo"
													name="correo" required min="0">

											</div>
										</div>
										<!-- NOMBRE DE USUARIO -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">

											<div class="col-12 col-md">
												<label for="usuario">Usuario</label> <input type="text"
													class="form-control" id="usuario"
													aria-describedby="emailHelp" placeholder="Ingrese Usuario"
													name="usuario" required>
											</div>
											<!-- CONTRASENIA -->
											<div class="col-12 col-md">
												<label for="password">Contraseña</label> <input
													type="password" class="form-control" id="password"
													aria-describedby="emailHelp"
													placeholder="Ingrese Contraseña" name="password" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<!-- CELULAR -->
											<div class="col-6 col-md">
												<label for="celular">Celular</label> <input type="text"
													class="form-control" id="celular"
													aria-describedby="emailHelp" placeholder="Ingrese Número"
													name="celular" maxlength="9" required>
											</div>
											<!-- ROL-->
											<div class="form-group mb-4 d-flex flex-wrap col-6 col-md">
												<label for="rol">Rol</label> <select class="form-select"
													aria-label="large select example" name="rol">
													<option disabled>- Selecciona -</option>
													<option value="1">Adminitrador</option>
													<option value="2">Cocinero</option>
													<option value="3">Mozo</option>
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
								<!-- MODAL PARA ESCRIBIR EL NUEVO VALOR -->
								<div class="modal-body">

									<form
										action="${pageContext.request.contextPath}/SvEditarTrabajador"
										method="POST" class="needs-validation" novalidate>

										<input type="hidden" name="id" id="trabajadorIdForm_e">
										<div class="form-group d-flex flex-wrap gap-2">
											<!-- APELLIDO -->
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="apellidoE">Apellido</label> <input type="text"
													class="form-control" id="apellidoE"
													aria-describedby="emailHelp"
													placeholder="Ingrese Apellidos" name="apellido" required>
											</div>
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="nombreE">Nombre</label> <input type="text"
													class="form-control" id="nombreE"
													aria-describedby="emailHelp" placeholder="Ingrese Nombres"
													name="nombre" required>
											</div>
										</div>
										<!-- DNI -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="dniE">DNI</label> <input type="text"
													class="form-control" id="dniE" aria-describedby="emailHelp"
													placeholder="Ingrese DNI" maxlength="8" name="dni" required>

											</div>
											<!-- CORREO -->
											<div class="col-12 col-md">

												<label for="correoE">Correo</label> <input type="text"
													class="form-control" id="correoE"
													aria-describedby="emailHelp" placeholder="Ingrese Correo"
													name="correo" required min="0">

											</div>
										</div>
										<!-- NOMBRE DE USUARIO -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">

											<div class="col-12 col-md">
												<label for="usuarioE">Usuario</label> <input type="text"
													class="form-control" id="usuarioE"
													aria-describedby="emailHelp" placeholder="Ingrese Usuario"
													name="usuario" required>
											</div>
											<!-- CONTRASENIA -->
											<div class="col-12 col-md">
												<label for="passwordE">Contraseña</label> <input
													type="password" class="form-control" id="passwordE"
													aria-describedby="emailHelp"
													placeholder="Ingrese Contraseña" name="password" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<!-- CELULAR -->
											<div class="col-6 col-md">
												<label for="celularE">Celular</label> <input type="text"
													class="form-control" id="celularE"
													aria-describedby="emailHelp" placeholder="Ingrese Número"
													name="celular" maxlength="9" required>
											</div>
											<!-- ROL-->
											<div class="form-group mb-4 d-flex flex-wrap col-6 col-md">
												<label for="rolE">Rol</label> <select class="form-select"
													aria-label="large select example" name="rol" id="rolE">
													<option disabled>- Selecciona -</option>
													<option value="1">Adminitrador</option>
													<option value="2">Cocinero</option>
													<option value="3">Mozo</option>
												</select>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">Editar</button>
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
									¿Estás seguro de que deseas eliminar el usuario con ID <span
										id="modalIdEliminarUsuario"></span>?
								</div>
								<div class="modal-footer">

									<button type="button" class="btn btn-warning"
										data-bs-dismiss="modal">Cancelar</button>

									<form
										action="${pageContext.request.contextPath}/SvEliminarTrabajador"
										method="POST">
										<input type="hidden" name="id" id="trabajadorIdForm">
										<!-- Campo oculto para enviar el id con JS -->

										<button type="submit"
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
									<th>Código</th>
									<th>Apellidos</th>
									<th>Nombres</th>
									<th>DNI</th>
									<th>Correo</th>
									<th>Usuario</th>
									
									<th>Celular</th>
									<th>Rol</th>
									<th></th>
								</tr>
							</thead>

							<tbody>
								<%
								if (trabajadores != null && !trabajadores.isEmpty()) {
									for (Trabajador trabajador : trabajadores) {
								%>

								<tr>
									<td><%=trabajador.getId()%></td>
									<td><%=trabajador.getApellido()%></td>
									<td><%=trabajador.getNombre()%></td>
									<td><%=trabajador.getDni()%></td>
									<td><%=trabajador.getCorreo()%></td>
									<td><%=trabajador.getNombreUsuario()%></td>
									
									<td><%=trabajador.getCelular()%></td>

									<td><span class="estado-cancelado"><%=trabajador.getRol().getNombre()%></span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<!-- Boton lapiz eliminar -->
											<button class="icon-action btn_eliminar"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop"
												data-id="<%=trabajador.getId()%>">
												<i class="lni lni-trash-can fs-4"></i>
											</button>

											<button class="icon-action btn_editar_input"
												data-bs-toggle="modal" data-bs-target="#modalEdit"
												data-id="<%=trabajador.getId()%>"
												data-apellido="<%=trabajador.getApellido()%>"
												data-nombre="<%=trabajador.getNombre()%>"
												data-dni="<%=trabajador.getDni()%>"
												data-correo="<%=trabajador.getCorreo()%>"
												data-usuario="<%=trabajador.getNombreUsuario()%>"
												
												data-celular="<%=trabajador.getCelular()%>"
												data-id-rol="<%=trabajador.getRol()%>">
												<i class="lni lni-pencil fs-4"></i>
											</button>

										</div>
									</td>
								</tr>
								<%
								}
								} else {

								out.write("No se registraron usuarios...");
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

	<script
		src="${pageContext.request.contextPath}/vista/administrador/usuarios/usuarios.js"></script>

</body>
</html>
