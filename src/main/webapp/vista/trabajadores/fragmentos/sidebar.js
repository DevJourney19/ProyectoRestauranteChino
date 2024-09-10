const toggler = document.querySelector(".toggler-btn");

if (toggler) {
	toggler.addEventListener("click", function() {
		document.querySelector("#sidebar").classList.toggle("collapsed");
		document.querySelector("#logo").classList.toggle("collapsed");
	});
}

