public class StringContainer {
    private String izena;
    private static final int n=10;
    int kont;

    public StringContainer(String izena){
        this.izena=izena;
    }

    public String toString(){
        return this.izena+kont;
    }

    public boolean isEqualTo(String bi){
        return this.izena.equals(bi);
    }

    public void shiftLeft(int x,char letra){
        String berria;
        berria=izena.substring(x,izena.length());

        for (int i=0;i<x;i++){
            berria=letra+berria;
        }
        this.izena=berria;
        System.out.println(this.izena);
    }

    public void shiftRigth(int x,char letra){
        String berria;
        berria=izena.substring(0,izena.length()-x);

        for (int i=0;i<x;i++){
            berria=letra+berria;
        }
        this.izena=berria;
        System.out.println(this.izena);

    }

    public void rotate(int x,char rl){
        String berria="";

        if (rl=='R'){
           berria=izena.substring(x);
           berria=berria+" "+izena.substring(0,x);
        }
        else if (rl=='L'){
            berria=izena.substring(0,izena.length()-x);
            berria=izena.substring(izena.length()-x)+" "+berria;
        }

        System.out.println(berria);

    }

    public void encoding(int x){
        String abc="abcdefghijklmnñopqrstuvwxyz";
        char berria=' ';
        String berria2="";
        int k=0;

        for (int i=0;i<izena.length();i++){
            for (int j=0;j<abc.length();j++){
                if (izena.charAt(i)==abc.charAt(j)){
                    if (i%2==0){
                        if ((j+x)>26){
                            k=j;
                            j=(j+x)-26;
                            berria=abc.charAt(j-1);
                            j=k;
                        }
                        else{
                            berria=abc.charAt(j+x);
                        }
                    }
                    else{
                        if((j-x)<0){
                            k=j;
                            j=(j-x)+26;
                            berria=abc.charAt(j+1);
                            j=k;
                        }
                        else{
                            berria=abc.charAt(j-x);
                        }
                    }
                    berria2=berria2+berria;
                }
            }
        }
        System.out.println(berria2);
    }

    public void random(){
        int rnd;
        rnd= (int) Math.random()*this.n+1;
        encoding(rnd);

    }

    public String mixWords(StringContainer a, StringContainer b){
        String c="";
        int kont1=0;
        int kont2=0;
        boolean container1=false;
        boolean container2=false;
        while(container1 == false && container2==false){
            while (kont1<a.izena.length() && a.izena.charAt(kont1) != ' '){
                c=c+a.izena.charAt(kont1);
                if (kont1== a.izena.length()-1){
                    container1=true;
                }
                kont1++;
            }
            kont1++;
            while (kont2<b.izena.length() && b.izena.charAt(kont2)!= ' ' ){
                c=c+b.izena.charAt(kont2);
                if (kont1== b.izena.length()-1){
                    container2=true;
                }
                kont2++;
            }
            kont2++;
        }
        return c;
    }
}
