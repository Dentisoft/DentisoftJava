
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexion {

    Connection cnn;
    public Connection conexionbd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnn=DriverManager.getConnection("jdbc:mysql://localhost/db_dentisoft1","root","");
}
catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
}
    return cnn;
    }
        public static void main(String []args){
            conexion con=new conexion();
            con.conexionbd();
        }
}
