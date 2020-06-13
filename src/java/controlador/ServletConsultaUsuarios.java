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
import modelo.auxiliargetset;
import modelo.usuario;
import modelo.usuariogetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletConsultaUsuarios", urlPatterns = {"/ServletConsultaUsuarios"})
public class ServletConsultaUsuarios extends HttpServlet {

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
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='table-responsive-xl'>");
            out.println("    <table class='table table-light'>");
            out.println("        <thead>");
            out.println("            <tr>");
            out.println("                <th ><font color='black'>Documento</font></th>");
            out.println("                <th><font color='black'>Nombre</font></th>");
            out.println("                <th><font color='black'>Clave</font></th>");
            out.println("                <th><font color='black'>Rol</font></th>");
            out.println("                <th><font color='black'>Genero</font></th>");
            out.println("                <th><font color='black'>Estado</font></th>");
            out.println("                <th><font color='black'>Mail</font></th>");
            out.println("                <th><font color='black'>Telefono</font></th>");
           // out.println("                <th scope='col'>Foto</th>");
            out.println("                <th><font color='balck'>Editar</font></th>");
            out.println("                <th><font color='balck'>Eliminar   </font></th>");

            out.println("            </tr>");
            out.println("        </thead>");
            out.println("        <tbody>");
                        
                            ArrayList<usuariogetset> listasUsuarios = new ArrayList<>();
                            usuariogetset convas = new usuariogetset(); //convas hago referencia al constructor vasio
                            usuario Cons = new usuario();
                           
                           listasUsuarios= Cons.consultar();

                            for (int i = 0; i < listasUsuarios.size(); i++) {

                                convas = listasUsuarios.get(i);

                        

            out.println("            <tr>");
            out.println("                <td scope='row'><input type='text'style='background-color: transparent;border:none'  class='codi' value="+convas.getDoc()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='nomb' value="+convas.getNom()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='clav' value="+convas.getCla()+"></td>");
            out.println("                <td><input type='text'style='background-color: transparent;border:none'  class='role' value="+convas.getRol()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='sexo' value="+convas.getSex()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='esta' value="+convas.getEst()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'   class='emai' value="+convas.getEma()+"></td>");
            out.println("                <td><input type='text' style='background-color: transparent;border:none'  class='tele' value="+convas.getTel()+"></td>");
            //out.println("                <td>"+convas.getFot()+"</td>");
            out.println("<td><input type='button'style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);' class='actualizar' value='Editar'></td>");
            out.println("<td><button  class='eliminar' style='border-radius: 52px; padding:12px 30px; background-color:rgba(242,246,248,1);'value="+convas.getDoc()+">Eliminar</button></td>");
            out.println("            </tr>");

  out.println("<script src=\"js/ActualizarUsuarios.js\"></script>");
                            
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
