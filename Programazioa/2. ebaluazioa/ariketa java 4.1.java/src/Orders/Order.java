package Orders;

import Items.Item;


public class Order {
    private Clients cl;
    private Item it;
    private int ordNum;


    Order(Clients a,Item b, int c){
        this.cl=a;
        this.it=b;
        this.ordNum=c;
    }

    public void show(){
        System.out.println(ordNum);
        System.out.println(cl.getCli_id());
        System.out.println(cl.getIzena());
        this.it.show();
    }
}



