<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../fragmentos/sidebar.css">
<link rel="stylesheet" href="mesas.css">
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
<title>Gestion de Mesas</title>
</head>
<body>
	<div class="d-flex flex-row">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<nav class="navbar navbar-expand d-flex align-items-center">
				<button class="toggler-btn" type="button">
					<i class="lni lni-text-align-left"></i>
				</button>
				<div class="navbar-logo collapsed" id="logo">
					<a href="#">Noche en Pekín 北京之夜</a>
				</div>
			</nav>
			<main class="p-3">
				<div class="container-fluid">
					<div class="mx-5 mb-3">
						<div
							class=" text-center d-flex align-items-center justify-content-between">
							<h1>Gestion de Mesas</h1>
							<span class="fs-3">200 mesas</span>
						</div>
						<div>
							<button>
								Filtrar <svg width="37" height="22" viewBox="0 0 37 22" fill="none" xmlns="http://www.w3.org/2000/svg">
<path d="M34.5312 4.125H2.46875C1.99633 4.125 1.54327 3.92746 1.20922 3.57583C0.875167 3.22419 0.6875 2.74728 0.6875 2.25C0.6875 1.75272 0.875167 1.27581 1.20922 0.924175C1.54327 0.572544 1.99633 0.375 2.46875 0.375H34.5312C35.0037 0.375 35.4567 0.572544 35.7908 0.924175C36.1248 1.27581 36.3125 1.75272 36.3125 2.25C36.3125 2.74728 36.1248 3.22419 35.7908 3.57583C35.4567 3.92746 35.0037 4.125 34.5312 4.125ZM28.5938 12.875H8.40625C7.93383 12.875 7.48076 12.6775 7.14672 12.3258C6.81267 11.9742 6.625 11.4973 6.625 11C6.625 10.5027 6.81267 10.0258 7.14672 9.67417C7.48076 9.32254 7.93383 9.125 8.40625 9.125H28.5938C29.0662 9.125 29.5192 9.32254 29.8533 9.67417C30.1873 10.0258 30.375 10.5027 30.375 11C30.375 11.4973 30.1873 11.9742 29.8533 12.3258C29.5192 12.6775 29.0662 12.875 28.5938 12.875ZM21.4688 21.625H15.5312C15.0588 21.625 14.6058 21.4275 14.2717 21.0758C13.9377 20.7242 13.75 20.2473 13.75 19.75C13.75 19.2527 13.9377 18.7758 14.2717 18.4242C14.6058 18.0725 15.0588 17.875 15.5312 17.875H21.4688C21.9412 17.875 22.3942 18.0725 22.7283 18.4242C23.0623 18.7758 23.25 19.2527 23.25 19.75C23.25 20.2473 23.0623 20.7242 22.7283 21.0758C22.3942 21.4275 21.9412 21.625 21.4688 21.625Z" fill="#D51818"/>
</svg>
								
							</button>
							<button>
								Nueva Mesa <i class="lni lni-plus"></i>
							</button>
						</div>
					</div>

					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>N&ordm; Salon</th>
									<th>N&ordm; Mesa</th>
									<th>Estado</th>
									<th>Fecha Creacion</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td class="estado-libre">Libre</td>
									<td><%=new Date()%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<form action="">
												<button class="icon-action">
													<i class="lni lni-trash-can fs-4"></i>
												</button>
											</form>
											<form action="">
												<button class="icon-action">
													<i class="lni lni-pencil fs-4"></i>
												</button>
											</form>
										</div>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>2</td>
									<td class="estado-ocupado">Ocupado</td>
									<td><%=new Date()%></td>
									<td>
										<div
											class="d-flex align-item-center justify-content-center gap-3">
											<form action="">
												<button class="icon-action">
													<i class="lni lni-trash-can fs-4"></i>
												</button>
											</form>
											<form action="">
												<button class="icon-action">
													<i class="lni lni-pencil fs-4"></i>
												</button>
											</form>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="../fragmentos/sidebar.js"></script>
	<script src="mesas.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>