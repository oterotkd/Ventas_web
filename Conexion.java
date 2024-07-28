package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager; 
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection con;
    public static String usuario="root";
    public static String url="jdbc:mysql://localhost/ventas_2";
    public static String passw="Janna1605";
  

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,passw);
        } catch (Exception e) {
        }

        return con;
   }
    public static void cerrar(){
        try {
            if(con != null){
                con.close();
            }
        } catch (Exception e) {
        }
        System.out.println("Error no se logró cerrar la conexion....");
    }
   

}
