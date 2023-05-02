public class Zuzena {
    int grosor;

    Punto p1,p2;

    Zuzena(int grosor,Punto p1,Punto p2){
        this.grosor=grosor;
        this.p1=p1;
        this.p2=p2;
    }

    boolean horiz(){
        if(p1.gety() == p2.gety()){
            return true;
        }
        else{
            return false;
        }
    }

    boolean bert(){
        if (p1.getX() == p2.getX()){
            return true;
        }
        else{
            return false;
        }
    }


}
