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
<title>Insert title here</title>
</head>
<body>
	<div class="detalle_pedido_div">Menu</div>
	<div class="table-responsive">
		<table
			class="table w-100 
				 table-bordered table-hover fs-2 text-center">
			<thead>
				<tr class="table-dark">
					<th>ID_PEDIDO</th>
					<th>Mesa</th>
					<th>Fecha</th>
					<th>Estado de pago</th>
					<th>Total</th>
					<th colspan="3">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>

				</tr>
				<tr>


				</tr>
				<tr>


				</tr>
			</tbody>
		</table>
	</div>
	<div class="container py-5">
		<div class="row row-cols-1 row-cols-md-3 g-4 py-5">
			<div class="col">
				<div class="shadow-lg bg-white rounded card p-5 ">
					<img src="../img/arroz_chaufa.png" class="card-img-top"
						alt="chaufa">
					<div class="card-body">
						<h1 class="card-title text-center mb-4">
							<b>Arroz Chaufa</b>
						</h1>
						<div class="d-flex justify-content-evenly mb-5">
							<h3 class="mt-4 fs-1">
								<b>S/. 18</b>
							</h3>

							<div class="d-flex flex-column">
								<i class="fas fa-chevron-up fa-2x"></i>
								<div class="circulito">
									<i class="fa-solid fa-circle fa-2x" style="color: #ffd73b;"></i><span
										class="number">&nbsp;1</span>
								</div>
								<i class="fa-solid fa-angle-down fa-2x"></i>
							</div>
						</div>
						<a href="#" class="d-flex justify-content-center btn btn-primary py-3">Agregar</a>

					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Comentario -->
<!-- 	<div class="card" style="width: 18rem;"> -->
<!-- 		<img src="..." class="card-img-top" alt="..."> -->
<!-- 		<div class="card-body"> -->
<!-- 			<h5 class="card-title">Card title</h5> -->
<!-- 			<p class="card-text">Some quick example text to build on the card -->
<!-- 				title and make up the bulk of the card's content.</p> -->
<!-- 			<a href="#" class="btn btn-primary">Go somewhere</a> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<script src="https://kit.fontawesome.com/c353473263.js"
		crossorigin="anonymous"></script>
</body>
</html>