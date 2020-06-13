<%-- 
    Document   : Administrador
    Created on : 5/02/2020, 06:45:42 PM
    Author     : HP
--%>

<%@page import="modelo.quejas"%>
<%@page import="modelo.quejas"%>
<%@page import="modelo.quejasgetset"%>
<%@page import="modelo.factura"%>
<%@page import="modelo.facturagetset"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.usuariogetset"%>
<%@page import="modelo.tratamiento"%>
<%@page import="modelo.tratamientogetset"%>
<%@page import="modelo.procedimiento"%>
<%@page import="modelo.procedimientogetset"%>
<%@page import="modelo.diagnostico"%>
<%@page import="modelo.diagnosticogetset"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.odontologo"%>
<%@page import="modelo.odontologogetset"%>
<%@page import="modelo.cita"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.citagetset"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/paciente.css">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/ConsulOdoPac.js" type="text/javascript"></script>
        <title>Dentisoft</title>
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
    <div>
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
        <div id="mainbox" onclick="openFunction()"><img style="width: 50px; height: 40px;" class="rounded-circle" src="css/perfil.jpg"></div>
        <div id="menu" class="sidemenu"> 
            <center>
            <a href="#"><%= x %> <%= nom%></a>
            <hr>

            <img class="rounded-circle" style="width: 200px; height: 180px;" src="css/perfil.jpg"> <br>
            
            <!-- src="<%=us.getFot()%>" -->
            <p class="h5"><%=us.getEma()%></p><br>
            <p class="h5">Id:<%=us.getDoc()%></p>
            <p class="h5">Rol:<%=us.getRol()%></p>
            <p class="h5">Estado:<%=us.getEst()%></p>
            <p class="h5">Tel:<%=us.getTel()%></p><br>
                 </center>
                 <%}%>
                 
              
        
  
                  <%
            String docmt;
            HttpSession resu=request.getSession(false);
            docmt=(String)resu.getAttribute("varsession3");
            ArrayList<quejasgetset> res=new ArrayList<>();
            quejasgetset re=new quejasgetset(docmt);
            quejas consulre=new quejas();
            res= consulre.consultarRespondidos(docmt);
            

            for (int e=0; e<res.size();e++){

                re=res.get(e);
            
            %>
            <br>
        
            <div class="alert alert-warning alert-dismissible fade show" data-toggle="popover" data-placement="left" role="alert">
                <strong>echa un vistazo,repondimos tu inquietud!</strong> <hr><%=re.getFec()%><br>
                <p><%=re.getRes()%></p>
                    
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
         
            <%
            }
            %>
             
            <form action="CerrarSesion" method="POST" class="form-inline my-2 my-lg-0">
                        <input class="btn btn-info btn-lg btn-block" type="submit" name="btncerrar" value="Cerrar Sesion">
                    </form>
                 
            
              
            <a href="#" class="closebtn" onclick="closeFunction()">&times</a>
        </div>
        <img class="imalog"src="ima/logo.jpg" class="rounded float-left" alt="...">
         
         
        </div>
  
          <center> <header>
                       
          
<div class="wave" style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;">
    <path d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" 
     style="stroke: none; fill: #fff;"></path></svg></div>
    
  
             
       <nav style="background-color:transparent;"class="navbar  navbar-expand-lg navbar-dark nav1">
    <a class="navbar-brand" href="#">
    <img src="https://image.flaticon.com/icons/png/512/65/65630.png" width="30" height="30" alt="" loading="lazy">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">CITAS<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">HISTORIAL</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">FACTURACIÓN</a>
      </li>
     <li class="nav-item">
        <a class="nav-link active" href="#">CONTACTO</a>
      </li>
    </ul>
   
  </div>
</nav>
                  <section class="textos-header">
                      <h1>Nos preocupamos por tu salud dental</h1>
                      <h2>¡visitanos!</h2>
                  </section> 
          
         </header></center>
    
    <main>
        <section class="contenedor sobre-nosotros">
            <h2 class="titulo">Mis citas</h2><br>
            <div class="contenedor-sobre-nosotros">
                <img src="ima/citas.png" alt="" class="imagen-about-as">
                <div class="contenido-textos">
                <h3><span>1</span>Agendar citas</h3>
                <p>Agende sus citas con anterioridad,estaremos atentos
                y le ofreceremos la mejor calidad</p>  
                 <form  method="POST">
            <input type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal" name="agendar"  value="Agendar cita">
                 </form><br>
                
                <h3><span>2</span>Ver citas</h3>
                <p>Agende sus citas con anterioridad,estaremos atentos
                y le ofreceremos la mejor calidad</p>
               <form  method="POST">
                   <input type="submit" class="btn btn-info" name="ver" id="ver" value="Ver citas">
            </form>
            </div>
               
            </div>
        </section>
    </main>
        
      
     <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agendar cita</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="seccion1 col-5">
          <form action="" method="POST" class="Content">

    <div class="form-group">
            <label for="exampleFormControlSelect1">Odontologo:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="odo">
                <%
                  ArrayList<odontologogetset> listaodo=new ArrayList<>();
                  odontologogetset od=new odontologogetset();
                  odontologo odo=new odontologo();
                  listaodo=odo.consultar();
                  
                  for (int i=0; i<listaodo.size(); i++){
                  od=listaodo.get(i);
                  
                %>
                <option value="<%=od.getDoc()%>"><%=od.getNom()%></option>
                    <%}%>
                </select>
    </div>    
            
            <div class="form-group">
            <label>Fecha:</label>
            <input class="form-control" id="exampleInputEmail1" type="date" name="fecha"  required="">
            </div>

          <div class="modal-footer">
              <button type="submit"  class="btn btn-primary btn-block" id="enviar" name="enviar">Aceptar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        
      </div>
</form>
    </div>        
  </div>
</div>
</div>
            </div>
                    


           <% if (request.getParameter("enviar")!=null){%>
          <section class="tabla">
              <div class="contenedor">
            <table class="table table-bordered table-info">
            <thead class="thead">
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Documento Odotologo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Hora</th>
                <th scope="col">Estado</th>
                <th scope="col">Solicitar</th>
               
                
            </tr>
            </thead>
            
            <%
            String docu="", fec, odon;
            ArrayList<citagetset> listacliente=new ArrayList<>();
            citagetset gs=new citagetset();
            cita  consul=new cita();
            HttpSession cli=request.getSession(false);
            docu=(String)cli.getAttribute("varsession3");
            fec=request.getParameter("fecha");
            odon=request.getParameter("odo");
            listacliente= consul.CitasDispo(fec, odon);
            

            for (int i=0; i<listacliente.size();i++){

                gs=listacliente.get(i);
            
            %>
            
            <tr>
                <td><%=gs.getCod()%></td>
                <td><%=docu%></td>
                <td><%=gs.getDod()%></td>
                <td><%=gs.getFec()%></td>
                <td><%=gs.getHor()%></td>
                <td><%=gs.getEst()%></td>
            <form action="ServletPac" method="POST">
                <input type="hidden" name="cod" value="<%=gs.getCod()%>">
                <td><input type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#exampleModal1" name="solicitar" value="Solicitar"></td>
                
            </form>
            </tr>
            <%
            }
            %>
        </table>
              </div>
          </section>
        <%}%>
        
          <% String fech, cod, odont, hor, esta, pac;
        HttpSession cli=request.getSession(false);
        fech = (String)cli.getAttribute("servletFechaCit");
        pac = (String)cli.getAttribute("varsession3");
        cod = (String)cli.getAttribute("ServletCitCod");
        odont = (String)cli.getAttribute("ServletCitOdo");
        hor = (String)cli.getAttribute("ServletCitHor");
        esta = (String)cli.getAttribute("ServletCitEst");
        
        %>
        <div class="seccion1 col-5"> 
        <form action="ServletPac" method="POST" class="Content">
            
             <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agendar cita</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            
            <div class="form-group">
            <label>Codigo: <%=cod%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="cod" value="<%=cod%>"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Documento paciente: <%=pac%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="pac" value="<%=pac%>"  required="">
            </div>
            
            
            <div class="form-group">
            <label>Documento odontologo: <%=odont%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="odo" value="<%=odont%>"  required="">
            </div>
            
            
            
            <div class="form-group">
            <label>Fecha: <%=fech%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="fec" value="<%=fech%>" required="">
            </div>
            
            
            <div class="form-group">
            <label>Hora: <%=hor%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden" name="hor" value="<%=hor%>" required="">
            </div>
            
              <div class="modal-footer">
           <button type="submit" class="btn btn-info btn-block" name="aceptar">Aceptar</button>
            <button type="submit" class="btn btn-info btn-block" name="cancelar">Cancelar</button>
      </div>
    </div>
  </div>
</div> 
        </form>
        </div>
        </div>
            
            
            <% if (request.getParameter("ver")!=null){%>
             <section class="tabla1">
              <div class="contenedor1">
                <table class="table table-bordered table-info">
            <thead class="thead">
            <tr>
                
                <th scope="col">Codigo</th>
                <th scope="col">Documento Paciente</th>
                <th scope="col">Documento Odontologo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Hora</th>
                <th scope="col">Borrar</th>
            </tr>
            </thead>
            <%
            String docu="";
            ArrayList<citagetset> listalin=new ArrayList<>();
            citagetset gs=new citagetset();
            cita consul=new cita();
            HttpSession clie=request.getSession(false);
            docu=(String)cli.getAttribute("varsession3");
            listalin=consul.CitPac(docu);
            
            for (int i=0; i<listalin.size(); i++){
                gs=listalin.get(i);
            
            %>
            
            
            <tr>
                
                <td><%=gs.getCod()%></td>
                <td><%=gs.getDpa()%></td>
                <td><%=gs.getDod()%></td>
                <td><%=gs.getFec()%></td>
                <td><%=gs.getHor()%></td>
                <td>
                    <form action="ServletPac" method="POST">
                        <input type="hidden" name="cod" value="<%=gs.getCod()%>">
                        <input type="submit" class="btn btn-info btn-block" name="borrar" value="Cancelar cita">
                    </form>
                </td>
            </tr>
            <%}%>
            </table>
              </div>
             </section>
        
   <%}%>
      
   
   <section class="portafolio"><br>
       <h2 class="titulo">portafolio</h2><br>
       <div class="contenedor">
           <div class="galeria-port">
               <div class="imagen-port">
                   <img src="ima/01.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                <div class="imagen-port">
                   <img src="ima/2.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                <div class="imagen-port">
                   <img src="ima/3.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                <div class="imagen-port">
                   <img src="ima/4.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                <div class="imagen-port">
                   <img src="ima/5.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                <div class="imagen-port">
                   <img src="ima/6.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                 <div class="imagen-port">
                   <img src="ima/7.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
                 <div class="imagen-port">
                   <img src="ima/8.jpg" alt="">
                   <div class="hover-galeria">
                        <img src="ima/icono.png" alt="">
                        <p>nuestro trabajo</p>
                   </div>
               </div>
           </div>
       </div>
   </section>
       
        
   <center>
   <main>
   <section class="historial"> 
               <div class="contenido-textos">
                    <h2 class="titulo">Historial clinico</h2><br>
                   <hr>
                <p>Podra ver todos sus diagnosticos , tratamientos y procediemientos  </p>  
                 
       </div>
            <img src="" alt="" class="imagen-historial">
             <div style="width: 200%;"class="accordion" id="accordionExample">
                  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
         Ver su historial clinico
        </button>
      </h2>
    </div>
                      <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div style="width: 100%;" class="card-body">
       
 
    <img src="ima/odontograma.PNG" width="100%" height="130%">
     <p class="h2">Situación diagnostica</p>
            <%
            String docum="";
            ArrayList<diagnosticogetset> listalin=new ArrayList<>();
            diagnosticogetset gs=new diagnosticogetset();
            diagnostico consul=new diagnostico();
            HttpSession clie=request.getSession(false);
            docum=(String)clie.getAttribute("varsession3");
            listalin=consul.consultarPac(docum);
            
            for (int i=0; i<listalin.size(); i++){
                gs=listalin.get(i);
            
            %>
            

                
                      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Username</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Codigo</div>
        </div>
          <td> <input style="width: 20px;"type="text" class="form-control" id="inlineFormInputGroup" value="<%=gs.getCod()%>" ></td>
       <div class="input-group-prepend">
          <div class="input-group-text">Fecha</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="<%=gs.getFec()%>">
     
        <div class="input-group-prepend">
          <div class="input-group-text">Id Paciente</div>
        </div>
        <td> <input type="text" class="form-control" id="inlineFormInputGroup" value="<%=gs.getDpa()%>"></td>
      </div>
       </div>
      
      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Dientes afectados</div>
        </div>
          <td><input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Username"></td>
      </div>
    </div>
     
      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Nombre de la situación</div>
        </div>
          <td><input type="text" class="form-control" id="inlineFormInputGroup" value=""></td>
        <div class="input-group-prepend">
          <div class="input-group-text">Tratar</div>
        </div>
          <td><input type="text" class="form-control" id="inlineFormInputGroup" value=""></td>
      </div>
    </div>
          
       <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Detalle</div>
        </div>
          <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="<%=gs.getDes()%>" rows="3"  ></textarea>
       
      </div>
    </div>
  
          <hr>
            <%}%>
          

          Hacer un buen diagnóstico es lo que realmente hace bueno a un profesional.
          
          <p class="h2">Tratamientos</p>

            <%
            
            
     
            ArrayList<tratamientogetset> lista=new ArrayList<>();
            tratamientogetset ss=new tratamientogetset();
            tratamiento con=new tratamiento();
            HttpSession tra=request.getSession(false);
            docum=(String)tra.getAttribute("varsession3");
            lista=con.consultarPac(docum);
            
            for (int i=0; i<lista.size(); i++){
                ss=lista.get(i);
            
            %>

                    
                      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Username</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Codigo Tratamiento</div>
        </div>
        <input style="width: 20px;"type="text" class="form-control" id="inlineFormInputGroup" value="<%=ss.getCod()%>" >
       <div class="input-group-prepend">
          <div class="input-group-text">Codigo diagnostico</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="<%=ss.getCdi()%>">
     
        <div class="input-group-prepend">
          <div class="input-group-text">Duración</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="<%=ss.getDur()%>">
      </div>
       </div>
      
      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Especialidad</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="<%=ss.getNom()%>">
         <div class="input-group-prepend">
          <div class="input-group-text">Dientes afectados</div>
        </div>
         <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Username">
      </div>
      </div>
     
      <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Estado</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="">
        <div class="input-group-prepend">
          <div class="input-group-text">Tratar</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" value="">
      </div>
    </div>
          
       <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Detalle</div>
        </div>
          <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="<%=ss.getDes()%>" rows="3"  ></textarea>
       
      </div>
    </div>

            <%}%>
     
   
            <p class="h2">Procedimientos</p>
               <%
            
            ArrayList<procedimientogetset> list=new ArrayList<>();
            procedimientogetset tt=new procedimientogetset();
            procedimiento conn=new procedimiento();
            HttpSession trat=request.getSession(false);
            docum=(String)trat.getAttribute("varsession3");
            list=conn.consultarPac(docum);
            
            for (int i=0; i<list.size(); i++){
                tt=list.get(i);
            
            %>
            
           <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Username</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Codigo</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="<%=tt.getCod()%>">
        <div class="input-group-prepend">
          <div class="input-group-text">Codigo Tratamiento</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="<%=tt.getCtr()%>">
      </div>
    </div>
                 <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Username</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Nombre</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="<%=tt.getNom()%>">
        <div class="input-group-prepend">
          <div class="input-group-text">Duración</div>
        </div>
        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="<%=tt.getDur()%>">
      </div>
    </div>
                
                 <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Detalle</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Detalle</div>
        </div>
          <textarea type="text" class="form-control" id="inlineFormInputGroup" placeholder="<%=tt.getDes()%>" rows="3"></textarea>
      </div>
    </div>
            <%}%>
            
             </div>
           </div>
         </div>
       </div>           
   </section>
   </main>
</center>
            
             <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div  class="card-body">
         <div style="width: 25%;margin-top: -1200px;" id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="https://plenilunia.com/wp-content/uploads/2012/12/Depositphotos_11644110_S.jpg" class="d-block w-15" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://i.pinimg.com/originals/78/14/35/78143552ea25cb4cc63a7ed62dbed7da.jpg" class="d-block w-15" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://image.freepik.com/foto-gratis/gente-sonriendo-aprobando-mujer-primer-plano_13339-103927.jpg" class="d-block w-20" alt="...">
    </div>
  </div>
</div>
      </div>
             </div>
            
            <hr>
            <center>
             <main>
        <section class="facturas">
            <h2 class="titulo">Facturas</h2><br>
            
            <div style="width: 90%"class="accordion" id="accordionExample">
                 <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          ver facturas
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body active">
  
        <br>
        
        <table class="table table-bordered table-info">
            <thead class="thead">
            <tr>
                <th scope="col">Descripcion</th>
                <th scope="col">Valor</th>
                <th scope="col">Imprimir</th>
                
            </tr>
            </thead>
      <%
            String docume="";
            String nombr;
            ArrayList<facturagetset> listafac=new ArrayList<>();
            facturagetset fa=new facturagetset();
            factura consult=new factura();
            HttpSession fac=request.getSession(false);
          nombr=(String)fac.getAttribute("varsession");
            docume=(String)fac.getAttribute("varsession3");
            listafac=consult.consultarPac(docume);
            
            for (int i=0; i<listafac.size(); i++){
                fa=listafac.get(i);
            
            %>
              <tr>
                   <div class="input-group mb-2 mr-sm-2">
    <div class="input-group-prepend">
      <div class="input-group-text">Fecha</div>
    </div>
    <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="<%=fa.getFec()%>">
  </div>
  
                   <div class="input-group mb-2 mr-sm-2">
    <div class="input-group-prepend">
      <div class="input-group-text">Codigo factura</div>
    </div>
    <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="<%=fa.getCod()%>">
     <div class="input-group-prepend">
      <div class="input-group-text">Codigo procedimiento</div>
    </div>
    <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="<%=fa.getCpr()%>">
  </div>
                
             
                
                <td><%=fa.getDes()%></td>
                <td><%=fa.getVal()%></td>
                <td>  <form action="Servletpdf">
                  <input type="hidden" name="nom" value="<%=nombr%>">

                <input type="hidden" name="Doc" value="<%=docume%>">
                <input type="submit" class="btn btn-info" name="btnpdf" value="Imprimir">
                    </form></td>
                    
            </tr>
            
        </table>
            <%}%>
      </div>
    </div>
  </div>
            </div>
        </section>
             </main>
            </center>
      
      <hr>
            <center>
                      <div class="lo">
      
<div  style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M0.00,49.98 C149.99,150.00 271.49,-49.98 500.00,49.98 L500.00,0.00 L0.00,0.00 Z" style="stroke: none; fill: #fff;"></path></svg></div>
                     
                     <p style="color:white;" class="h2">Contactenos</p>
                      
                     <%
                 String docu;
                HttpSession clit=request.getSession(false);
                docu=(String)clit.getAttribute("varsession3");
                %>
                
                <form class="contacto">
                    <br>
                    <p style="color:white;"class="h5">Envíenos una línea sobre sus requisitos,sugerencias o quejas y nos pondremos en contacto pronto.</p>
                    <br>
                    <input type="hidden" name="pac" value="<%=docu%>">
              <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">Detalle</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <label class="input-group-text" for="validatedInputGroupSelect">Odontologo que lo atendio</label>
      </div>
      <select class="custom-select" id="validatedInputGroupSelect" name="odo"required>
        
     
                <%
                ArrayList<usuariogetset> listas=new ArrayList<>();
                usuariogetset qr=new usuariogetset();
                usuario gss=new usuario();
                listas=gss.consultarOdo();
                
                for (int i=0; i<listas.size(); i++){
                    qr=listas.get(i);
                
                
                %>
                
                <option value="<%=qr.getDoc()%>"><%=qr.getNom()%></option>
                
                <%}%>
            </select>
            <div class="input-group-prepend">
          <div class="input-group-text">Fecha del suceso</div>
        </div>
        <input class="form-control" id="inlineFormInputGroup" type="date"   name="fec" required="">
        </div>

         <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup"></label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">Detalle</div>
        </div>
          <textarea class="form-control" name="des" id="exampleFormControlTextarea1"  rows="5"  ></textarea>
       
      </div>
    </div>
            
            <input type="hidden" name="res" value="NULL">
   <button type="submit" class="btn btn-primary " name="insertarQueja">Enviar</button>
            
         </div>
            <br>
           </form>
            
            <div class="cont">
                
                <img src="css/facebook.png" class="rounded mx-auto d-block" alt="..."><p class="h5">Dentisoft</p>
                <img src="css/w.png" class="rounded mx-auto d-block mt-2" alt="..."><p class="h5">+573123445678</p>
            </div>
                
                      </div>
</center>
       
             <script type="text/javascript">
            function openFunction(){
                document.getElementById("menu").style.width="400px";
                document.getElementById("mainbox").style.marginLeft="400px";  
                document.getElementById("mainbox").innerHTML="&#9776";
            }
            function closeFunction(){
                document.getElementById("menu").style.width="0px";
                document.getElementById("mainbox").style.marginLeft="0%";
              
                document.getElementById("mainbox").innerHTML="&#9776;";
                document.getElementById("mainbox").style.color="black";
                
                
            }
            
           

        </script>
        <script type="text/javascript">
            $('.popover-dismiss').popover({
            trigger: 'focus';
            });
            </script>
    
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
    </body>
</html>
