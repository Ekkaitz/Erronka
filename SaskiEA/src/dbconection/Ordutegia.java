package dbconection;

public class Ordutegia {
    int id;
    String izena,h_data, b_data;

    public Ordutegia(int id,String izena,String h_data,String b_data){
        this.id=id;
        this.izena=izena;
        this.b_data=b_data;
        this.h_data=h_data;
    }

    public String getB_data() {
        return b_data;
    }

    public String getH_data() {
        return h_data;
    }

    public String getIzena() {
        return izena;
    }

    public int getId() {
        return id;
    }
}
