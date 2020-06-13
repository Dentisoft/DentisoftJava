<%-- 
    Document   : dientes
    Created on : 22/04/2020, 10:52:37 PM
    Author     : HP
--%>



<%@page import="modelo.diente"%>
<%@page import="modelo.dientegetset"%>
<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
<%@page import="modelo.paciente"%>
<%@page import="modelo.pacientegetset"%>
<%@page import="java.util.ArrayList"%>
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
                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form method="POST">
            <input type="submit" class="btn btn-outline-light ml-5" name="nuevo"  value="Insertar nuevo">
    
            <input type="submit" class="btn btn-outline-light ml-5" name="todos" value="Ver todos">
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
        
            
           
            </form>
          </nav>   
        
        
    <table class="table table-dark">
            <thead class="thead">
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Nombre</th>
                <th scope="col">Imagen</th>
                <th scope="col">Estado</th>
                <th scope="col">tip</th>
                
               
                
            </tr>
            </thead>
            <%
            
            ArrayList<dientegetset> die=new ArrayList<>();
            dientegetset gm=new dientegetset();
            diente gss=new diente();
            
            die=gss.consultar();
            
             
          for (int e=0; e<die.size();e++){
                    gm=die.get(e);
                
                 
                %>
               
            <tr>
                <td><%=gm.getCod()%></td>
                <td><%=gm.getNom()%></td>
                <td><%=gm.getIma()%></td>
                <td><%=gm.getEst()%></td>
                <td><%=gm.getTip()%></td>
                
                
            <form action="ServletOdo" method="POST">
                <input type="hidden" name="cod" value="<%=gm.getCod()%>">
             
                
            </form>
            </tr>
                
                
                
                
                
            <%
            }
            %>
        </table>
         
    
    </body>
</html>

