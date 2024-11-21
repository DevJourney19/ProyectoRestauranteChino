let suma = 0;
let sumaImporte = 0;
let tamanio_menu = [];

let cantidad_producto = 0;
//let cantidad_productito = 1;

//Cuando se presione en el circulito color gris para aumentar o disminuir la cantidad del producto


//===================================================================

//Funcion para el toggle
let elemento = document.getElementById("tabla_detalle_pedidos");
elemento.classList.add("toggle_tabla_detalle_pedidos_nada");
function myFunction() {
	if (elemento) {
		elemento.classList.toggle("toggle_tabla_detalle_pedidos");
	}
}

const agregar_btn = document.querySelectorAll(".agregar_btn");

//CUANDO SE DE CLIC EN EL BOTON AGREGAR -> LLEVARÁ AL PANEL DONDE SE MOSTRARAN LOS PRODUCTOS A COMPRAR
agregar_btn.forEach(t => t.addEventListener("click", async function(event) {
	event.preventDefault();
	//Swal.fire("Producto agregado");
	Swal.fire("Producto agregado correctamente", "", "success");

	//Se detecta la clase col, en la que se seleccionó el botón
	const productContainer = t.closest(".col");

	//Obtener el id del producto
	const idInput = productContainer.querySelector(".product-id").value;
	if (!idInput) {
		console.error("ID del producto no encontrado");
		return;
	}

	//Relizar la solicitud asincrónica con fetch
	try {

		let response = await fetch("MoAgregarDetaPedi", {
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
			},
			body: `id_input=${idInput}`
		});

		if (!response.ok) {
			throw new Error('Error al agregar el producto');
		}

		let data = await response.json();
		if (data.error) {
			Swal.fire("Error", data.error, "error");
		} else {
			//Agregamos los detalles de pedido para mostrar la cantidad de platillos 
			let menu = data.menuJSON;

			agregarProducto(menu);

		}

	} catch (error) {
		console.error("Hubo un problema con la solicitud:", error);
		Swal.fire("Hubo un problema al agregar el producto", error.message, "error");
	}

}));



const agregarProducto = (menu) => {
	cantidad_producto++;
	let productoEncontrado = false;
	//Verificar que no se agreguen platillos duplicados
	//console.log(tamanio_menu[0]);
	console.log("====================");
	console.log("Tamanio menu length: " + tamanio_menu.length);
	console.log(tamanio_menu);
	console.log("====================");
	for (let i = 0; i < tamanio_menu.length; i++) {
		if (menu.nombre === tamanio_menu[i]) {
			console.log(menu.nombre);
			console.log("Se encontró el mismo platillo");
			productoEncontrado = true;

			let producto_valor_dom = document.querySelector("[data-name='" + menu.nombre + "']");
			console.log(producto_valor_dom);
			if (producto_valor_dom) {
				console.log("Se encontró el DOM	");
				producto_valor_dom.querySelector("#numerito_de_cantidad").textContent = "(" + cantidad_producto + ")";
			}
			break;
		}
	}

	//let cantidaProductos = data.cantidadProductosJSON;
	//console.log(detallePedido.getIdMenu());

	//Head
	tamanio_menu.push(menu.nombre);

	let total_objetos = document.getElementById("total_objetos");
	total_objetos.innerHTML = 'Total de platillos (' + cantidad_producto + ') ';

	//Body
	//Si el producto no se encuentra duplicado
	if (!productoEncontrado) {
		let ubicacion = document.getElementById("resumen_pedido_platos");

		ubicacion.innerHTML += "";

		ubicacion.innerHTML += '<div class="d-flex p-2 m-2 align-items-center justify-content-between"' +
			'style = "border:1px solid lightgray; border-radius: 10px; gap:6px;" data-name="' + menu.nombre + '" > ' +
			'<div class="d-flex gap-2 align-items-center justify-content-center">' +
			'<img src="data:' + menu.tipo_imagen + ';base64,' + menu.archivo_imagen + '" style="width: 60px" alt="' + menu.nombre + '">' +
			'<h6 class="mx-2 cant_platillo" style="font-weight: 600">' + menu.nombre + '</h6></div>' +

			'<div class="d-flex justify-content-center align-items-center px-2 rounded-pill" ' +
			'style="gap:6px; height:35px;">' +
			'<i class="fa-solid fa-circle fa-2x circulito_card" style="color: #f9f9f9; position: relative"><i ' +
			'data-target="contador_resta" class="fa-solid fa-minus fa-2xs" style="color: #000000; position: absolute; bottom: 14px; left: 8px">' +
			'</i></i><div id="numerito_de_cantidad">' + cantidad_producto + '</div><i class="fa-solid fa-circle fa-2x circulito_card"' +
			'style="color: #fafafa; position: relative"><i data-target="contador_suma" class="fa-solid fa-plus fa-2xs"' +
			'style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i></i></div>' +
			'<i class="fas fa-solid fa-trash fa-xl mx-2 icono_eliminar" style="color:red;"></i></div>';
		//-------------------------------------------------

		separar_accion_de_los_circulos(menu, ubicacion);

		//--------------------------------------------
	}
	//Footer
	agregando_foot(menu);
}

function separar_accion_de_los_circulos(menu, ubicacion) {
	let ir_pagar = false;
	let separar_accion = document.querySelectorAll(".circulito_card");

	separar_accion.forEach(e => (e.addEventListener("click", function(event) {
		//console.log(event.target);
		console.log(tamanio_menu);
		let data_target = event.target.getAttribute("data-target");

		if (data_target === "contador_suma") {
			//console.log("Es suma");
			cantidad_producto++;
			agregando_foot(menu);
		} else if (data_target === "contador_resta") {
			cantidad_producto--;
			if (cantidad_producto === 0) {
				alert("El platillo se agotó");
				ubicacion.innerHTML = "";
				//console.log("La cantidad del producto es 0");

				//Devuelve el indice del primer valor que coincide de la lista

				console.log("Antes: " + tamanio_menu);
				//Eliminar todo el registro del producto agregado
				for (let i = tamanio_menu.length-1; i >= 0; i--) {
					if (menu.nombre === tamanio_menu[i]) {
						tamanio_menu.splice(i, 1);
					}
				}

				ir_pagar = true;

				console.log("Despues: " + tamanio_menu);
				total_objetos.innerHTML = 'Total de platillos (' + cantidad_producto + ') ';

				//let indice = tamanio_menu.indexOf(menu.nombre);
				//console.log("EL INDICE ES: " + indice);
				/*if (indice !== -1) { // -1 significa que el indexOf no encontró ningun indice
					tamanio_menu.splice(indice, 1); //Eliminar unicamente el valor encontrado	
				}*/

			}
			restando_foot(menu);
			//console.log("Es resta");
		}

		//Esto pasa cuando se realiza la editación por medio de los botones de suma o resta

		total_objetos.innerHTML = 'Total de platillos (' + cantidad_producto + ') ';
		if (!ir_pagar) {
			let mostrar_numero = document.getElementById("numerito_de_cantidad");
			mostrar_numero.innerHTML = cantidad_producto;
		}

	})));
}

function agregando_foot(menu) {
	let importe = document.getElementById("importe");
	let impuestos = document.getElementById("impuestos");
	let total = document.getElementById("total");
	//Hacemos la operación por separado
	console.log("La cantidad obtenida es: " + cantidad_producto);
	console.log(menu.precio);
	sumaImporte = parseFloat(sumaImporte) + (parseFloat(menu.precio)); //0 + 12 = 12 ||| //12+12 = 24
	//Mostramos el valor obtenido de la operación
	importe.innerHTML = 'S/. ' + Math.round(sumaImporte * 100) / 100;

	//Hacemos la operación para obtener el valor de los impuestos
	let sumaImpuestos = sumaImporte * 0.18; //2.16 ||| //4.32
	//Mostramos el valor de los impuestos en total
	impuestos.innerHTML = 'S/. ' + Math.round(sumaImpuestos * 100) / 100;

	//Realizamos la suma para el total
	suma = parseFloat(sumaImporte) + parseFloat(sumaImpuestos); //14.16 ||| //28.32
	//Mostramos el valor total
	total.innerHTML = 'S/. ' + Math.round(suma * 100) / 100;
}

function restando_foot(menu) {
	let importe = document.getElementById("importe");
	let impuestos = document.getElementById("impuestos");
	let total = document.getElementById("total");
	//Hacemos la operación por separado
	console.log("La cantidad obtenida es: " + cantidad_producto);
	console.log(menu.precio);
	sumaImporte = parseFloat(sumaImporte) - (parseFloat(menu.precio));
	//Mostramos el valor obtenido de la operación
	importe.innerHTML = 'S/. ' + Math.round(sumaImporte * 100) / 100;

	//Hacemos la operación para obtener el valor de los impuestos
	let sumaImpuestos = sumaImporte * 0.18;
	//Mostramos el valor de los impuestos en total
	impuestos.innerHTML = 'S/. ' + Math.round(sumaImpuestos * 100) / 100;

	//Realizamos la suma para el total
	suma = parseFloat(sumaImporte) + parseFloat(sumaImpuestos);
	//Mostramos el valor total
	total.innerHTML = 'S/. ' + Math.round(suma * 100) / 100;
}


let icono_eliminar = document.querySelectorAll(".icono_eliminar");
//NOTIFICACION ANIMADA
icono_eliminar.forEach(t => {
	t.addEventListener("click", function() {
		const swalWithBootstrapButtons = Swal.mixin({
			customClass: {
				confirmButton: "btn btn-success",
				cancelButton: "btn btn-danger"
			},
			buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
			title: "¿Deseas eliminar el producto?",
			text: "You won't be able to revert this!",
			icon: "warning",
			showCancelButton: true,
			confirmButtonText: "Sí, eliminar",
			cancelButtonText: "No, cancelar",
			reverseButtons: true
		}).then((result) => {
			if (result.isConfirmed) {
				swalWithBootstrapButtons.fire({
					title: "Producto eliminado con éxito!",
					icon: "success"
				});
			} else if (
				/* Read more about handling dismissals below */
				result.dismiss === Swal.DismissReason.cancel
			) {
				swalWithBootstrapButtons.fire({
					title: "Cancelado",
					text: "Tu producto no ha sido eliminado",
					icon: "error"
				});
			}
		});
	})
})
//FIN DE NOTIFICACION ANIMADA

const realizarPago = () => {

}