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
import modelo.factura;
import modelo.facturagetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletConsultaFacturas", urlPatterns = {"/ServletConsultaFacturas"})
public class ServletConsultaFacturas extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConsultaFacturas</title>");            
            out.println("</head>");
            out.println("<body>");
            
              out.println("<div class='table-responsive'>");
            out.println("    <table class='table table-light'>");
            out.println("        <thead>");
            out.println("            <tr>");
            out.println("                <th scope='col'>Documeto</th>");
            out.println("                <th ><font color='black'>Codigo de tratamiento</font></th>");
            out.println("                <th ><font color='black'>Fecha</font></th>");
            out.println("                <th ><font color='black'>Valor</font></th>");
            out.println("                <th ><font color='black'>Descripción</font></th>");
   
           // out.println("                <th scope='col'>Foto</th>");
            out.println("                <th ><font color='balck'>Editar</font></th>");
            out.println("                <th ><font color='balck'>Eliminar</font></th>");
           

            out.println("            </tr>");
            out.println("        </thead>");
            out.println("        <tbody>");
                        
                            ArrayList<facturagetset> listasFacturas= new ArrayList<>();
                            facturagetset convas = new facturagetset(); //convas hago referencia al constructor vasio
                            factura Cons = new factura();
                           
                           listasFacturas= Cons.consultar();

                            for (int i = 0; i < listasFacturas.size(); i++) {

                                convas = listasFacturas.get(i);

                        

            out.println("            <tr>");
            out.println("                <td><input  type='text'style='background-color: transparent;border:none' class='codi' value="+convas.getCod()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='codip' value="+convas.getCpr()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='fec' value="+convas.getFec()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='val' value="+convas.getVal()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='des' value="+convas.getDes()+"></td>");
          
          
            out.println("<td><input type='button' style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);' class='actualizar' value='Editar'></td>");
            out.println("<td><button style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);'  class='eliminar' value="+convas.getCod()+">Eliminar</button></td>");
         
            
  out.println("<script src=\"js/ActualizarFacturas.js\"></script>");
                            
                                }
                            
            out.println("        </tbody>");
            out.println("    </table>");
            out.println("</div>");
            
            
            
            
           // out.println("<h1>Servlet ServletConsultaFacturas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
