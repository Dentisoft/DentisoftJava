<%-- 
    Document   : AuxUsu2
    Created on : 17/02/2020, 10:04:07 PM
    Author     : Usuario
--%>

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

            <form  method="POST">
            
            <a href="Auxiliar.jsp" class="btn btn-outline-light ml-5">Volver</a>
            
        </form>
        
            
           
            
          </nav> 
        
        
         <% String doc, nom, cla, rol, sex, est, ema, tel, fot;
        HttpSession cli=request.getSession(false);
        doc = (String)cli.getAttribute("servletDoc");
        nom = (String)cli.getAttribute("ServletNom");
        cla = (String)cli.getAttribute("ServletCla");
        rol = (String)cli.getAttribute("ServletRol");
        sex = (String)cli.getAttribute("ServletSex");
        est = (String)cli.getAttribute("ServletEst");
        ema = (String)cli.getAttribute("ServletEma");
        tel = (String)cli.getAttribute("ServletTel");
        fot = (String)cli.getAttribute("ServletFot");
        
        
        
        
        
        %>
        <div class="seccion1 col-5"> 
        <form action="ServletAux" method="POST" enctype="multipart/form-data" class="Content">
            
            <div class="form-group">
            <label>Documento: <%=doc%></label>
            <input class="form-control" id="exampleInputEmail1" type="hidden"  value="<%=doc%>" name="doc" required="">
            </div>
            
            

            <div class="form-group">
            <label>Nombre: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=nom%>"  type="text" name="nom" required="">
            </div>
            
            
            <div class="form-group">
            <label>Clave: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=cla%>" type="password" name="cla" required="">
            </div>
            
            
            <div class="form-group">
            <label for="exampleFormControlSelect1">Rol:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="rol">
                <option value="<%=rol%>"><%=rol%></option>
                <option value="paciente">Paciente</option>
                <option value="odontologo">Odontologo</option>
                <option value="auxiliar">Auxiliar</option>
            </select>
            </div>
                
            <div class="form-group">
            <label for="exampleFormControlSelect1">Sexo:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="sex">
                <option value="<%=sex%>"><%=sex%></option>
                <option value="femenino">Femenino</option>
                <option value="masculino">Masculino</option>
                
            </select>
            </div>
                
                
            <div class="form-group">
            <label for="exampleFormControlSelect1">Estado:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="est">
                <option value="<%=est%>"><%=est%></option>
                <option value="activo">Activo</option>
                <option value="inactivo">Inactivo</option>
            </select>
            </div>    
                
            
            <div class="form-group">
            <label>Email: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=ema%>" type="email" name="ema" required="">
            </div>
            
            
            <div class="form-group">
            <label>Telefono: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=tel%>" type="text" maxlength="11" name="tel" required="">
            </div>
            
            

            <div class="form-group">
            <label>Foto: </label>
            <input class="form-control" id="exampleInputEmail1" value="<%=fot%>" type="file" accept="image/*" name="fot" required="">
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" name="act">Aceptar</button>
            
                
        </form>
        </div>
            <div class="section">
            <div class="container" id="resusu">
                
            </div>
        </div>
    </body>
</html>
