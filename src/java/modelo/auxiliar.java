
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class auxiliar {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<auxiliargetset> consultar(){
        ArrayList<auxiliargetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_auxiliar");
            rs=ps.executeQuery();
            
            while(rs.next()){
              auxiliargetset consultar=new auxiliargetset(rs.getString(1),rs.getString(2));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(auxiliargetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_auxiliar values(?,?)");            
            ps.setString(1, usugs.getDoc());
            ps.setString(2, usugs.getNom());

            
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
    public boolean eliminar(auxiliargetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_auxiliar where aux_documento='"+usugs.getDoc()+"'");               
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
 public boolean actualizar(auxiliargetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_auxiliar SET aux_nombre='"+usugs.getNom()+
                    "'WHERE aux_documento='"+usugs.getDoc()+"'");            
           
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
