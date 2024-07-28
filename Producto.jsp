<%-- 
    Document   : Producto
    Created on : 11/05/2024, 3:06:36 p. m.
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
        <title>Productos</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="card col-lg-3 col-md-4 col-sm-12 mb-3">
                    <div class="card-body">
                        <form action="Controlador?menu=Producto" method="POST">
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" value="${producto.getNom()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${producto.getPre()}" name="txtPre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>                
                    </div>
                </div>
                <div class="col-lg-9 col-md-8 col-sm-12">
                    <table class="table table-hover table-responsive">
                        <thead>                       
                            <tr>
                                <th>I.D</th>
                                <th>NOMBRES</th>
                                <th>PRECIO</th>
                                <th>STOCK</th> 
                                <th>ESTADO</th>                          
                                <th>ACCIONES</th>
                            </tr>                      
                        </thead>
                        <tbody>
                            <c:forEach var="pro" items="${productos}">                     
                                <tr>
                                    <td>${pro.getIdProducto()}</td>
                                    <td>${pro.getNom()}</td>
                                    <td>${pro.getPre()}</td>
                                    <td>${pro.getStock()}</td>
                                    <td>${pro.getEstado()}</td>                                
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pro.getIdProducto()}"><i class='bx bxs-edit'></i></a>
                                        <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pro.getIdProducto()}"><i class='bx bxs-trash'></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Incluye los archivos JavaScript de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
