
let btn_e_input = document.querySelectorAll(".btn_editar_input");
if (btn_e_input) {
	btn_e_input.forEach(t => t.addEventListener("click", function() {

		const id = this.getAttribute('data-id');
		const nombre = this.getAttribute('data-nombre');
		const categoria = this.getAttribute('data-categoria');
		const descripcion = this.getAttribute('data-descripcion');
		const precio = this.getAttribute('data-precio');
		const estado = this.getAttribute('data-estado');
		document.querySelector("#menuIdForm_e").value = id;
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

		urlParams.delete('mensaje');

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
	.addEventListener(
		'show.bs.modal',
		function(event) {
		const button = event.relatedTarget;
			let id = button.getAttribute('data-id');
			let nombre = button.getAttribute('data-nombre');
			let descripcion = button.getAttribute('data-descripcion');
			let precio = button.getAttribute('data-precio');
			let estado = button.getAttribute('data-estado');
			let id_categoria = button.getAttribute('data-categoria');
			document.querySelector("#nombreE").value = nombre;
			document.querySelector("#descripcionE").value = descripcion;
			document.querySelector("#precioE").value = precio;
			document.querySelector("#estadoE").value = estado;

			const categoriaSelect = document.querySelector("#categoriaE");
			categoriaSelect.value = id_categoria;
			document
			    .getElementById('editarId')
			    .addEventListener(
			        'click',
			        function(event) {
			             nombre = document.querySelector("#nombreE").value;
			             descripcion = document.querySelector("#descripcionE").value;
			             precio = document.querySelector("#precioE").value;
			             estado = document.querySelector("#estadoE").value;
			             categoria = document.querySelector("#categoriaE").value; // Asegúrate de obtener el valor correcto

			            // Crear un objeto con los datos a enviar
			            const data = {
			                id: id,
			                nombre: nombre,
							descripcion: descripcion,
			                precio: precio,
			                estado: estado,
			                categoria: {id:categoria}
			            };

			            // Hacer la petición POST
			            fetch('/ProyectoRestauranteChino/EditarMenu', {
			                method: 'POST',
			                headers: {
			                    'Content-Type': 'application/json'
			                },
			                body: JSON.stringify(data)
			            })
			            .then(response => {
			                if (response.ok) {
							window.location.reload();
			                    return response.json().then(data => {
							            window.location.reload();
							        });
			                }
			                throw new Error('Error en la red');
			            })
			            .then(data => {
			                console.log('Éxito:', data);
			            })
			            .catch((error) => {
			                console.error('Error:', error);
			            });
					
			        }
			    );

		});