<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
<%@page import="modelo.Categoria"%>
<%@page import="datos.impl.DaoCategoriaImpl" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="menu" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="categorias" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>

<head>
    <title>Menú - Noche en Pekín</title>
    <%@include file="../fragmentos/head.jsp"%>
    <link href="vista/trabajadores/menu/menu.css" rel="stylesheet" />
</head>

<body class="body">
    <%
    List<Menu> listaMenu = (List<Menu>) menu;
    %>
    <div class="d-flex ">
        <%@ include file="../fragmentos/sidebar.jsp"%>
        <div class="main">
            <%@ include file="../fragmentos/nav.jsp"%>
            <div class="container">
                <div class="mb-3">
                    <div class="text-center d-md-flex align-items-center justify-content-between flex-wrap mb-2">
                        <h1 class="text-center py-4">MENÚ - 菜单</h1>
                        <span class="fs-3 numero-productos"><%= listaMenu.size() %> items</span>
                    </div>
                </div>

				<!-- Carrusel de productos -->
				<div id="menuCarouselXl" class="carousel slide d-none d-xl-block" data-bs-ride="carousel" data-bs-interval="3000">
				    <div class="carousel-inner">
				        <%
				        if (menu != null && !menu.isEmpty()) {
				            int totalMenus = listaMenu.size();
				            for (int i = 0; i < totalMenus; i += 6) {
				                String activeClass = (i == 0) ? "active" : ""; // Clase activa para el primer elemento
				        %>
				        <div class="carousel-item <%= activeClass %>">
				            <div class="row">
				                <%
				                // Mostrar hasta 3 elementos en cada carousel-item
				                for (int j = 0; j < 6 && (i + j) < totalMenus; j++) {
				                    Menu menus = listaMenu.get(i + j);
				                    String estadoMenu = menus.getEstado() == Menu.Estado.Venta ? "Disponible" : "No Disponible";
				                    String estadoClass = menus.getEstado() == Menu.Estado.Venta ? "bg-success" : "bg-danger";
				                %>
				                <div class="col-12 col-xl-4 col-xxl-4">
				                    <div class="card mb-5">
				                        <div class="row g-0">
				                            <div class="col-md-4">
				                                <img src="data:<%=menus.getTipoImagen()%>;base64,<%=menus.getImagen()%>" class="img-menu m-2 rounded-start" alt="<%= menus.getNombre() %>">
				                            </div>
				                            <div class="col-md-8">
				                                <div class="card-body">
				                                    <h5 class="card-title text-truncate"><%= menus.getNombre() %></h5>
				                                    <p class="card-text text-truncado"><%= menus.getDescripcion() %></p>
				                                </div>
				                            </div>
				                        </div>
             							<div class="card-footer bg-transparent">
		                                      <div class="d-flex justify-content-between align-items-start">
											    <div class="ms-2 mt-2 me-auto">
		                                   			 <h2 class="fw-semibold">S/ <%= menus.getPrecio() %></h2>
											    </div>
											    <h5><span class="badge bg-primary mt-3 rounded-pill <%= estadoClass %>"><%= estadoMenu %></span></h5>
											  </div>
									  	</div>
				                    </div>
				                </div>
				                <%
				                }
				                %>
				            </div>
				        </div>
				        <%
				            }
				        } else {
				            out.write("No se registraron menús...");
				            System.out.println("No hay registros");
				        }
				        %>
				    </div>
				    <button class="boton bg-dark carousel-control-prev" type="button" data-bs-target="#menuCarouselXl" data-bs-slide="prev" style="width: 50px;">
				        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				        <span class="visually-hidden">Previous</span>
				    </button>
				    <button class="boton bg-dark carousel-control-next" type="button" data-bs-target="#menuCarouselXl" data-bs-slide="next" style="width: 50px;">
				        <span class="carousel-control-next-icon" aria-hidden="true"></span>
				        <span class="visually-hidden">Next</span>
				    </button>
				</div>
				                
                <!-- Carrusel de productos -->
                <div id="menuCarousel" class="carousel slide d-block d-xl-none" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <%
                        if (menu != null && !menu.isEmpty()) {
                            for (int i = 0; i < listaMenu.size(); i++) {
                                Menu menus = listaMenu.get(i);
                                String estadoMenu = menus.getEstado() == Menu.Estado.Venta ? "Disponible" : "No Disponible";
                                String estadoClass = menus.getEstado() == Menu.Estado.Venta ? "bg-success" : "bg-danger";
                                String activeClass = (i == 0) ? "active" : ""; // Clase activa para el primer elemento
                        %>
                        <div class="carousel-item <%= activeClass %>">
               			   <div class="card mb-5">
                          		<div class="row g-0">
	                                <div class="col-md-4">
	                                    <img src="data:<%=menus.getTipoImagen()%>;base64,<%=menus.getImagen()%>" class="img-menu m-2 rounded-start" alt="<%= menus.getNombre() %>">
	                                </div>
	                                <div class="col-md-8">
	                                    <div class="card-body">
	                                        <h5 class="card-title"><%= menus.getNombre() %></h5>
	                                        <p class="card-text text-truncado"><%= menus.getDescripcion() %></p>
	                                    </div>
	                                </div>
           							<div class="card-footer bg-transparent">
	                                      <div class="d-flex justify-content-between align-items-start">
										    <div class="ms-2 mt-2 me-auto">
	                                   			 <h2 class="fw-semibold">S/ <%= menus.getPrecio() %></h2>
										    </div>
										    <h5><span class="badge bg-primary mt-3 rounded-pill <%= estadoClass %>"><%= estadoMenu %></span></h5>
										  </div>
								  	</div>
                                </div>
                           </div>
                        </div>
                        <%
                            }
                        } else {
                            out.write("No se registraron menús...");
                            System.out.println("No hay registros");
                        }
                        %>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#menuCarousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#menuCarousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>

            </div>
        </div>
    </div>

    <script src="https://kit.fontawesome.com/c353473263.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js /bootstrap.bundle.min.js"></script>
</body>
</html>