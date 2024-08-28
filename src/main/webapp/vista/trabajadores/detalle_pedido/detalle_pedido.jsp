<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="../fragmentos/link_bootstrap.jsp"%>
<link href="../general_css/general_css.css" rel="stylesheet" />
<link href="detalle_pedido.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Detalle Pedido</title>
</head>
<body>
	<div class="detalle_pedido_div">Menu</div>
	<!-- 	my-lg-5 -->
	<button onclick="myFunction()"
		class="d-flex w-25 justify-content-center mx-auto btn btn-warning my-3 boton_deta_pedi">Mostrar
		Tabla</button>
	<div class="d-flex flex-column">
		<!-- Inicio TABLA -->
		<div class="table-responsive" id="tabla_detalle_pedidos">
			<table
				class="table w-100 
				 table-bordered table-hover fs-2 text-center">
				<thead>
					<tr class="table-dark">

						<th>Cantidad</th>
						<th>Precio</th>
						<th>Importe</th>
						<th colspan="3">Acciones</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
		<!-- Fin TABLA -->
		<!-- INICIO UNION DIVS BUSQUEDA Y CARD_PRODUCTS -->
		<div>
			<!-- Inicio BUSQUEDA -->
			<div class="container py-4">
				<h2>
					<label for="buscar" class="text-white">Buscar producto</label>
				</h2>
				<div class="contorno_buscar">

					<div class="container-fluid">
						<form class="d-flex" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Buscar" aria-label="Search">
							<button class="btn btn-warning" type="submit">Buscar</button>
						</form>
						<div class=" d-flex mt-3 gap-2 rounded">
							<button class="btn btn-outline-warning">Todo</button>
							<button class="btn btn-outline-warning">Segundos</button>
							<button class="btn btn-outline-warning">Sopas</button>
							<button class="btn btn-outline-warning">Otros</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Fin BUSQUEDA -->
			<div class="fondo_verde_productos">
				<!-- Inicio CARD PRODUCTO -->
				<div class="container py-2 contenedor_cards">
					<div
						class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xxl-4 g-4 py-2">
						<!-- inicio card 1 -->
						<div class="col" style="max-height: 362px;">
							<div class="shadow-lg bg-white rounded card p-2 ">
								<img src="../img/arroz_chaufa.png" style="width: 200px"
									class="mx-auto card-img-top" alt="chaufa">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b>Arroz Chaufa</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 18</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin card 1 -->
						<!-- inicio card 2 -->
						<div class="col" style="max-height: 362px;">
							<div class="shadow-lg bg-white rounded card p-2 ">
								<img src="../img/tallarin_saltado.png" style="width: 140px;"
									class="mx-auto card-img-top" alt="tallarín_saltado">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b class="fs-2">Tallarín Saltado</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 16</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center btn estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin de card 2 -->
						<!-- inicio card 3 -->
						<div class="col">
							<div class="shadow-lg bg-white rounded card p-2"
								style="max-height: 352px;">
								<img src="../img/aeropuerto.png" style="width: 204px"
									class="mx-auto card-img-top" alt="plato_aeropuerto">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b>Aeropuerto</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 20</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center btn estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin de card 3 -->
						<!-- inicio card 4 -->
						<div class="col">
							<div class="shadow-lg bg-white rounded card p-2"
								style="max-height: 352px;">
								<img src="../img/wantan.png" style="width: 220px"
									class="mx-auto card-img-top" alt="wantán">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b>Wantán</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 5</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center btn estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin de card 4 -->
						<!-- inicio card 5 -->
						<div class="col" style="max-height: 362px;">
							<div class="shadow-lg bg-white rounded card p-2 ">
								<img src="../img/sopa_wantan.png" style="width: 117px"
									class="mx-auto card-img-top" alt="sopa_wantán">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b>Sopa Wantán</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 8</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center btn estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin de card 5 -->
						<!-- inicio card 6 -->
						<div class="col" style="max-height: 362px;">
							<div class="shadow-lg bg-white rounded card p-2 ">
								<img src="../img/fideos_yakisoba.png" style="width: 178px"
									class="mx-auto card-img-top" alt="Fideos Yakisoba">
								<div class="card-body">
									<h1 class="card-title text-center mb-4">
										<b class="fs-2">Fideos Yakisoba</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h3 class="mt-4 fs-1">
											<b>S/. 18</b>
										</h3>

										<div class="d-flex flex-column">
											<i class="fas fa-chevron-up fa-2x"></i>
											<div class="circulito">
												<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
													class="number"><b>&nbsp;1</b></span>
											</div>
											<i class="fa-solid fa-angle-down fa-2x"></i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center btn estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin de card 6 -->
					</div>
				</div>
				<!-- Fin CARD PRODUCTO -->
			</div>
		</div>
		<!-- FIN DE UNIÓN DIVS BUSQUEDA Y CARD_PRODUCTS -->
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"
		crossorigin="anonymous"></script>
	<script src="detalle_pedido.js"></script>
</body>
</html>