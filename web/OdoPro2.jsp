<%-- 
    Document   : OdoPro2
    Created on : 19/02/2020, 09:19:49 PM
    Author     : Usuario
--%>

<%@page import="modelo.tratamiento"%>
<%@page import="modelo.tratamientogetset"%>
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
        
            <% String cod, tra, des, nom, dur;
        HttpSession cli=request.getSession(false);
        cod = (String)cli.getAttribute("servletCod");
        tra = (String)cli.getAttribute("ServletTra");
        des = (String)cli.getAttribute("ServletDes");
        nom = (String)cli.getAttribute("ServletNom");
        dur = (String)cli.getAttribute("ServletDur");
        
        
        
        
        %>
        
                    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
                        <form method="POST">
            
            <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>
        
            
           
            </form>
            
          </nav> 
        
        
        
        <div class="seccion1 col-5"> 
                <form action="ServletOdo" method="POST" class="Content">
            
            <div class="form-group">
            <label>Codigo: <%=cod%> </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=cod%>" type="hidden" name="cod"  required="">
            </div>
            
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo tratamiento:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="tra">
                <option value="<%=tra%>"><%=tra%></option>
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
            <input class="form-control" id="exampleInputEmail1" value="<%=des%>" type="text"  maxlength="200" name="des"  required="">
            </div>
            
            
        
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control" id="exampleInputEmail1" value="<%=nom%>" type="text"  name="nom"  required="">
            </div>
            

            <div class="form-group">
            <label>Duracion:</label>
            <input class="form-control" id="exampleInputEmail1" value="<%=dur%>" type="text" maxlength="10" name="dur"  required="">
            </div>
            
            
            <button type="submit" class="btn btn-primary btn-block" name="pro3">Aceptar</button>
            
        </form>
        </div>
    </body>
</html>
