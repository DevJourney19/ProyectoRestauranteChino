<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="d-flex">

	<aside id="sidebar" class="sidebar-toggle">
		<div class="sidebar-logo">
			<a href="#">NOCHE EN PEKÍN - 北京之夜</a>
		</div>
		<ul class="sidebar-nav p-0">

			<li class="sidebar-item"><a
				href="${pageContext.request.contextPath}/SvConsultarTrabajador"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-users"></i> <span>Usuarios</span>
			</a></li>
			<li class="sidebar-item"><a href="AdmiMenu"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-service"></i> <span>Menu</span>
			</a></li>

			<li class="sidebar-item"><a href="AdmiInventario"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-agenda"></i> <span>Inventario</span>
			</a></li>
			<li class="sidebar-item"><a href="AdmiPedido"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos</span>
			</a></li>
			<li class="sidebar-item"><a href="AdmiMesa"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-airtable"></i> <span>Mesas</span>
			</a></li>

			<li class="sidebar-item"><a href="AdmiCategoria"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-layers"></i> <span>Categorias</span>
			</a></li>
		</ul>

		<div class="sidebar-footer">
			<a href="${pageContext.request.contextPath}/vista/login.jsp"
				class="sidebar-link d-flex align-items-center gap-2"> <i
				class="lni lni-exit"></i> <span>Salir</span>
			</a>
		</div>
	</aside>
</div>