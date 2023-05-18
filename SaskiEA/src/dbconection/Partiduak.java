package dbconection;

public class Partiduak {
    private int id_partidoa;
    private String zelaia,emaitza,data;

    public Partiduak(int id, String zelaia, String emaitza, String data){
        this.id_partidoa=id;
        this.zelaia=zelaia;
        this.emaitza=emaitza;
        this.data=data;
    }

    public String getData() {
        return data;
    }

    public String getEmaitza() {
        return emaitza;
    }

    public String getZelaia() {
        return zelaia;
    }

    public String getId_partidoa() {

        return String.valueOf(id_partidoa);
    }
}
