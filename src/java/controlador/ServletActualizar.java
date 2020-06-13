/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.usuario;
import modelo.usuariogetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletActualizar", urlPatterns = {"/ServletActualizar"})
public class ServletActualizar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("dd")!=null){
           String d,n,c,r,e,s,m,t;
        d=request.getParameter("dd");
         n=request.getParameter("nn");
         c=request.getParameter("cc");
          r=request.getParameter("rr");
           e=request.getParameter("ss");
            s=request.getParameter("ee");
             m=request.getParameter("em");
            t=request.getParameter("te"); 
         boolean dat;
         usuariogetset gs=new usuariogetset(d, n, c, r, e, s, m, t);
         usuario usu=new usuario();
         dat=usu.actualizaru(gs);
         
         if(dat){
             out.print("datos actualizados");
             
         }else{
             out.print("datos no actualizados");
   
         }           
            
        }
                        if(request.getParameter("documento")!=null){
                            String d;
        d=request.getParameter("documento");
                                   
       
         boolean dat;
         usuariogetset gs=new usuariogetset(d);
         usuario usu=new usuario();
         dat=usu.eliminar(gs);
         
         if(dat){
             out.print("datos eliminados");
             
         }else{
             out.print("datos no eliminados");
   
         }    
                            
                        }
            
        }
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
