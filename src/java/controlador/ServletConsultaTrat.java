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
import modelo.tratamiento;
import modelo.tratamientogetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletConsultaTrat", urlPatterns = {"/ServletConsultaTrat"})
public class ServletConsultaTrat extends HttpServlet {

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
            out.println("<title>Servlet ServletConsultaUsuarios</title>"); 
            out.println("<script src=\"js/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"js/GestionTratJson.js\" type=\"text/javascript\"></script>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='table-responsive-xl'>");
            out.println("    <table class='table table-light'>");
            out.println("        <thead>");
            out.println("            <tr>");
            out.println("                <th scope='col'>Codigo</th>");
            out.println("                <th scope='col'>Codigo diagnostico</th>");
            out.println("                <th scope='col'>Duracion</th>");
            out.println("                <th scope='col'>Descripción</th>");
            out.println("                <th scope='col'>Nombre</th>");
 out.println("                <th scope='col'>Editar:)</th>");
            out.println("                <th scope='col'>Eliminar</th>");
           // out.println("                <th scope='col'>Foto</th>");
        

            out.println("            </tr>");
            out.println("        </thead>");
            out.println("        <tbody>");
                        
                            ArrayList<tratamientogetset> listasUsuarios = new ArrayList<>();
                            tratamientogetset convas = new tratamientogetset(); //convas hago referencia al constructor vasio
                            tratamiento Cons = new tratamiento();
                           
                           listasUsuarios= Cons.consultar();

                            for (int i = 0; i < listasUsuarios.size(); i++) {

                                convas = listasUsuarios.get(i);

                        

            out.println("            <tr>");
            out.println("            <form action='' method='POST'>");
            out.println("                <td> <input type='text' style='background-color: transparent;border:none' class='codi' id='codi' value="+convas.getCod()+"></td>");
            out.println("                <td> <input type='text' style='background-color: transparent;border:none' class='codip'  id='codip' value="+convas.getCdi()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='du'  id='du' value="+convas.getDur()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='des'  id='des' value="+convas.getDes()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none' class='nom'  id=nom' value="+convas.getNom()+"></td>");
     
            //out.println("                <td>"+convas.getFot()+"</td>");
                       
                 out.println("<td><input id='actualizar' type='button'style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);' class='actualizar' value='Editar'></td>");
            out.println("<td><button id='eliminar'  class='eliminar' style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);'>Eliminar</button></td>");
out.println("            </form>");

                            
                                }
                            
            out.println("        </tbody>");
            out.println("    </table>");
            out.println("</div>");
            
            //out.println("<h1>Servlet ServletConsultaUsuarios at " + request.getContextPath() + "</h1>");
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
