<%-- 
    Document   : index
    Created on : 10/05/2024, 3:02:28 p. m.
    Author     : OTEROTKD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Index</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            /*este codigo pone una imagen en el fondo de la pantalla y centra la card*/

            .card-center {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">                   
                    <img class="d-block w-100"src="imagenes Proyecto/bags-8741237_1280.png" alt=""/>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"src="imagenes Proyecto/shopping-2616824_1920.jpg" alt=""/>
                </div>              
                <div class="carousel-item">
                    <img class="d-block w-100" src="imagenes Proyecto/e-commerce-3228418_1280.jpg" alt=""/>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="imagenes Proyecto/ecommerce-3530785_1280.jpg" alt=""/>
                </div>
            </div>
        </div>
        <div class="container card-center card-img-overlay">
            <!-- En este caso:   
                En pantallas grandes (lg), el elemento ocupará 4 de las 12 columnas.
                En pantallas medianas (md), el elemento ocupará 6 de las 12 columnas.
                En pantallas pequeñas (sm), el elemento ocupará 10 de las 12 columnas.
                Esto permite que el diseño sea completamente responsivo y se adapte 
                adecuadamente a diferentes tamaños de pantalla.
            -->
            <div class="card col-lg-4 col-md-4 col-sm-8">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="post">
                        <div class="form-group text-center">
                            <img src="imagenes Proyecto/VariedadesCindy.jpeg" alt="70" width="170"/>
                            <h5>Variedades Cindy</h5>
                        </div>
                        <div class="form-group">
                            <h5>Usuario</h5>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <h5>Password</h5>
                            <input type="password" name="txtpassword" class="form-control">                            
                        </div>
                        <div class="d-grid gap-2 mt-4">
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">

                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
