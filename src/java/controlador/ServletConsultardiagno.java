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
import modelo.diagnostico;
import modelo.diagnosticogetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletConsultardiagno", urlPatterns = {"/ServletConsultardiagno"})
public class ServletConsultardiagno extends HttpServlet {

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
            out.println("<script src='ActuDiag.js' type='text/javascript'></script>"); 
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='table-responsive-xl'>");
            out.println("    <table class='table'>");
            out.println("        <thead>");
            out.println("            <tr>");
            out.println("                <th scope='col'>Codgio</th>");
            out.println("                <th scope='col'>Documento</th>");
            out.println("                <th scope='col'>Fecha</th>");
            out.println("                <th scope='col'>Descripcion:)</th>");
 
           // out.println("                <th scope='col'>Foto</th>");
                out.println("<th scope='col'>Editar</th>");

            out.println("            </tr>");
            out.println("        </thead>");
            out.println("        <tbody>");
                        
                            ArrayList<diagnosticogetset> listasUsuarios = new ArrayList<>();
                            diagnosticogetset convas = new diagnosticogetset(); //convas hago referencia al constructor vasio
                            diagnostico Cons = new diagnostico();
                           
                           listasUsuarios= Cons.consultar();

                            for (int i = 0; i < listasUsuarios.size(); i++) {

                                convas = listasUsuarios.get(i);

                        
            out.println( "<form action='' method='POST'>");
            out.println("            <tr>");
            out.println("                <td scope='row'><input type='text' class='codi' value="+convas.getCod()+"></td>");
            out.println("                <td><input type='text' class='codip' value="+convas.getDpa()+"></td>");
            out.println("                <td><input type='text' class='fec' value="+convas.getFec()+"></td>");
            out.println("                <td><input type='text' class='des' value="+convas.getDes()+"></td>");
        
            //out.println("                <td>"+convas.getFot()+"</td>");

            
            out.println( "<input type='hidden' name='cod' value="+convas.getCod()+">");
            out.println( "   <td><input type='button' name='diag2' value='Editar'></td>");
            out.println( "       </form>       ");      
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
