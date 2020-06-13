<%-- 
    Document   : OdoDiag
    Created on : 17/02/2020, 12:17:14 AM
    Author     : Lucho
--%>

<%@page import="modelo.procedimiento"%>
<%@page import="modelo.procedimientogetset"%>
<%@page import="modelo.tratamiento"%>
<%@page import="modelo.tratamientogetset"%>
<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentisoft</title>
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
            <form  method="POST">
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>
                        </nav>
        
        
    <div class="card col-9 border-primary">
       <h1>DIAGNOSTICO</h1>
           <table class="table table-dark">
            <thead class="thead">
            <tr>
                
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Fecha</th>
                <th scope="col">Descripcion</th>
                
            </tr>
            </thead>
            <%
            String doc;
            ArrayList<diagnosticogetset> listalin=new ArrayList<>();
            diagnosticogetset gs=new diagnosticogetset();
            diagnostico consul=new diagnostico();
            HttpSession tra=request.getSession(false);
            doc=(String)tra.getAttribute("paciente");
            listalin=consul.consultarPac(doc);

            for (int i=0; i<listalin.size(); i++){
                gs=listalin.get(i);
            
            %>
            
            
            <tr>
                
                <td><%=gs.getCod()%></td>
                <td><%=gs.getDpa()%></td>
                <td><%=gs.getFec()%></td>
                <td><%=gs.getDes()%></td>
                
            </tr>
            <%}%>
            
        </table>
    </div>   
    <div class="card border-primary col-9">        
            <h1>TRATAMIENTO</h1>
           <table class="table table-dark">
            <thead class="thead">
            <tr>
                
                <th scope="col">Codigo</th>
                <th scope="col">Codigo Diagnostico</th>
                <th scope="col">Duracion</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Nombre</th>
                
            </tr>
            </thead>
            <%
            
            ArrayList<tratamientogetset> lista=new ArrayList<>();
            tratamientogetset ss=new tratamientogetset();
            tratamiento con=new tratamiento();
            doc=(String)tra.getAttribute("paciente");
            lista=con.consultarPac(doc);

            for (int i=0; i<lista.size(); i++){
                ss=lista.get(i);
            
            %>
            
            
            <tr>
                
                <td><%=ss.getCod()%></td>
                <td><%=ss.getCdi()%></td>
                <td><%=ss.getDur()%></td>
                <td><%=ss.getDes()%></td>
                <td><%=ss.getNom()%></td>
                
            </tr>
            <%}%>
            
        </table>
    </div>   
    <div class="card border-primary col-9">        
            <h1>PROCEDIMIENTO</h1>
            <table class="table table-dark">
            <thead class="thead">
            <tr>
                
                <th scope="col">Codigo</th>
                <th scope="col">Codigo Tratamiento</th>
                <th scope="col">Duracion</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Nombre</th>
                
            </tr>
            </thead>
            <%
            
            ArrayList<procedimientogetset> list=new ArrayList<>();
            procedimientogetset tt=new procedimientogetset();
            procedimiento conn=new procedimiento();
            doc=(String)tra.getAttribute("paciente");
            list=conn.consultarPac(doc);
            
            for (int i=0; i<list.size(); i++){
                tt=list.get(i);
            
            %>
            
            
            <tr>
                
                <td><%=tt.getCod()%></td>
                <td><%=tt.getCtr()%></td>
                <td><%=tt.getDur()%></td>
                <td><%=tt.getDes()%></td>
                <td><%=tt.getNom()%></td>
                
            </tr>
            <%}%>
        </table>
    </div>
    </body>
</html>
