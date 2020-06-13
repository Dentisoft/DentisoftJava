
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class usuario {
  conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<usuariogetset> consultar(){
        ArrayList<usuariogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_usuario");
            rs=ps.executeQuery();
            while(rs.next()){
              usuariogetset consultar=new usuariogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
      public ArrayList<usuariogetset> consultarDoc(String doc){
        ArrayList<usuariogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select usu_documento, usu_nombre, AES_DECRYPT(usu_clave, 'asdfg'), usu_rol, usu_sexo, usu_estado, usu_email, usu_telefono, usu_foto from tb_usuario where usu_documento='"+doc+"'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              usuariogetset consultar=new usuariogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        
    public ArrayList<usuariogetset> consultarRol(){
        ArrayList<usuariogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_usuario where usu_rol='paciente'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              usuariogetset consultar=new usuariogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<usuariogetset> consultarOdo(){
        ArrayList<usuariogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_usuario where usu_rol='odontologo'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Datos consultados");
            while(rs.next()){
              usuariogetset consultar=new usuariogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<usuariogetset> consultarPac(String doc){
        ArrayList<usuariogetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select usu_documento, usu_nombre, AES_DECRYPT(usu_clave, 'asdfg'), usu_rol, usu_sexo, usu_estado, usu_email, usu_telefono, usu_foto from tb_usuario where usu_documento='"+doc+"'");
            rs=ps.executeQuery();
            while(rs.next()){
              usuariogetset consultar=new usuariogetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(usuariogetset usugs){
        boolean dat=false;
        int x;
        try {
            ps=cnn.prepareStatement("Insert Into tb_usuario values(?,?,AES_ENCRYPT(?,'asdfg'),?,?,?,?,?,?)");            
            ps.setString(1, usugs.getDoc());
            ps.setString(2, usugs.getNom());
            ps.setString(3, usugs.getCla());
            ps.setString(4, usugs.getRol());     
            ps.setString(5, usugs.getSex());
            ps.setString(6, usugs.getEst());
            ps.setString(7, usugs.getEma());
            ps.setString(8, usugs.getTel());
            ps.setString(9, usugs.getFot());

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
     public boolean eliminar(usuariogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_usuario where usu_documento='"+usugs.getDoc()+"'");               
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
     
          public boolean eliminarUsu(String usu){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("DELETE FROM tb_usuario where usu_documento='"+usu+"'");               
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
 public boolean actualizar(usuariogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_usuario SET usu_nombre='"+usugs.getNom()+
                    "',usu_rol='"+usugs.getRol()+
                    "',usu_sexo='"+usugs.getSex()+
                    "',usu_estado='"+usugs.getEst()+
                    "',usu_email='"+usugs.getEma()+
                    "',usu_telefono='"+usugs.getTel()+
                    "',usu_foto='"+usugs.getFot()+
                    "'WHERE usu_documento='"+usugs.getDoc()+"'");            
           
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
  public boolean actualizaru(usuariogetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_usuario SET usu_nombre='"+usugs.getNom()+
                    "',usu_rol='"+usugs.getRol()+
                    "',usu_sexo='"+usugs.getSex()+
                    "',usu_estado='"+usugs.getEst()+
                    "',usu_email='"+usugs.getEma()+
                    "',usu_telefono='"+usugs.getTel()+
                    "'WHERE usu_documento='"+usugs.getDoc()+"'");            
           
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



 public boolean actualizarUsu(String doc, String nom, String cla, String rol, String sex, String est, String ema, String tel, String fot){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_usuario SET usu_nombre='"+nom+
                    "',usu_clave=AES_ENCRYPT('"+cla+
                    "', 'asdfg'),usu_rol='"+rol+
                    "',usu_sexo='"+sex+
                    "',usu_estado='"+est+
                    "',usu_email='"+ema+
                    "',usu_telefono='"+tel+
                    "',usu_foto='"+fot+
                    "'WHERE usu_documento='"+doc+"'");            
           
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


