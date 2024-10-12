<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="agregacion" class="modelo.Trabajador" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="usuarios.css">
<%@ include file="../fragmentos/head.jsp"%>

<title>ADMIN | USUARIOS</title>
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
								<!-- Solucionar problema de url -->
									<form action="vista/administrador/usuarios/SvAgregarTrabajador" class="needs-validation"
										novalidate method="POST">
										<div class="form-group  d-flex flex-wrap gap-2">
											<!-- NOMBRE -->
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="nombre">Apellidos</label> <input type="text"
													class="form-control" id="nombre"
													aria-describedby="emailHelp"
													placeholder="Ingrese Apellidos" name="apellido" required>
											</div>
											<div
												class="form-group mb-4 d-flex flex-wrap gap-2 col-6 col-md">
												<label for="nombre">Nombres</label> <input type="text"
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
													placeholder="Ingrese DNI" name="dni" required>
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
													name="celular" required>
											</div>
											<!-- ROL-->
											<div class="form-group mb-4 d-flex flex-wrap col-6 col-md">
												<label for="rol">Rol</label> <select class="form-select"
													aria-label="large select example" name="rol">
													<option selected>- Selecciona -</option>
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
								<div class="modal-body">
									<form action="SvAgregarTrabajador" class="needs-validation"
										novalidate>
										<!-- NOMBRE -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="nombre">Nombre Completo</label> <input
												type="text" class="form-control" id="nombre"
												aria-describedby="emailHelp" placeholder="Enter Name"
												name="nombre" required>
										</div>
										<!-- NOMBRE -->
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="dni">DNI</label> <input type="text"
													class="form-control" id="dni" aria-describedby="emailHelp"
													placeholder="Enter DNI" name="dni" required>
											</div>
											<div class="col-12 col-md">
												<label for="correo">Correo</label> <input type="text"
													class="form-control" id="correo"
													aria-describedby="emailHelp" placeholder="Enter Correo"
													name="corro" required min="0">
											</div>
											<!-- NOMBRE DE USUARIO-->
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="usuario">Usuario</label> <input type="text"
													class="form-control" id="usuario"
													aria-describedby="emailHelp" placeholder="Enter Usuario"
													name="usuario" required>
											</div>
											<!-- CONTRASENIA -->
											<div class="col-12 col-md">
												<label for="password">Password</label> <input
													type="password" class="form-control" id="password"
													aria-describedby="emailHelp" placeholder="Enter Password"
													name="password" required>
											</div>
										</div>

										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="rol">Rol</label> <select class="form-select"
												aria-label="large select example">
												<option selected>- Selecciona -</option>
												<option value="1">Adminitrador</option>
												<option value="2">Cocinero</option>
												<option value="3">Mozo</option>
											</select>
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
									<p>Estas seguro de eliminar este Usuario?</p>
									<p>#1</p>
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
									<th>Código</th>
									<th>Apellidos</th>
									<th>Nombres</th>
									<th>DNI</th>
									<th>Correo</th>
									<th>Usuario</th>
									<th>Password</th>
									<th>Rol</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Elena</td>
									<td>73794657</td>
									<td>ede24@gmail.com</td>
									<td>le123</td>
									<td>********</td>
									<td><span class="estado-cancelado">Administrador</span></td>

									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Mariana</td>
									<td>73794657</td>
									<td>ede24@gmail.com</td>
									<td>le123</td>
									<td>********</td>
									<td><span class="estado-cancelado">Cocinero</span></td>

									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button class="icon-action">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Yoshua</td>
									<td>73993482</td>
									<td>f4r3ver@gmail.com</td>
									<td>DevJourney19</td>
									<td>********</td>
									<td><span class="estado-cancelado">Mozo</span></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">
												<i class="lni lni-trash-can fs-4"></i>
											</button>
											<button class="icon-action" data-bs-toggle="modal"
												data-bs-target="#modalEdit">
												<i class="lni lni-pencil fs-4"></i>
											</button>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</main>
		</div>
	</div>

</body>
</html>