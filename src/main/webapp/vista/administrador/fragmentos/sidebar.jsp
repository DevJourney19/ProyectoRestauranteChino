<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<div class="d-flex">

	<aside id="sidebar" class="sidebar-toggle">
		<div class="sidebar-logo">
			<a href="#">NOCHE EN PEKÍN - 北京之夜</a>
		</div>
		<ul class="sidebar-nav p-0">
			<li class="sidebar-item"><a href="../usuarios/usuarios.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-users"></i> <span>Usuarios</span>
			</a></li>
			<li class="sidebar-item"><a href="../menu/menu.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-service"></i> <span>Menu</span>
			</a></li>
			<li class="sidebar-item"><a href="../inventario/inventario.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-agenda"></i> <span>Inventario</span>
			</a></li>
			<li class="sidebar-item"><a href="../pedidos/pedidos.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos</span>
			</a></li>
			<li class="sidebar-item"><a href="../mesas/mesas.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-airtable"></i> <span>Mesas</span>
			</a></li>
			<!-- <li class="sidebar-item"><a href="#" class="sidebar-link d-flex align-items-center gap-2">
						<i class="lni lni-stats-up"></i> <span>Reportes</span>
				</a></li> -->
			<li class="m-5">
				<div class="form-check form-switch">
		  			<input class="check-modo-nocturno form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked">
		  			<label class="form-check-label text-light" for="flexSwitchCheckChecked">Modo nocturno</label>
				</div>
			</li>
		</ul>

		<div class="sidebar-footer">
			<a href="../../login.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
				class="lni lni-exit"></i> <span>Salir</span>
			</a>
		</div>
	</aside>
</div>