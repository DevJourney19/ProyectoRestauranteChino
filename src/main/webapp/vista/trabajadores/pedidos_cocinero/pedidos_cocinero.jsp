<%@page import="modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="listaPedido" class="java.util.ArrayList"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<title>PEDIDOS - COCINERO</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="pedidos_cocinero.css" rel="stylesheet" />
</head>
<body>
	<%
	List<Object[]> pedidos = (List<Object[]>) listaPedido;
	%>
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="titulo_pedidos p-3">
				<h1 class="text-center">PEDIDOS ENTRANTES - 收到的订单</h1>
				<div class="table-responsive">
					<table class="table table-bordered text-center">
						<thead>
							<tr>
								<th>ID Pedido</th>
								<th>Mesa</th>
								<th>Hora</th>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Estado</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Object[] pe : pedidos) {
								java.sql.Timestamp timestamp = (java.sql.Timestamp) pe[2];
								SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
								String hora = sdf.format(timestamp);
								String estado = "estado-desconocido";
								switch (Pedido.EstadoPedido.valueOf(pe[5].toString())) {
									case Pendiente :
								estado = "badge bg-warning";
								break;
									case Cancelado :
								estado = "badge bg-primary";
								break;
									case Completado :
								estado = "badge bg-success";
								break;
								}
							%>
							<tr>
								<td>#<%=pe[0]%></td>
								<td>Mesa <%=pe[1]%></td>
								<td><%=hora%></td>
								<td><%=pe[3]%></td>
								<td><%=pe[4]%></td>
								<td><span class="<%=estado%>"><%=pe[5]%></span></td>
								<td class="d-flex flex-wrap gap-2 justify-content-center">
									<form action="EditarEstadoCocinero" method="post">
										<input type="hidden" name="idDet" value="<%=pe[0]%>">
										<input type="hidden" name="estado" value="Cancelado">
										<button type="submit" class="btn btn-primary">Cancelado</button>
									</form>
									<form action="EditarEstadoCocinero" method="post">
										<input type="hidden" name="idDet" value="<%=pe[0]%>">
										<input type="hidden" name="estado" value="Completado">
										<button type="submit" class="btn btn-success">Completado</button>
									</form>
									<form action="EditarEstadoCocinero" method="post">
										<input type="hidden" name="idDet" value="<%=pe[0]%>">
										<input type="hidden" name="estado" value="Pendiente">
										<button type="submit" class="btn btn-warning">Pendiente</button>
									</form>
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
