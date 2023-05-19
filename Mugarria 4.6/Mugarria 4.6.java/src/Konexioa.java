import javax.swing.*;
import java.sql.*;

public class Konexioa {
    public Connection konexioa;
    public Statement sententzia;

    private String erabiltzailea="root";
    private String pasahitza="zubiri";
    private ListModel<String> modelList;


    public void konexioEgin(){

        try {

            final String url="jdbc:mysql://localhost:3306/mugarria6";
            konexioa= DriverManager.getConnection(url,erabiltzailea,pasahitza);
            sententzia=konexioa.createStatement();
            System.out.println("Konektatuta");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void artistakBete(){
        String selecta="select * from pictures where photographer_id= (select photographer_id from photographers where name= ?)";
        Statement statement;
    }
}
