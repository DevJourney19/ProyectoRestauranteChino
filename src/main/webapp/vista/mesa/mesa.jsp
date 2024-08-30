<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Escoger mesa</title>
<%@include file="../fragmentos/link_bootstrap.jsp"%>
<link href="../general_css/general_css.css" rel="stylesheet" />
<link href="mesa_css.css" rel="stylesheet" />
</head>
<body>
	<div class="p-3 text-white seleccionar_mesa_titulo">
		<i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i>
		Seleccionar mesa
	</div>
	<div class="busqueda_mesa">


		<div class="row row-cols-2 g-2 mb-4 opciones_busqueda_mesa" >
			<input type="text" placeholder="Nro o descripcion de la mesa" /> <select>
				<option>-- Selecciona Nivel --</option>
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
		<div class="mb-4">
			<div class="btn btn-success" style="font-size: 3rem;">Disponible</div>
			<div class="btn btn-danger" style="font-size: 3rem;">Ocupado</div>
			<div class="btn btn-warning" style="font-size: 3rem;">Atendido</div>
			<div class="btn btn-primary" style="font-size: 3rem;">Limpieza</div>
		</div>
		<div class="container py-2">


			<form action="../detalle_pedido/detalle_pedido.jsp" method="get">
				<div class="row row-cols-1 row-cols-md-2 justify-content-center"
					style="gap: 10px">
					<button class="mesa bg-success">
						<div class="d-flex justify-content-around">
							<span>01</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Disponible</div>
					</button>

					<button class="mesa bg-danger">
						<div class="d-flex justify-content-around">
							<span>02</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Ocupado</div>
					</button>

					<button class="mesa bg-primary">
						<div class="d-flex justify-content-around">
							<span>03</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Limpieza</div>
					</button>

					<button class="mesa bg-success">
						<div class="d-flex justify-content-around">
							<span>04</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Disponible</div>
					</button>

					<button class="mesa bg-success">
						<div class="d-flex justify-content-around">
							<span>05</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Disponible</div>
					</button>

					<button class="mesa bg-warning">
						<div class="d-flex justify-content-around">
							<span>06</span> <img alt="" src="../img/mesa.png"
								style="width: 100px;">
						</div>
						<div class="text-center">Atendido</div>
					</button>
				</div>
			</form>

		</div>
	</div>

	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>