<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>PEDIDO - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link
	href="${pageContext.request.contextPath}/vista/trabajadores/pedido/pedido.css"
	rel="stylesheet" />

</head>
<body class="body">
	<div class="d-flex">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="container">
				<h1 class="text-center pt-4 pb-2">PEDIDOS REALIZADOS - 已下订单</h1>
				<div
					class="d-flex justify-content-center justify-content-md-end 
	align-items-center pb-2 pb-md-4">
					<button
						class="aniadir_pedido fs-5 d-flex align-items-center gap-2 btn btn-warning"
						data-bs-toggle="modal" data-bs-target="#modalEdit">
						<img
							src="${pageContext.request.contextPath}/vista/img/boton-mas.png"
							style="width: 20px; height: 20px"> <span>Añadir
							Pedido</span>
					</button>
				</div>

				<div
					class="row row-cols-1 row-cols-xl-4 gap-4 justify-content-center overflow-auto mb-4">
					<%@include file="../fragmentos/pedido_realizado.jsp"%>
					<%@include file="../fragmentos/pedido_realizado.jsp"%>

				</div>
			</main>
		</div>
	</div>
	<!-- Modal con a;adir pedido segun mesa ocupadas actual y luego pasar a detalle_pedido-->
	<div class="modal fade" id="modalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog-centered modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
						Elegir la Mesa</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<!-- TIENE QUE LLEVARTE AL CONTROLADOR PARA CAMBIAR EL ESTADO DE LA MESA Y DE AHÍ TE TIENE QUE LLEVAR PARA SELECCIONAR EL PLATILLO (DETALLE DE PEDIDO) -->
					<form action="${pageContext.request.contextPath}/MesaMozoProceso"
						class="needs-validation" novalidate>
						<div class="d-flex justify-content-center flex-wrap">
							<div class="box_mesa">
								<label class="img_mesa" id="mesa1" for="mesa1"> <img
									src="${pageContext.request.contextPath}/vista/img/mesa.png" />
									<span>Mesa 1</span>
								</label><input type="radio" value="mesa1" name="mesa" data-target="1" />
							</div>
							<div class="box_mesa">
								<label class="img_mesa" id="mesa2" for="mesa2"> <img
									src="${pageContext.request.contextPath}/vista/img/mesa.png" />
									<span>Mesa 2</span>
								</label><input type="radio" value="mesa2" name="mesa" data-target="2" />
							</div>
							<div class="box_mesa">
								<label class="img_mesa" id="mesa3" for="mesa3"> <img
									src="${pageContext.request.contextPath}/vista/img/mesa.png" />
									<span>Mesa 3</span>
								</label><input type="radio" value="mesa3" name="mesa" data-target="3" />
							</div>
							<div class="box_mesa">
								<label class="img_mesa" id="mesa4" for="mesa4"> <img
									src="${pageContext.request.contextPath}/vista/img/mesa.png" />
									<span>Mesa 4</span>
								</label><input type="radio" value="mesa4" name="mesa" data-target="4" />
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-warning">Agregar
								Detalles</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>