<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Sesion"%>
<%@ page import="modelo.Trabajador"%>
<%
	Trabajador tra = (Trabajador) Sesion.obtenerAtributo(request, "usuario");
%>
<div class="d-flex">

	<aside id="sidebar" class="sidebar-toggle">
		<div class="sidebar-logo">
			<a href="#">NOCHE EN PEKÍN - 北京之夜</a>
		</div>
		<ul class="sidebar-nav p-0">
		<%if(tra.getRol().getNombre().equals("Mozo")){ %>
			<li class="sidebar-item"><a
				href="${pageContext.request.contextPath}/TrabajadorMenu"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-service"></i> <span>Menu</span>
			</a></li>
			<li class="sidebar-item"><a href="${pageContext.request.contextPath}/TrabajadorPedido"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos - Mozo</span>
			</a></li>
			<li class="sidebar-item"><a href="${pageContext.request.contextPath}/TrabajadorMesa"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-airtable"></i> <span>Mesas</span>
			</a></li>
			<%} %>
			<%if(tra.getRol().getNombre().equals("Cocinero")){ %>
			<li class="sidebar-item"><a
				href="${pageContext.request.contextPath}/TrabajadorMenu"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-service"></i> <span>Menu</span>
			</a></li>
			<li class="sidebar-item"><a href="${pageContext.request.contextPath}/TrabajadorInventario"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-agenda"></i> <span>Inventario</span>
			</a></li>
			<li class="sidebar-item"><a href="${pageContext.request.contextPath}/TrabajadorPedidoCocinero"
				class="sidebar-link d-flex align-items-center gap-2"> <i
					class="lni lni-cart"></i> <span>Pedidos - Cocinero</span>
			</a></li>
			<%} %>
		</ul>
		<div class="sidebar-footer">
		<!-- Se debe de prohibir el acceso a otras ventanas por medio del url (Antes que nada debe de estar logueado) -->
			<a href="${pageContext.request.contextPath}/LogoutControlador"
				class="sidebar-link d-flex align-items-center gap-2"> <i
				class="lni lni-exit"></i> <span>Salir</span>
			</a>
		</div>
	</aside>

</div>