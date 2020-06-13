package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.diente;
import modelo.dientegetset;
import modelo.diagnostico;
import modelo.diagnosticogetset;
import modelo.paciente;
import modelo.pacientegetset;
import java.util.ArrayList;

public final class dientes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Flores del Hato</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Estilos.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                <img src=\"css/Icono.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("                <a class=\"Tit-nav\" style=\"color:#ffffff;\">DentiDanna</a>\n");
      out.write("            </a>\n");
      out.write("            <form method=\"POST\">\n");
      out.write("            <input type=\"submit\" class=\"btn btn-outline-light ml-5\" name=\"nuevo\"  value=\"Insertar nuevo\">\n");
      out.write("    \n");
      out.write("            <input type=\"submit\" class=\"btn btn-outline-light ml-5\" name=\"todos\" value=\"Ver todos\">\n");
      out.write("            <a href=\"Odontologo.jsp\" class=\"btn btn-outline-light ml-5\">Volver</a>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("           \n");
      out.write("            </form>\n");
      out.write("          </nav>   \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 if(request.getParameter("nuevo")!=null){ 
      out.write("\n");
      out.write("        <div class=\"seccion1 col-5\"> \n");
      out.write("        <form action=\"ServletOdo\" method=\"POST\" class=\"Content\">\n");
      out.write("            \n");
      out.write("           <div class=\"form-group\">\n");
      out.write("            <label for=\"exampleFormControlSelect1\">Documento paciente:</label>\n");
      out.write("            <select class=\"form-control\" id=\"exampleFormControlSelect1\" name=\"doc\">\n");
      out.write("                ");

                ArrayList<pacientegetset> lista=new ArrayList<>();
               
                pacientegetset gs=new pacientegetset();
                paciente gss=new paciente();
                lista=gss.consultar();
                
               
                
                for (int i=0; i<lista.size(); i++){
                    gs=lista.get(i);
                
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("             \n");
      out.write("                \n");
      out.write("                 \n");
      out.write("                <option value=\"");
      out.print(gs.getDoc());
      out.write('"');
      out.write('>');
      out.print(gs.getNom());
      out.write("</option>\n");
      out.write("                \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select>\n");
      out.write("           </div>\n");
      out.write("            \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("            <label>Fecha: </label>\n");
      out.write("            <input class=\"form-control\" id=\"exampleInputEmail1\" type=\"date\" name=\"fec\" required=\"\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("            <label>Descripcion: </label>\n");
      out.write("            <input class=\"form-control\" id=\"exampleInputEmail1\" type=\"text\"  maxlength=\"200\" name=\"des\" required=\"\">\n");
      out.write("            </div>\n");
      out.write("            <table> \n");
      out.write("                        <tr>\n");
      out.write("            \n");
      out.write("             </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            \n");
      out.write("                             </tr>\n");
      out.write("                    </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary btn-block\" name=\"diag\">Aceptar</button>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("         ");
}
      out.write("\n");
      out.write("         \n");
      out.write("         ");

         if (request.getParameter("todos")!=null){
         
      out.write("\n");
      out.write("         \n");
      out.write("                    <table class=\"table table-dark\">\n");
      out.write("            <thead class=\"thead\">\n");
      out.write("            <tr>\n");
      out.write("                <th scope=\"col\">Codigo</th>\n");
      out.write("                <th scope=\"col\">Paciente</th>\n");
      out.write("                <th scope=\"col\">Fecha</th>\n");
      out.write("                <th scope=\"col\">Descripcion</th>\n");
      out.write("                <th scope=\"col\">Editar</th>\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            </thead>\n");
      out.write("            \n");
      out.write("            ");

            
            ArrayList<diagnosticogetset> listacliente=new ArrayList<>();
            diagnosticogetset gs=new diagnosticogetset();
            diagnostico consul=new diagnostico();
            
            
            listacliente= consul.consultar();
            

            for (int i=0; i<listacliente.size();i++){

                gs=listacliente.get(i);
            
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(gs.getCod());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDpa());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getFec());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDes());
      out.write("</td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            <form action=\"ServletOdo\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" name=\"cod\" value=\"");
      out.print(gs.getCod());
      out.write("\">\n");
      out.write("                <td><input type=\"submit\" name=\"diag2\" value=\"Editar\"></td>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

            
            ArrayList<dientegetset> die=new ArrayList<>();
            dientegetset gm=new dientegetset();
            diente gss=new diente();
            
            die=gss.consultar();
            
             
          for (int e=0; e<die.size();e++){
                    gm=die.get(e);
                
                 
                
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(gm.getCod());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gm.getNom());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gm.getIma());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gm.getEst());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gm.getTip());
      out.write("</td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            <form action=\"ServletOdo\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" name=\"cod\" value=\"");
      out.print(gm.getCod());
      out.write("\">\n");
      out.write("                <td><input type=\"submit\" name=\"diag2\" value=\"Editar\"></td>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            </tr>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("         \n");
      out.write("         ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
