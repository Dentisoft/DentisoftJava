<%-- 
    Document   : AuxUsu
    Created on : 17/02/2020, 09:44:56 PM
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
        <link rel="stylesheet" href="css/Estilos_1.css">
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

            <form  method="POST">
            <a href="AuxFac.jsp" class="btn btn-outline-light ml-5">Factura</a>
     
            <a href="Auxiliar.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>
        
            
           
            
          </nav> 
        
  
        
        <form id="InsertarPac" enctype="multipart/form-data" class="Content">
            
            <div class="form-group">
            <label>Documento:</label>
            <input class="form-control" id="doc" type="number" maxlength="10" name="doc"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control" id="nom" type="text"  name="nom"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Clave:</label>
            <input class="form-control" id="cla" type="password" name="cla"  required="">
            </div>
            
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Rol:</label>
            <select class="form-control" id="rol" name="rol">
                <option value="paciente">Paciente</option>
                <option value="odontologo">Odontologo</option>
                <option value="auxiliar">Auxiliar</option>
            </select>
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Sexo:</label>
            <select class="form-control" id="sex" name="sex">
                <option value="femenino">Femenino</option>
                <option value="masculino">Masculino</option>
                
            </select>
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Estado:</label>
            <select class="form-control" id="est" name="est">
                <option value="activo">Activo</option>
                <option value="inactivo">Inactivo</option>
            </select>
            </div>
            
            
            
            <div class="form-group">
            <label>Email:</label>
            <input class="form-control" id="ema" type="email" name="ema"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Telefono:</label>
            <input class="form-control" id="tel" type="text" maxlength="11" name="tel"  required="">
            </div>
            
            
            
            <!--<div class="form-group">
            <label>Foto:</label>
            <input class="form-control" id="exampleInputEmail1" value="foto" type="file" accept="image/*" name="fot"  required="">
            </div>
            -->
                        <input class="form-control" id="foto" value="foto" type="hidden" accept="image/*" name="fot"  required="">
            <button type="submit" class="btn btn-primary btn-block" name="insertar">Aceptar</button>
            
                
        </form>
        
        
        <table class="table table-dark" id="res">
            
                
                
        </table>
        

        
        <%
        if (request.getParameter("nuevo")!=null){
        %>
        <div class="seccion1 col-5"> 
        <form action="ServletAux" method="POST" enctype="multipart/form-data" class="Content">
            
            <div class="form-group">
            <label>Documento:</label>
            <input class="form-control" id="exampleInputEmail1" type="number" maxlength="10" name="doc"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control" id="exampleInputEmail1" type="text"  name="nom"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Clave:</label>
            <input class="form-control" id="exampleInputEmail1" type="password" name="cla"  required="">
            </div>
            
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Rol:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="rol">
                <option value="paciente">Paciente</option>
                <option value="odontologo">Odontologo</option>
                <option value="auxiliar">Auxiliar</option>
            </select>
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Sexo:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="sex">
                <option value="femenino">Femenino</option>
                <option value="masculino">Masculino</option>
                
            </select>
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Estado:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="est">
                <option value="activo">Activo</option>
                <option value="inactivo">Inactivo</option>
            </select>
            </div>
            
            
            
            <div class="form-group">
            <label>Email:</label>
            <input class="form-control" id="exampleInputEmail1" type="email" name="ema"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Telefono:</label>
            <input class="form-control" id="exampleInputEmail1" type="text" maxlength="11" name="tel"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Foto:</label>
            <input class="form-control" id="exampleInputEmail1" type="file" accept="image/*" name="fot"  required="">
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" name="insertar">Aceptar</button>
            
                
        </form>
        </div>
        
        <%}%>
        <script src="http://public.nygsst.com/assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="text/javascript" src="http://public.nygsst.com/js/jquery.dataTables.min.js" ></script> <!-- BLOQUEO PANTALLA -->
        <script src="js/Consultausuarios.js"></script>
         <script src="js/InsertaUsuario.js"></script>
    </body>
    
</html>
