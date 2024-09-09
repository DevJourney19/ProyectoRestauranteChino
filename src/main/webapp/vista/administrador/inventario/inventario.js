let inventario_inicial_input = document.getElementById("inventario_inicial");
let stock_inicial_input = document.getElementById("stock_inicial");
let stock_minimo_input = document.getElementById("stock_minimo");

stock_inicial_input.addEventListener("input", function() {

	let inventario_inicial = parseInt(inventario_inicial_input.value) || 0;
	let stock_inicial = parseInt(stock_inicial_input.value) || 0;
	
	if (stock_inicial > inventario_inicial) {
		//Si el stock inicial es mayor al inventario inicial, el stock inicial no debe sobrepasar esa cantidad
		//Se aplica el input.value para mostrar en pantalla el cambio realizado
		stock_inicial_input.value=inventario_inicial;
		//Hacer alerta
		console.log(stock_inicial)
	}

})

stock_minimo_input.addEventListener("input", function() {

	let stock_inicial = parseInt(stock_inicial_input.value) || 0;
	
	let stock_minimo = parseInt(stock_minimo_input.value) || 0;

	if (stock_minimo > stock_inicial) {
		stock_minimo_input.value=stock_inicial;
	}
})