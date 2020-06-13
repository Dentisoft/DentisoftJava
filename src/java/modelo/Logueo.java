package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Logueo {
    conexion con = new conexion();
    Connection cnn = con.conexionbd();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<usuariogetset> login(usuariogetset gs){
        ArrayList<usuariogetset> list = new ArrayList<>();
        try {
            ps = cnn.prepareStatement("SELECT usu_documento, usu_nombre, AES_DECRYPT(usu_clave, 'asdfg'), usu_rol, usu_sexo, usu_estado, usu_email, usu_telefono, usu_foto FROM tb_usuario WHERE usu_nombre='"+gs.getNom()+"' AND AES_DECRYPT(usu_clave, 'asdfg')='"+gs.getCla()+"'");
            rs = ps.executeQuery();
            while(rs.next()){
                usuariogetset gts = new usuariogetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(gts);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return list;
    }
    
   
}
