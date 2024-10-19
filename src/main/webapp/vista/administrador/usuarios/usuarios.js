let btn = document.querySelectorAll(".btn_eliminar");
if (btn) {
	btn.forEach(t => t.addEventListener("click", function() {
		const trabajador_id = this.getAttribute('data-id');
		document.querySelector("#trabajadorIdForm").value = trabajador_id;
	}));
}

let btn_e = document.querySelectorAll(".btn_editar");
if (btn_e) {
	btn_e.forEach(t => t.addEventListener("click", function() {
		const trabajador_id = this.getAttribute('data-id');
		document.querySelector("#trabajadorIdForm_e").value = trabajador_id;
	}));
}

let btn_e_input = document.querySelectorAll(".btn_editar_input");
if (btn_e_input) {
	btn_e_input.forEach(t => t.addEventListener("click", function() {

		const id = this.getAttribute('data-id');
		const apellido = this.getAttribute('data-apellido');
		const nombre = this.getAttribute('data-nombre');
		const dni = this.getAttribute('data-dni');
		const correo = this.getAttribute('data-correo');
		const usuario = this.getAttribute('data-usuario');
		//const password = this.getAttribute('data-pass');
		const celular = this.getAttribute('data-celular');
		const id_rol = this.getAttribute('data-id-rol');
		document.querySelector("#trabajadorIdForm_e").value = id;
		document.querySelector("#apellidoE").value = apellido;
		document.querySelector("#nombreE").value = nombre;
		document.querySelector("#dniE").value = dni;
		document.querySelector("#correoE").value = correo;
		document.querySelector("#usuarioE").value = usuario;
		//document.querySelector("#passwordE").value = password;
		document.querySelector("#celularE").value = celular;

		const rolSelect = document.querySelector("#rolE");
		rolSelect.value = id_rol;

	}));
}