const buttonToggle = document.querySelector("#toggle");

if (buttonToggle) {
	buttonToggle.addEventListener("click", function() {
		document.querySelector("#sidebar").classList.toggle("collapsed");
		document.querySelector("#logo").classList.toggle("collapsed");
	});
}

