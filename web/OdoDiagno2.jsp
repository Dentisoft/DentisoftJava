<%-- 
    Document   : OdoDiagno2
    Created on : 19/02/2020, 08:00:02 PM
    Author     : Usuario
--%>

<%@page import="modelo.diente"%>
<%@page import="modelo.dientegetset"%>
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
           <% String cod, doc, fec, des;
        HttpSession cli=request.getSession(false);
        cod = (String)cli.getAttribute("servletCod");
        doc = (String)cli.getAttribute("ServletDoc");
        fec = (String)cli.getAttribute("ServletFec");

        des = (String)cli.getAttribute("ServletDes");
        
        
        
        
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
            <input class="form-control" id="exampleInputEmail1" value="<%=cod%>" type="hidden" name="cod" required="">
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Paciente:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="doc">
                <option value="<%=doc%>"><%=doc%></option>
                <%
                ArrayList<pacientegetset> lista=new ArrayList<>();
                pacientegetset gs=new pacientegetset();
                paciente gss=new paciente();
                lista=gss.consultar();
                
                for (int i=0; i<lista.size(); i++){
                    gs=lista.get(i);
                
                
                %>
                
                <option value="<%=gs.getDoc()%>"><%=gs.getDoc()%></option>
                
                <%}%>
            </select>
            </div>
            
            
            
            <div class="form-group">
            <label>Fecha: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=fec%>" type="date" name="fec" required="">
            </div>
            
            
            <div class="form-group">
            <label>Descripcion: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=des%>" type="text"  maxlength="200" name="des" required="">
            </div>
            
            <table > 
                    <tr>
                        <%
                            ArrayList<dientegetset> die = new ArrayList<>();
                            dientegetset gm = new dientegetset();
                            diente gssm = new diente();
                            die = gssm.dienteSuperior();
                            for (int e = 0; e < die.size(); e++) {
                                gm = die.get(e);
                        %>
                        <td><%=gm.getNom()%></td>
                        <% } %>


                    </tr>
                    <tr>
                        <% for (int e = 0; e < die.size(); e++) {
                                gm = die.get(e);%>
                        <td diente="<%=gm.getCod()%>" onclick="DienteNuevo('Superior',<%=gm.getCod()%>, '<%=gm.getNom()%>')"><img src="ima/<%=gm.getIma()%>" width="25px"></td>      
                            <% } %>
                    </tr>
                </table>
                <br>
                <table> 
                    <tr>
                        <%
                            die = gssm.dienteInferior();
                            for (int e = 0; e < die.size(); e++) {
                                gm = die.get(e);
                        %>
                        <td><%=gm.getNom()%></td>
                        <% } %>

                    </tr>
                    <tr>
                        <% for (int e = 0; e < die.size(); e++) {
                                gm = die.get(e);%>
                        <td diente="<%=gm.getCod()%>" onclick="DienteNuevo('Inferiores',<%=gm.getCod()%>, '<%=gm.getNom()%>')"><img src="ima/<%=gm.getIma()%>" width="25px"></td>      
                            <% } %>
                    </tr>
                </table>
                <br>
                <div class="dientesDiv">

                </div>
            
            
            <button type="submit" class="btn btn-primary btn-block" name="diag3">Aceptar</button>
            
        </form>
        </div>
    </body>
</html>
<script>
    function DienteNuevo(tipo, num, nombre) {
        var html = '<div class="form-group" diente="dienteDetella' + num + '"> <button type="button" class="btn btn-danger" onclick="eliminarDetalle(' + num + ')"><i class="fa fa-remove"></i></button>'
                + '<label>' + tipo + ' ' + nombre + ':</label><input class="form-control" type="text" name="descripcion[' + num + ']" value="">'
                + '</div>';
        $('.dientesDiv').append(html);
    }
    function eliminarDetalle(num) {
        if (confirm('¿Desea eliminar el registro?'))
            $('div[diente="dienteDetella' + num + '"]').remove();
    }

    function myFunction() {
        setTimeout(alertFunc, 1000);
    }
    function alertFunc() {
        for (i = 0; i < 100; i++) {
            var die = $('div[diente="dienteDetella' + i + '"]').html();
            if (die != "" && die != 'undefined' && die != null) {
                $('td[diente="' + i + '"]').css('opacity', '0.5');
            } else
                $('td[diente="' + i + '"]').css('opacity', '1');
        }
        myFunction();
    }
    myFunction();
</script>