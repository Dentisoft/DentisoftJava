<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Dentisoft</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/EstilosL.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <a type="button" class="btn btn-primary ml-5" href="">
               Inicio
            </a>
            <div class="btn-group" role="group">
              <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle ml-5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Quienes somos
                </button>
              <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <a class="dropdown-item" href="#">Dropdown link</a>
                <a class="dropdown-item" href="#">Dropdown link</a>
              </div>
            </div>
          </div>
             <a type="button" class="btn btn-primary ml-5" href="">
               Instalaciones
            </a>
            <div class="btn-group" role="group">
              <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle ml-5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Tratamientos
                </button>
              <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <a class="dropdown-item" href="#">Dropdown link</a>
                <a class="dropdown-item" href="#">Dropdown link</a>
              </div>
            </div>
          </div>
            <a type="button" class="btn btn-primary ml-5" href="">
               Contactenos
            </a>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              </form>
            </div>
             <a type="button" class="btn btn-outline-light " href="index.jsp">
               Regresar
            </a>
          </nav>
      <div class=" seccion1 col-3">     
          <form action="ServletLogin" method="POST" class="Content" >
              <h3>Iniciar sesion</h3>
            <div class="form-group">
                <input type="text" class="form-control" id="exampleInputEmail1" name="usu" placeholder="Usuario" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="exampleInputPassword1" name="con" placeholder="Contraseña" required="">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Recuérdame</label>
            </div>
              <button type="submit" class="btn btn-primary btn-block" name="btnlogin">Ingresar</button>
                <h6 class="text-muted">Contacto</h6>
                <img src="css/facebook.png" class="rounded mx-auto d-block" alt="...">
                <img src="css/w.png" class="rounded mx-auto d-block mt-2" alt="...">
          </form>
      </div>
      
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
    </body>
</html>
