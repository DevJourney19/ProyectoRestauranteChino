/**
 * Hello World! :)
 */
let elemento = document.getElementById("tabla_detalle_pedidos");
elemento.classList.add("toggle_tabla_detalle_pedidos_nada");
function myFunction() {
	elemento.classList.toggle("toggle_tabla_detalle_pedidos");
	console.log("todo funcional");
}


const agregar_btn = document.querySelectorAll(".agregar_btn");

agregar_btn.forEach(t => t.addEventListener("click", function() {
	Swal.fire("Producto agregado");
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

//Se activa para poder detectar el clic al circulo de aumentar cantidad de producto
const circulito_card = document.querySelectorAll(".circulito_card");
//Se activa para todos
circulito_card.forEach(t => t.addEventListener("click", function() {
	//Llama a la ubicación de un div que se encuentra al costado de la imagen
	let barrita = document.getElementById("contador_suma_resta");

	//Crear un nuevo div para el contador
	let numeroContador = document.createElement("div");
	//Agregamos un texto al contenido del div
	numeroContador.textContent = "-1";
	//Quiero que ese div se encuentre en la misma posición que barrita
	numeroContador.classList.add("contador_suma_resta");
	//Hacemos que barrita tenga un hijo div llamado numeroContador
	barrita.appendChild(numeroContador);
	
	//Añadir clase para animación (aparecerá cuando se de clic en el botón)
	barrita.classList.add("contador_suma_resta_mover");

	//Eliminar el div después de 2 segundos
	setTimeout(function() {
		//Si en 2 segundos sigue existiendo el contenido de texto entonces se elimina
		if (numeroContador) {
			//Eliminar al createElement("div")
			numeroContador.remove();
		}
		//Si no hay más elementos, eliminar la clase de animación
		if (barrita.children.length === 0) {
			//Remueve el efecto de movimiento para que nuevos elementos puedan obtener ese efecto
			barrita.classList.remove("contador_suma_resta_mover");
		}

	}, 500);
}))
	
//	barrita.classList.add("contador_suma_resta_mover");
//	
//	barrita.innerHTML = "<div>+1</div>"
	
//	barrita.innerHTML+= too;
	
//	let numero_contador = "<div>+1</div>"
//	barrita.innerHTML += numero_contador;
//		barrita.classList.remove("contador_suma_resta_mover");
//		barrita.innerHTML = "";

