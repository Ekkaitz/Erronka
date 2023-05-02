public class Ikaslea {
    private String izena;
    private double nota;
    private String idatzi;

    Ikaslea(String Izena,double nota){
        this.izena=izena;
        this.nota=nota;
    }

    public String getIzena(){
        return izena;
    }

    public double getNota(){
        return nota;
    }

    public String idatzia(){
        switch ((int) nota){
            case 1,2,3,4:
                idatzi="suspenso";
                break;
            case 5,6:
                idatzi="ongi";
                break;
            case 7,8:
                idatzi="oso ongi";
                break;
            case 9,10:
                idatzi="bikain";
                break;
            default:
                idatzi="Sartu beste zenbaki bat";
        }
        return idatzi;
    }
}


