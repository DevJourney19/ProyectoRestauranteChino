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

