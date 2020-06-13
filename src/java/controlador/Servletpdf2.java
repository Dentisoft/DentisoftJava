/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import com.itextpdf.text.Image;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import com.itextpdf.text.Image;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Phaser;
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
import com.itextpdf.text.Chunk;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import java.awt.geom.Area;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import javafx.scene.control.Cell;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javax.swing.JOptionPane;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.ColorConstants;
import javax.swing.text.html.CSS;
@WebServlet(name = "Servletpdf2", urlPatterns = {"/Servletpdf2"})
public class Servletpdf2 extends HttpServlet {

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
       
        
        if(request.getParameter("btnpdf")!=null){
            this.pdf(request, response);
        }
        
    }

     protected void pdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             response.setContentType("application/pdf");
             OutputStream out=response.getOutputStream();
             
             String Doc=request.getParameter("Doc");
             ArrayList<facturagetset> list=new ArrayList<>();
             facturagetset lo=new facturagetset(Doc);
             factura mc=new factura();
             list=mc.consultarPac(Doc);
                          JOptionPane.showMessageDialog(null,Doc);

             Document documento=new Document(PageSize.CROWN_OCTAVO.rotate());
             String nombre;
            nombre=request.getParameter("nom");
            String fecha;
         
            
             Date dNow = new Date();
             SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String currentDate = ft.format(dNow);
        
        fecha=currentDate;
             
             try {
                 PdfWriter.getInstance((Document) documento,out);
                 PdfWriter.getInstance(documento, new FileOutputStream("pba.pdf"));
        
                 
             } catch (Exception e) {
             }
             
             documento.open();
             Paragraph pg=new Paragraph();
         
             Font titulo=new Font(Font.FontFamily.HELVETICA,24,Font.BOLD,BaseColor.BLUE);
             Font nom = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLDITALIC, BaseColor.LIGHT_GRAY);
            

             pg.add(new Phrase("Factura",titulo));            
             pg.add(new Phrase(Chunk.NEWLINE));
             pg.add(new Phrase(nombre+" ",nom));
              pg.add(new Phrase(fecha,nom));
             pg.setAlignment(Element.ALIGN_CENTER);
             pg.add(new Phrase(Chunk.NEWLINE));
            pg.add(new Phrase(Chunk.NEWLINE));
             PdfPTable tabla=new PdfPTable(5);
             tabla.setWidthPercentage(100);
             
             
       
             Image imagen = Image.getInstance("D:\\Documentos\\Dentisoftproyecto\\web\\ima\\luisa_amor.gif");
             documento.add(imagen);
             
               Image imagens = Image.getInstance("D:\\Documentos\\Dentisoftproyecto\\web\\ima\\logo_oral.png");
                imagens.setAbsolutePosition(90, -25);

            documento.add(imagens);
            
            Image imagenss = Image.getInstance("D:\\Documentos\\Dentisoftproyecto\\web\\ima\\pop.png");
                imagenss.setAbsolutePosition(-9, -110);

            documento.add(imagenss);
             PdfPCell doc=new PdfPCell(new Paragraph("Documento",FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.WHITE)));
             PdfPCell docp=new PdfPCell(new Paragraph("Codigo del procedimiento ",FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.RED)));
             PdfPCell fec=new PdfPCell(new Paragraph("Fecha",FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.RED)));
             PdfPCell val=new PdfPCell(new Paragraph("Valor",FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.RED)));
             PdfPCell des=new PdfPCell(new Paragraph("Descripción",FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.RED)));

             
      PdfPCell docu=new PdfPCell(new Paragraph(lo.getCod(),FontFactory.getFont("Arial",10,Font.ITALIC,BaseColor.WHITE)));
     docu.setBackgroundColor(BaseColor.DARK_GRAY);
     
     doc.setBackgroundColor(BaseColor.DARK_GRAY);
     

             documento.add(pg);
             tabla.addCell(doc);
             tabla.addCell(docp);
             tabla.addCell(fec);
             tabla.addCell(val);
             tabla.addCell(des);
             
          
             for(int i=0; i<list.size(); i++){
                 lo=list.get(i);
                 tabla.addCell(docu);
                 tabla.addCell(lo.getCpr());
                 tabla.addCell(lo.getFec());
                 tabla.addCell(lo.getVal());
                 tabla.addCell(lo.getDes());
             }
             
             documento.add(tabla);
             documento.close();
             
             JOptionPane.showMessageDialog(null,"nn");
                     
         } catch (Exception e) {
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
