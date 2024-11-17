<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Menu"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../fragmentos/head.jsp"%>
<link
	href="${pageContext.request.contextPath}/vista/trabajadores/detalle_pedido/detalle_pedido.css"
	rel="stylesheet">
<title>Detalle Pedido</title>
</head>
<body>
	<!-- Obtener todos los platillos para mostrarlo -->
	<%
	List<Menu> listaMenu = (List<Menu>) request.getAttribute("listaMenu");
	%>
	<div class="d-flex ">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>

			<main>
				<div class="container detalle_pedido_div"></div>
				<button onclick="myFunction()"
					class=" d-flex justify-content-center mx-auto btn btn-warning my-3 boton_deta_pedi">Mostrar
					resumen de pedido</button>
				<div
					class="d-flex flex-column combinado_tabla_y_productos justify-content-center mx-4">
					<!-- Inicio TABLA Y CARDS -->
					<div
						class="container d-flex flex-column flex-wrap mt-4 bg-white tabla_detalle_pedidos"
						style="border: 1px solid lightgray; border-radius: 10px;"
						id="tabla_detalle_pedidos">
						<div class="p-3 fs-3">
							<b>Resumen de Pedido</b> <br />#0000001
						</div>

						<hr />
						<div>
							<div class=" fs-5" style="display: inline; font-weight: 600">Total
								de objetos (6)</div>
							<div style="height: 300px; overflow: scroll;">

								<div
									class="d-flex p-2 m-2 align-items-center justify-content-between"
									style="border: 1px solid lightgray; border-radius: 10px; gap: 16px;">
									<div
										class="d-flex gap-2 align-items-center justify-content-center">
										<img src="../../img/arroz_chaufa.png" style="width: 60px"
											alt="img">
										<h6 class="mx-2 " style="font-weight: 600">
											Arroz Chaufa<br /> (S/. 18) x2
										</h6>
									</div>
									<i class="fas fa-solid fa-trash fa-xl mx-2 icono_eliminar"
										style="color: red;"></i>
								</div>
							</div>
						</div>
						<!-- Resumen de pago -->
						<div class="p-2">
							<div class="d-flex p-2 m-2 flex-column fs-5"
								style="border: 1px solid lightgray; border-radius: 10px; font-weight: 600">

								<div>Resumen de pago</div>
								<div class="d-flex justify-content-between ">
									<div>Importe:</div>
									<div>S/. 54.00</div>
								</div>
								<div class="d-flex justify-content-between ">
									<div>Impuestos:</div>
									<div>S/. 9.80</div>
								</div>
								<div class="d-flex justify-content-between"
									style="color: #ac0000; font-size: 800;">
									<div>Total:</div>
									<div>S/. 63.80</div>
								</div>

								<hr />
								<!-- UN MODAL QUE PREGUNTE SI DESEA IMPRIMIR LA BOLETA CON LOS RESULTADOS, SI SI ENTONCES AHI RECIEN SE REGISTRA EL DETALLE DE PEDIDO Y SE CREA UNA BOLETA -->
								<button type="button" onclick="realizarPago()"
									class="btn mx-auto text-white" style="background: #ac0000">Realizar
									pedido</button>
							</div>
						</div>

						<!-- FIN DE UNIÓN DIVS BUSQUEDA Y CARD_PRODUCTS -->
					</div>
					<div class="d-flex justify-content-center">

						<!-- INICIO UNION DIVS BUSQUEDA Y CARD_PRODUCTS -->
						<div>
							<!-- Inicio BUSQUEDA -->
							<div class="py-4 px-xl-5">
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
									class="row row-cols-1 row-cols-md-2 row-cols-lg-2 row-cols-xxl-3 g-4 py-2 px-xl-5 overflow-auto"
									style="margin: auto">
									<!-- inicio card 1 -->
									<%
									for (Menu lm : listaMenu) {
									%>
									<div class="col">
										<div class="shadow-sm card card_plato "
											style="border: 2px solid #FFD700; width: 300px; height: 350px; border-radius: 15px">
											<!-- Formato para poder utilizar las imágenes tipo base 64 -->
											<img
												src="data:<%=lm.getTipoImagen()%>;base64, <%=lm.getImagen()%>"
												style="width: 200px" class="mx-auto card-img-top"
												alt="<%=lm.getNombre()%>">
											<div class="contador_suma_resta" id="contador_suma_resta"></div>
											<div class="card-body ">
												<h1 class="card-title text-center mb-3"><%=lm.getNombre()%></h1>
												<div
													class="d-flex justify-content-center align-items-center mb-4 gap-4 gap-md-5">
													<h2 class="fw-bolder">
														S/.
														<%=lm.getPrecio()%></h2>

													<div
														class="d-flex justify-content-center align-items-center px-2 rounded-pill"
														style="background: lightgray; gap: 10px; height: 35px;">

														<!-- inicio del circulo -->
														<i class="fa-solid fa-circle fa-2x circulito_card"
															data-target="contador_suma_resta"
															style="color: #fafafa; position: relative"> <i
															class="fa-solid fa-minus fa-2xs"
															style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
														</i>
														<!-- fin del circulo -->
														<div>1</div>
														<i class="fa-solid fa-circle fa-2x circulito_card"
															style="color: #fafafa; position: relative"> <i
															class="fa-solid fa-plus fa-2xs"
															style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>
														</i>
													</div>
												</div>
												<input type="hidden" class="product-id" name="id_input"
													value="<%=lm.getId()%>">
												<button type="submit"
													class="d-flex justify-content-center estilo_btn_1 agregar_btn">Agregar</button>
											</div>
										</div>
									</div>
									<%
									}
									%>
									<!-- Fin CARD PRODUCTO -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<!-- Fin TABLA Y CARDS -->
	<script
		src="${pageContext.request.contextPath}/vista/trabajadores/detalle_pedido/detalle_pedido.js"
		type="text/javascript"></script>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
	<script>
		
	</script>
</body>
</html>