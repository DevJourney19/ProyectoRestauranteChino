const toggler = document.querySelector(".toggler-btn");
toggler.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("collapsed");
  document.querySelector("#logo").classList.toggle("collapsed");
});

// Obtener path y colocar una clase active al side que corresponda

//const check = document.querySelector(".check-modo-nocturno");
//const modo_nocturno = document.querySelector("div .main");
//const table = document.querySelector(".table");

/**check.addEventListener("click", () => {
	if(check.checked) {
		modo_nocturno.classList.add("modo-nocturno");
		table.classList.add("table-dark");
	} else {
		modo_nocturno.classList.remove("modo-nocturno");
		table.classList.remove("table-dark");
	}
})
**/