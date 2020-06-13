<%-- 
    Document   : OdoPro
    Created on : 19/02/2020, 08:38:11 PM
    Author     : Usuario
--%>

<%@page import="modelo.procedimiento"%>
<%@page import="modelo.procedimientogetset"%>
<%@page import="modelo.tratamiento"%>
<%@page import="modelo.tratamientogetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DentiSoft</title>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/GestionProJson.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/Estilos.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <script src="js/ConsultaPro.js"></script>
     
    </head>
    <body>
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form method="POST">
    
         
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
                    <a href="OdoTrat.jsp" class="btn btn-outline-light ml-5">Tratamiento</a>
           <a href="OdoDiagno.jsp" class="btn btn-outline-light ml-5">Diagnostico</a>  
           
            </form>
          </nav>                
        
                        <table class="table table-dark" id="res">
            
                            </table>
       
        <div class="seccion1 col-5"> 
            <form method="POST" action="" class="Content">
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo tratamiento:</label>
            <select class="form-control  codtrat" id="codtrat"  name="tra">
                <%
                ArrayList<tratamientogetset> lista=new ArrayList<>();
                tratamientogetset gs=new tratamientogetset();
                tratamiento gss=new tratamiento();
                lista=gss.consultar();
                
                for (int i=0; i<lista.size(); i++){
                    gs=lista.get(i);
                
                
                %>
                
                <option value="<%=gs.getCod()%>"><%=gs.getCod()%></option>
                
                <%}%>
            </select>
            </div>
            
            
            <div class="form-group">
            <label>Descripcion:</label>
            <input class="form-control  descrip" id="descrip" type="text"  maxlength="200" name="des"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control  nombre" id="nombre" type="text"  name="nom"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Duracion:</label>
            <input class="form-control  dura" id="dura" type="text" maxlength="10" name="dur"  required="">
            </div>
            <button type="button" id="btnPro" class="btn btn-primary btn-block btnPro" name="btnPro">Aceptar</button>
            
        </form>
        </div>
            
         
             
                                         
             
                
         
    </body>
</html>
