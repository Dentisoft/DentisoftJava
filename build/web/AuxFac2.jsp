

<%@page import="modelo.procedimiento"%>
<%@page import="modelo.procedimientogetset"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : AuxFac2
    Created on : 17/02/2020, 09:11:50 PM
    Author     : Usuario
--%>

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
        
        
        
        
         <% String fec, cod, pro, val, des;
        HttpSession cli=request.getSession(false);
        fec = (String)cli.getAttribute("servletFecha");
        pro = (String)cli.getAttribute("ServletPro");
        cod = (String)cli.getAttribute("ServletCod");
        val = (String)cli.getAttribute("ServletVal");
        des = (String)cli.getAttribute("ServletDes");
        
        
        
        
        %>
        
                                                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form action="ServletAux" method="POST">
                <a href="Auxiliar.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>

          
        
            
           
            
          </nav>
        <div class="seccion1 col-5">
        <form action="ServletAux" method="POST" class="Content">
            
            
            <div class="form-group">
            <label>Codigo: <%=cod%></label>
            <input type="hidden" class="form-control" id="exampleInputEmail1" name="cod" value="<%=cod%>"  required="">
            </div>
            
            
           <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo procedimiento:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="pro">
                <option value="<%=pro%>"><%=pro%></option>
                <%
            
            ArrayList<procedimientogetset> listacliente=new ArrayList<>();
            procedimientogetset ss=new procedimientogetset();
            procedimiento consul=new procedimiento();
            
            listacliente= consul.consultar();
            

            for (int i=0; i<listacliente.size();i++){

                ss=listacliente.get(i);
            
            %>
            
            <option value="<%=ss.getCod()%>"><%=ss.getCod()%></option>
            
            <%}%>
            </select>
           </div>
            
            
            <div class="form-group">
            <label>Fecha:</label>
            <input type="date" class="form-control" id="exampleInputEmail1" name="fec" value="<%=fec%>"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Valor:</label>
            <input type="number" class="form-control" id="exampleInputEmail1" name="val" value="<%=val%>"  required="">
            </div>
            

            <div class="form-group">
            <label>Descripcion:</label>
            <input class="form-control" id="exampleInputEmail1" type="text"  maxlength="200" name="des" value="<%=des%>"  required="">
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" name="actu">Aceptar</button>
            
                
        </form>
            </div>
    </body>
</html>
