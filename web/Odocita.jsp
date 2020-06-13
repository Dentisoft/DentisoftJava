<%-- 
    Document   : Odocita
    Created on : 16/02/2020, 11:29:52 PM
    Author     : Lucho
--%>

<%@page import="modelo.cita"%>
<%@page import="modelo.citagetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/GestionOdoCita.js" type="text/javascript"></script>
        
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/Estilos.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form action="" method="POST">
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
            
           
            </form>
            
        </nav>
    
    
    <body>
                 <div class="card col-9">

        <table  class="table table-dark">
            <thead class="thead">
        <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Documento Odotologo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Hora</th>
                <th scope="col">Estado</th>
                <th scope="col">Cancelar</th>
                <th scope="col">Historial</th>
                
               
                
            </tr>
            </thead>
       <%
                  ArrayList<citagetset> listacit=new ArrayList<>();
                  citagetset ci=new citagetset();
                  cita cit=new cita();
                  listacit=cit.consultarOcu();
                  
                  for (int i=0; i<listacit.size(); i++){
                  ci=listacit.get(i);
                  
                %>
                
                <tr>
                <td><%=ci.getCod()%></td>
                <td><%=ci.getDpa()%></td>
                <td><%=ci.getDod()%></td>
                <td><%=ci.getFec()%></td>
                <td><%=ci.getHor()%></td>
                <td><%=ci.getEst()%></td>
                
            <form action="ServletPac" method="POST">
                <input type="hidden" name="cod" value="<%=ci.getCod()%>">
                <td><input type="submit" name="borrarCit" value="Cancelar"></td>
                
            </form>
                <form action="ServletOdo" method="POST">
                <input type="hidden" name="dpa" value="<%=ci.getDpa()%>">
                <td><input type="submit" name="historial" value="ver historial"></td>
                
            </form>
            </tr>
            
            
            
            <%
                  }
                  %>
                
        </table>   
                 </div>
                  
                  
           <table id="contenedor">
                
            </table>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
    </body>
</html>
