<%-- 
    Document   : OdoCalendario
    Created on : 19/02/2020, 09:38:13 PM
    Author     : Usuario
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flores del Hato</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/Estilos.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <% String odo;
        HttpSession cli=request.getSession(false);
        
        odo = (String)cli.getAttribute("varsession3");
        
        
        %>
        
                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form  method="POST">
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>
            
          </nav>
     
        <form action="ServletOdo" method="POST" class="Content">
            
            <input type="hidden" value="null" name="doc">
            
            <div class="form-group">
            <label>Doocumento odontologo: <%=odo%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="odo" value="<%=odo%>"required="">
            </div>
            
            
            <div class="form-group">
            <label>Fecha:</label>
            <input class="form-control" id="exampleInputEmail1" type="date" min="" name="fec" required="">
            </div>
            
            
            
            
            <div class="form-group">
            <label>Hora:</label>
            <input class="form-control" id="exampleInputEmail1" type="text" name="hor" required="">
            </div>
            
            <input type="hidden" value="disponible" maxlength="8" name="est">
            <button type="submit" class="btn btn-primary btn-block" name="hor">Aceptar</button>
            
            
            
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form action="ServletOdo" method="POST">
            <input type="submit" class="btn btn-outline-light ml-5" name="cita" value="Citas programadas">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="pacientes" value="Paciente">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="horario" value="Crear agenda">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="diagnostico" value="Diagnostico">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="tratamiento" value="Tratamiento">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="procedimiento" value="Procedimiento">

            </form>
             <form action="CerrarSesion" method="POST" class="form-inline my-2 my-lg-0">
                        <input class="btn btn-outline-light ml-5" type="submit" name="btncerrar" value="Cerrar Sesion">
                    </form>
        </nav>
            .sidemenu{
        
    
        margin-left:50px;
        height: 50%;
        width: 450px;
        background-color: transparent;
         border:white 3px solid;
        padding-top: 150px;
         margin-top: 150px;
  
    }
            
        </form>
         </div>
    </body>
</html>
