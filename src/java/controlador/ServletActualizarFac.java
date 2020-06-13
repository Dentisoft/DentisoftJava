/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.factura;
import modelo.facturagetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletActualizarFac", urlPatterns = {"/ServletActualizarFac"})
public class ServletActualizarFac extends HttpServlet {

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
           String d,c,r,v,ds;
        ds=request.getParameter("ds");

           d=request.getParameter("dd");
         c=request.getParameter("nn");
          r=request.getParameter("cc");
          v=request.getParameter("rr");
         boolean dat;
                facturagetset gs=new facturagetset(ds, d, c, r, v);
         factura usu=new factura();
         dat=usu.actualizar(gs);
         
         
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
         facturagetset gs=new facturagetset(d);
                            factura usu=new factura();
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
