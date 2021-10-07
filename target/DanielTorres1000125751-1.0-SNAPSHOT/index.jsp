<%-- 
    Document   : index
    Created on : 2/09/2021, 09:39:34 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>Taller java web</title>
    </head>
    <body>
        <h1>Aqui va un control de acceso</h1>
        <div class="card col-sm-4">
            <div class="card-body">
                <form>
                    <div class="form-group text-center">
                        <p><strong>Bienvenidos al sistema de login</strong></p>
                    </div>
                    <div class="form-group">
                        <label>Nombre Usuario</label>
                        <input class="form-control" type="text" name="txtnombre_usu" required>
                    </div>
                    <div class="form-group">
                        <label>Clave Usuario</label>
                        <input class="form-control" type="password" name="txtclave_usu" required>
                    </div>

                    <input class="btn btn-success" type="submit" name="accion" value="ingresar">
                </form>
            </div>    
        </div>
        
        <a href="ProductoCTO?accion=Listar">Productos</a>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    </body>
</html>
