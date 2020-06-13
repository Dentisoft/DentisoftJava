<%-- 
    Document   : AuxQueja2
    Created on : 12/04/2020, 01:05:04 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String  cod;
        HttpSession cli=request.getSession(false); 
        cod = (String)cli.getAttribute("ServletCod");
        %>
        
        
        <div class="seccion1 col-5">
        <form action="ServletAux" method="POST" class="Content">
            
            
            <div class="form-group">
            <label>Codigo: <%=cod%></label>
            <input type="hidden" class="form-control" id="exampleInputEmail1" name="cod" value="<%=cod%>"  required="">
            </div>
            

            <div class="form-group">
            <label>Respuesta:</label>
            <input class="form-control" id="exampleInputEmail1" type="text"   name="res" required="">
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" name="responder2">Aceptar</button>
            
                
        </form>
            </div>
    </body>
</html>
