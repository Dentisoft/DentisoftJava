
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class quejas {
    conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    
        public ArrayList<quejasgetset> consultar(){
        ArrayList<quejasgetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_quejas");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              quejasgetset consultar=new quejasgetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        
            public ArrayList<quejasgetset> consultarDoc(String doc){
        ArrayList<quejasgetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_quejas where que_doc_pac='"+doc+"'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              quejasgetset consultar=new quejasgetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
            
            
                public ArrayList<quejasgetset> consultarRespondidos(String doc){
        ArrayList<quejasgetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_quejas where que_doc_pac='"+doc+"' and que_respuesta !='NULL'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              quejasgetset consultar=new quejasgetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        
                public ArrayList<quejasgetset> NoRespondidos(){
        ArrayList<quejasgetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_quejas where que_respuesta='NULL'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              quejasgetset consultar=new quejasgetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
                
                        public ArrayList<quejasgetset> ConsulCod(String cod){
        ArrayList<quejasgetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_quejas where que_id='"+cod+"'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              quejasgetset consultar=new quejasgetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
        
             public boolean insertar(quejasgetset usugs){
        boolean dat=false;
        int x;
        try {
            ps=cnn.prepareStatement("Insert Into tb_quejas (que_doc_pac, que_doc_odo, que_fec, que_com, que_respuesta) values(?,?,?,?, ?)");            
            
            ps.setString(1, usugs.getPac());
            ps.setString(2, usugs.getOdo());
            ps.setString(3, usugs.getFec());     
            ps.setString(4, usugs.getDes());
            ps.setString(5, usugs.getRes());
            

            x=ps.executeUpdate();
            if(x<0){
                dat=true;
            }else{
                dat=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return dat;
    } 
             
             
     public boolean responderQueja(String id, String res){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_quejas SET que_respuesta='"+res+ "'WHERE que_id='"+id+"'");            
           
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
