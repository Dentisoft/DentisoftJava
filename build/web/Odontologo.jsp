

<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
<%@page import="modelo.paciente"%>
<%@page import="modelo.pacientegetset"%>
<%@page import="modelo.diente"%>
<%@page import="modelo.dientegetset"%>
<%@page import="modelo.dientegetset"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.usuariogetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentisoft</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/odontologo.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.26.0/moment.min.js"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/GestionTratJson.js" type="text/javascript"></script>        
    </head>
    <body>
         <%
            String nom, rol, sex, x, doc, est, cla;
        HttpSession usu=request.getSession(false);
        nom=(String)usu.getAttribute("varsession");
        rol=(String)usu.getAttribute("varsession2");
        sex=(String)usu.getAttribute("varsession1");
        
        
        
        if (sex.equals("femenino"))
        x="Bienvenida";
        else
        x="Bienvenido";
        %>
      
        
        
       
          <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">DENTIDANNA</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">CREAR AGENDA <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">PACIENTES</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ODONTOGRAMA
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <form method="POST">
                 <input type="submit" class="dropdown-item" name="nuevo" value="DIAGNOSTICO" >
                  <input type="submit" class="dropdown-item" name="trat" value="TRATAMIENTO" >
             </form>
          
          <a class="dropdown-item" href="#">PROCEDIMIENTO</a>
        </div>
      </li>
      <li class="nav-item">
          <form action="CerrarSesion" method="POST">
 <input class="btn btn-info btn-lg btn-block" type="submit" name="btncerrar" value="Cerrar Sesion">
          </form>
      </li>
    </ul>
    
  </div>
</nav>
          <%
            String documento="";
            ArrayList<usuariogetset> listaus=new ArrayList<>();
            usuariogetset us=new usuariogetset();
            usuario consulu=new usuario();
            
            documento=(String)usu.getAttribute("varsession3");
            listaus=consulu.consultarPac(documento);
            
            for (int i=0; i<listaus.size(); i++){ 
                us=listaus.get(i);
            
            %>
            <main>
                <section class="contenedor sobre-nosotros">
                    <div class="contenedor-sobre-nosotros">
                       <div  class="imagen-about-as">
        <div id="menu" class="sidemenu"> 
            <center>
            <a href="#"><%= x %> <%= nom%></a>
            <hr>

            <img class="rounded-circle"  src="css/perfil.jpg"> <br>
            
            <!-- src="<%=us.getFot()%>" -->
            <p class="h5"><%=us.getEma()%></p><br>
            <p class="h5">Id:<%=us.getDoc()%></p>
            <p class="h5">Rol:<%=us.getRol()%></p>
            <p class="h5">Estado:<%=us.getEst()%></p>
            <p class="h5">Tel:<%=us.getTel()%></p><br>
                 </center>
                 <%}%>
        </div>
        </div>  
        
      
        
    
            
                <div class="contenido-textos">
            <br>
            <% if (request.getParameter("nuevo") != null) { %>
            <div class="form">
            <center
            <p class="h5">SITUACIÓN DIAGNOSTICA</p>
            </center>
            <hr>
            <br>
                <center>
                    
            <form  method="POST" class="Content" action="">
                 <div class="dientesDiv">
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
                        <td diente="<%=gm.getCod()%>" onclick="DienteNuevo('Superior',<%=gm.getCod()%>, '<%=gm.getNom()%>')"><img src="ima/<%=gm.getIma()%>" width="30px"></td>   
                    
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
                        <td diente="<%=gm2.getCod()%>" onclick="DienteNuevo('Inferiores',<%=gm2.getCod()%>, '<%=gm2.getNom()%>')"><img src="ima/<%=gm2.getIma()%>" width="30px%"></td>      
                            <% } %>
                    </tr>
                    
                </table>
                    </div>
   
                <br>

            
                <div style="width: 70%">
                  <div class="col-auto">
             <div class="input-group mb-2">
             <div class="input-group-prepend">
          <div class="input-group-text">Fecha</div>
        </div>
              <input class="form-control" id="exampleInputEmail1" type="date" name="fec" required="">
        <div class="input-group-prepend">
          <label class="input-group-text" for="validatedInputGroupSelect">Odontologo</label>
      </div>
      <select class="custom-select" id="validatedInputGroupSelect" name="doc"required>
                  
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
                  </div>
             
   <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Detalle</div>
        </div>
          <textarea class="form-control" name="des" id="exampleFormControlTextarea1" name="des" rows="3"  ></textarea>
       
      </div>
    </div>
                </div>
                    <br>
     <button type="submit"  class="btn btn-primary " name="diag">Insertar nuevo</button>

            </form>
            
                </center>
       
</div>
                    
                    <br>
                    <div class="accordion" id="accordionExample">
              <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-info btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          ver diagnosticos
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
         <table class="table table-light">
                                <thead class="thead-light">
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


                                <form action="" method="POST">
                                    <input type="hidden" name="cod" value="<%=gss.getCod()%>">
                                    <td><button class="btn btn-info"  data-toggle="modal" data-target="#exampleModal" type="button" name="diag2" >Editar</button></td>
                                </form>
                                </tr>
                                <%
                                }
                                %>
                            </table>
      </div>
    </div>
  </div>
                </div>
                            </div>
        <%}%>
       
        
    
       
             </section>
            </main>
        
        
        
     
        
        <% String cod, docu, fec, des;
        HttpSession cli=request.getSession(false);
        cod = (String)cli.getAttribute("servletCod");
        docu = (String)cli.getAttribute("ServletDoc");
        fec = (String)cli.getAttribute("ServletFec");
        des = (String)cli.getAttribute("ServletDes");

        %>
       
        
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <div class="seccion1 col-5"> 
        <form action="ServletOdo" method="POST" class="Content">
            <div class="form-group">
            <label>Codigo: <%=cod%> </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=cod%>" type="hidden" name="cod" required="">
            </div>
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Paciente:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="doc">
                <option value="<%=docu%>"><%=docu%></option>
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
         </div>
      </div>
             <div class="modal-footer">
            <button type="submit" class="btn btn-primary btn-block" name="diag3">Aceptar</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
    </div>
  </div>
</div>
                    
                    
                      <main>
                <section class="contenedor sobre-nosotras">
                    <div class="contenedor-sobre-nosotras">
                       <div  class="imagen-about-es">
        <div class="root">
             <div class="calendar" id="calendar">
                 <div class="calendar__header">
                     <button type="button" class="control control--prev">&lt;</button>
                     <span class="month-name">OCT 2019</span>
                     <button type="button" class="control control--next">&gt;</button>
                 </div>
                 <div class="calendar_body">
                 <div class="grid">
                     <div class="grid__header">
                         <span class="grid__cell grid__cell--gh">Lun</span>
                         <span class="grid__cell grid__cell--gh">Mar</span>
                         <span class="grid__cell grid__cell--gh">Mie</span>
                         <span class="grid__cell grid__cell--gh">Jue</span>
                         <span class="grid__cell grid__cell--gh">Vie</span>
                         <span class="grid__cell grid__cell--gh">Sab</span>
                         <span class="grid__cell grid__cell--gh">Dom</span>
                     </div>
                     <div class="grid__body">
                     
                     <span class="grid__cell grid__cell--gd grid__cell--selected">1</span>
                     <span class="grid__cell grid__cell--gd">2</span>
                     <span class="grid__cell grid__cell--gd">3</span>
                     <span class="grid__cell grid__cell--gd">4</span>
                     <span class="grid__cell grid__cell--gd">5</span>
                     <span class="grid__cell grid__cell--gd">6</span>
                     <span class="grid__cell grid__cell--gd">7</span>
                     <span class="grid__cell grid__cell--gd">8</span>
                     <span class="grid__cell grid__cell--gd">9</span>
                     <span class="grid__cell grid__cell--gd">10</span>
                     <span class="grid__cell grid__cell--gd">11</span>
                     <span class="grid__cell grid__cell--gd">12</span>
                     <span class="grid__cell grid__cell--gd">13</span>
                     <span class="grid__cell grid__cell--gd">14</span>
                     <span class="grid__cell grid__cell--gd">15</span>
                     <span class="grid__cell grid__cell--gd">16</span>
                     <span class="grid__cell grid__cell--gd">17</span>
                     <span class="grid__cell grid__cell--gd">18</span>
                     <span class="grid__cell grid__cell--gd">19</span>
                     <span class="grid__cell grid__cell--gd">20</span>
                     <span class="grid__cell grid__cell--gd">21</span>
                     <span class="grid__cell grid__cell--gd">22</span>
                     <span class="grid__cell grid__cell--gd">23</span>
                     <span class="grid__cell grid__cell--gd">24</span>
                     <span class="grid__cell grid__cell--gd">25</span>
                     <span class="grid__cell grid__cell--gd">26</span>
                     <span class="grid__cell grid__cell--gd">27</span>
                     <span class="grid__cell grid__cell--gd">28</span>
                     <span class="grid__cell grid__cell--gd">29</span>
                     <span class="grid__cell grid__cell--gd">30</span>
                     <span class="grid__cell grid__cell--gd">31</span>
                     <span class="grid__cell grid__cell--gd">32</span>
                     <span class="grid__cell grid__cell--gd">33</span>
                     <span class="grid__cell grid__cell--gd grid__cell--disabled">34</span>
                     <span class="grid__cell grid__cell--gd grid__cell--disabled">35</span>
                     
                 </div>
                 </div>
             </div>    
         </div>
         
         </div>
        </div>
        </div> 
                    <div class="contenedor-dos">
                      <% if (request.getParameter("trat") != null) { %>
        
                     
                          
                         
              <form id="InsertarTrat" class="Content" action="" method="POST">
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Codigo diagnostico:</label>
            <select  id="cod" class="cod"  name="cod">
                <%
                ArrayList<diagnosticogetset> listad=new ArrayList<>();
                diagnosticogetset di=new diagnosticogetset();
                diagnostico gds=new diagnostico();
                listad=gds.consultar();
                
                for (int i=0; i<listad.size(); i++){
                    di=listad.get(i);
                
                
                %>
                
                <option value="<%=di.getCod()%>"><%=di.getCod()%></option>
                
                <%}%>
            </select>
            </div>
            
            <div class="form-group">
            <label>Duracion:</label>
            <input class="form-control" id="du" type="text"  maxlength="10" name="dur"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Descripcion:</label>
            <input class="form-control" id="des" type="text"  maxlength="200" name="des"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Nombre:</label>
            <input class="form-control" id="nom" type="text"  name="nom"  required="">
            </div>
            
            <input type="button" class="botonTrat" id="botonTrat"  name="botonTrat"  value="Enviar">
            
        </form>
        </div>
                 
              <%}%>
                </div>
        
         
        
        
       
      
         <form action="ServletOdo" method="POST">
            <input type="submit" class="btn btn-outline-light ml-5" name="cita" value="Citas programadas">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="pacientes" value="Paciente">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="horario" value="Crear agenda">
               
            
               
            <input type="submit" class="btn btn-outline-light ml-5" name="tratamiento" value="Tratamiento">
               
            <input type="submit" class="btn btn-outline-light ml-5" name="procedimiento" value="Procedimiento">

            </form>
                 
          
          <script src="js/Consultadiagnostico.js"></script>

   ¿
        
        <script type="text/javascript">
                     console.log(moment().format('MMMM Do YYYY, h:mm:ss a'));
                     </script>
                     <script>
    function DienteNuevo(tipo, num, nombre) {
        var html = '<div class="form-group" diente="dienteDetella' + num + '"> <button type="button" class="btn btn-danger" onclick="eliminarDetalle(' + num + ')"><i class="fa fa-remove"></i></button>'
                + '<label>' + tipo + ' ' + nombre + ':</label><input  class="form-control" type="text" name="descripcion[' + num + ']" value="">'
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
    </body>
</html>
