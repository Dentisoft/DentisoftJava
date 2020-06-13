<%-- 
    Document   : OdoDiagno
    Created on : 19/02/2020, 07:14:47 PM
    Author     : Usuario
--%>

<%@page import="modelo.diente"%>
<%@page import="modelo.dientegetset"%>
<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">
                <img src="css/Icono.png" width="40" height="40" class="d-inline-block align-top" alt="">
                <a class="Tit-nav" style="color:#ffffff;">DentiDanna</a>
            </a>
            <form method="POST">
                <input type="submit" class="btn btn-outline-light ml-5" name="nuevo"  value="Insertar nuevo">
                
                <a href="Odontologo.jsp" class="btn btn-outline-light ml-5">Volver</a>



            </form>
        </nav>   


 <div class="modal-body">
                            <table class="table table-dark">
                                <thead class="thead">
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Paciente</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Editar</th>



                                </tr>
                                </thead>

                                <%

                                ArrayList<diagnosticogetset> listacliente=new ArrayList<>();
                                diagnosticogetset gss=new diagnosticogetset();
                                diagnostico consul=new diagnostico();


                                listacliente= consul.consultar();


                                for (int i=0; i<listacliente.size();i++){

                                    gss=listacliente.get(i);

                                %>

                                <tr>
                                    <td><%=gss.getCod()%></td>
                                    <td><%=gss.getDpa()%></td>
                                    <td><%=gss.getFec()%></td>
                                    <td><%=gss.getDes()%></td>


                                <form action="ServletOdo" method="POST">
                                    <input type="hidden" name="cod" value="<%=gss.getCod()%>">
                                    <td><input type="submit" name="diag2" value="Editar"></td>
                                </form>
                                </tr>
                                <%
                                }
                                %>
                            </table>
                      </div>
                      </div>
        
        
        
        

        <% if (request.getParameter("nuevo") != null) { %>
        <div class="seccion1 col-5"> 
            <form  method="POST" class="Content" action="">

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Documento paciente:</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="doc">
                        <%
                            ArrayList<pacientegetset> lista = new ArrayList<>();

                            pacientegetset gs = new pacientegetset();
                            paciente gl = new paciente();
                            lista = gl.consultar();

                            for (int i = 0; i < lista.size(); i++) {
                                gs = lista.get(i);


                        %>





                        <option value="<%=gs.getDoc()%>"><%=gs.getNom()%></option>

                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label>Fecha: </label>
                    <input class="form-control" id="exampleInputEmail1" type="date" name="fec" required="">
                </div>



                <div class="form-group">
                    <label>Descripcion: </label>
                    <input class="form-control" id="exampleInputEmail1" type="text"  maxlength="200" name="des" required="">
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
                            ArrayList<dientegetset> diee=new ArrayList<>();
                            dientegetset gm2=new dientegetset();
                            diente gssm2=new diente();
                            diee = gssm2.dienteInferior();
                            for (int i = 0; i < diee.size(); i++) {
                                gm2 = diee.get(i);
                        %>
                        <td><%=gm2.getNom()%></td>
                        <% } %>

                    </tr>
                    <tr>
                        <% for (int e = 0; e < diee.size(); e++) {
                                gm2 = diee.get(e);%>
                        <td diente="<%=gm2.getCod()%>" onclick="DienteNuevo('Inferiores',<%=gm2.getCod()%>, '<%=gm2.getNom()%>')"><img src="ima/<%=gm2.getIma()%>" width="25px"></td>      
                            <% } %>
                    </tr>
                </table>
                <br>
                <div class="dientesDiv">

                </div>

                <button type="submit"  class="btn btn-primary btn-block" name="diag">Aceptar</button>

            </form>
        </div>

        <%}%>

             

   
</body>
</html>


    <script src="js/Consultadiagnostico.js"></script>
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

