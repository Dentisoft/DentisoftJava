<%-- 
    Document   : OdoTrat2
    Created on : 19/02/2020, 03:15:47 PM
    Author     : Usuario
--%>

<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
<%@page import="modelo.tratamiento"%>
<%@page import="modelo.tratamientogetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
        
            
           
            </form>
            
        </nav>
        
         <% String cod, diag, dur, des, nom;
        HttpSession cli=request.getSession(false);
        diag = (String)cli.getAttribute("servletDia");
        dur = (String)cli.getAttribute("ServletDur");
        cod = (String)cli.getAttribute("ServletCod");
        nom = (String)cli.getAttribute("ServletNom");
        des = (String)cli.getAttribute("ServletDes");
        
        
        
        
        %>
        
        <div class="seccion1 col-5"> 
                <form action="ServletOdo" method="POST" class="Content">
                    
                    <div class="form-group">
            <label>Codigo: <%=cod%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="cod" value="<%=cod%>"
                   required="">
            </div>
                    
                    
            <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo diagnostico:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="dia">
                
                <option value="<%=diag%>"><%=diag%></option>
                 <%
                ArrayList<diagnosticogetset> lista=new ArrayList<>();
                diagnosticogetset gs=new diagnosticogetset();
                diagnostico gss=new diagnostico();
                lista=gss.consultar();
                
                for (int i=0; i<lista.size(); i++){
                    
                
                
                %>
                
                <option value="<%=gs.getCod()%>"><%=gs.getCod()%></option>
                
                <%}%>
            </select>
            </div>
            
            
            
            <div class="form-group">
            <label>Duracion:</label>
            <input class="form-control" id="exampleInputEmail1" type="text" value="<%=dur%>"   maxlength="10" name="dur"  required="">
            </div>
            
            
   
            <div class="form-group">
            <label>Descripcion:</label>
            <input class="form-control" id="exampleInputEmail1" value="<%=des%>"  type="text"  maxlength="200" name="des"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control" id="exampleInputEmail1" value="<%=nom%>" type="text"   name="nom"  required="">
            </div>
            
            
            <button type="submit" class="btn btn-primary btn-block" name="trat3">Aceptar</button>
            
        </form>
        </div>
    </body>
</html>
