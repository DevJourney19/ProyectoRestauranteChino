
let btn_e_input = document.querySelectorAll(".btn_editar_input");
if (btn_e_input) {
	btn_e_input.forEach(t => t.addEventListener("click", function() {

		const id = this.getAttribute('data-id');
		const nombre = this.getAttribute('data-nombre');
		const categoria = this.getAttribute('data-categoria');
		const descripcion = this.getAttribute('data-descripcion');
		const precio = this.getAttribute('data-precio');
		const estado = this.getAttribute('data-estado');
		document.querySelector("#nombreE").value = nombre;
		document.querySelector("#descripcionE").value = descripcion;
		document.querySelector("#precioE").value = precio;
		document.querySelector("#estadoE").value = estado;

		const categoriaSelect = document.querySelector("#categoriaE");
		categoriaSelect.value = categoria;

	}));
}

window.onload = function() {
	const urlParams = new URLSearchParams(window.location.search);
	const mensaje = urlParams.get('mensaje');

	if (mensaje) {
		alert(mensaje);
		// Eliminar el parámetro 'mensaje' de la URL
		urlParams.delete('mensaje');
		// Actualizar la URL sin recargar la página
		window.history.replaceState({}, document.title, window.location.pathname + (urlParams.toString() ? '?' + urlParams.toString() : ''));
	}
};
// Modal de eliminación
document
	.getElementById('staticBackdrop')
	.addEventListener(
		'show.bs.modal',
		function(event) {
			const button = event.relatedTarget;
			const id = button.getAttribute('data-id');
			document.getElementById('modalIdEliminarMenu').innerHTML = "#"
				+ id;
			8
			document
				.getElementById('eliminarId')
				.addEventListener(
					'click',
					function(event) {
						window.location.href = "/ProyectoRestauranteChino/EliminarMenu?id="
							+ id;
					})
		});

// Modal de edición
document
	.getElementById('modalEdit')
	.addEventListener('show.bs.modal', function(event) {
		const button = event.relatedTarget;
		let id = button.getAttribute('data-id');
		let nombre = button.getAttribute('data-nombre');
		let descripcion = button.getAttribute('data-descripcion');
		let precio = button.getAttribute('data-precio');
		let estado = button.getAttribute('data-estado');
		let id_categoria = button.getAttribute('data-categoria');

		// Llenar los campos del formulario con los valores obtenidos
		document.querySelector("#nombreE").value = nombre;
		document.querySelector("#descripcionE").value = descripcion;
		document.querySelector("#precioE").value = precio;
		document.querySelector("#estadoE").value = estado;

		const categoriaSelect = document.querySelector("#categoriaE");
		categoriaSelect.value = id_categoria;

		document
			.getElementById('editarId')
			.addEventListener('click', function(event) {
				// Obtener los valores de los campos después de la edición
				nombre = document.querySelector("#nombreE").value;
				descripcion = document.querySelector("#descripcionE").value;
				precio = document.querySelector("#precioE").value;
				estado = document.querySelector("#estadoE").value;
				id_categoria = document.querySelector("#categoriaE").value;

				// Crear un objeto FormData para manejar los datos del formulario
				const formData = new FormData();

				// Agregar los datos al FormData
				formData.append('id', id);
				formData.append('nombre', nombre);
				formData.append('descripcion', descripcion);
				formData.append('precio', precio);
				formData.append('estado', estado);
				formData.append('categoria', id_categoria);

				// Verificar si hay una imagen seleccionada en el formulario y agregarla
				const imagenInput = document.querySelector("#imagenE");
				const archivoImagen = imagenInput.files[0];
				if (archivoImagen) {
					formData.append('file', archivoImagen);
				} else {
					formData.append("tipo", button.getAttribute('data-tipo'));
					formData.append('imagen', button.getAttribute('data-imagen'));
				}

				// Hacer la solicitud POST con multipart/form-data usando fetch
				fetch('/ProyectoRestauranteChino/EditarMenu', {
					method: 'POST',
					body: formData
				}).then(response => {
					if (!response.ok) {
						throw new Error('Error en la red');
					}
					return response.json(); // Esperar un JSON de respuesta
				})
					.then(data => {
						console.log('Éxito:', data);
						window.location.reload(); // Recargar la página después de la respuesta exitosa
					})
					.catch((error) => {
						console.error('Error:', error);
					});
			});
	});
