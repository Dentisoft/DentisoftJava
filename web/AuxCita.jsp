<%-- 
    Document   : AuxCita
    Created on : 17/02/2020, 04:54:04 PM
    Author     : Usuario
--%>

<%@page import="modelo.cita"%>
<%@page import="modelo.citagetset"%>
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
                <a href="Auxiliar.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>

           
        
            
           
            
          </nav> 
                    <table class="table table-dark">
            <thead class="thead">
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Documento Odotologo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Hora</th>
                <th scope="col">Estado</th>
                
               
                
            </tr>
            </thead>
            
            <%
            String doc="", fec, odo;
            ArrayList<citagetset> listacliente=new ArrayList<>();
            citagetset gs=new citagetset();
            cita  consul=new cita();
            listacliente= consul.consultar();
            

            for (int i=0; i<listacliente.size();i++){

                gs=listacliente.get(i);
            
            %>
            
            <tr>
                <td><%=gs.getCod()%></td>
               <td><%=gs.getDpa()%></td>
                <td><%=gs.getDod()%></td>
                <td><%=gs.getFec()%></td>
                <td><%=gs.getHor()%></td>
                <td><%=gs.getEst()%></td>
            
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
