/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.cita;
import modelo.citagetset;
import modelo.diagnostico;
import modelo.diagnosticogetset;
import modelo.diente;
import modelo.factura;
import modelo.facturagetset;
import modelo.procedimiento;
import modelo.procedimientogetset;
import modelo.tratamiento;
import modelo.tratamientogetset;
import modelo.usuario;
import modelo.usuariogetset;

/**
 *
 * @author Lucho
 */
@WebServlet(name = "ServletOdo", urlPatterns = {"/ServletOdo"})
public class ServletOdo extends HttpServlet {
    
    String codi, diag, dura, desc, nomb; 
    String cod, doc, fec, des;
    String c, t, d, n, du;

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
          if(request.getParameter("cita")!=null){
                response.sendRedirect("Odocita.jsp");
         }
        
        if (request.getParameter("pacientes")!=null){
            response.sendRedirect("Odopac.jsp");
        }
        if (request.getParameter("dientes")!=null){
            response.sendRedirect("dientes.jsp");
        }
        if (request.getParameter("historial")!=null){
            historialpac(request, response);
        }
        
        if (request.getParameter("tratamiento")!=null){
            response.sendRedirect("OdoTrat.jsp");
        }
        
        if (request.getParameter("trat")!=null){
            InsertarTrat(request, response);
        }
        if (request.getParameter("trat2")!=null){
            actualizarTrat(request, response);
        }
        if (request.getParameter("trat3")!=null){
            ActualizarTrat2(request, response);
        }
        
        if (request.getParameter("diagnostico")!=null){
            response.sendRedirect("OdoDiagno.jsp");
        }
        
        if (request.getParameter("diag")!=null){
            InsertarDiag(request, response);
        }
        
        if (request.getParameter("diag2")!=null){
            actualizarDiag(request, response);
        }
        if (request.getParameter("diag3")!=null){
            ActualizarDiag2(request, response);
        }
        if (request.getParameter("procedimiento")!=null){
            response.sendRedirect("OdoPro.jsp");
        }
        if (request.getParameter("pro")!=null){
            InsertarPro(request, response);
        }
        if (request.getParameter("pro2")!=null){
            actualizarPro(request, response);
        }
        if (request.getParameter("pro3")!=null){
            ActualizarPro2(request, response);
        }
        if (request.getParameter("horario")!=null){
            response.sendRedirect("OdoCalendario.jsp");
        }
        if (request.getParameter("hor")!=null){
            InsertarHor(request, response);
        }
        
        
    }
     protected void historialpac(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            ArrayList<citagetset> lista=new ArrayList<>();
            String dpa;
            dpa=request.getParameter("dpa");
            
            
            
            
           
            
            HttpSession usuario= request.getSession(true);
            usuario.setAttribute("paciente",dpa);
            response.sendRedirect("OdoDiag.jsp");
            
        

    }
     
          protected void InsertarTrat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String cod, dia, dur, des, nom;
       boolean dat;
       
       
       dia=request.getParameter("dia");
       dur=request.getParameter("dur");
       des=request.getParameter("des");
       nom=request.getParameter("nom");
       
              tratamientogetset ds=new tratamientogetset( dia, dur, des, nom);
              tratamiento gu=new tratamiento();
            dat=gu.insertar(ds);
            
            if (dat){
                
                response.sendRedirect("OdoTrat.jsp");
            }
            else{
                
                response.sendRedirect("OdoTrat.jsp");
            }
            
        

    }
          
     
          protected void InsertarHor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String codig, paci, odont, fech, hor, est;
       boolean dat;
       
       
       paci=request.getParameter("doc");
       odont=request.getParameter("odo");
       fech=request.getParameter("fec");
       hor=request.getParameter("hor");
       est=request.getParameter("est");
       
              citagetset ds=new citagetset(paci, odont, fech, hor, est);
              cita gu=new cita();
            dat=gu.insertar(ds);
            
            if (dat){
                
                response.sendRedirect("OdoCalendario.jsp");
            }
            else{
                
                response.sendRedirect("OdoCalendario.jsp");
            }
            
        

    }
          
          
          protected void InsertarPro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String codigo, trata, des, nom, dur;
       boolean dat;
       
       
       trata=request.getParameter("tra");
       des=request.getParameter("des");
       nom=request.getParameter("nom");
       dur=request.getParameter("dur");
       
              procedimientogetset ds=new procedimientogetset( trata, des, nom, dur);
              procedimiento gu=new procedimiento();
            dat=gu.insertar(ds);
            
            if (dat){
                
                response.sendRedirect("OdoPro.jsp");
            }
            else{
                
                response.sendRedirect("OdoPro.jsp");
            }
            
        

    }
          
                protected void actualizarPro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            ArrayList<procedimientogetset> listaa=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            procedimientogetset cit=new procedimientogetset(cod);
            procedimiento ci=new procedimiento();
            listaa=ci.consultarCod(cod);
            
            if (listaa.size()>0){
                for (int i=0; i<listaa.size(); i++){
                    cit=listaa.get(i);
                    c=cit.getCod();
                    t=cit.getCtr();
                    d=cit.getDes();
                    n=cit.getNom();
                    du=cit.getDur();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletCod", c);
            pac.setAttribute("ServletTra", t);
            pac.setAttribute("ServletDes", d);
            pac.setAttribute("ServletNom",n);
            pac.setAttribute("ServletDur", du);
            
            response.sendRedirect("OdoPro2.jsp");
            
        

    }
          
            
        
                protected void actualizarTrat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            ArrayList<tratamientogetset> listaa=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            tratamientogetset cit=new tratamientogetset(cod);
            tratamiento ci=new tratamiento();
            listaa=ci.consultarCod(cod);
            
            if (listaa.size()>0){
                for (int i=0; i<listaa.size(); i++){
                    cit=listaa.get(i);
                    codi=cit.getCod();
                    diag=cit.getCdi();
                    dura=cit.getDur();
                    desc=cit.getDes();
                    nomb=cit.getNom();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletDia", diag);
            pac.setAttribute("ServletCod", codi);
            pac.setAttribute("ServletDur", dura);
            pac.setAttribute("ServletNom",nomb);
            pac.setAttribute("ServletDes", desc);
            
            response.sendRedirect("OdoTrat2.jsp");
            
        

    }
                
        protected void ActualizarPro2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String co, ta, de, no, dur;
       boolean dat;
       
       co=request.getParameter("cod");
       ta=request.getParameter("tra");
       de=request.getParameter("des");
       no=request.getParameter("nom");
       dur=request.getParameter("dur");
       
              procedimientogetset ds=new procedimientogetset(co, ta, de, no, dur);
              procedimiento gu=new procedimiento();
            dat=gu.actualizarCod(co, ta, de, no, dur);
            
            if (dat){
                
                response.sendRedirect("OdoPro.jsp");
            }
            else{
                
                response.sendRedirect("OdoPro.jsp");
            }
            
        

    }
                
        protected void ActualizarTrat2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String cod, dia, dur, des, nom;
       boolean dat;
       
       cod=request.getParameter("cod");
       dia=request.getParameter("dia");
       dur=request.getParameter("dur");
       des=request.getParameter("des");
       nom=request.getParameter("nom");
       
              tratamientogetset ds=new tratamientogetset(cod, dia, dur, des, nom);
              tratamiento gu=new tratamiento();
            dat=gu.actualizarTrat(cod, dia, dur, des, nom);
            
            if (dat){
                
                response.sendRedirect("OdoTrat.jsp");
            }
            else{
                
                response.sendRedirect("OdoTrat.jsp");
            }
            
        

    }
        
     
          protected void InsertarDiag(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String cod, doc, fec, des;
              
       boolean dat;
       
       
       doc=request.getParameter("doc");
       fec=request.getParameter("fec");
       des=request.getParameter("des");
       
       
       ArrayList<diagnosticogetset> lista=new ArrayList<>();
              diagnosticogetset ds=new diagnosticogetset(doc, fec, des);
              diagnostico gu=new diagnostico();
            dat=gu.insertar(ds);
            
            
            
            
              diente die=new diente();
              lista=die.BuscarCodigo(doc, fec, des);
              
              JOptionPane.showMessageDialog(null, lista.size());
              
              for (int i = 0; i < lista.size(); i++) {
                 ds=lista.get(i);
                 String codd=ds.getCod();
                 
                  JOptionPane.showMessageDialog(null, codd);
                  
                  
              }
              
            
            if (dat){
                
                response.sendRedirect("Odontologo.jsp");
            }
            else{
                
                response.sendRedirect("Odontologo.jsp");
            }
            
        

    }
          
          
          
          
        
                protected void actualizarDiag(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        JOptionPane.showMessageDialog(null, "Ento actualizar diag");
            ArrayList<diagnosticogetset> listaa=new ArrayList<>();
            String codigo;
            codigo=request.getParameter("cod");
            diagnosticogetset cit=new diagnosticogetset(codigo);
            diagnostico ci=new diagnostico();
            listaa=ci.consultarCod(codigo);
            
            if (listaa.size()>0){
                for (int i=0; i<listaa.size(); i++){
                    cit=listaa.get(i);
                    cod=cit.getCod();
                    doc=cit.getDpa();
                    fec=cit.getFec();
                    des=cit.getDes();
                    
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletCod", cod);
            pac.setAttribute("ServletDoc", doc);
            pac.setAttribute("ServletFec", fec);
            pac.setAttribute("ServletDes",des);
            
            
            response.sendRedirect("Odontologo.jsp");
            
        

    }
                
                
          protected void ActualizarDiag2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
              String codigo, docum, fecha, descri;
       boolean dat;
       
       codigo=request.getParameter("cod");
       docum=request.getParameter("doc");
       fecha=request.getParameter("fec");
       descri=request.getParameter("des");
       
       
              diagnosticogetset ds=new diagnosticogetset(codigo, docum, fecha, descri) ;
              diagnostico gu=new diagnostico();
            dat=gu.actualizarDiag(codigo, docum, fecha, descri);
            
            if (dat){
                
                response.sendRedirect("Odontologo.jsp");
            }
            else{
                
                response.sendRedirect("Odontologo.jsp");
            }
            
        

    }
     
     
     

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
