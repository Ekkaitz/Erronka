package Items;

public class Item {
    protected int id;
    protected String titulua;
    protected String idazlea;

    public Item() {}


    public void show(){
        System.out.println(this.id);
        System.out.println(this.idazlea);
        System.out.println(this.titulua);
    }

}

