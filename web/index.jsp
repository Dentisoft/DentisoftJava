<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Dentisoft</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
           <link rel="stylesheet" href="css/indexd.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
           
    </head>
    <body>
   
           
                  
       <nav id="nava" class="navbar navbar-expand-lg navbar-light fixed-top">
  <a class="navbar-brand" href="#">DentiDanna</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">INICIO <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">CONOCENOS</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         NUESTROS SERVICIOS
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" tabindex="-1" >CONTACTANOS</a>
      </li>
    </ul>
   
  </div>
</nav>
            
            <header> 
               
               <div id="mainbox" onclick="openFunction()">&#9776;Iniciar sesion</div>
                 <header>
        <div id="menu" class="sidemenu">
            <div id="login" >     
          <form action="ServletLogin" method="POST" class="Content" >
              <h3>Iniciar sesion</h3>
            <div class="form-group">
                <input type="text" class="form-control" id="exampleInputEmail1" name="usu" placeholder="&#129492; Usuario" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="exampleInputPassword1" name="con" placeholder="&#128272; Contraseña" required="">
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
            <a href="#" class="closebtn" onclick="closeFunction()">&times;</a>
        </div>
                
            <section class="textos-header">
                <h1>Tu sonrisa <br>es nuestro mejor regalo</h1>
                <h2>Aprovecha nuestros servicios</h2>
            </section>
            <div class="wave" style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M-1.41,4.45 C-134.02,361.67 381.20,143.58 500.27,152.45 L504.22,-1.47 L249.15,109.03 Z" style="stroke: none; fill: #fff;"></path></svg></div>
    </header>
        
        <img class="imalog"src="ima/logo.jpg" class="rounded float-left" alt="...">
     
    
    
    
     

        </header>   
        
        
       
    
</div>
   
        <script type="text/javascript">
            function openFunction(){
                document.getElementById("menu").style.width="500px";
                document.getElementById("mainbox").style.marginLeft="10%";
               
                document.getElementById("mainbox").innerHTML="&#9776";
            }
            function closeFunction(){
                document.getElementById("menu").style.width="0px";
                document.getElementById("mainbox").style.marginLeft="10%";
              
                document.getElementById("mainbox").innerHTML="&#9776;Iniciar sesion";
                document.getElementById("mainbox").style.color="white";
            }
        </script>
        
      
      
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
     
        <script type="text/javascript">
            $(window).scroll(function(){
                if ($("#nava").offset().top > 56){
                    $("#nava").addClass("bg-inverse");
                }else{
                    $("#nava").removeClass("bg-inverse");
                }
            });
            
            </script>
    </body>
</html>
