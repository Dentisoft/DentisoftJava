<%-- 
    Document   : AuxPac
    Created on : 17/02/2020, 04:59:34 PM
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
                <th scope="col">Documento</th>
                <th scope="col">Nombre</th>
                <th scope="col">Clave</th>
                <th scope="col">Rol</th>
                <th scope="col">Sexo</th>
                <th scope="col">Estado</th>
                <th scope="col">Email</th>
                <th scope="col">Telefono</th>
                <th scope="col">Foto</th>
               
                
            </tr>
            </thead>
            
            <%
            String doc="", fec, odo;
            ArrayList<usuariogetset> listacliente=new ArrayList<>();
            usuariogetset gs=new usuariogetset();
            usuario  consul=new usuario();
            
            listacliente= consul.consultarRol();
            

            for (int i=0; i<listacliente.size();i++){

                gs=listacliente.get(i);
            
            %>
            
            <tr>
                <td><%=gs.getDoc()%></td>
                <td><%=gs.getNom()%></td>
                <td><%=gs.getCla()%></td>
                <td><%=gs.getRol()%></td>
                <td><%=gs.getSex()%></td>
                <td><%=gs.getEst()%></td>
                <td><%=gs.getEma()%></td>
                <td><%=gs.getTel()%></td>
                <td><img style="width: 40px;" src="<%=gs.getFot()%>"> </td>
           
            </tr>
            <%
            }
            %>
        </table>
        <form action="Servletpdf">
                <input type="submit" name="btnpdf" value="Imprimir">
                     </form>
                               
        
                
    </body>
</html>
