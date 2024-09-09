<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://cdn.lineicons.com/4.0/lineicons.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../general_css/general_css.css">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link href="inicio.css" rel="stylesheet">
<title>Noche en Pekin Inicio Sesion</title>
</head>
<style>
.absolute {
	position: absolute;
}

.inset-0 {
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
}

.-z-10 {
	z-index: -10;
}

.h-full {
	height: 100%;
}

.w-full {
	width: 100%;
}

.items-center {
	align-items: center;
}

.px-5 {
	padding-left: 1.25rem;
	padding-right: 1.25rem;
}

.py-24 {
	padding-top: 6rem;
	padding-bottom: 6rem;
}

.background-gradient {
	background: radial-gradient(125% 125% at 50% 10%, #000 40%, #eeb833 100%);
}
</style>
<body>
	<div
		class="absolute inset-0 -z-10 h-full w-full items-center px-5 py-24 background-gradient"></div>
	<div class="login-container">
		<div>
			<h1>Bienvenido de Nuevo!</h1>
			<p>Por favor ingrese sus datos</p>
			<form>
				<div class="d-flex flex-wrap align-items-center gap-2 flex-column mb-4">
					<input class="input-inicio" type="text" placeholder="Username" required> 
					<input class="input-inicio" type="password" placeholder="Contraseña" required>
				</div>
				<button class="btn-inicio" type="submit">Iniciar Sesion</button>
			</form>
		</div>
	</div>
</body>
</html>