let sumaImporteEimpuestos = 0;
let sumaImporte = 0;
let tamanio_menu = [];
let cantidad_producto = 0;
let quantity = 0;
let cantidadesPorProducto = {};

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

	//Se ubica en la clase col, por medio del clic al botón
	const productContainer = t.closest(".col");

	//Se obtendrá el id del producto o platillo (menu) del boton seleccionado
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
//Muchos de los problemas con menu, es que seleccionaba el último valor, 
//para ello se hicieron sumas de ese objeto para obtener la cantidad total, 
//ademas que se hizo la logica para detectar en nombre del div donde se encuentra 
//ubicado el boton a seleccionar por medio de closest
const agregarProducto = (menu) => {

	//Vamos a agregar la cantidad dependiendo de un producto

	if (!cantidadesPorProducto[menu.nombre]) {
		cantidadesPorProducto[menu.nombre] = 0;
	}

	cantidadesPorProducto[menu.nombre]++;
	console.log(cantidadesPorProducto);
	let productoEncontrado = false;

	//Verificar que no se agreguen platillos duplicados
	for (let i = 0; i < tamanio_menu.length; i++) {
		if (menu.nombre === tamanio_menu[i]) {
			//Esta variable influye para ya no crear un nuevo registro "visible" en el bloque de selección
			productoEncontrado = true;

			let producto_valor_dom = document.querySelector("[data-nombre='" + menu.nombre + "']");
			if (producto_valor_dom) {
				//let precio_producto = producto_valor_dom.querySelector("[data-precio]");

				//precio_producto.setAttribute("data-precio", menu.precio);

				let cantidadDiv = producto_valor_dom.querySelector("[data-cantidad]");

				//let cantidadActual = parseInt(cantidadDiv.textContent, 10) + 1;
				cantidadDiv.textContent = cantidadesPorProducto[menu.nombre];
				cantidadDiv.setAttribute("data-cantidad", cantidadesPorProducto[menu.nombre]);
				//cantidadesPorProducto[menu.nombre] = cantidadActual;
				let precioDiv = producto_valor_dom.querySelector("[data-precio]");
				if (precioDiv) {
					//precioDiv.textContent = menu.precio;
					precioDiv.setAttribute("data-precio", menu.precio);
				}
			}
			break; 
		}
	}

	//Head
	if (!tamanio_menu.includes(menu.nombre)) {
		tamanio_menu.push(menu.nombre);
	}

	let totalCantidad = Object.values(cantidadesPorProducto).reduce((a, b) => a + b, 0);
	let total_objetos = document.getElementById("total_objetos");
	total_objetos.innerHTML = 'Total de platillos (' + totalCantidad + ') ';

	//Body
	//Si el producto es unico
	if (!productoEncontrado) {
		let ubicacion = document.getElementById("resumen_pedido_platos");

		ubicacion.innerHTML += "";
		//-------------------------------------------------

		ubicacion.innerHTML += crearBloque(menu, cantidadesPorProducto);

		//-------------------------------------------------

		separar_accion_de_los_circulos(menu);

		//-------------------------------------------------
	}
	//Footer
	agregando_foot(menu.precio);
}

function separar_accion_de_los_circulos() {
	let ir_pagar = false;
	let circuloMasOMenos = document.querySelectorAll(".circulito_card");
	let total_objetos = document.getElementById("total_objetos");

	circuloMasOMenos.forEach(e => (e.addEventListener("click", function(event) {
		let menuName = e.getAttribute("data-menu");

		let data_target = event.target.getAttribute("data-target");
		let productoDOM = e.closest("[data-nombre='" + menuName + "']"); //Lee el nombre del platillo que se ingresó
		//Busca el elemento (div entero)
		let cantidad_div = productoDOM.querySelector("[data-cantidad]");
		//Obtiene el valor del elemento (data-cantidad)
		let cantidad_actual = parseInt(cantidad_div.textContent, 10);
		let precio_producto = Math.round(parseFloat(e.getAttribute("data-precio")) * 100) / 100;
		console.log("El precio_producto es: " + precio_producto);

		if (data_target === "contador_suma") {
			cantidad_actual++;
			//Actualizamos el valor del atributo especifico
			cantidadesPorProducto[menuName] = cantidad_actual;
			agregando_foot(precio_producto);

		} else if (data_target === "contador_resta") {

			if (cantidad_actual === 1) {
				alert("El platillo se agotó");
				productoDOM.remove(); //Elimina el bloque del DOM
				delete cantidadesPorProducto[menuName];

				//Eliminar todo el registro del producto agregado
				for (let i = tamanio_menu.length - 1; i >= 0; i--) {
					if (menuName === tamanio_menu[i]) {
						tamanio_menu.splice(i, 1);
					}
					console.log(tamanio_menu);
				}

				//cantidad_producto = 0;
				ir_pagar = true;
				restando_foot(precio_producto);
				//total_objetos.innerHTML = 'Total de platillos (' + cantidad_producto + ') ';
			} else {
				cantidad_actual--;
				cantidadesPorProducto[menuName] = cantidad_actual;
				restando_foot(precio_producto);
			}
		}
		cantidad_div.textContent = cantidad_actual;
		cantidad_div.setAttribute('data-cantidad', cantidad_actual);
		//cantidadesPorProducto[menuName] = cantidad_actual;

		cantidad_producto = Object.values(cantidadesPorProducto).reduce((a, b) => a + b, 0);
		total_objetos.innerHTML = 'Total de platillos (' + cantidad_producto + ') ';
		if (!ir_pagar) {
			let mostrar_numero = productoDOM.querySelector('[data-cantidad]');
			mostrar_numero.textContent = cantidad_actual;
		}

	})));
	//agregando_foot(precio_producto);

}

function agregando_foot(precio_producto) {
	let importe = document.getElementById("importe");
	let impuestos = document.getElementById("impuestos");
	let total = document.getElementById("total");
	//Hacemos la operación por separado
	sumaImporte = parseFloat(sumaImporte) + (parseFloat(precio_producto)); //0 + 12 = 12 ||| //12+12 = 24
	//Mostramos el valor obtenido de la operación
	importe.innerHTML = 'S/. ' + Math.round(sumaImporte * 100) / 100;
	//Hacemos la operación para obtener el valor de los impuestos
	let sumaImpuestos = sumaImporte * 0.18; //2.16 ||| //4.32
	//Mostramos el valor de los impuestos en total
	impuestos.innerHTML = 'S/. ' + Math.round(sumaImpuestos * 100) / 100;
	//Realizamos la suma para el total
	sumaImporteEimpuestos = parseFloat(sumaImporte) + parseFloat(sumaImpuestos); //14.16 ||| //28.32
	//Mostramos el valor total
	total.innerHTML = 'S/. ' + Math.round(sumaImporteEimpuestos * 100) / 100;
}

function restando_foot(precio_producto) {
	let importe = document.getElementById("importe");
	let impuestos = document.getElementById("impuestos");
	let total = document.getElementById("total");
	
	console.log("suma importe es: "+sumaImporte);
	//Hacemos la operación por separado
	sumaImporte = parseFloat(sumaImporte) - (parseFloat(precio_producto));
	//Mostramos el valor obtenido de la operación
	importe.innerHTML = 'S/. ' + Math.round(sumaImporte * 100) / 100;
	//Hacemos la operación para obtener el valor de los impuestos
	let sumaImpuestos = sumaImporte * 0.18;
	//Mostramos el valor de los impuestos en total
	impuestos.innerHTML = 'S/. ' + Math.round(sumaImpuestos * 100) / 100;
	//Realizamos la suma para el total
	sumaImporteEimpuestos = parseFloat(sumaImporte) + parseFloat(sumaImpuestos);
	//Mostramos el valor total
	total.innerHTML = 'S/. ' + Math.round(sumaImporteEimpuestos * 100) / 100;
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

const crearBloque = (menu, cantidadesPorProducto) => {
    return '<div class="d-flex p-2 m-2 align-items-center justify-content-between"' +
        ' style="border:1px solid lightgray; border-radius: 10px; gap:6px;" data-nombre="' + menu.nombre + '">' +
        
        // Imagen y nombre del platillo
        '<div class="d-flex gap-2 align-items-center justify-content-center">' +
            '<img src="data:' + menu.tipo_imagen + ';base64,' + menu.archivo_imagen + '" ' +
            'style="width: 60px" alt="' + menu.nombre + '">' +
            '<h6 class="mx-2 cant_platillo" style="font-weight: 600">' + menu.nombre + '</h6>' +
        '</div>' +
        
        // Controles de cantidad
        '<div class="d-flex justify-content-center align-items-center px-2 rounded-pill"' +
        ' style="gap:6px; height:35px;">' +
            // Botón de disminuir cantidad
            '<i data-menu="' + menu.nombre + '" data-precio="' + menu.precio + '"' +
            ' class="fa-solid fa-circle fa-2x circulito_card" style="color: #f9f9f9; position: relative">' +
                '<i data-target="contador_resta" class="fa-solid fa-minus fa-2xs"' +
                ' style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>' +
            '</i>' +
            
            // Cantidad actual
            '<div  data-cantidad="' + cantidadesPorProducto[menu.nombre] + '">' +
                cantidadesPorProducto[menu.nombre] +
            '</div>' +
            
            // Botón de aumentar cantidad
            '<i data-precio="' + menu.precio + '" data-menu="' + menu.nombre + '" class="fa-solid fa-circle fa-2x circulito_card"' +
            ' style="color: #fafafa; position: relative">' +
                '<i data-target="contador_suma" class="fa-solid fa-plus fa-2xs"' +
                ' style="color: #000000; position: absolute; bottom: 14px; left: 8px"></i>' +
            '</i>' +
        '</div>' +
        
        // Botón de eliminar
        '<i class="fas fa-solid fa-trash fa-xl mx-2 icono_eliminar" style="color:red;"></i>' +
    '</div>';
};


const realizarPago = () => {

}