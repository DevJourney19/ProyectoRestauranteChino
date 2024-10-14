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