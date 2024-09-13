<<<<<<< HEAD
const toggler = document.querySelector(".toggler-btn");

if (toggler) {
	toggler.addEventListener("click", function() {
		document.querySelector("#sidebar").classList.toggle("collapsed");
		document.querySelector("#logo").classList.toggle("collapsed");
	});
}

=======
const buttonToggle = document.querySelector("#toggle");
buttonToggle.addEventListener("click", function() {
	document.querySelector("#sidebar").classList.toggle("collapsed");
});

document.getElementById("toggle").addEventListener("click", function() {
    const sidebar = document.getElementById("sidebar");
    sidebar.style.width = sidebar.style.width === "50px" ? "180px" : "50px";
});
>>>>>>> origin/inventario
