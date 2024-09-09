const buttonToggle = document.querySelector("#toggle");
buttonToggle.addEventListener("click", function() {
	document.querySelector("#sidebar").classList.toggle("collapsed");
});
