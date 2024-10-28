
let btn_e_input = document.querySelectorAll(".btn_editar_input");
if (btn_e_input) {
	btn_e_input.forEach(t => t.addEventListener("click", function() {

		const id = this.getAttribute('data-id');
		const apellido = this.getAttribute('data-apellido');
		const nombre = this.getAttribute('data-nombre');
		const usuario = this.getAttribute('data-usuario');
		const password = this.getAttribute('data-pass');
		const celular = this.getAttribute('data-celular');
		const id_rol = this.getAttribute('data-id-rol');
		document.querySelector("#trabajadorIdForm_e").value = id;
		document.querySelector("#apellidoE").value = apellido;
		document.querySelector("#nombreE").value = nombre;
		document.querySelector("#usuarioE").value = usuario;
		document.querySelector("#passwordE").value = password;
		document.querySelector("#celularE").value = celular;

		const rolSelect = document.querySelector("#rolE");
		rolSelect.value = id_rol;

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
			document.getElementById('modalIdEliminarUsuario').innerHTML = "#"
				+ id;
			8
			document
				.getElementById('eliminarId')
				.addEventListener(
					'click',
					function(event) {
						window.location.href = "/ProyectoRestauranteChino/EliminarTrabajador?id="
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
			let apellido = button.getAttribute('data-apellido');
			let nombre = button.getAttribute('data-nombre');
			let usuario = button.getAttribute('data-usuario');
			let password = button.getAttribute('data-pass');
			let celular = button.getAttribute('data-celular');
			let id_rol = button.getAttribute('data-id-rol');
			document.querySelector("#apellidoE").value = apellido;
			document.querySelector("#nombreE").value = nombre;
			document.querySelector("#usuarioE").value = usuario;
			document.querySelector("#passwordE").value = password;
			document.querySelector("#celularE").value = celular;

			const rolSelect = document.querySelector("#rolE");
			rolSelect.value = id_rol;
			document
			    .getElementById('editarId')
			    .addEventListener(
			        'click',
			        function(event) {
			             apellido = document.querySelector("#apellidoE").value;
			             nombre = document.querySelector("#nombreE").value;
			             usuario = document.querySelector("#usuarioE").value;
			             password = document.querySelector("#passwordE").value;
			             celular = document.querySelector("#celularE").value;
			             rol = document.querySelector("#rolE").value; // Asegúrate de obtener el valor correcto

			            // Crear un objeto con los datos a enviar
			            const data = {
			                id: id,
			                apellido: apellido,
			                nombre: nombre,
			                nombreUsuario: usuario,
			                contrasenia: password,
			                celular: celular,
			                rol: {id:rol}
			            };

			            // Hacer la petición POST
			            fetch('/ProyectoRestauranteChino/EditarTrabajador', {
			                method: 'POST',
			                headers: {
			                    'Content-Type': 'application/json'
			                },
			                body: JSON.stringify(data)
			            })
			            .then(response => {
			                if (response.ok) {
			                    return response.json();
			                }
			                throw new Error('Error en la red');
			            })
			            .then(data => {
			                console.log('Éxito:', data);
			            })
			            .catch((error) => {
			                console.error('Error:', error);
			            });
						
						window.location.reload();
			        }
			    );

		});