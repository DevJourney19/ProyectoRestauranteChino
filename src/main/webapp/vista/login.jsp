<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<link href="https://cdn.lineicons.com/4.0/lineicons.css"
	rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>Admin | Login</title>
</head>
<body>
	<div class="container">
        <div class="login-box">
            <h1 class="titulo">Bienvenido!</h1>
            <p>Completa tus credenciales para ingresar al panel administrativo de tu restaurante.</p>

            <form>
                <label for="usuario">Usuario</label><br>
                <input type="text" id="usuario" placeholder="MO001"><br>

                <label for="password">Contraseña</label>
                <div class="password-box">
                    <input type="password" id="password" placeholder="A12345">
                </div>                

                <button type="submit" class="login-btn">INICIAR SESIÓN</button>
                <a href="#" class="forgot-password">¿Olvidaste tu contraseña?</a>
            </form>
        </div>

        <div class="image-box">
            <img src="../img/login.jpg" alt="Food">
        </div>
    </div>
</body>
</html>
