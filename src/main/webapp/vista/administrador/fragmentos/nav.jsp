<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<nav class="navbar d-flex align-items-center">
    <button class="toggler-btn" type="button">
        <i class="lni lni-text-align-left"></i>
    </button>
    <div class="navbar-logo collapsed" id="logo">
        <a href="#">Noche en Pekín 北京之夜</a>
    </div>
    <div>
        <button type="button" data-bs-toggle="modal" data-bs-target="#modalMessages" class="btn btn-white rounded-5 position-relative mt-2">
            <i class="lni lni-popup fs-2"></i>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                1
                <span class="visually-hidden">unread messages</span>
            </span>
        </button>
        <img class="m-2 rounded-5" width="50" height="50"
             src="../../img/tallarin_saltado.png" alt="alt" /> <span class="fw-bold">Usuario</span>
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
                    <div class="message-item mb-3">
                        <strong>De:</strong> Usuario 1 <br>
                        <strong>Mensaje:</strong> Este es un mensaje de prueba.
                    </div>
                    <hr> <!-- Separator -->
                    <div class="message-item mb-3">
                        <strong>De:</strong> Usuario 2 <br>
                        <strong>Mensaje:</strong> Otro mensaje para revisar.
                    </div>
                    <hr> <!-- Separator -->
                    <div class="message-item mb-3">
                        <strong>De:</strong> Usuario 3 <br>
                        <strong>Mensaje:</strong> Necesito ayuda con un problema.
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
