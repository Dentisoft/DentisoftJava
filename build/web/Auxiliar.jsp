<%-- 
    Document   : Auxiliar
    Created on : 17/02/2020, 04:42:07 PM
    Author     : Usuario
--%>

<%@page import="modelo.usuario"%>
<%@page import="modelo.usuariogetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/odontologo.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
            <%
            String nom, rol, sex, x, doc, est, cla;
        HttpSession usu=request.getSession(false);
        nom=(String)usu.getAttribute("varsession");
        rol=(String)usu.getAttribute("varsession2");
        sex=(String)usu.getAttribute("varsession1");
        
        
        
        if (sex.equals("femenino"))
        x="Bienvenida";
        else
        x="Bienvenido";
        %>
               
          <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">DENTIDANNA</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">CITAS <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">PACIENTES</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">FACTURA</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">USUARIO</a>
        
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">PQR</a>
      </li>
      
      <li class="nav-item">
          <form action="CerrarSesion" method="POST">
 <input class="btn btn-info btn-lg btn-block" type="submit" name="btncerrar" value="Cerrar Sesion">
          </form>
      </li>
    </ul>
    
  </div>
</nav>
        
        
        
                  <%
            String documento="";
            ArrayList<usuariogetset> listaus=new ArrayList<>();
            usuariogetset us=new usuariogetset();
            usuario consulu=new usuario();
            
            documento=(String)usu.getAttribute("varsession3");
            listaus=consulu.consultarPac(documento);
            
            for (int i=0; i<listaus.size(); i++){ 
                us=listaus.get(i);
            
            %>
            <main>
                <section class="contenedor sobre-nosotros">
                    <div class="contenedor-sobre-nosotros">
                       <div  class="imagen-about-as">
        <div id="menu" class="sidemenu"> 
            <center>
            <a href="#"><%= x %> <%= nom%></a>
            <hr>

            <img class="rounded-circle"  src="css/perfil.jpg"> <br>
            
            <!-- src="<%=us.getFot()%>" -->
            <p class="h5"><%=us.getEma()%></p><br>
            <p class="h5">Id:<%=us.getDoc()%></p>
            <p class="h5">Rol:<%=us.getRol()%></p>
            <p class="h5">Estado:<%=us.getEst()%></p>
            <p class="h5">Tel:<%=us.getTel()%></p><br>
                 </center>
                 <%}%>
        </div>
        </div> 
        
        
        
        
        
        
        
<!--                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>

            <form action="ServletAux" method="POST">
            <input type="submit" class="btn btn-outline-light ml-5" name="citas"  value="Citas">
            <input type="submit" class="btn btn-outline-light ml-5" name="pacientes"  value="Paciente">
            <input type="submit" class="btn btn-outline-light ml-5" name="factura"  value="Factura">
            <input type="submit" class="btn btn-outline-light ml-5" name="usuario"  value="Usuario">
            <input type="submit" class="btn btn-outline-light ml-5" name="quejasrecla"  value="Quejas y reclamos">
        </form>
        
            
            <form action="CerrarSesion" method="POST" class="form-inline my-2 my-lg-0">
                        <input class="btn btn-outline-light ml-5" type="submit" name="btncerrar" value="Cerrar Sesion">
                    </form>
            
          </nav> -->
       
        
    </div>
    </body>
</html>
