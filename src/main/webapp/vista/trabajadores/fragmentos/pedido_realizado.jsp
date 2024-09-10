<div class="col">
	<div class="p-3 border rounded bg-white"
		style="width: 320px; position: relative">
		<div class="mesa_numero">M01</div>
		<div
			style="position: absolute; top: 20px; left: 62px; font-size: 1rem">Cliente</div>
		<div class="completado">
			<i class="fa-solid fa-square-check" style="color: #000000;"></i>
			Completado
		</div>
		<div class="pedido_especifico_numero_pedido">Pedido #0000000</div>
		<div class="d-flex justify-content-between mt-2"
			style="font-size: 0.7rem">
			<div>29/08/2024</div>
			<div>21:00 PM</div>
		</div>
		<hr />
		<div class="table-responsive ">
			<table class="table text-center" style="border: transparent;">
				<thead>
					<tr style="font-size: 0.8rem">
						<th>Producto</th>
						<th>Cantidad</th>
						<th>Subtotal</th>
					</tr>
				</thead>
				<tbody>
					<tr style="font-size: 0.8rem">
						<th>Chaufa</th>
						<th>2</th>
						<th>S/. 40</th>

					</tr>
					<tr style="font-size: 0.8rem">
						<th>Chaufa</th>
						<th>2</th>
						<th>S/. 40</th>

					</tr>
					<tr style="font-size: 0.8rem">
						<th>Chaufa</th>
						<th>2</th>
						<th>S/. 40</th>

					</tr>
					<tr style="font-size: 0.8rem">
						<th>Chaufa</th>
						<th>2</th>
						<th>S/. 40</th>

					</tr>
					<tr style="font-size: 0.8rem">
						<th>Chaufa</th>
						<th>2</th>
						<th>S/. 40</th>

					</tr>

				</tbody>
			</table>
			<hr />
			<div class="d-flex justify-content-between mb-3"
				style="font-size: 0.8rem; font-weight: 600">
				<div>Total</div>
				<div>S/. 200</div>
			</div>
			<div class="d-flex justify-content-evenly">
				<form action="../detalle_pedido/detalle_pedido.jsp" method="post">
					<button class="btn btn-warning">Detalles</button>
				</form>
				<form action="../pagar/pagar.jsp" method="post">
					<button class="btn btn-success">Pagar</button>
				</form>
			</div>
		</div>
	</div>
</div>