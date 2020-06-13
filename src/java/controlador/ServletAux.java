/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.cita;
import modelo.citagetset;
import modelo.factura;
import modelo.facturagetset;
import modelo.usuario;
import modelo.usuariogetset;
import javax.servlet.http.Part;
import modelo.quejas;
import modelo.quejasgetset;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServletAux", urlPatterns = {"/ServletAux"})
@MultipartConfig
public class ServletAux extends HttpServlet {
    
    String codi, proc, fec, valo, desc;
    String docu, nom, cla, rol, sex, est, ema, tel, fot;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        if (request.getParameter("citas")!=null){
            response.sendRedirect("AuxCita.jsp");
        }
        
        if (request.getParameter("pacientes")!=null){
            response.sendRedirect("AuxPac.jsp");
        }
        
        if (request.getParameter("factura")!=null){
            response.sendRedirect("AuxFac.jsp");
        }
        
        if (request.getParameter("enviar")!=null){
            InsertarFac(request, response);
        }
        if (request.getParameter("editar")!=null){
            actualizarFac(request, response);
        }
        if (request.getParameter("quejasrecla")!=null){
            response.sendRedirect("AuxQueja.jsp");
        }
        
        
          if (request.getParameter("actu")!=null){
            actualizarFac2(request, response);
        } 
          
         if (request.getParameter("responder")!=null){
            responderQueja(request, response);
        }  
         if (request.getParameter("responder2")!=null){
            responderQueja2(request, response);
        }  
        
        
        
        if (request.getParameter("usuario")!=null){
            response.sendRedirect("AuxUsu.jsp");
        }
        if (request.getParameter("insertar")!=null){
            InsertarUsu(request, response);
        }
        if (request.getParameter("eliminar")!=null){
            EliminarUsu(request, response);
        }
        if (request.getParameter("actualizar")!=null){
            actualizarUsu(request, response);
        }
        
        if (request.getParameter("act")!=null){
            actualizarUsu2(request, response);
        }
    }
    
        protected void InsertarFac(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       String cod, pro, fec, val, des;
       boolean dat;
       
       
       pro=request.getParameter("pro");
       fec=request.getParameter("fec");
       val=request.getParameter("val");
       des=request.getParameter("des");
       
            facturagetset ds=new facturagetset( pro, fec, val, des);
            factura gu=new factura();
            dat=gu.insertar(ds);
            
            if (dat){
                
                response.sendRedirect("AuxFac.jsp");
            }
            else{
                
                response.sendRedirect("AuxFac.jsp");
            }
    }
        
            
        protected void InsertarUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       String doc, nomb, clav, roll, sexo, esta, emai, tele;
       boolean dat;
       
       doc=request.getParameter("doc");
       nomb=request.getParameter("nom");
       clav=request.getParameter("cla");
       roll=request.getParameter("rol");
       sexo=request.getParameter("sex");
       esta=request.getParameter("est");
       emai=request.getParameter("ema");
       tele=request.getParameter("tel");
       Part foto = request.getPart("fot");
       String nomfoto=foto.getSubmittedFileName();
       
       String nombre=nomb+"_"+nomfoto;
       
       String Url="D:\\Documentos\\Dentisoftproyecto\\web\\ima\\"+nombre;
       String Url2="ima/"+nombre;
       
       
       //if(foto.getContentType().equals("image/png") || foto.getContentType().equals("image/jpg")
         //       || foto.getContentType().equals("image/gif") || foto.getContentType().equals("image/jpeg")){
                InputStream file =foto.getInputStream();
                File f=new File(Url);
                FileOutputStream sal=new FileOutputStream(f);
                int num=file.read();
                JOptionPane.showMessageDialog(null, num);
                while(num != -1){
                
                    sal.write(num);
                    num=file.read();
                }
                //sal.close();
                //file.close();
            
       
            usuariogetset ds=new usuariogetset(doc, nomb, clav, roll, sexo, esta, emai, tele, Url2);
            usuario gu=new usuario();
            dat=gu.insertar(ds);
            
            if(dat){
                
                response.sendRedirect("AuxUsu.jsp");
            }
            else{
                
                response.sendRedirect("AuxUsu.jsp");
            }
    }
        
        
            protected void EliminarUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       String doc;
       boolean dat;
       
       doc=request.getParameter("cod");
       
       
            usuariogetset ds=new usuariogetset(doc);
            usuario gu=new usuario();
            dat=gu.eliminarUsu(doc);
            
            if (dat){
                
                response.sendRedirect("AuxUsu.jsp");
            }
            else{
                
                response.sendRedirect("AuxUsu.jsp");
            }
    }
        
                protected void actualizarFac(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
            response.sendRedirect("AuxFac2.jsp");
            ArrayList<facturagetset> lista=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            facturagetset cit=new facturagetset(cod);
            factura ci=new factura();
            lista=ci.consultarCod(cod);
            
            if (lista.size()>0){
                for (int i=0; i<lista.size(); i++){
                    cit=lista.get(i);
                    codi=cit.getCod();
                    proc=cit.getCpr();
                    fec=cit.getFec();
                    valo=cit.getVal();
                    desc=cit.getDes();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletFecha", fec);
            pac.setAttribute("ServletCod", codi);
            pac.setAttribute("ServletPro", proc);
            pac.setAttribute("ServletVal",valo);
            pac.setAttribute("ServletDes", desc);
            
            
            
        

    }
                
                
            protected void responderQueja(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
            response.sendRedirect("AuxQueja2.jsp");
            ArrayList<quejasgetset> lista=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            quejasgetset cit=new quejasgetset(cod);
            quejas ci=new quejas();
            lista=ci.ConsulCod(cod);
            
            if (lista.size()>0){
                for (int i=0; i<lista.size(); i++){
                    cit=lista.get(i);
                    codi=cit.getId();
                    
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("ServletCod", codi);
           
            
            
            
        

    }
                
        protected void actualizarUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            ArrayList<usuariogetset> lista=new ArrayList<>();
            String doc;
            doc=request.getParameter("cod");
            usuariogetset cit=new usuariogetset(doc);
            usuario ci=new usuario();
            lista=ci.consultarDoc(doc);
            
            if (lista.size()>0){
                for (int i=0; i<lista.size(); i++){
                    cit=lista.get(i);
                    docu=cit.getDoc();
                    nom=cit.getNom();
                    cla=cit.getCla();
                    rol=cit.getRol();
                    sex=cit.getSex();
                    est=cit.getEst();
                    ema=cit.getEma();
                    tel=cit.getTel();
                    fot=cit.getFot();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletDoc", docu);
            pac.setAttribute("ServletNom", nom);
            pac.setAttribute("ServletCla", cla);
            pac.setAttribute("ServletRol",rol);
            pac.setAttribute("ServletSex", sex);
            pac.setAttribute("ServletEst", est);
            pac.setAttribute("ServletEma", ema);
            pac.setAttribute("ServletTel", tel);
            pac.setAttribute("ServletFot", fot);
            
            response.sendRedirect("AuxUsu2.jsp");
            
        

    }
        
        
        protected void actualizarFac2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
        String cod, pro, fec, val, des;
       boolean dat;
       
       cod=request.getParameter("cod");
       pro=request.getParameter("pro");
       fec=request.getParameter("fec");
       val=request.getParameter("val");
       des=request.getParameter("des");
       
            facturagetset ds=new facturagetset(cod, pro, fec, val, des);
            factura gu=new factura();
            dat=gu.actualizarFac(cod, pro, fec, val, des);
            
            if (dat){
                
                response.sendRedirect("AuxFac.jsp");
            }
            else{
                
                response.sendRedirect("AuxFac.jsp");
            }
            
        

    }
                
    protected void responderQueja2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
        String cod, res;
       boolean dat;
       
       cod=request.getParameter("cod");
       res=request.getParameter("res");
       
       
            quejasgetset ds=new quejasgetset(cod, res);
            quejas gu=new quejas();
            dat=gu.responderQueja(cod, res);
            
            if (dat){
                
                response.sendRedirect("AuxQueja.jsp");
            }
            else{
                
                response.sendRedirect("AuxQueja.jsp");
            }
            
        

    }
    
                    
    protected void actualizarUsu2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
    String doc, nomb, nom, cla, rol, sex, est, ema, tel, fot;
       boolean dat;
       
       doc=request.getParameter("doc");
       nomb=request.getParameter("nom");
       cla=request.getParameter("cla");
       rol=request.getParameter("rol");
       sex=request.getParameter("sex");
       est=request.getParameter("est");
       ema=request.getParameter("ema");
       tel=request.getParameter("tel");
              Part foto = request.getPart("fot");
       String nomfoto=foto.getSubmittedFileName();
       
       String nombre=nomb+"_"+nomfoto;
       
       String Url="C:\\Users\\Lucho\\Downloads\\proyectojava1\\web\\ima\\"+nombre;
       String Url2="ima/"+nombre;
       
       
       //if(foto.getContentType().equals("image/png") || foto.getContentType().equals("image/jpg")
         //       || foto.getContentType().equals("image/gif") || foto.getContentType().equals("image/jpeg")){
                InputStream file =foto.getInputStream();
                File f=new File(Url);
                FileOutputStream sal=new FileOutputStream(f);
                int num=file.read();
                JOptionPane.showMessageDialog(null, num);
                while(num != -1){
                
                    sal.write(num);
                    num=file.read();
                }
                //sal.close();
                //file.close();
       
            usuariogetset ds=new usuariogetset(doc, nomb, cla, rol, sex, est, ema, tel, Url2);
            usuario gu=new usuario();
            dat=gu.actualizarUsu(doc, nomb, cla, rol, sex, est, ema, tel, Url2 );
            
            if (dat){
                
                response.sendRedirect("AuxUsu.jsp");
            }
            else{
                
                response.sendRedirect("AuxUsu.jsp");
            }
            
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
