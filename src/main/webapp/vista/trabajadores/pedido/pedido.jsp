<%@page import="modelo.DetallePedido"%>
<%@page import="modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Mesa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>PEDIDO - MOZO</title>
<%@include file="../fragmentos/head.jsp"%>
<link
	href="${pageContext.request.contextPath}/vista/trabajadores/pedido/pedido.css"
	rel="stylesheet" />

</head>

<body class="body">
	<%
	List<Pedido> listaPedido = (List<Pedido>) request.getAttribute("listaPedido");
	List<DetallePedido> listaDetallePedido = (List<DetallePedido>) request.getAttribute("listaDetallePedido");
	%>
	<div class="d-flex">
		<%@ include file="../fragmentos/sidebar.jsp"%>
		<div class="main">
			<%@ include file="../fragmentos/nav.jsp"%>
			<main class="container">
				<h1 class="text-center pt-4 pb-2">PEDIDOS REALIZADOS - 已下订单</h1>
				<div
					class="d-flex justify-content-center justify-content-md-end 
	align-items-center pb-2 pb-md-4">
					<button
						class="aniadir_pedido fs-5 d-flex align-items-center gap-2 btn btn-warning"
						data-bs-toggle="modal" data-bs-target="#modalEdit"
						id="botoncito_modal_mesas">
						<img
							src="${pageContext.request.contextPath}/vista/img/boton-mas.png"
							style="width: 20px; height: 20px"> <span>Añadir
							Pedido</span>
					</button>
				</div>

				<div
					class="row row-cols-1 row-cols-xl-4 gap-4 justify-content-center overflow-auto mb-4">
					<%
					if (listaPedido != null) {
						for (Pedido pedido : listaPedido) {
					%>

					<div class="col p-3 border rounded bg-white"
						style="width: 320px; position: relative; height: fit-content;">
						<div class="mesa_numero">
							M<%=pedido.getMesa().getN_mesa()%></div>
						<div
							style="position: absolute; top: 20px; left: 62px; font-size: 1rem">Cliente</div>
						<div class="completado">
							<i class="fa-solid fa-square-check" style="color: #000000;"></i>
							<%=pedido.getEstado()%>
						</div>
						<div class="pedido_especifico_numero_pedido">
							Pedido #000000<%=pedido.getId()%></div>
						<div class="d-flex justify-content-between mt-2"
							style="font-size: 0.7rem">
							<div><%=pedido.getCreated_at()%></div>
						</div>
						<hr />
						<div class="table-responsive"
							style="overflow-y: scroll; height: 200px;">
							<table class="table text-center" style="border: transparent;">
								<thead>
									<tr style="font-size: 0.8rem">
										<th>Producto</th>
										<th>Cantidad</th>
										<th>Subtotal</th>
									</tr>
								</thead>
								<tbody>
									<%
									if (listaDetallePedido != null) {
										for (DetallePedido dp : listaDetallePedido) {
									%>
									<tr style="font-size: 0.8rem">
										<th><%=dp.getMenu().getNombre()%></th>
										<th><%=dp.getCantidad()%></th>
										<th><%=dp.getMenu().getPrecio()%></th>
									</tr>
									<%
									}
									}
									%>

								</tbody>
							</table>
							<hr />

						</div>
						<div>
							<div class="d-flex justify-content-between mb-3"
								style="font-size: 0.8rem; font-weight: 600">
								<div>Total</div>
								<div><%=pedido.getTotal()%></div>
							</div>
							<div class="d-flex justify-content-evenly">
								<form action="#" method="post">
									<button class="btn btn-danger">Eliminar</button>
								</form>
								<form action="../detalle_pedido/detalle_pedido.jsp"
									method="post">
									<button class="btn btn-warning">Detalles</button>
								</form>

								<form action="../pagar/pagar.jsp" method="post">
									<button class="btn btn-success">Pagar</button>
								</form>
							</div>
						</div>
					</div>
					<%
					}
					} else {
					out.print("No se encuentran pedidos realizados");
					}
					%>

				</div>
			</main>
		</div>
	</div>
	<!-- Modal con añadir pedido segun mesa ocupadas actual y luego pasar a detalle_pedido-->
	<div class="modal fade" id="modalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog-centered modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
						Elegir la Mesa</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<!-- TIENE QUE LLEVARTE AL CONTROLADOR PARA CAMBIAR EL ESTADO DE LA MESA Y DE AHÍ TE TIENE QUE LLEVAR PARA SELECCIONAR EL PLATILLO (DETALLE DE PEDIDO) -->
					<form action="${pageContext.request.contextPath}/MesaMozoProceso"
						class="needs-validation" novalidate>

						<div class="d-flex justify-content-center flex-wrap"
							id="eleccion_mesas"></div>


						<div class="modal-footer">
							<button type="button" class="btn btn-danger"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-warning">Agregar
								Detalles</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/c353473263.js"></script>
	<script type="text/javascript">

	document.addEventListener("DOMContentLoaded", function() {
		const contextPath = "${pageContext.request.contextPath}";
		console.log(contextPath);
	const url=contextPath+"/MoMostrarMesa";
	
		    let botoncito_modal_mesa = document.getElementById("botoncito_modal_mesas");
		    
		    botoncito_modal_mesa.addEventListener("click", async function() {
		        console.log("BOTONCITOOOOO");
		        try {
		    		let response = await fetch(url);
		    		let data = await response.json();
		    		if (data.error) {
		    			console.log("Error");
		    		} else {
		    			console.log("Fue un exito");
		    			let mesas = data.mesas; //Accedemos a la lista de mesas
		    			let bloque = document.getElementById("eleccion_mesas");
		    			console.log(bloque); 
		    			bloque.innerHTML = "";

		    			// Iteramos sobre las mesas y las mostramos
		    			mesas.forEach(mesa => {
		    				console.log(mesa);
		    				// Crear un div para cada mesa con la clase "box_mesa"
		    				let mesaElemento = document.createElement("div");
		    				mesaElemento.classList.add("box_mesa");

		    				// Crear el contenido del label con la imagen y el nombre de la mesa
		    				mesaElemento.innerHTML = 
    												'<label class="img_mesa" for="mesa' + mesa.id + '">'+
        											'<img src="/ProyectoRestauranteChino/vista/img/mesa.png" />' +
	        										'<span>' + mesa.nombre + '</span>' +
	   												 '</label>' +
    												'<input type="radio" id="mesa' + mesa.id + '" value="' + mesa.id + '" name="mesa" data-target="' + mesa.id + '" />';


		    				// Añadir el nuevo div de la mesa al bloque
		    				bloque.appendChild(mesaElemento);
		    			});

		    		}
		    	} catch (error) {
		    		console.log("Error detectado en el fetch MoMostrarMesa: " + error);
		    	}
		    });
		
	});

	</script>
</body>
</html>