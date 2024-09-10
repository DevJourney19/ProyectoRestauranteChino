<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Pedidos - Cocinero</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="pedidos_cocinero_css.css" rel="stylesheet" />
</head>
<body>
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<div class="titulo_pedidos bg-success text-white p-3">
				<h1 class="text-center">Pedidos Entrantes</h1>
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
							<tr>
								<td>#0001</td>
								<td>Mesa 01</td>
								<td>12:30 PM</td>
								<td>Chaufa</td>
								<td>2</td>
								<td><span class="badge bg-warning">Pendiente</span></td>
								<td>
									<form action="#" method="post">
										<button type="submit" class="btn btn-primary">En
											preparación</button>
										<button type="submit" class="btn btn-success">Listo
											para servir</button>
									</form>
								</td>
							</tr>
							<tr>
								<td>#0002</td>
								<td>Mesa 01</td>
								<td>2:30 PM</td>
								<td>Chaufa</td>
								<td>5</td>
								<td><span class="badge bg-warning">Pendiente</span></td>
								<td>
									<form action="#" method="post">
										<button type="submit" class="btn btn-primary">En
											preparación</button>
										<button type="submit" class="btn btn-success">Listo
											para servir</button>
									</form>
								</td>
							</tr>
							<tr>
								<td>#0003</td>
								<td>Mesa 11</td>
								<td>1:30 PM</td>
								<td>Tallarines</td>
								<td>3</td>
								<td><span class="badge bg-warning">Pendiente</span></td>
								<td>
									<form action="#" method="post">
										<button type="submit" class="btn btn-primary">En
											preparación</button>
										<button type="submit" class="btn btn-success">Listo
											para servir</button>
									</form>
								</td>
							</tr>
							<tr>
								<td>#0004</td>
								<td>Mesa 21</td>
								<td>4:00 PM</td>
								<td>Combinado</td>
								<td>10</td>
								<td><span class="badge bg-warning">Pendiente</span></td>
								<td>
									<form action="#" method="post">
										<button type="submit" class="btn btn-primary">En
											preparación</button>
										<button type="submit" class="btn btn-success">Listo
											para servir</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>
