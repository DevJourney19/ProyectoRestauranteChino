<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="sidebar">
	<div class="sidebar-logo">
		<img alt="" src="../../img/logo.png">
		<button id="toggle" type="button">
			<i class="lni lni-angle-double-left"></i>
		</button>
	</div>
	<ul class="sidebar-nav p-0 mt-4">
		<!-- falta -->
		<li class="sidebar-item"><a href="../menu/menu.jsp"
			class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
				<i class="fa-solid fa-bowl-food"></i> <span class="hidden">Menu</span>
		</a></li>
		<li class="sidebar-item"><a href="../mesa/mesa.jsp"
			class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
				<i class="lni lni-airtable"></i> <span class="hidden">Mesas</span>
		</a></li>
		<li class="sidebar-item"><a href="../inventario/inventario.jsp"
			class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
				<i class="lni lni-agenda"></i> <span class="hidden">Inventario</span>
		</a></li>
		<li class="sidebar-item"><a href="../pedido/pedido.jsp"
			class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
				<i class="lni lni-cart"></i> <span class="hidden">Pedidos</span>
		</a></li>
	</ul>
	<div class="sidebar-footer">
		<a href="../../login.jsp"
			class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
			<i class="lni lni-exit"></i> <span class="hidden">Logout</span>
		</a>
	</div>
</div>