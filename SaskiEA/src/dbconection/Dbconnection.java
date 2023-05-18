package dbconection;

import javax.swing.*;
import java.sql.*;

public class Dbconnection {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    private String user = "c##taldea5";
    private String passw = "Zubiri99";
    boolean egoera;

    public void ConexionBaseDeDatos(){
        try{
            final String Controlador = "oracle.jdbc.driver.OracleDriver";
            Class.forName(Controlador);
            final String url = "jdbc:oracle:thin:@10.14.0.232:1521:orcl";
            conexion = DriverManager.getConnection(url,user,passw);
            sentencia = conexion.createStatement();
            System.out.println("Conexión establecida");
            egoera=true;

            /*String a = "INSERT INTO erabiltzaileak (erabiltzailea,pasahitza,email,mota) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = null;

            try{
                pstmt = conexion.prepareStatement(a);
                pstmt.setString(1, "a");
                pstmt.setString(2,"n");
                pstmt.setString(3,"k");
                pstmt.setString(4,"o");
                pstmt.execute();
            }catch (SQLException ex){
                System.out.println("error al preparas la sentencia SQL: "+ ex.getMessage());
            }*/
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("error");
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            egoera=false;
        }

    }
    public boolean DesconexionDeBasesDeDatos(){
        try{
            if(conexion != null){
                if(sentencia != null){
                    sentencia.close();
                }
                conexion.close();
            }
            return true;
        }catch (SQLException ex){
            System.out.println("No se ha desconextado");
            JOptionPane.showMessageDialog(null,ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public Connection getConexion(){
        return conexion;
    }

    public boolean getEgoera() {
        return egoera;
    }
}
