<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Mesa"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="mesas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<title>MESAS - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="./vista/trabajadores/mesas_mozo/mesas_mozo.css"
	rel="stylesheet" />
</head>
<body>
	<%
	List<Mesa> listaMesas = (List<Mesa>) mesas;
	%>
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="titulo_mesas p-3">
				<h1 class="text-center">GESTIONAR MESAS - 管理表</h1>

				<form class="row mb-4 g-2" action="TrabajadorMesa" method="GET">
					<div class="col-md-6">
						<input type="text" class="form-control" name="tituloSearch"
							placeholder="Buscar mesa (Nro o descripción)">
					</div>
					<div class="col-md-3">
						<select id="busqueda" name="estado" class="form-select"
							aria-label="Default select example">
							<option selected disabled>Estado</option>
							<%
							for (Mesa.EstadoMesa estado : Mesa.EstadoMesa.values()) {
							%>
							<option value="<%=estado%>"><%=estado%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="col-md-3">
						<button class="btn btn-primary w-100">Buscar</button>
					</div>
				</form>

				<!-- Tabla de mesas -->
				<div class="table-responsive">
					<table class="table table-bordered text-center">
						<thead>
							<tr>
								<th>Nro de Salon</th>
								<th>Nro de Mesa</th>
								<th>Estado</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Mesa mesa : listaMesas) {
								String estado = "estado-desconocido";
								switch (mesa.getEstado()) {
									case Libre :
								estado = "badge bg-success";
								break;
									case Reservado :
								estado = "badge bg-info";
								break;
									case Ocupado :
								estado = "badge bg-danger";
								break;
									case Limpieza :
								estado = "badge bg-warning";
								break;
								}
							%>

							<tr>
								<td><%=mesa.getN_salon()%></td>
								<td><%=mesa.getN_mesa()%></td>
								<td><span class="<%=estado%>"><%=mesa.getEstado().toString()%></span></td>
								<td>
									<div
										class="d-flex align-item-center justify-content-center gap-3">
										<form action="EditarMesa?accion=Libre" method="post">
											<input type="hidden" name="id" value="<%=mesa.getId()%>">
											<input type="hidden" name="mesa"
												value="<%=mesa.getN_mesa()%>"> <input type="hidden"
												name="salon" value="<%=mesa.getN_salon()%>">
											<button class="btn btn-dark">Liberar Mesa</button>
										</form>
										<form action="EditarMesa?accion=Ocupado" method="post">
											<input type="hidden" name="id" value="<%=mesa.getId()%>">
											<input type="hidden" name="mesa"
												value="<%=mesa.getN_mesa()%>"> <input type="hidden"
												name="salon" value="<%=mesa.getN_salon()%>">
											<button class="btn btn-primary">Asignar Mesa</button>
										</form>
										<form action="EditarMesa?accion=Limpieza" method="post">
											<input type="hidden" name="id" value="<%=mesa.getId()%>">
											<input type="hidden" name="mesa"
												value="<%=mesa.getN_mesa()%>"> <input type="hidden"
												name="salon" value="<%=mesa.getN_salon()%>">
											<button class="btn btn-secondary">Limpieza</button>
										</form>
									</div>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
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
    </script>
</body>
</html>
