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
<%
/*
HttpSession sessionMesas = request.getSession(false);
List<Mesa> listaMesitas = null;
if (sessionMesas != null) {
	try {
		// Intentamos obtener el atributo
		System.out.println("Si existe la session ------------");

		Object listaMesas = sessionMesas.getAttribute("listaMesas");
		System.out.println("Objeto listaMesas ------------");
		if (listaMesas != null && listaMesas instanceof List) {
	listaMesitas = (List<Mesa>) listaMesas;

	// Aquí puedes usar la listaMesitas
	for (Mesa mesa : listaMesitas) {
		System.out.println("Mesa: " + mesa.getN_mesa() + "<br>");
	}

		} else {
	// Aquí puedes manejar el caso en que el atributo no es una lista, tal vez loguear un error
	System.out.println("Se crea el array y chau");
	listaMesitas = new ArrayList<>(); // O manejarlo de alguna forma predeterminada
		}
	} catch (Exception e) {
		System.out.println("Error en obtener la lista de mesas!! : " + e.getMessage());
	}
	//CORREGIR
} else {
	// Si no hay sesión activa
	out.println("No hay sesión activa.");
}*/
%>
<body class="body">
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
					<%@include file="../fragmentos/pedido_realizado.jsp"%>
					<%@include file="../fragmentos/pedido_realizado.jsp"%>

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
		    		//let contextPath = "${pageContext.request.contextPath}";
		    		let response = await fetch(url);
		    		//console.log("Respuesta del servidor:", await response.text()); // Ver qué está devolviendo el servidor

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
    '<label class="img_mesa" for="mesa' + mesa.id + '">' +
        '<p>Buenas noches</p>' +
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