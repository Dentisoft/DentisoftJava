
<%@page import="modelo.procedimiento"%>
<%@page import="modelo.procedimientogetset"%>
<%@page import="modelo.factura"%>
<%@page import="modelo.facturagetset"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : AuxFac
    Created on : 17/02/2020, 05:09:11 PM
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
                   <script src="js/ConsultarFacturas.js"></script>
             <script src=\"js/ActualizarFacturas.js\"></script>
         <%
            String nom, rol, sex, x, doc, est, cla;
        HttpSession usu=request.getSession(false);
        nom=(String)usu.getAttribute("varsession");
        cla=(String)usu.getAttribute("varsessioncla");
        
        
         %>
    </head>
    <body>
                                        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>

           <form action="" method="POST">
        <a href="AuxUsu.jsp" class="btn btn-outline-light ml-5">Usuarios</a>  
 
        <a href="Auxiliar.jsp" class="btn btn-outline-light ml-5">Volver</a>
                  
        
             </form>
                                               <form action="Servletpdf">
               <input type="hidden" name="nom" value="<%=nom%>"> 
                <input type="submit" name="btnpdf"  class="btn btn-outline-light ml-5" value="VER">
                    
                                        
        </form>
                                            </nav>
        
      <table class="table table-dark" id="res">
            
                
  

                            </table>
                                            
        
       
       
        <div class="seccion1 col-5"> 
        <form id="InsertarFac"  class="Content">
            <h3>Nueva factura</h3>
            
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo procedimiento:</label>
            <select class="form-control" id="Docp" name="pro">
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
            <input type="date" class="form-control" id="fec" name="fec" placeholder="Clave" required="">
            </div>
            
            
            <div class="form-group">
            <input type="number" class="form-control" id="val" name="val" placeholder="Valor" required="">
            </div>
            
            <div class="form-group">
            <input  maxlength="200" type="text" class="form-control" id="des" name="des" placeholder="Descripcion" required="">
            </div>
            
            
            <button type="submit" class="btn btn-primary btn-block" name="enviar">Aceptar</button>
            
                
        </form>
        </div>
        
    
        
        
                  


        
    </body>
</html>
