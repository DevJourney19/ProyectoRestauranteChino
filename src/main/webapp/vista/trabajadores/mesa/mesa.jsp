<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trabajadores | Escoger mesa</title>
<%@ include file="../fragmentos/head.jsp"%>
<link href="mesa.css" rel="stylesheet" />
</head>
<body>
	<main>
		<div class="main-content">
			<div class="p-3 text-white seleccionar_mesa_titulo text-center">
				<i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i>
				Seleccionar Mesa
			</div>
			<div class="busqueda_mesa">
				<div
					class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-2 mb-4 opciones_busqueda_mesa">
					<input type="text" placeholder="Nro o descripcion de la mesa" /> <select>
						<option class="text-center">-- Selecciona Nivel --</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <select>
						<option class="text-center">-- Todo --</option>
						<option>Disponible</option>
						<option>Ocupado</option>
						<option>Atendido</option>
						<option>Limpieza</option>
					</select>
					<button>
						<i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
						Buscar
					</button>
				</div>
				<!-- 		<div class="mb-4"> -->
				<!-- 			<div class="btn btn-success" style="font-size: 3rem;">Disponible</div> -->
				<!-- 			<div class="btn btn-danger" style="font-size: 3rem;">Ocupado</div> -->
				<!-- 			<div class="btn btn-warning" style="font-size: 3rem;">Atendido</div> -->
				<!-- 			<div class="btn btn-primary" style="font-size: 3rem;">Limpieza</div> -->
				<!-- 		</div> -->
				<div class="container py-2">


					<form action="../detalle_pedido/detalle_pedido.jsp" method="get">
						<div class="row row-cols-1 row-cols-md-2 justify-content-center "
							style="gap: 10px;">
							<button class="mesa bg-success" style="border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 01 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-white text-dark fs-1"
									style="border-radius: 12px;">Disponible</div>
							</button>

							<button class="mesa bg-danger" style="border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 02 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-dark text-white fs-1"
									style="border-radius: 12px;">Ocupado</div>
							</button>

							<button class="mesa"
								style="background: #02bfe8; border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 03 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-dark text-white fs-1"
									style="border-radius: 12px;">Limpieza</div>
							</button>

							<button class="mesa bg-success " style="border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 04 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-white text-dark fs-1"
									style="border-radius: 12px;">Disponible</div>
							</button>

							<button class="mesa bg-success" style="border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 05 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-white text-dark fs-1"
									style="border-radius: 12px;">Disponible</div>
							</button>

							<button class="mesa bg-warning" style="border-radius: 12px;">
								<div class="d-flex justify-content-around">
									<span class="text-white">- 06 -</span> <i
										class="fa-solid fa-receipt" style="color: #ffffff;"></i>
								</div>
								<div class="text-center bg-dark text-white fs-1"
									style="border-radius: 12px;">Atendido</div>
							</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</main>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>