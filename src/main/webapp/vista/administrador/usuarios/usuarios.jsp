<%@page import="modelo.Trabajador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="vista/administrador/usuarios/usuarios.css">
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
					<div class="table-responsive overflow-auto">
					    <table class="table">
					        <thead>
					            <tr>
					                <th>Id</th>
					                <th>Nombre Completo</th>
					                <th>Usuario</th>
					                <th>Contraseña</th>
					                <th>Teléfono</th>
					                <th>Rol</th>
					                <th>Acciones</th>
					            </tr>
					        </thead>
					        <tbody>
					            <%
					            // Verifica si la lista de usuarios no es nula
					            	List<Trabajador> listaTrabajadores = (List<Trabajador>) request.getAttribute("trabajador");
									if (listaTrabajadores == null || listaTrabajadores.isEmpty()) {
									    out.println("No hay trabajadores en la lista.");
									} else {
									    for (Trabajador trabajador : listaTrabajadores) {
									        String rol = "";
									        switch (trabajador.getId_rol()) {
									            case 1 :
									                rol = "Administrador";
									                break;
									            case 2 :
									                rol = "Mesero";
									                break;
									            case 3 :
									                rol = "Cajero";
									                break;
									        }
					            %>
					            <tr>
					                <td><%= trabajador.getCodigo() %></td>
					                <td><%= trabajador.getNombre() + " " + trabajador.getApellido() %></td>
					                <td><%= trabajador.getNombreUsuario() %></td>
					                <td>********</td>
					                <td><%= trabajador.getCelular() %></td>
					                <td><%= rol %></td>
					                <td>
					                    <div class="d-flex align-item-center justify-content-center gap-3">
					                        <!-- Botón Eliminar -->
					                        <button class="icon-action"
					                            data-bs-toggle="modal" data-bs-target="#staticBackdropUsuario"
					                            data-id="<%= trabajador.getCodigo()%>" >
					                            <i class="lni lni-trash-can fs-4"></i>
					                        </button>
					                        <!-- Botón Editar -->
					                        <button data-id="<%= trabajador.getCodigo()%>"
										        data-nombre="<%=trabajador.getNombre()%>" 
										        data-apellido="<%=trabajador.getApellido()%>" 
										        data-usuario="<%=trabajador.getNombreUsuario()%>" 
										        data-telefono="<%=trabajador.getCelular()%>"
										        data-rol="<%=trabajador.getId_rol()%>" class="icon-action"
					                            data-bs-toggle="modal" data-bs-target="#modalEdit">
					                            <i class="lni lni-pencil fs-4"></i>
					                        </button>
					                    </div>
					                </td>
					            </tr>
					            <%
								    }
								}
								%>
					        </tbody>
					    </table>
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
									<form action="AgregarUsuarios" method="post" class="needs-validation" novalidate>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="nombre">Nombres</label> 
												<input type="text" class="form-control" id="nombre" placeholder="Ingresa tu nombre" name="nombre" required>
											</div>
											<div class="col-12 col-md">
												<label for="apellidos">Apellidos</label>
												<input type="text" class="form-control" id="apellidos" placeholder="Ingresa tus apellidos" name="apellidos" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="usuario">Usuario</label> 
											<input type="text" class="form-control" id="usuario" placeholder="Ingresa tu usuario" name="usuario" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="password">Contraseña</label> 
											<input type="text" class="form-control" id="password" placeholder="Ingresa tu contraseña" name="password" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="telefono">Telefono</label> 
											<input type="text" class="form-control" id="telefono" placeholder="Ingresa tu telefono" name="telefono" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="rol">Rol</label> 
											<select class="form-select" name="rol" required>
												<option value="1">Adminitrador</option>
												<option value="2">Mesero</option>
												<option value="3">Cajero</option>
											</select>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
											<button type="submit" class="btn btn-warning">Registrar</button>
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
									<form action="EditarUsuarios" method="post" class="needs-validation" novalidate>
    									<input type="hidden" id="editId" name="id">
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<div class="col-12 col-md">
												<label for="nombre">Nombres</label> 
												<input type="text" class="form-control" id="editNombre" placeholder="Ingresa tu nombre" name="nombre" required>
											</div>
											<div class="col-12 col-md">
												<label for="apellidos">Apellidos</label>
												<input type="text" class="form-control" id="editApellidos" placeholder="Ingresa tus apellidos" name="apellidos" required>
											</div>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="usuario">Usuario</label> 
											<input type="text" class="form-control" id="editUsuario" placeholder="Ingresa tu usuario" name="usuario" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="password">Contraseña</label> 
											<input type="text" class="form-control" id="editPassword" placeholder="Ingresa tu contraseña" name="password" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="telefono">Telefono</label> 
											<input type="text" class="form-control" id="editTelefono" placeholder="Ingresa tu telefono" name="telefono" required>
										</div>
										<div class="form-group mb-4 d-flex flex-wrap gap-2">
											<label for="rol">Rol</label> 
											<select class="form-select" name="rol" id="editRol" required>
												<option value="1">Adminitrador</option>
												<option value="2">Mesero</option>
												<option value="3">Cajero</option>
											</select>
										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-bs-dismiss="modal">Cerrar</button>
											<button type="button" class="btn btn-warning" id="editarIdUsuario">Editar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal de Eliminar -> recibir un data value -->
					<div class="modal fade" id="staticBackdropUsuario"
						data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
						aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body fw-medium fs-4">
									 ¿Estás seguro de que deseas eliminar el usuario con ID <span id="modalIdEliminarUsuario"></span>?
								</div>
								<div class="modal-footer">
					                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
					                <button type="button" class="btn btn-danger" id="eliminarIdUsuario">Eliminar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script>
	 // Modal de eliminación para usuarios
    document
        .getElementById('staticBackdropUsuario')
        .addEventListener('show.bs.modal', function(event) {
            const button = event.relatedTarget;
            const id = button.getAttribute('data-id');
            document.getElementById('modalIdEliminarUsuario').innerHTML = "#" + id;

            document
                .getElementById('eliminarIdUsuario')
                .addEventListener('click', function(event) {
                    window.location.href = "/ProyectoRestauranteChino/EliminarUsuarios?id=" + id;
                });
        });
	 
 // Modal de edición para usuarios
    document
        .getElementById('modalEdit')
        .addEventListener('show.bs.modal', function(event) {
            const button = event.relatedTarget;
            const id = button.getAttribute('data-id');
            let nombreUsuario = button.getAttribute('data-nombre');
            let apellidoUsuario = button.getAttribute('data-apellido');
            let usuario = button.getAttribute('data-usuario');
            let telefonoUsuario = button.getAttribute('data-telefono');
            let rolUsuario = button.getAttribute('data-rol');

            document.getElementById('editNombre').value = nombreUsuario;
            document.getElementById('editApellidos').value = apellidoUsuario;
            document.getElementById('editUsuario').value = usuario;
            document.getElementById('editTelefono').value = telefonoUsuario;
            document.getElementById('editRol').value = rolUsuario;

            document
                .getElementById('editarIdUsuario')
                .addEventListener('click', function(event) {
                	nombreUsuario = document.getElementById('editNombre').value;
                	apellidoUsuario = document.getElementById('editApellidos').value;
                	usuario = document.getElementById('editUsuario').value;
                	telefonoUsuario = document.getElementById('editTelefono').value;
                	rolUsuario = document.getElementById('editRol').value;

                    window.location.href = "/ProyectoRestauranteChino/EditarUsuarios?id=" + id +
                        "&nombre=" + nombreUsuario +
                        "&apellido=" + apellidoUsuario +
                        "&usuario=" + usuario +
                        "&telefono=" + telefonoUsuario +
                        "&rol=" + rolUsuario;
                });
        });
	</script>

</body>
</html>
