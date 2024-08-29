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
	<!-- 	<button onclick="myFunction()" -->
	<!-- 		class="d-flex w-25 justify-content-center mx-auto btn btn-warning my-3 boton_deta_pedi">Mostrar -->
	<!-- 		Tabla</button> -->
	<!-- Inicio TABLA Y CARDS -->
	<div class="d-flex">

		<!-- INICIO UNION DIVS BUSQUEDA Y CARD_PRODUCTS -->
		<div>
			<!-- Inicio BUSQUEDA -->
			<div class="container py-4">
				<h2>
					<label for="buscar" class="text-dark">Buscar producto</label>
				</h2>
				<div class="contorno_buscar">

					<div class="container-fluid">
						<form class="d-flex" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Buscar" aria-label="Search">
							<button class="btn btn-warning" type="submit">Buscar</button>
						</form>
						<div class=" d-flex mt-3 gap-2 rounded">
							<button class="btn btn-warning">Todo</button>
							<button class="btn btn-warning">Segundos</button>
							<button class="btn btn-warning">Sopas</button>
							<button class="btn btn-warning">Otros</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Fin BUSQUEDA -->
			<div class="fondo_verde_productos mx-3 ">
				<!-- Inicio CARD PRODUCTO -->
				<div class="container py-2 contenedor_cards">
					<div
						class="row row-cols-1 row-cols-md-2 row-cols-lg-2 row-cols-xxl-3 g-4 py-2">
						<!-- inicio card 1 -->
						<div class="col">
							<div class="shadow-lg card card_plato" style="width: 75%">
								<img src="../img/arroz_chaufa.png" style="width: 200px"
									class="mx-auto card-img-top" alt="chaufa">
								<div class="card-body ">
									<h1 class="card-title text-center mb-3">
										<b>Arroz Chaufa</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h1 class="mt-3 ">
											<b>S/. 18</b>
										</h1>

										<div
											class="d-flex justify-content-center align-items-center px-2 rounded-pill mt-3"
											style="background: lightgray; gap: 10px; height: 35px;">

											<!-- inicio del circulo -->
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-minus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<!-- fin card 1 -->
						<div class="col">
							<div class="shadow-lg card card_plato" style="width: 75%">
								<img src="../img/arroz_chaufa.png" style="width: 200px"
									class="mx-auto card-img-top" alt="chaufa">
								<div class="card-body ">
									<h1 class="card-title text-center mb-3">
										<b>Arroz Chaufa</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h1 class="mt-3 ">
											<b>S/. 18</b>
										</h1>

										<div
											class="d-flex justify-content-center align-items-center px-2 rounded-pill mt-3"
											style="background: lightgray; gap: 10px; height: 35px;">

											<!-- inicio del circulo -->
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-minus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-lg card card_plato" style="width: 75%">
								<img src="../img/arroz_chaufa.png" style="width: 200px"
									class="mx-auto card-img-top" alt="chaufa">
								<div class="card-body ">
									<h1 class="card-title text-center mb-3">
										<b>Arroz Chaufa</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h1 class="mt-3 ">
											<b>S/. 18</b>
										</h1>

										<div
											class="d-flex justify-content-center align-items-center px-2 rounded-pill mt-3"
											style="background: lightgray; gap: 10px; height: 35px;">

											<!-- inicio del circulo -->
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-minus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-lg card card_plato" style="width: 75%">
								<img src="../img/arroz_chaufa.png" style="width: 200px"
									class="mx-auto card-img-top" alt="chaufa">
								<div class="card-body ">
									<h1 class="card-title text-center mb-3">
										<b>Arroz Chaufa</b>
									</h1>
									<div class="d-flex justify-content-evenly mb-4">
										<h1 class="mt-3 ">
											<b>S/. 18</b>
										</h1>

										<div
											class="d-flex justify-content-center align-items-center px-2 rounded-pill mt-3"
											style="background: lightgray; gap: 10px; height: 35px;">

											<!-- inicio del circulo -->
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-minus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 12px; left: 6px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>

					







					<!-- fin de card 6 -->
				</div>
				
			</div>
			<!-- Fin CARD PRODUCTO -->
		</div>
	</div>

	<div class="d-flex flex-column mt-4"
		style="border: 1px solid lightgray; border-radius: 10px;">
		<div class="p-3">
			<b><h4>Resumen de Pedido</h4></b> #AAAAAAA

		</div>
		<hr />
		<div class="p-3">
			<b>Total de objetos </b>(1)
			<div class="d-flex p-2 m-2 align-items-center"
				style="border: 1px solid lightgray; border-radius: 10px;">
				<img src="../img/arroz_chaufa.png" style="width: 60px" alt="img">
				<h6 class="mx-2 " style="font-weight: 600">
					Arroz Chaufa<br /> (S/. 18) x2
				</h6>
				<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
			</div>

		</div>
		<!-- Resumen de pago -->
		<div class="p-2">
			<div class="d-flex p-3 m-2 align-items-center flex-column"
				style="border: 1px solid lightgray; border-radius: 10px;">

				<h5>Resumen de pago</h5>
				<h5>Precio: S/. 18.00</h5>
				<h5>Impuestos: S/. 10.00</h5>
				<h5>Descuento: S/. 5.00</h5>
				<hr />
				<h5 class="text-primary">Total: S/. 23.00</h5>
				<button class="btn btn-primary mx-auto">Realizar pedido</button>
			</div>
		</div>

		<!--  
		<!-- Inicio TABLA -->
		<!--  
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
		</div> -->
		<!-- Fin TABLA -->
		<!-- FIN DE UNIÓN DIVS BUSQUEDA Y CARD_PRODUCTS -->
	</div>
	<!-- Fin TABLA Y CARDS -->
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
	<script src="detalle_pedido.js"></script>
</body>
</html>
<!-- <script src="https://kit.fontawesome.com/c353473263.js" -->
<!-- 		crossorigin="anonymous"></script> -->