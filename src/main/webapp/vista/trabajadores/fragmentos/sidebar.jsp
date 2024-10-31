<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="d-flex">

	<aside id="sidebar" class="sidebar-toggle">
		<div class="sidebar-logo">
			<a href="#">NOCHE EN PEKÍN - 北京之夜</a>
		</div>
		<ul class="sidebar-nav p-0">
			<li class="sidebar-item"><a
				href="TrabajadorMenu"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-service"></i> <span>Menu</span>
			</a></li>
			<li class="sidebar-item"><a href="TrabajadorInventario"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-agenda"></i> <span>Inventario</span>
			</a></li>
			<li class="sidebar-item"><a href="TrabajadorPedido"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos - Mozo</span>
			</a></li>
			<li class="sidebar-item"><a href="TrabajadorPedidoCocinero"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos - Cocinero</span>
			</a></li>
			<li class="sidebar-item"><a href="TrabajadorMesa"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-airtable"></i> <span>Mesas</span>
			</a></li>
			<!-- <li class="sidebar-item"><a href="#" class="sidebar-link d-flex align-items-center gap-2">
						<i class="lni lni-stats-up"></i> <span>Reportes</span>
				</a></li> -->
		</ul>
		<div class="sidebar-footer">
		<!-- Se debe de prohibir el acceso a otras ventanas por medio del url (Antes que nada debe de estar logueado) -->
			<a href="LogoutControlador"
				class="sidebar-link d-flex align-items-center gap-2"> <i
				class="lni lni-exit"></i> <span>Salir</span>
			</a>
		</div>
	</aside>

</div>