
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class paciente {
     conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<pacientegetset> consultar(){
        ArrayList<pacientegetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_paciente");
            rs=ps.executeQuery();
            
            while(rs.next()){
              pacientegetset consultar=new pacientegetset(rs.getString(1),rs.getString(2),rs.getString(3));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
    
     public boolean insertar(pacientegetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_paciente values(?,?,?)");            
            ps.setString(1, usugs.getDoc());
            ps.setString(2, usugs.getNom());
            ps.setString(3, usugs.getEda());

            
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
    public boolean eliminar(pacientegetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_paciente where pac_documento='"+usugs.getDoc()+"'");               
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
 public boolean actualizar(pacientegetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_paciente SET pac_nombre='"+usugs.getNom()+"',pac_edad='"+usugs.getEda()+
                    "'WHERE pac_documento='"+usugs.getDoc()+"'");            
           
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


