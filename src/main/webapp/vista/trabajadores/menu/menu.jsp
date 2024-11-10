<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MENU</title>
<%@include file="../fragmentos/head.jsp"%>
<link href="./vista/trabajadores/menu/menu.css" rel="stylesheet" />
</head>
<body>

	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<div class="titulo_mesas p-3">
				<h1 class="text-center">MENU - 菜单</h1>
				<main>
					<section class="entradas">
						<h2>Entradas</h2>
						<div class="card_menu d-flex gap-4 align-item-center justify-content-between">
							<div class="description">
								<h3 class="fs-4">Rollitos Primavera</h3>
								<p>Crujientes rollos rellenos de verduras frescas, servidos
									con salsa agridulce.</p>
							</div>
							<span class="fs-2 fw-bolder">S/12.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Wantán Frito</h3>
								<p>Masa rellena de carne y verduras, frita hasta dorarse y
									servida con salsa de soya.</p>
							</div>
							<span>S/ 10.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Sopa Wonton</h3>
								<p>Caldo ligero con wontones rellenos de carne, ideal para
									comenzar la comida.</p>
							</div>
							<span>S/14.00</span>
						</div>
					</section>
					<section class="principal">
						<h2>Platos Principales</h2>
						<div class="card_menu">
							<div class="description">
								<h3>Pollo Kung Pao</h3>
								<p>Trozos de pollo salteados con cacahuates y verduras en una salsa picante.</p>
							</div>
							<span>S/24.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Pato Laqueado</h3>
								<p>Pato crujiente servido con crepas finas, cebolla y salsa hoisin.</p>
							</div>
							<span>S/35.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Arroz Frito Yangzhou</h3>
								<p>Arroz salteado con mariscos, jamón y verduras frescas.</p>
							</div>
							<span>S/18.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/25.90</span>
						</div>
					</section>
					<section class="arroz">
						<h2>Arroz y Fideos</h2>
						<div class="card_menu">
							<div class="description">
								<h3>Fideos Chinos Salteados</h3>
								<p>Fideos finos salteados con carne y vegetales al gusto.</p>
							</div>
							<span>S/20.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Arroz Blanco al Vapor</h3>
								<p>Arroz cocido al vapor, ideal como acompañante para cualquier plato.</p>
							</div>
							<span>S/ 5.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Tallarín Chino</h3>
								<p>Fideos gruesos salteados con pollo y salsa especial.</p>
							</div>
							<span>S/ 21.00</span>
						</div>
					</section>
					<section class="sopas">
						<h2>Sopas</h2>
						<div class="card_menu">
							<div class="description">
								<h3>Sopa Picante de Tofu</h3>
								<p>Caldo picante con tofu suave, setas y vegetales variados.</p>
							</div>
							<span>S/ 15.00</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
					</section>
					<section class="postres">
						<h2>Postres</h2>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
					</section>
					<section class="bebidas">
						<h2>Bebidas</h2>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
						<div class="card_menu">
							<div class="description">
								<h3>Cerdo agridulce</h3>
								<p>Cerdo tierno en una salsa agridulce con piña y pimientos.</p>
							</div>
							<span>S/ 25.90</span>
						</div>
					</section>
				</main>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
</body>
</html>
