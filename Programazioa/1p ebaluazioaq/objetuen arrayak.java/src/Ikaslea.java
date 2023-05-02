public class Ikaslea {
    private String izena;
    private String notaid;
    private float nota;

    Ikaslea(String izena,float nota){
        this.izena=izena;
        this.nota=nota;
        letraz();
    }

    public String letraz(){
        switch ((int) nota){
            case 0,1,2,3,4:
                this.notaid="ez duzu gainditu";
                break;
            case 5,6:
                this.notaid="ondo";
                break;
            case 7,8:
                this.notaid="oso ondo";
                break;
            case 9,10:
                this.notaid="bikain";
                break;
            default:
                this.notaid="sartu zenbaki egoki bat";
        }
        return notaid;
    }

    public String getIzena() {
        return izena;
    }

    public String getNotaid() {
        return notaid;
    }

    public float getNota() {
        return nota;
    }


}
