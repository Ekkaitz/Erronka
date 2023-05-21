package dbconection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kontsultak {
    Dbconnection konexioa;
    PreparedStatement ps;
    ResultSet rs;

    public Kontsultak() {
        konexioa=new Dbconnection();
    }

    public ArrayList<Ordutegia> entrenamenduordutegia(){
        ArrayList<Ordutegia> ordutegiak=new ArrayList<>();
        String ordutegia="select * from e_entrenatu_t";

        try {
            ps=konexioa.conexion.prepareStatement(ordutegia);
            rs=ps.executeQuery();

            while (rs.next()){
                int a=rs.getInt("id_langilea");
                String b=rs.getString("izena_taldea");
                String c=rs.getString("hasiera_data");
                String d=rs.getString("amaiera_data");

                Ordutegia o=new Ordutegia(a,b,c,d);
                ordutegiak.add(o);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ordutegiak;
    }
}
