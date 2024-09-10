<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
</head>
    <div id="sidebar">
        <div class="sidebar-logo">
            <img alt="Logo" src="../../img/logo.png">
            <button id="toggle" type="button" class="toggle-button"><i class="lni lni-angle-double-left"></i></button>
        </div>
        <ul class="sidebar-nav p-0 mt-4">
            <li class="sidebar-item">
                <a href="../menu/menu.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                    <i class="fa-solid fa-bowl-food"></i><span>Menu</span>
                </a>
            </li>
            <li class="sidebar-item">
                <a href="../mesa/mesa.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                    <i class="lni lni-airtable"></i><span>Mesas</span>
                </a>
            </li>
            <li class="sidebar-item">
                <a href="../inventario/inventario.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                    <i class="lni lni-agenda"></i><span>Inventario</span>
                </a>
            </li>
            <li class="sidebar-item">
                <a href="../pedido/pedido.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                    <i class="lni lni-cart"></i><span>Pedidos</span>
                </a>
            </li>
            <!-- <li class="sidebar-item">
                <a href="../nuevo/nuevo.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                    <i class="lni lni-warning"></i><span>Perdido</span>
                </a>
            </li> -->
        </ul>
        <div class="sidebar-footer">
            <a href="../../login.jsp" class="sidebar-link d-flex align-items-center gap-2 justify-content-center">
                <i class="lni lni-exit"></i><span>Logout</span>
            </a>
        </div>
    </div>
</div>