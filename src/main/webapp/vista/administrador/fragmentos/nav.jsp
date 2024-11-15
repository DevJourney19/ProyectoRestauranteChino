<%@page import="modelo.Trabajador"%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="datos.DaoInventario" %>
<%@ page import="datos.impl.DaoInventarioImpl" %>
<%@page import="modelo.Inventario"%>

<%@page import="util.Sesion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
Trabajador trabajadorNombre = (Trabajador) Sesion.obtenerAtributo(request, "usuario");

DaoInventario daoInventarioImpl = new DaoInventarioImpl();
List<Inventario> inventarioList = daoInventarioImpl.consultar();

List<Inventario> inventarioBajoStock = new ArrayList<>();
for (Inventario item : inventarioList) {
    LocalDate fechaActual = LocalDate.now();
    if (item.getStock() <= item.getStockMin() || item.getCaducidad().isBefore(fechaActual)) {
        inventarioBajoStock.add(item);
    }
}
%>

<nav class="navbar d-flex align-items-center">

    <button class="toggler-btn" type="button">
        <i class="lni lni-text-align-left"></i>
    </button>
    <div class="navbar-logo collapsed" id="logo">
        <a href="#">NOCHE EN PEKÍN - 北京之夜</a>
    </div>
    <div class="d-flex align-items-center gap-4">
        <button type="button" data-bs-toggle="modal" data-bs-target="#modalMessages" class="btn btn-white rounded-5 position-relative mt-2 d-flex align-items-center">
            <i class="lni lni-popup fs-2"></i>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                <%= inventarioBajoStock.size() %>
                <span class="visually-hidden">unread messages</span>
            </span>
        </button>
        <div class="d-flex align-items-center gap-2"><img class="m-2 rounded-5" width="50" height="50"
             src="vista/img/tallarin_saltado.png" alt="alt" /> <span class="fw-bold"><%= trabajadorNombre != null ? trabajadorNombre.getNombre() : "Unknown" %></span></div>
    </div>
</nav>

<!-- Modal Mensajes -->
<div class="modal fade" id="modalMessages" tabindex="-1" aria-labelledby="modalMessagesLabel" aria-hidden="true">
    <div class="modal-dialog-centered modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-3 fw-semibold" id="modalMessagesLabel">Mensajes</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
			<div class="modal-body">
			    <div class="message-list">
			        <% if (!inventarioBajoStock.isEmpty()) { %>
			            <% for (Inventario item : inventarioBajoStock) {
							String stock = "stock-desconocido";
							if (item.getStock() <= item.getStockMin()) {
								stock = "stock-bajo";
							} else if (item.getStock() > 0) {
								stock = "stock-alto";
							}
						    LocalDate fechaActual = LocalDate.now();
							String estado = "badge rounded-pill text-bg-warning";

							if (item.getCaducidad().isBefore(fechaActual)) {
								estado = "badge rounded-pill text-bg-danger";
							} else if (item.getStock() > 0) {
								estado = "badge rounded-pill text-bg-success";
							}  	
	            	%>
		           		 	<h5><%= item.getNombre() %></h5>
			                <div class="row message-item mb-3">
			                	<div class="col-6"><strong>Stock:</strong> <span class="<%=stock%>"><%=item.getStock()%></span> </div>
                                <div class="col-6"><strong>Caducidad:</strong> <br> <span class="<%=estado%>"><%=item.getCaducidad()%></span> </div>
			                </div>
			                <hr> <!-- Separator -->
			            <% } %>
			        <% } else { %>
			            <div class="message-item mb-3">
			                No hay artículos vencidos o con bajo stock.
			            </div>
			        <% } %>
			    </div>
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

