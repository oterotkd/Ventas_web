<%-- 
    Document   : Nueva Venta
    Created on : 11/05/2024, 3:07:06â€¯p.â€¯m.
    Author     : OTEROTKD
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Incluye los archivos CSS de Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">    
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <title>Ventas</title>
        <style>
            @media print {
                .parte01, .btn, .accion {
                    display: none;
                }
                /* esta parte es la que se encarga de hacer la impresionn, de no mostrar los botones cuando se imprime */
            }

            /*este codigo pone una imagen en el fondo de la pantalla y centra la card*/
            body {
                background-image: url('imagenes Proyecto/shopping-2616824_1920.jpg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                height: 100vh;
                margin: 0;
            }
            .card-center {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12 parte01 mb-3">
                    <div class="card">
                        <form action="Controlador?menu=NuevaVenta" method="POST">
                            <div class="card-body">
                                <!-- Datos del Cliente -->
                                <div class="form-group">
                                    <label>DATOS CLIENTE</label>
                                </div>
                                <div class="form-group d-flex flex-wrap">
                                    <div class="col-lg-6 col-md-12 d-flex">
                                        <input type="text" name="codigocliente" value="${cl.getDni()}" class="form-control" placeholder="Codigo">
                                        <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info"><i class='bx bx-search-alt' ></i></button>

                                    </div>
                                    <div class="col-lg-6 col-md-12 mt-2 mt-lg-0">
                                        <input type="text" name="nombrescliente" value="${cl.getNom()}" class="form-control">
                                    </div>
                                </div>
                                <!-- Datos del Producto -->
                                <div class="form-group">
                                    <label>Datos Producto</label>
                                </div>
                                <div class="form-group d-flex flex-wrap">
                                    <div class="col-lg-6 col-md-12 d-flex">
                                        <input type="text" name="codigoproducto" class="form-control" placeholder="Codigo">
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info"><i class='bx bx-search-alt' ></i></button>
                                    </div>
                                    <div class="col-lg-6 col-md-12 mt-2 mt-lg-0">
                                        <input type="text" name="nombreproducto" value="${producto.getNom()}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group d-flex flex-wrap">
                                    <div class="col-lg-6 col-md-12">
                                        <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="$/0.0">
                                    </div>
                                    <div class="col-lg-3 col-md-6 mt-2 mt-lg-0">
                                        <input type="number" name="cantidad" value="1" placeholder="Cantidad" class="form-control">
                                    </div>
                                    <div class="col-lg-3 col-md-6 mt-2 mt-lg-0">
                                        <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                                    </div>
                                </div>
                                <!-- BotÃ³n para Agregar una venta -->
                                <div class="form-group">
                                    <div class="col-6">
                                        <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info"><i class='bx bxs-cart-download'style="font-size:40px"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="col-lg-8 col-md-6 col-sm-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex col-lg-6 col-md-12 ml-auto">
                                <label>Numero Serie</label>
                                <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                            </div>
                            <br>
                            <table class="table table-hover table-responsive">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>SubTotal</th>
                                        <th class="accion">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${lista}">
                                        <tr id="row-${list.getItem()}">
                                            <td>${list.getItem()}</td>
                                            <td>${list.getIdProducto()}</td>
                                            <td>${list.getDescripcion()}</td>
                                            <td>${list.getPrecio()}</td>
                                            <td>${list.getCantidad()}</td>
                                            <td>${list.getSubtotal()}</td>
                                            <td class="d-flex">
                                                <a class="btn btn-warning" href="Controlador?menu=NuevaVenta&accion=Editar&item=${list.getItem()}"><i class='bx bxs-edit'></i></a>
                                                <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete&id=${list.getItem()}"><i class='bx bxs-trash'></i></a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer d-flex flex-wrap">
                            <div class="col-lg-6 col-md-12 ml-auto">
                                <!-- Botón para Generar Venta con el id agregado que muestra el mensaje de haber realoizado la venta-->
                                <a id="generarVentaBtn" href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                <a href="Controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-danger">Cancelar</a>                              
                            </div>
                            <div class="col-lg-4 col-md-12 ml-auto mt-2 mt-lg-0">
                                <input type="text" name="txtTotal" value=" $/. ${totalPagar}" class="form-control">
                            </div>
                        </div>
                        <!-- Este div definae el Contenedor de alerta 
                        id="alertaVenta": Un identificador único para el contenedor de la alerta, que se usa para manipularlo desde JavaScript.
                        class="alert alert-success alert-dismissible fade show": Clases de Bootstrap que aplican estilos de alerta:
                        alert: Clase básica de alerta.
                        alert-success: Clase para una alerta de tipo éxito (color verde).
                        alert-dismissible: Clase que permite que la alerta se pueda cerrar (desaparecer) mediante un botón.
                        fade y show: Clases que añaden efectos de transición.
                        Venta realizada con éxito.: El mensaje que se muestra dentro de la alerta.

                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">: Un botón para cerrar la alerta.

                        type="button": Define que este es un botón.
                        class="close": Clase de Bootstrap que aplica estilos de cierre.
                        data-dismiss="alert": Atributo de Bootstrap que permite que el botón cierre la alerta automáticamente.
                        aria-label="Close": Atributo de accesibilidad que indica que este botón cierra la alerta.
                        <span aria-hidden="true">&times;</span>: Un elemento span que contiene el símbolo "×", representando el botón de cierre visualmente. aria-hidden="true" oculta este elemento a los lectores de pantalla.
                        -->
                        <div id="alertaVenta" class="alert alert-success alert-dismissible fade show" role="alert" style="display:none;">
                            Venta realizada con éxito.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Incluye los archivos JavaScript de Bootstrap -->
            <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
            <script>
                                    document.getElementById('generarVentaBtn').addEventListener('click', function (event) {
                                        event.preventDefault(); // Evita la acción por defecto del enlace
                                        document.getElementById('alertaVenta').style.display = 'block';
                                        setTimeout(function () {
                                            window.location.href = document.getElementById('generarVentaBtn').href;
                                        }, 2000); // Espera 2 segundos antes de redirigir
                                    });
                                    /*Explicación:
                                     
                                     document.getElementById('generarVentaBtn'): Selecciona el botón con el id="generarVentaBtn".
                                     
                                     .addEventListener('click', function(event) { ... }): Añade un evento de clic a este botón. Cuando se hace clic, se ejecuta la función proporcionada.
                                     
                                     event.preventDefault();: Evita la acción por defecto del enlace (es decir, no redirige inmediatamente al hacer clic).
                                     
                                     document.getElementById('alertaVenta').style.display = 'block';: Cambia el estilo del contenedor de la alerta para que se muestre (display: block).
                                     
                                     setTimeout(function() { ... }, 2000);: Establece un temporizador que espera 2 segundos (2000 milisegundos) antes de ejecutar la función proporcionada.
                                     
                                     window.location.href = document.getElementById('generarVentaBtn').href;: Después de 2 segundos, redirige a la URL original del botón usando window.location.href.
                                     Este script asegura que, al hacer clic en el botón "Generar Venta", primero se muestra la alerta de éxito durante 2 segundos antes de redirigir y proceder con la impresión de la factura.*/
            </script>
    </body>
</html>