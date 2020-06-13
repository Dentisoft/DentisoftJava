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
import modelo.Logueo;
import modelo.usuariogetset;

/**
 *
 * @author Lucho
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
private String doc,nom,cla,rol,est,sex;
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
    
                if(request.getParameter("btnlogin")!=null){
                }
                 
                    ArrayList<usuariogetset> arr = new ArrayList<>();
                    String u, c;
                    u= request.getParameter("usu");
                    c= request.getParameter("con");
                    
                    usuariogetset ge=new usuariogetset(u, c);
                    Logueo lo=new Logueo();
                     arr= lo.login(ge);

                    if(arr.size()>0){
                        for(int i=0; i<arr.size(); i++){
                            ge=arr.get(i);
                            doc = ge.getDoc();
                            nom = ge.getNom();
                            cla = ge.getCla();
                            rol = ge.getRol();
                            sex = ge.getSex();
                            est = ge.getEst();
                        }
                        if(u.equals(nom) && c.equals(cla)){
                             
                             if(rol.equals("paciente")&&est.equals("activo")){
                            HttpSession usuario= request.getSession(true);
                             usuario.setAttribute("varsession",nom);
                             usuario.setAttribute("varsession1",sex);
                             usuario.setAttribute("varsession2",rol);
                             usuario.setAttribute("varsession3",doc);
                            response.sendRedirect("Paciente.jsp"); 
                             }
                             else if(rol.equals("odontologo")&&est.equals("activo")){
                            HttpSession usuario= request.getSession(true);
                             usuario.setAttribute("varsession",nom);
                             usuario.setAttribute("varsession1",sex);
                             usuario.setAttribute("varsession2",rol);
                             usuario.setAttribute("varsession3",doc);
                             response.sendRedirect("Odontologo.jsp"); 
                             }
                             else if(rol.equals("auxiliar")&&est.equals("activo")){
                            HttpSession usuario= request.getSession(true);
                             usuario.setAttribute("varsession",nom);
                             usuario.setAttribute("varsession1",sex);
                             usuario.setAttribute("varsession2",rol);
                             usuario.setAttribute("varsession3",doc);
                             response.sendRedirect("Auxiliar.jsp"); 
                        }
                    else if(est.equals("inactivo")){
                      response.sendRedirect("index.jsp");
                      JOptionPane.showMessageDialog(null, "Su usuario esta inactivo");
                        
                    }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Su Usuario y contraseña son incorrectos");
                            response.sendRedirect("index.jsp");
                        }

                }else{
                    JOptionPane.showMessageDialog(null, "No hay datos");
                    response.sendRedirect("index.jsp");
                }    
            }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
