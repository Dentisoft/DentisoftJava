
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class tratamiento {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<tratamientogetset> consultar(){
        ArrayList<tratamientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_tratamiento");
            rs=ps.executeQuery();
            
            while(rs.next()){
              tratamientogetset consultar=new tratamientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    

    
        public ArrayList<tratamientogetset> consultarPac(String doc){
        ArrayList<tratamientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_tratamiento inner join tb_diagnostico on (trat_cod_diagnos=diag_codigo) inner join tb_paciente on (pac_documento=diag_doc_paciente) where pac_documento='"+doc+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              tratamientogetset consultar=new tratamientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        
            public ArrayList<tratamientogetset> consultarCod(String cod){
        ArrayList<tratamientogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_tratamiento where trat_codigo='"+cod+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              tratamientogetset consultar=new tratamientogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(tratamientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_tratamiento (trat_cod_diagnos, trat_duracion,"
                    + "trat_descripcion, trat_nombre) values(?,?,?,?)");            
            
            ps.setString(1, usugs.getCdi());
            ps.setString(2, usugs.getDur());
            ps.setString(3, usugs.getDes());
            ps.setString(4, usugs.getNom());

            
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
    public boolean eliminar(tratamientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_tratamiento where  trat_codigo='"+usugs.getCod()+"'");               
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
 public boolean actualizar(tratamientogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_tratamiento SET trat_cod_diagnos='"+usugs.getCdi()+
                    "',trat_duracion='"+usugs.getDur()+
                    "',trat_descripcion='"+usugs.getDes()+
                    "',trat_nombre='"+usugs.getNom()+
                    "'WHERE trat_codigo='"+usugs.getCod()+"'");            
           
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
 
 
  public boolean actualizarTrat(String cod, String diag, String dur, String des, String nom){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_tratamiento SET trat_cod_diagnos='"+diag+
                    "',trat_duracion='"+dur+
                    "',trat_descripcion='"+des+
                    "',trat_nombre='"+nom+
                    "'WHERE trat_codigo='"+cod+"'");            
           
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
 