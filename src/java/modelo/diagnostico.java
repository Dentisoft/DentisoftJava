
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class diagnostico {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<diagnosticogetset> consultar(){
        ArrayList<diagnosticogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_diagnostico");
            rs=ps.executeQuery();
            
            while(rs.next()){
              diagnosticogetset consultar=new diagnosticogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        public ArrayList<diagnosticogetset> consultarCod(String cod){
        ArrayList<diagnosticogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_diagnostico where diag_codigo='"+cod+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              diagnosticogetset consultar=new diagnosticogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<diagnosticogetset> consultarPac(String doc){
        ArrayList<diagnosticogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select * from tb_diagnostico inner join tb_paciente on (diag_doc_paciente=pac_documento) where diag_doc_paciente='"+doc+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              diagnosticogetset consultar=new diagnosticogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
    
    
     public boolean insertar(diagnosticogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into  tb_diagnostico (diag_doc_paciente, diag_fecha, diag_descrip) values(?,?,?)");            
            
            ps.setString(1, usugs.getDpa());
            ps.setString(2, usugs.getFec());
            ps.setString(3, usugs.getDes());
            
            dat=ps.executeUpdate();
            if(dat<0){
                reg=true;
            }else{
                reg=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    public boolean eliminar(diagnosticogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_diagnostico where diag_codigo='"+usugs.getCod()+"'");               
            dat=ps.executeUpdate();
            if(dat>0){
                reg=true;
        }else{
                reg=false;
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
 public boolean actualizar(diagnosticogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_diagnostico SET diag_doc_paciente='"+usugs.getDpa()+
                    "',diag_fecha='"+usugs.getFec()+
                    "',diag_descrip='"+usugs.getDes()+
                    "'WHERE diag_codigo='"+usugs.getCod()+"'");            
           
            dat=ps.executeUpdate();
            if(dat>0){
                reg=true;
            }else{
                reg=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    } 
 
 
  public boolean actualizarDiag(String cod, String doc, String fec, String des){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_diagnostico SET diag_doc_paciente='"+doc+
                    "',diag_fecha='"+fec+
                    "',diag_descrip='"+des+
                    "'WHERE diag_codigo='"+cod+"'");            
           
            dat=ps.executeUpdate();
            if(dat>0){
                reg=true;
            }else{
                reg=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    } 
}

