/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.servlet.http.HttpSession;
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
import modelo.quejas;
import modelo.quejasgetset;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServletPac", urlPatterns = {"/ServletPac"})
public class ServletPac extends HttpServlet {
    
   private String fec, codi, odo, hor, est;

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
                response.sendRedirect("Paciente.jsp");
         }
        
        if (request.getParameter("cancelar")!=null){
            response.sendRedirect("Paciente.jsp");
        }
        
        if (request.getParameter("quejas")!=null){
            response.sendRedirect("PacQueja.jsp");
        }
        
        if (request.getParameter("solicitar")!=null){
            actualizarCit(request, response);
        }
        
        if (request.getParameter("ver")!=null){
            response.sendRedirect("PacCita3.jsp");
        }
        
        if (request.getParameter("borrar")!=null){
            borrarCit(request, response);
        }
        
        if (request.getParameter("factura")!=null){
            response.sendRedirect("PacFactura.jsp");
        }
        
        if (request.getParameter("historial")!=null){
                response.sendRedirect("PacDiag.jsp");
            }
        
        if (request.getParameter("datos")!=null){
                response.sendRedirect("PacDatos.jsp");
            }
        if (request.getParameter("aceptar")!=null){
                AsignarCit(request, response);
            }
        if (request.getParameter("borrarCit")!=null){
            borrarCit2(request, response);
        }
        
        if (request.getParameter("insertarQueja")!=null){
            insertarQueja(request, response);
        }
        
        
    }
        protected void actualizarCit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            ArrayList<citagetset> lista=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            citagetset cit=new citagetset(cod);
            cita ci=new cita();
            lista=ci.consulCod(cod);
            
            if (lista.size()>0){
                for (int i=0; i<lista.size(); i++){
                    cit=lista.get(i);
                    fec=cit.getFec();
                    codi=cit.getCod();
                    odo=cit.getDod();
                    hor=cit.getHor();
                    est=cit.getEst();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletFechaCit", fec);
            pac.setAttribute("ServletCitCod", cod);
            pac.setAttribute("ServletCitOdo", odo);
            pac.setAttribute("ServletCitHor", hor);
            pac.setAttribute("ServletCitEst", est);
            
       
            
        

    }
        
                protected void borrarCit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            
            String cod;
            boolean dat;
            cod=request.getParameter("cod");
            citagetset cit=new citagetset(cod);
            cita ci=new cita();
            dat=ci.eliminar(cod);
           
            if (dat){
                
                response.sendRedirect("Paciente.jsp");
            }
            else{
                response.sendRedirect("Paciente.jsp");
            }
            
            
           
            
            
            
        

    }
                
                
            
                protected void insertarQueja(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            
            String pac, odo, fec, des, res;
            boolean dat;
            pac=request.getParameter("pac");
            odo=request.getParameter("odo");
            fec=request.getParameter("fec");
            des=request.getParameter("des");
            res=request.getParameter("res");
                    
            quejasgetset cit=new quejasgetset(pac, odo, fec, des, res) ;
            quejas ci=new quejas();
            dat=ci.insertar(cit);
           
            if (dat){
                
                response.sendRedirect("PacQueja.jsp");
            }
            else{
                response.sendRedirect("PacQueja.jsp");
            }
            
            
           
            
            
            
        

    }
        
                
                
                    protected void borrarCit2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            
            String cod;
            boolean dat;
            cod=request.getParameter("cod");
            citagetset cit=new citagetset(cod);
            cita ci=new cita();
            dat=ci.eliminar(cod);
           
            if (dat){
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                response.sendRedirect("Odocita.jsp");
            }
            else{
                JOptionPane.showMessageDialog(null, "Datos no eliminados");
            }
            
            
           
            
            
            
        

    }            
                
                        
                protected void AsignarCit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
            
            String cod, doc;
            boolean dat;
            cod=request.getParameter("cod");
            doc=request.getParameter("pac");
            citagetset cit=new citagetset(cod, doc);
            cita ci=new cita();
            dat=ci.Asignar(doc, cod);
           
            if (dat){
                JOptionPane.showMessageDialog(null, "Cita Asignada");
                response.sendRedirect("Paciente.jsp");
            }
            else{
                JOptionPane.showMessageDialog(null, "Cita no asignada");
                response.sendRedirect("Paciente.jsp");
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
