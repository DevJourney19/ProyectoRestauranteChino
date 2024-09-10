<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inventario - Noche en Pekín</title>
        <%@include file="../fragmentos/head.jsp"%>
        <link href="inventario_css.css" rel="stylesheet" />
    </head>
    <body class="body">
		<%@ include file="../fragmentos/sidebar.jsp"%>

        <div class="titulo_inventario">Noche en Pekín 北京之夜</div>
        <div class="container">
            <h2 class="my-2">Inventario</h2>

            <div class="mb-3">
                <button class="btn btn-success d-flex align-items-center gap-2"
                        type="button" data-bs-toggle="modal" data-bs-target="#modalAdd">
                    Solicitar Item <i class="lni lni-plus"></i>
                </button>
            </div>


            <!-- Modal Solicitar-->
            <div class="modal fade" id="modalAdd" tabindex="-1"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog-centered modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-3 fw-semibold" id="exampleModalLabel">
                                Solicitar Item</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="" class="needs-validation" novalidate>
                                <div class="form-group mb-4 d-flex flex-wrap gap-2">
                                    <div class="col-12 col-md">
                                        <label for="asunto">Asunto</label> <input type="text"
                                                                                   class="form-control" id="asunto" name="asunto" required>
                                    </div>
                                </div>


                                <div class="form-group mb-4 d-flex flex-wrap gap-2">
                                    <div class="col-12 col-md">
                                        <label for="unidad">Mensaje</label> <textarea rows="5" class="form-control" id="unidad" name="unidad" required></textarea>
                                    </div>
                                </div>

                                <div class="modal-footer">

                                    <button type="button" class="btn btn-danger"
                                            data-bs-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn btn-warning">Solicitar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="row">
                <div class="col-6 col-md-4 col-lg-3">
                    <div class="card mb-4 p-4">
                        <div class="row no-gutters">
                            <img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
                            <div class="card-body text-center">
                                <h5 class="card-title">Arroz</h5>
                                <p class="card-text">Stock</p>
                                <h1>20 KG</h1>
                                <form action="modificar_item.jsp" method="post"
                                      style="display: inline;">
                                    <input type="hidden" name="id" value="1">
                                    <button class="btn btn-warning">
                                        <i class="fa-solid fa-edit" style="color: #000000;"></i>
                                        Modificar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-6 col-md-4 col-lg-3">
                    <div class="card mb-4 p-4">
                        <div class="row no-gutters">
                            <img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
                            <div class="card-body text-center">
                                <h5 class="card-title">Manies</h5>
                                <p class="card-text">Stock</p>
                                <h1>20 UND</h1>
                                <form action="modificar_item.jsp" method="post"
                                      style="display: inline;">
                                    <input type="hidden" name="id" value="1">
                                    <button class="btn btn-warning">
                                        <i class="fa-solid fa-edit" style="color: #000000;"></i>
                                        Modificar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-6 col-md-4 col-lg-3">
                    <div class="card mb-4 p-4">
                        <div class="row no-gutters">
                            <img src="../../img/arroz.png" class="card-img-top" alt="Chaufa">
                            <div class="card-body text-center">
                                <h5 class="card-title">Tomate</h5>
                                <p class="card-text">Stock</p>
                                <h1>20 KG</h1>
                                <form action="modificar_item.jsp" method="post"
                                      style="display: inline;">
                                    <input type="hidden" name="id" value="1">
                                    <button class="btn btn-warning">
                                        <i class="fa-solid fa-edit" style="color: #000000;"></i>
                                        Modificar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="https://kit.fontawesome.com/c353473263.js"></script>
    </body>
</html>