<%-- 
    Document   : Odopac
    Created on : 17/02/2020, 12:08:20 AM
    Author     : Lucho
--%>

<%@page import="modelo.paciente"%>
<%@page import="modelo.pacientegetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flores del Hato</title>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/ConsulOdoPac.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/Estilos.css">
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
            <form action="" method="POST">
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
            <input type="button" class="consul" id="consul"  name="boton"  value="Consultar">
            
           
            </form>
            
            
          </nav>
        
        
                  <table  style="width:80%; margin-top: 5%;margin-left: 10%; "class="table table-dark" id="contenedor">
                      <thead class="thead"></thead>
                  </table>  
        
    </body>
</html>
