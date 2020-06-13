

package modelo;


import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class diente {
     conexion con=new conexion();
    Connection cnn=con.conexionbd();
    ResultSet rs=null;
    PreparedStatement ps=null; 
    
    public ArrayList<dientegetset> consultar(){
        ArrayList<dientegetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("Select *from tb_diente");
            rs=ps.executeQuery();
            
            while(rs.next()){
              dientegetset consultar=new dientegetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
        public ArrayList<diagnosticogetset> BuscarCodigo(String paciente, String fecha, String descripcion){
            ArrayList<diagnosticogetset> lista=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("select * from tb_diagnostico where  diag_doc_paciente='"+paciente+"' and diag_fecha='"+fecha+"' and diag_descrip='"+descripcion+"'");
            rs=ps.executeQuery();
            while (rs.next()){
                diagnosticogetset consultar=new diagnosticogetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(consultar);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return lista;
    }
    
    
    public ArrayList<dientegetset> dienteSuperior(){
       ArrayList<dientegetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("select * from tb_diente where estado=0 and tipo=1");
            rs=ps.executeQuery();
            
            while(rs.next()){
              dientegetset consultar=new dientegetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    public ArrayList<diagDientegetset> dientesCodigo(String cod){
        ArrayList<diagDientegetset> lista=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("select * from tb_diacnostico_dientes inner join tb_diente on tb_diente.die_codigo=tb_diacnostico_dientes.die_codigo where estado=0 and diag_codigo='"+cod+"'");
            rs=ps.executeQuery();
            while (rs.next()){
                diagDientegetset consultar=new diagDientegetset(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(consultar);
            }
            
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
            
        }
        return lista;
    }
    
    public boolean borrarDatos(String codigo){
        boolean reg=false;
        int dat;
        try{
            ps=cnn.prepareStatement("delete from tb_diacnostico_dientes where diag_codigo='"+codigo+"'");
            dat=ps.executeUpdate();
            if (dat>0){
                reg=true;
            }else{
                reg=false;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    public ArrayList<dientegetset> dienteInferior(){
        ArrayList<dientegetset> lista=new ArrayList<>();
        try{
            ps=cnn.prepareStatement("select * from tb_diente where estado=0 and tipo=2");
            rs=ps.executeQuery();
            
            while(rs.next()){
              dientegetset consultar=new dientegetset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(consultar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
        
    }
    
     public boolean insertar(diagDientegetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("insert into tb_diacnostico_dientes ( die_codigo, pacDie_descripcion,diag_codigo) values (?, ?,?)");            
            ps.setString(1, usugs.getDienCod());
            ps.setString(2, usugs.getDiagDes());
            ps.setString(3, usugs.getDiagId());
            
         
            
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
    
 public boolean actualizar(dientegetset usugs){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("UPDATE tb_diente SET die_nombre='"+usugs.getNom()+"',die_imagen='"+usugs.getIma()+
                    "'WHERE pac_documento='"+usugs.getCod()+"'");            
           
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


