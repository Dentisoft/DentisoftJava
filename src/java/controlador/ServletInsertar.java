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
import modelo.usuario;
import modelo.usuariogetset;

/**
 *
 * @author HP
 */
@WebServlet(name = "ServletInsertar", urlPatterns = {"/ServletInsertar"})
public class ServletInsertar extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInsertar</title>");            
            out.println("</head>");
            out.println("<body>");
            String doc,nom,cla,rol,sex,est,ema,tel,fot;
            boolean ua;
            doc=request.getParameter("doc");
            nom=request.getParameter("nom");
            cla=request.getParameter("cla");
            rol=request.getParameter("rol");
            sex=request.getParameter("sex");
            est=request.getParameter("est");
            ema=request.getParameter("ema");
             tel=request.getParameter("tel");
            fot=request.getParameter("fot");
            
            
            
            usuariogetset usu=new usuariogetset(doc, nom, cla, rol, sex, est, ema, tel, fot);
            usuario u=new usuario();
            ua=u.insertar(usu);
            
            if(ua){
                out.print("datos resgistrados");
            }
            else{
                out.print("datos no registrados");
            }

            
            out.println("<h1>Servlet ServletInsertar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
