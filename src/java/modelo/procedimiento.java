
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class procedimiento {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<procedimientogetset> consultar(){
        ArrayList<procedimientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_procedimiento");
            rs=ps.executeQuery();
            
            while(rs.next()){
              procedimientogetset consultar=new procedimientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
    
        public ArrayList<procedimientogetset> consultarCod(String cod){
        ArrayList<procedimientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_procedimiento where pro_codigo='"+cod+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              procedimientogetset consultar=new procedimientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<procedimientogetset> consultarPac(String doc){
        ArrayList<procedimientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_procedimiento inner join tb_tratamiento on (pro_cod_tratamiento=trat_codigo) inner join tb_diagnostico on (trat_cod_diagnos=diag_codigo) inner join tb_paciente on (pac_documento=diag_doc_paciente) where pac_documento='"+doc+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              procedimientogetset consultar=new procedimientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(procedimientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_procedimiento (pro_cod_tratamiento, pro_descripcion"
                    + ", pro_nombre, pro_duracion) values(?,?,?,?)");            
            
            ps.setString(1, usugs.getCtr());
            ps.setString(2, usugs.getDes());
            ps.setString(3, usugs.getNom());
            ps.setString(4, usugs.getDur());

            
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
    public boolean eliminar(procedimientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_procedimiento where pro_codigo='"+usugs.getCod()+"'");               
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
 public boolean actualizar(procedimientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_procedimiento SET pro_cod_tratamiento='"+usugs.getCtr()+
                    "',pro_descripcion='"+usugs.getDes()+
                    "',pro_nombre='"+usugs.getNom()+
                    "',pro_duracion='"+usugs.getDur()+
                    "'WHERE pro_codigo='"+usugs.getCod()+"'");            
           
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

 public boolean actualizarCod(String cod, String tra, String des, String nom, String dur){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_procedimiento SET pro_cod_tratamiento='"+tra+
                    "',pro_descripcion='"+des+
                    "',pro_nombre='"+nom+
                    "',pro_duracion='"+dur+
                    "'WHERE pro_codigo='"+cod+"'");            
           
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
