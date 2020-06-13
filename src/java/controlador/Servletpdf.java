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
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfLayer;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.Spring.height;
import javax.swing.text.StyleConstants;
@WebServlet(name = "Servletpdf", urlPatterns = {"/Servletpdf"})
public class Servletpdf extends HttpServlet {

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
             Document documento=new Document(PageSize.PENGUIN_LARGE_PAPERBACK.rectangle(10000,0));
             
             String nombre = request.getParameter("nom");
            String fecha = null;
         
            
             Date dNow = new Date();
             SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
      String currentDate = ft.format(dNow);
        
        fecha=currentDate;
     
                //Se indica la posicion donde se colocara la imágen en el PDF                //Se inserta la imágen en el PDF
         
         
             
             try {
                 PdfWriter.getInstance((Document) documento,out);
                 
                 
                 
             } catch (Exception e) {
             }
             
             
             
             documento.open();
               Image imagen = Image.getInstance("C:\\Users\\Lucho\\Downloads\\proyectojava1\\web\\ima\\cuerpo.png");
                imagen.setAbsolutePosition(90, 0);

            documento.add(imagen);
            Image imagens = Image.getInstance("C:\\Users\\Lucho\\Downloads\\proyectojava1\\web\\ima\\font.png");
                imagens.setAbsolutePosition(-140, 0);

            documento.add(imagens);
             Paragraph pg=new Paragraph();
             
             Font titulo=new Font(Font.FontFamily.HELVETICA,40,Font.ITALIC,BaseColor.PINK);
            Font nom = new Font(Font.FontFamily.COURIER, 8, Font.UNDEFINED, BaseColor.BLACK );
   
        Font text = new Font(Font.FontFamily.HELVETICA, 20, Font.DEFAULTSIZE, BaseColor.PINK);

            
            pg.add(new Phrase(" Creado por:"+nombre,nom));
            pg.add(new Phrase(Chunk.NEWLINE));
            
              pg.add(new Phrase(fecha,nom));
              pg.add(new Phrase(Chunk.NEWLINE));
                           pg.add(new Phrase(Chunk.NEWLINE));
  
              pg.add(new Phrase("Listado de",text));

             pg.add(new Phrase(Chunk.NEWLINE));
              pg.add(new Phrase(Chunk.NEWLINE));

             pg.add(new Phrase("FACTURAS",titulo));
              pg.add(new Phrase(Chunk.NEWLINE));
           
             pg.setAlignment(Element.ALIGN_CENTER);
             pg.add(new Phrase(Chunk.NEWLINE));
            pg.add(new Phrase(Chunk.NEWLINE));
            
                Paragraph paragraph = new Paragraph();
                
             PdfPTable tabla=new PdfPTable(5);
             tabla.setWidthPercentage(115);
             
             PdfPCell doc=new PdfPCell(new Paragraph("Documento",FontFactory.getFont("Arial",11,Font.NORMAL,BaseColor.DARK_GRAY)));
             PdfPCell docp=new PdfPCell(new Paragraph("Procedimiento",FontFactory.getFont("Arial",9,Font.NORMAL,BaseColor.DARK_GRAY)));
             PdfPCell fec=new PdfPCell(new Paragraph("Fecha",FontFactory.getFont("Arial",11,Font.NORMAL,BaseColor.DARK_GRAY)));
             PdfPCell val=new PdfPCell(new Paragraph("Valor",FontFactory.getFont("Arial",12,Font.NORMAL,BaseColor.DARK_GRAY)));
             PdfPCell des=new PdfPCell(new Paragraph("Objetivo",FontFactory.getFont("Arial",12,Font.NORMAL,BaseColor.DARK_GRAY)));
            
             
            des.setBackgroundColor(BaseColor.LIGHT_GRAY);
            docp.setBackgroundColor(BaseColor.LIGHT_GRAY);
            fec.setBackgroundColor(BaseColor.LIGHT_GRAY);
            val.setBackgroundColor(BaseColor.LIGHT_GRAY);
            doc.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            doc.setBorderColor(BaseColor.DARK_GRAY);
            docp.setBorderColor(BaseColor.DARK_GRAY);
            fec.setBorderColor(BaseColor.DARK_GRAY);
            val.setBorderColor(BaseColor.DARK_GRAY);
            des.setBorderColor(BaseColor.DARK_GRAY);


                        des.setBorderColorLeft(BaseColor.YELLOW);

             
             documento.add(pg);
             tabla.addCell(doc);
             tabla.addCell(docp);
             tabla.addCell(fec);
             tabla.addCell(val);
             tabla.addCell(des);
               
             
          
             for(int i=0; i<list.size(); i++){
                 lo=list.get(i);
                 tabla.addCell(lo.getCod());
                 tabla.addCell(lo.getCpr());
                 tabla.addCell(lo.getFec());
                 tabla.addCell(lo.getVal());
                 tabla.addCell(lo.getDes());
             }
             
             documento.add(tabla);
          

             documento.close();
             
             JOptionPane.showMessageDialog(null,"Exitoso");
                     
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
