
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class cita {
         conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    
        public ArrayList<citagetset> consulpac(String dpa){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
        ps=cnn.prepareStatement("Select * from tb_cita where cit_doc_paciente='"+dpa+"'");
        rs=ps.executeQuery();
        
        while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
    public ArrayList<citagetset> consultar(){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_cita");
            rs=ps.executeQuery();
            
            while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<citagetset> consultarOcu(){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_cita where cit_estado='No disponible'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        public ArrayList<citagetset> CitPac(String doc){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select * from tb_cita where cit_doc_paciente='"+doc+"'");
            rs=ps.executeQuery();
            
            while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(citagetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Insert Into tb_cita (cit_doc_paciente, cit_doc_odontologo, "
                    + "cit_fecha, cit_hora, cit_estado)  values(?,?,?,?,?)");            
            
            ps.setString(1, usugs.getDpa());
            ps.setString(2, usugs.getDod());
            ps.setString(3, usugs.getFec());
            ps.setString(4, usugs.getHor());
            ps.setString(5, usugs.getEst());

            
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
         

    public boolean eliminar(String cod){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("update  tb_cita set cit_doc_paciente=null, cit_estado='Disponible' where cit_codigo='"+cod+"'");               
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
 public boolean actualizar(citagetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_cita SET cit_doc_paciente='"+usugs.getDpa()+"',cit_doc_odontologo='"+usugs.getDod()
                    +"', cit_fecha='"+usugs.getFec()
                    +"', cit_hora='"+usugs.getHor()
                    +"', cit_fecha='"+usugs.getEst()
                    +"'WHERE  cit_codigo ='"+usugs.getCod()+"'");            
           
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
 
 
         public ArrayList<citagetset> CitasDispo(String fec, String odo){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select distinct cit_codigo, cit_doc_paciente, cit_doc_odontologo, cit_fecha, cit_hora, cit_estado from tb_cita"
                    + " inner join tb_odontologo on (odo_documento=cit_doc_odontologo)  where cit_estado='Disponible'and cit_fecha='"+fec+"' and cit_doc_odontologo='"+odo+"' order by cit_fecha");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null, fec);
            JOptionPane.showMessageDialog(null, odo);
            

            while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
         
             public ArrayList<citagetset> consulCod(String cod){
        ArrayList<citagetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_cita where cit_codigo='"+cod+"'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              citagetset consultar=new citagetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
             
        public boolean Asignar(String doc, String cod){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_cita SET cit_doc_paciente='"+doc+"', cit_estado='No disponible' where cit_codigo='"+cod+"'");            
           
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


