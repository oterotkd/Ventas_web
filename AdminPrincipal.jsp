<%-- 
    Document   : Principal
    Created on : 10/05/2024, 3:06:56 p. m.
    Author     : OTEROTKD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Principal</title>
         <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
       <style>
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
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong> ${usuario.getNom()} </strong> Como Administrador Tienes Asceso Total
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
                <h3 class="text-light">Variedades Cindy</h3>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-secondary btn-outline dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${usuario.getNom()}
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end text-center">
                            <li>
                                <a class="dropdown-item active" href="#">
                                    <img src="imagenes Proyecto/usuario.jpg" alt="Usuario" width="70"/>
                                </a>
                            </li>
                            <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                            <li><a class="dropdown-item" href="#">Tel:${usuario.getTel()}</a></li>
                            <li><a class="dropdown-item" href="#">C.C:${usuario.getDni()}</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <form action="Validar" method="post">
                                    <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 550px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none;"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
