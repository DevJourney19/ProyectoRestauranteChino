<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../fragmentos/head.jsp"%>
<link href="detalle_pedido.css" rel="stylesheet">
<title>Detalle Pedido</title>
</head>
<body>
	<div class="titulo_detalle_pedido">Noche en Pekín 北京之夜</div>
	<div class="container detalle_pedido_div">Menu</div>
	<!-- 	my-lg-5 -->
	<button onclick="myFunction()"
		class=" d-flex  justify-content-center mx-auto btn btn-warning my-3 boton_deta_pedi">Mostrar
		resumen de pedido</button>


	<div
		class="d-flex flex-column combinado_tabla_y_productos justify-content-center">
		<!-- Inicio TABLA Y CARDS -->
		<div
			class="container d-flex flex-column flex-wrap mt-4 bg-white tabla_detalle_pedidos"
			style="border: 1px solid lightgray; border-radius: 10px; max-width: 80%"
			id="tabla_detalle_pedidos">
			<div class="p-3 fs-3">
				<b>Resumen de Pedido</b> <br />#0000001
			</div>

			<hr />
			<div class="p-3">
				<div class=" fs-5" style="display: inline; font-weight: 600">Total
					de objetos (6)</div>
				<div style="height: 300px; overflow: scroll;">

					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
					<div
						class="d-flex p-2 m-2 align-items-center justify-content-center"
						style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
						<img src="../../img/arroz_chaufa.png" style="width: 60px"
							alt="img">
						<h6 class="mx-2 " style="font-weight: 600">
							Arroz Chaufa<br /> (S/. 18) x2
						</h6>
						<i class="fas fa-solid fa-trash fa-xl mx-2" style="color: red;"></i>
					</div>
				</div>
			</div>
			<!-- Resumen de pago -->
			<div class="p-2">
				<div class="d-flex p-2 m-2 flex-column fs-5"
					style="border: 1px solid lightgray; border-radius: 10px; font-weight: 600">

					<div>Resumen de pago</div>
					<div class="d-flex justify-content-evenly ">
						<div>Precio:</div>
						<div>S/. 18.00</div>
					</div>
					<div class="d-flex justify-content-evenly ">
						<div>Impuestos:</div>
						<div>S/. 4.00</div>
					</div>
					<div class="d-flex justify-content-evenly text-primary ">
						<div>Total:</div>
						<div>S/. 20.00</div>
					</div>

					<hr />
					<a type="button" href="../pedido/pedido.jsp"
						class="btn btn-primary mx-auto">Realizar pedido</a>
				</div>
			</div>

			<!--  
		<!-- Inicio TABLA -->
			<!--  
		
		<!-- Fin TABLA -->
			<!-- FIN DE UNIÓN DIVS BUSQUEDA Y CARD_PRODUCTS -->
		</div>
		<div class="d-flex justify-content-center">

			<!-- INICIO UNION DIVS BUSQUEDA Y CARD_PRODUCTS -->
			<div>
				<!-- Inicio BUSQUEDA -->
				<div class="py-4">
					<h2>
						<label for="buscar" class="text-dark">Buscar producto</label>
					</h2>



					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Buscar" aria-label="Search">
						<button class="btn btn-warning" type="submit">Buscar</button>
					</form>
					<div class=" d-flex mt-3 gap-1 rounded">
						<button class="btn btn-warning">Todo</button>
						<button class="btn btn-warning">Segundos</button>
						<button class="btn btn-warning">Sopas</button>
						<button class="btn btn-warning">Otros</button>
					</div>


				</div>
				<!-- Fin BUSQUEDA -->

				<!-- Inicio CARD PRODUCTO -->
				<div class="container py-2 contenedor_cards">
					<div
						class="row row-cols-1 row-cols-md-2 row-cols-lg-2 row-cols-xxl-3 g-4 py-2">
						<!-- inicio card 1 -->
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
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
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="shadow-sm card card_plato"
								style="border: 2px solid #FFD700; border-radius: 15px">
								<img src="../../img/arroz_chaufa.png" style="width: 200px"
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
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
											<!-- fin del circulo -->
											<div>1</div>
											<i class="fa-solid fa-circle fa-2x"
												style="color: #fafafa; position: relative"> <i
												class="fa-solid fa-plus fa-2xs"
												style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
											</i>
										</div>
									</div>
									<a href="#"
										class="d-flex justify-content-center estilo_btn_1 py-3">Agregar</a>
								</div>
							</div>
						</div>

						<!-- Fin CARD PRODUCTO -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin TABLA Y CARDS -->
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
	<script src="detalle_pedido.js"></script>
</body>
</html>