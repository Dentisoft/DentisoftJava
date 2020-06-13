<%-- 
    Document   : AuxQueja
    Created on : 12/04/2020, 12:55:16 PM
    Author     : Usuario
--%>

<%@page import="modelo.quejas"%>
<%@page import="modelo.quejasgetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DentiSoft</title>
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

            <form action="ServletAux" method="POST">
            <input type="submit" class="btn btn-outline-light ml-5" name="citas"  value="Citas">
            <input type="submit" class="btn btn-outline-light ml-5" name="pacientes"  value="Paciente">
            <input type="submit" class="btn btn-outline-light ml-5" name="factura"  value="Factura">
            <input type="submit" class="btn btn-outline-light ml-5" name="usuario"  value="Usuario">
        </form>
        
            
           
            
          </nav> 
        
                            <table class="table table-dark">
            <thead class="thead">
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Documento Odotologo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Estado</th>
                
               
                
            </tr>
            </thead>
            
            <%
            
            ArrayList<quejasgetset> listacliente=new ArrayList<>();
            quejasgetset gs=new quejasgetset();
            quejas consul=new quejas();
            listacliente= consul.NoRespondidos();
            

            for (int i=0; i<listacliente.size();i++){

                gs=listacliente.get(i);
            
            %>
            
            <tr>
                <td><%=gs.getId()%></td>
               <td><%=gs.getPac()%></td>
                <td><%=gs.getOdo()%></td>
                <td><%=gs.getFec()%></td>
                <td><%=gs.getDes()%></td>
                <form action="ServletAux" method="POST">
                    <input type="hidden" name="cod" value="<%=gs.getId()%>">
                <td><input type="submit" name="responder" value="Responder"></td>
                </form>
            
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
