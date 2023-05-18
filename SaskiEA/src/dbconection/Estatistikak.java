package dbconection;

public class Estatistikak {
    private int puntuazioa;
    private int asistentziak;
    private String jokalaria_izena;

    public Estatistikak(int puntuazioa,int asistentziak,String jokalaria_izena){

        this.puntuazioa=puntuazioa;
        this.asistentziak=asistentziak;
        this.jokalaria_izena=jokalaria_izena;

    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public int getAsistentziak() {
        return asistentziak;
    }

    public String getJokalaria_izena() {
        return jokalaria_izena;
    }
}
