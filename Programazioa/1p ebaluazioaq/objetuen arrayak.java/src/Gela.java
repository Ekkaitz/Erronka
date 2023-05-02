public class Gela {
    private Ikaslea[] gela;

    Gela(){
        this.gela=new Ikaslea[20];
    }

    public void sartuarray(String izena,float nota){
        Ikaslea obj=new Ikaslea(izena,nota);

        for (int i=0;i< gela.length;i++){
            if (gela[i]==null){
                gela[i]=obj;
                i= gela.length;
            }

        }
    }

    public void idatzi(){
        for (int i=0;i<gela.length;i++){
            System.out.println(gela[i].getIzena());
            System.out.println(gela[i].letraz());
        }
    }

    public void idatzi1(String iznea){
        for (int i=0;i< gela.length;i++){
            if(gela[i]!=null){
                System.out.println("vfsf");
                if(gela[i].getIzena().equals(iznea)){
                    System.out.println(iznea);
                    System.out.println(gela[i].letraz());
                }
            }
            else {System.out.println(gela[0]);}

        }
    }
}
