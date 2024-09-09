const toggler = document.querySelector(".toggler-btn");
toggler.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("collapsed");
  document.querySelector("#logo").classList.toggle("collapsed");
});

// Obtener path y colocar una clase active al side que corresponda