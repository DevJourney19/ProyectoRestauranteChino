
let elemento = document.getElementById("tabla_detalle_pedidos");
elemento.classList.add("toggle_tabla_detalle_pedidos_nada");
function myFunction() {

	if (elemento) {
		elemento.classList.toggle("toggle_tabla_detalle_pedidos");
		console.log("todo funcional");
	}
}

const agregar_btn = document.querySelectorAll(".agregar_btn");

agregar_btn.forEach(t => t.addEventListener("click", async function(event) {
	event.preventDefault();
	let detalles = [];
	//console.log("WE ARE HERESSSSSSSSS");
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

			let detallePedido = data.detPedidoJSON;
			let menu = data.menuJSON;
			
			//console.log(detallePedido.getIdMenu());
			detalles.push(detallePedido);
			let ubicacion = document.getElementById("resumen_pedido_platos");


			ubicacion.innerHTML += "";


			ubicacion.innerHTML += '<div class="d-flex p-2 m-2 align-items-center justify-content-between"' +
				'style = "border:1px solid lightgray; border-radius: 10px; gap:16px;" > ' +
				'<div class="d-flex gap-2 align-items-center justify-content-center">' +
				'<img src="data:' + menu.tipo_imagen + ';base64,' + menu.archivo_imagen + '" style="width: 60px" alt="' + menu.nombre + '">' +
				'<h6 class="mx-2" style="font-weight: 600">' + menu.nombre + '</h6></div>' +
				'<i class="fas fa-solid fa-trash fa-xl mx-2 icono_eliminar" style="color:red;"></i></div>';

			//Referencia
			/*
			'<label class="img_mesa" for="mesa' + mesa.id + '">' +
				'<img src="/ProyectoRestauranteChino/vista/img/mesa.png" />' +
				'<span>' + mesa.nombre + '</span>' +
				'</label>' +
				'<input type="radio" id="mesa' + mesa.id + '" value="' + mesa.id + '" name="mesa" data-target="' + mesa.id + '" />';*/

			console.log(detallePedido);

			//Agregamos la ubicación "Mostrar detalles..." //Y agregamos una lista



		}

	} catch (error) {
		console.error("Hubo un problema con la solicitud:", error);
		Swal.fire("Hubo un problema al agregar el producto", error.message, "error");
	}




}))

let icono_eliminar = document.querySelectorAll(".icono_eliminar");

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


const realizarPago = () => {

}