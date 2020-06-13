
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class factura {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<facturagetset> consultar(){
        ArrayList<facturagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_factura");
            rs=ps.executeQuery();
            
            while(rs.next()){
              facturagetset consultar=new facturagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<facturagetset> consultarCod(String cod){
        ArrayList<facturagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_factura where fact_codigo='"+cod+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              facturagetset consultar=new facturagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        public ArrayList<facturagetset> consultarPac(String doc){
        ArrayList<facturagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select * from tb_factura inner join tb_procedimiento on (fact_cod_procedimiento=pro_codigo) inner join tb_tratamiento on (pro_cod_tratamiento=trat_codigo) inner join tb_diagnostico on (trat_cod_diagnos=diag_codigo) inner join tb_paciente on (pac_documento=diag_doc_paciente) where pac_documento='"+doc+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              facturagetset consultar=new facturagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(facturagetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_factura (fact_cod_procedimiento, "
                    + "fact_fecha, fact_valor, fact_descrip) values(?,?,?,?)");            
            
            ps.setString(1, usugs.getCpr());
            ps.setString(2, usugs.getFec());
            ps.setString(3, usugs.getVal());
            ps.setString(4, usugs.getDes());

            
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
    public boolean eliminar(facturagetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_factura where fact_codigo='"+usugs.getCod()+"'");               
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
 public boolean actualizar(facturagetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_factura SET fact_cod_procedimiento='"+usugs.getCpr()+
                    "',fact_fecha='"+usugs.getFec()+
                    "',fact_valor='"+usugs.getVal()+
                    "',fact_descrip='"+usugs.getDes()+
                    "'WHERE fact_codigo='"+usugs.getCod()+"'");            
           
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
 
 
  public boolean actualizarFac(String cod, String pro, String fec, String val, String des){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_factura SET fact_cod_procedimiento='"+pro+
                    "',fact_fecha='"+fec+
                    "',fact_valor='"+val+
                    "',fact_descrip='"+des+
                    "'WHERE fact_codigo='"+cod+"'");            
           
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
